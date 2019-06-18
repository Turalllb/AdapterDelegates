package com.turalllb.adapterdelegates

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.turalllb.adapterdelegates.adapter.ComponentAdapter
import com.turalllb.adapterdelegates.adapter.MoveAdapterDelegate
import com.turalllb.adapterdelegates.entity.Component
import com.turalllb.adapterdelegates.entity.Event
import com.turalllb.adapterdelegates.entity.Move
import com.turalllb.adapterdelegates.entity.Notice
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ComponentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv: RecyclerView = findViewById(R.id.rv)


        rv.layoutManager = LinearLayoutManager(this)
        adapter = ComponentAdapter(this, getData())
        rv.adapter = adapter
        adapter.addComponent(MoveAdapterDelegate(this))

    }


    private fun getData(): List<Component> {
        val list = mutableListOf<Component>()

        val event = Event("EVENT", "Какие-то детали")
        event.startTime = Date()
        event.endTime = Date()
        val component: Component = event

        val move = Move("MOVE", "Какие-то детали", "London", "Moscow")
        move.estimateTime = TimeInterval.getInterval(System.currentTimeMillis())
        val component1: Component = move

        val component2: Component = Notice("NOTICE", "Какие-то детали", Date(), 7.toString())

        for (i: Int in 10..100) {
            when (Random.nextInt(3)) {
                0 -> list.add(component)
                1 -> list.add(component1)
                2 -> list.add(component2)
            }
        }
        return list
    }
}
