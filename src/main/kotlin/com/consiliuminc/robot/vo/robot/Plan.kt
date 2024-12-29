package com.consiliuminc.robot.vo.robot

data class Plan (
        val planKey: String,
        val country: String,
        val tts: String,
        val minDay: String,
        val maxDay: String
)