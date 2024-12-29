package com.consiliuminc.robot.entity

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "robot_task_result")
class RobotTaskResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0


    @SerializedName("task_code")
    var taskCode: String? = null


    @SerializedName("crm_data")
    @Column(columnDefinition = "nvarchar(max)")
    var crmData: String? = null

    @SerializedName("flow_data")
    @Column(columnDefinition = "nvarchar(max)")
    var flowData: String? = null

    @SerializedName("call_result")
    var callResult: Long = 0

    @SerializedName("call_id")
    var callID: String? = null

    @SerializedName("robot_flow")
    var robotFlow: String? = null
    var caller: String? = null
    var called: String? = null

    @SerializedName("call_type")
    var callType: String? = null

    @SerializedName("start_time")
    var startTime: LocalDateTime? = null

    @SerializedName("ring_time")
    var ringTime: LocalDateTime? = null

    @SerializedName("answer_time")
    var answerTime: LocalDateTime? = null

    @SerializedName("end_time")
    var endTime: LocalDateTime? = null

    @SerializedName("ring_sec")
    var ringSEC: Long = 0
    var duration: Long = 0

    @SerializedName("call_status")
    @Column(columnDefinition = "nvarchar(255)")
    var callStatus: String? = null

    @SerializedName("talk_times")
    var talkTimes: Long = 0

    @SerializedName("tocc_state")
    var toccState: Long = 0

    @SerializedName("tocc_time")
    var toccTime: String? = null

    @SerializedName("disconnect_reason")
    var disconnectReason: String? = null

    @SerializedName("call_label")
    var callLabel: String? = null

    @SerializedName("nlp_crm_data")
    @Column(columnDefinition = "nvarchar(max)")
    var nlpCRMData: String? = null

    @SerializedName("talk_infos")
    @Column(columnDefinition = "nvarchar(max)")
    var talkInfos: String? = null

}