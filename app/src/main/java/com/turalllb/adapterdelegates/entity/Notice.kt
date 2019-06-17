package com.turalllb.adapterdelegates.entity

import java.util.*

data class Notice(
    override var name: String,
    override var details: String,
    val flightDate: Date? = null,
    val gate: String? = null

) : Component


