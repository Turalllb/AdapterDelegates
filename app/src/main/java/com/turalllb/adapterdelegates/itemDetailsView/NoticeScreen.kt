package com.turalllb.adapterdelegates.itemDetailsView

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.turalllb.adapterdelegates.R
import java.util.*

class NoticeScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notice_screen)


        val flightTv = findViewById<TextView>(R.id.date_tv)
        val str = intent.getSerializableExtra("FLIGHT_DATE") as Date
        flightTv.text = str.toString()

        val gateTv = findViewById<TextView>(R.id.gate_tv)
        gateTv.text = intent.getStringExtra("gate")

    }

}
