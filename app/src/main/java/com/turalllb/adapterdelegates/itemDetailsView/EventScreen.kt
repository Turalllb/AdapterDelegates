package com.turalllb.adapterdelegates.itemDetailsView

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.turalllb.adapterdelegates.R
import com.turalllb.adapterdelegates.entity.Event

class EventScreen : AppCompatActivity() {
    companion object {
        const val EVENT = "event"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_screen)


        val event = intent.getSerializableExtra(EVENT) as Event
        val startTimeTv = findViewById<TextView>(R.id.startTime_tv)
        val endTimeTv = findViewById<TextView>(R.id.endTime_tv)
        startTimeTv.text = event.startTime.toString()
        endTimeTv.text = event.endTime.toString()
    }

}
