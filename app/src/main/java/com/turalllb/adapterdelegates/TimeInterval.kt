package com.turalllb.adapterdelegates

import java.io.Serializable

class TimeInterval private constructor(startTime: Long?, endTime: Long): Serializable {
    private val length: Long? = null


    companion object {
        fun getInterval(mills: Long): TimeInterval? {
            return TimeInterval(null, mills)
        }
    }
}