package com.consiliuminc.robot.vo.robot

data class Action (
        val transferToCc: Boolean,
        val isEnd: Boolean,
        val isContinue: Boolean
)