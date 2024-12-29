package com.consiliuminc.robot.vo.robot

import com.consiliuminc.robot.vo.robot.Action

data class DialogInfo (
        val round: Long,
        val type: String,
        val requestEvent: String,
        val requestText: String,
        val responseText: String,
        val action: Action,
        val taskId: String,
        val taskName: String,
        val subflowName: String,
        val subflowID: String
)