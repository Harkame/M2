package fr.tp1.harkame.tp1.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.tutorialkart.sqlitetutorial.EventDBHelper
import fr.tp1.harkame.tp1.EventModel
import fr.tp1.harkame.tp1.R
import kotlinx.android.synthetic.main.activity_event_creation.*
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime

class EventCreationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var eventDBHelper : EventDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_creation)

        eventDBHelper = EventDBHelper(this)

        eventCreationValidate.setOnClickListener { view ->

            val eventName = findViewById<EditText>(R.id.eventCreationName).text.toString()
            val eventDate = findViewById<EditText>(R.id.eventCreationName).text.toString()
            val eventType = findViewById<EditText>(R.id.eventCreationName).text.toString()

            val localDateTime = LocalDateTime.now();

            eventDBHelper.insertEvent(EventModel(eventName, localDateTime, eventType))

            val intent = Intent(this, HomeActivity::class.java).apply {

            }
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
