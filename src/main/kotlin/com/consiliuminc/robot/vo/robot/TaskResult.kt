package com.consiliuminc.robot.vo.robot

import com.consiliuminc.robot.vo.robot.NLPCRMData
import com.consiliuminc.robot.vo.robot.TalkInfo
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime


data class TaskResult (
        @SerializedName("task_code")
        val taskCode: String,
        @SerializedName("crm_data")
        val crmData: Any? = null,
        @SerializedName("flow_data")
        val flowData: Any? = null,
        @SerializedName("call_result")
        val callResult: Long,
        @SerializedName("call_id")
        val callID: String,
        @SerializedName("robot_flow")
        val robotFlow: String,
        val caller: String,
        val called: String,
        @SerializedName("call_type")
        val callType: String,
        @SerializedName("start_time")
        val startTime: LocalDateTime?,
        @SerializedName("ring_time")
        val ringTime: LocalDateTime?,
        @SerializedName("answer_time")
        val answerTime: LocalDateTime?,
        @SerializedName("end_time")
        val endTime: LocalDateTime?,
        @SerializedName("ring_sec")
        val ringSEC: Long,
        val duration: Long,
        @SerializedName("call_status")
        val callStatus: String,
        @SerializedName("talk_times")
        val talkTimes: Long,
        @SerializedName("tocc_state")
        val toccState: Long,
        @SerializedName("tocc_time")
        val toccTime:String? = null,
        @SerializedName("disconnect_reason")
        val disconnectReason: String?= null,
        @SerializedName("call_label")
        val callLabel: String?,
        @SerializedName("nlp_crm_data")
        val nlpCRMData:  Any?,
        @SerializedName("talk_infos")
        val talkInfos: List<TalkInfo>
)
