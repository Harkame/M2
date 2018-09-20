package fr.tp1.harkame.tp1

import android.provider.BaseColumns

object DBContract {
    class EventEntry : BaseColumns {
        companion object {
            const val TABLE_NAME = "events"
            const val COLUMN_EVENT_ID = "event_id"
            const val COLUMN_NAME = "event_name"
            const val COLUMN_DATE = "event_date"
            const val COLUMN_TYPE = "event_type"
        }
    }
}