package com.tutorialkart.sqlitetutorial

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import fr.tp1.harkame.tp1.DBContract
import fr.tp1.harkame.tp1.DateUtils
import fr.tp1.harkame.tp1.EventModel
import java.time.LocalDateTime


class EventDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertEvent(event: EventModel): Boolean {


        val db = writableDatabase
        db.execSQL(SQL_DELETE_ENTRIES)
        db.execSQL(SQL_CREATE_ENTRIES)
        // Create a new map of values, where column names are the keys
        val values = ContentValues()
        values.put(DBContract.EventEntry.COLUMN_NAME, event.name)
        values.put(DBContract.EventEntry.COLUMN_DATE, DateUtils.localDateTimeToString(event.date))
        values.put(DBContract.EventEntry.COLUMN_TYPE, event.type)

        db.insert(DBContract.EventEntry.TABLE_NAME, null, values)

        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun deleteEvent(eventID: String): Boolean {

        val db = writableDatabase

        val selection = DBContract.EventEntry.COLUMN_EVENT_ID + " LIKE ?"

        val selectionArgs = arrayOf(eventID)

        db.delete(DBContract.EventEntry.TABLE_NAME, selection, selectionArgs)

        return true
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "FeedReader.db"

        private val SQL_CREATE_ENTRIES =
                "CREATE TABLE " + DBContract.EventEntry.TABLE_NAME + " (" +
                        DBContract.EventEntry.COLUMN_EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        DBContract.EventEntry.COLUMN_NAME + " TEXT," +
                        DBContract.EventEntry.COLUMN_DATE + " TEXT," +
                        DBContract.EventEntry.COLUMN_TYPE + " TEXT)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBContract.EventEntry.TABLE_NAME
    }

    fun readAllEvents(): ArrayList<EventModel> {
        val events = ArrayList<EventModel>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + DBContract.EventEntry.TABLE_NAME, null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var eventName: String
        var eventDate: LocalDateTime
        var eventType: String
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                eventName = cursor.getString(cursor.getColumnIndex(DBContract.EventEntry.COLUMN_NAME))
                eventDate = DateUtils.stringToLocalDateTime(cursor.getString(cursor.getColumnIndex(DBContract.EventEntry.COLUMN_DATE)))
                eventType = cursor.getString(cursor.getColumnIndex(DBContract.EventEntry.COLUMN_TYPE))

                events.add(EventModel(eventName, eventDate, eventType))
                cursor.moveToNext()
            }
        }
        return events
    }
}

    /*
    fun readEvent(eventid: String): ArrayList<EventModel> {
        val events = ArrayList<EventModel>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + DBContract.EventEntry.TABLE_NAME + " WHERE " + DBContract.EventEntry.COLUMN_USER_ID + "='" + eventid + "'", null)
        } catch (e: SQLiteException) {
            // if table not yet present, create it
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var name: String
        var age: String
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                name = cursor.getString(cursor.getColumnIndex(DBContract.EventEntry.COLUMN_NAME))
                age = cursor.getString(cursor.getColumnIndex(DBContract.EventEntry.COLUMN_AGE))

                events.add(EventModel(eventid, name, age))
                cursor.moveToNext()
            }
        }
        return events
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "FeedReader.db"

        private val SQL_CREATE_ENTRIES =
                "CREATE TABLE " + DBContract.EventEntry.TABLE_NAME + " (" +
                        DBContract.EventEntry.COLUMN_USER_ID + " TEXT PRIMARY KEY," +
                        DBContract.EventEntry.COLUMN_NAME + " TEXT," +
                        DBContract.EventEntry.COLUMN_AGE + " TEXT)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBContract.EventEntry.TABLE_NAME
    }
    */