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
import com.turalllb.adapterdelegates.entity.Notice
import com.turalllb.adapterdelegates.itemDetailsView.NoticeScreen


class NoticeAdapterDelegate(private val context: Context) : AdapterDelegate<List<Component>>() {
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val itemView = inflater.inflate(R.layout.rv_item, parent, false)
        return NoticeViewHolder(itemView)
    }

    override fun isForViewType(items: List<Component>, position: Int): Boolean {
        return items[position] is Notice
    }

    override fun onBindViewHolder(
        items: List<Component>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        val vh = holder as NoticeViewHolder
        val notice = items[position] as Notice
        vh.textName.text = notice.name
        vh.textDetails.text = notice.details
        holder.itemClickListener = object : ComponentAdapter.ItemClickListener {
            override fun onClick(position: Int) {
                val intent = Intent(context, NoticeScreen::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.putExtra("FLIGHT_DATE", notice.flightDate)
                intent.putExtra("gate", notice.gate)
                context.startActivity(intent)
            }
        }

    }


    inner class NoticeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val textName: TextView = itemView.findViewById(R.id.name_tv)
        val textDetails: TextView = itemView.findViewById(R.id.details_tv)
        lateinit var itemClickListener: ComponentAdapter.ItemClickListener

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            itemClickListener.onClick(adapterPosition)
        }
    }


}
