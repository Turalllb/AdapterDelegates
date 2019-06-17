package com.turalllb.adapterdelegates.adapter

import android.content.Context
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.turalllb.adapterdelegates.entity.Component


class ComponentAdapter(context: Context, items: List<Component>) : ListDelegationAdapter<List<Component>>() {

    init {
        with(delegatesManager) {
            addDelegate(NoticeAdapterDelegate(context))
            addDelegate(EventAdapterDelegate(context))
            addDelegate(MoveAdapterDelegate(context))
        }


        setItems(items)
    }

    interface ItemClickListener {
        fun onClick(position: Int)
    }
}