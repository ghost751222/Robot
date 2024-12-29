package com.consiliuminc.robot.vo.robot

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class TalkInfo (
        val talker: String,
        @SerializedName("sentence_id")
        val sentenceID: String,
        val content: String,
        @SerializedName("talk_at")
        val talkAt: LocalDateTime?,
        @SerializedName("talk_duration")
        val talkDuration: Long,
        @SerializedName("label_name")
        val labelName: String,
        @SerializedName("label_type")
        val labelType: String,
        val concern: String,
        @SerializedName("match_type")
        val matchType: Long,
        @SerializedName("match_name")
        val matchName: String
)