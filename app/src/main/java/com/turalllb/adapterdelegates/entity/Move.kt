package com.turalllb.adapterdelegates.entity

import com.turalllb.adapterdelegates.TimeInterval
import java.io.Serializable

class Move(
    override var name: String,
    override var details: String,
    var fromPlace: String? = null,
    var toPlace: String? = null
) : Component, Serializable {
    var estimateTime: TimeInterval? = null
}