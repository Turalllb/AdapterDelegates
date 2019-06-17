package com.turalllb.adapterdelegates.itemDetailsView

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.turalllb.adapterdelegates.R
import com.turalllb.adapterdelegates.entity.Move

class MoveScreen : AppCompatActivity() {
    companion object {
        const val MOVE = "move"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.move_screen)


        val toPlaceTv = findViewById<TextView>(R.id.toPlace_tv)
        val move = intent.getSerializableExtra(MOVE) as Move
        toPlaceTv.text = move.toPlace

        val fromPlaceTv = findViewById<TextView>(R.id.fromPlace_tv)
        fromPlaceTv.text = move.fromPlace
    }


}
