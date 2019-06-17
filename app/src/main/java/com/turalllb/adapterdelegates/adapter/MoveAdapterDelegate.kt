package com.turalllb.adapterdelegates.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.turalllb.adapterdelegates.R
import com.turalllb.adapterdelegates.entity.Component
import com.turalllb.adapterdelegates.entity.Move
import com.turalllb.adapterdelegates.itemDetailsView.MoveScreen
import com.turalllb.adapterdelegates.itemDetailsView.MoveScreen.Companion.MOVE

class MoveAdapterDelegate(private val context: Context) : AdapterDelegate<List<Component>>() {
    private val inflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val itemView = inflater.inflate(R.layout.rv_item, parent, false)
        return MoveViewHolder(itemView)
    }

    override fun isForViewType(items: List<Component>, position: Int): Boolean {
        return items[position] is Move
    }

    override fun onBindViewHolder(
        items: List<Component>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        val vh = holder as MoveViewHolder
        val move = items[position] as Move
        vh.textName.text = move.name
        vh.textDetails.text = move.details
        holder.itemClickListener = object :
            ItemClickListener {
            override fun onClick(position: Int) {
                val intent = Intent(context, MoveScreen::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.putExtra(MOVE, move)
                context.startActivity(intent)
            }
        }
    }


    inner class MoveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val textName: TextView = itemView.findViewById(R.id.name_tv)
        val textDetails: TextView = itemView.findViewById(R.id.details_tv)
        lateinit var itemClickListener: ItemClickListener

        init {
            itemView.setOnClickListener(this)
        }


        override fun onClick(v: View?) {
            itemClickListener.onClick(adapterPosition)
        }
    }

    interface ItemClickListener {
        fun onClick(position: Int)
    }

}