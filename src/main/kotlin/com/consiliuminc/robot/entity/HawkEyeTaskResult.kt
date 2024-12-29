package com.consiliuminc.robot.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "hawkeye_task_result")
class HawkEyeTaskResult {

    @Id
    var callID: String? = null

    var duration: Long? = null
    var caller: String? = null
    var called: String? = null
    var agentID: String? = null

    @Column(name = "calltime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    var callTime: LocalDateTime? = null

    var direction: String? = null
    var account: String? = null
    var extension: String? = null

    @Column(name = "ringtime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    var ringTime: LocalDateTime? = null

    @Column(name = "hitmodels",columnDefinition = "nvarchar(max)")
    var hitModels: String? = null
    @Column(columnDefinition = "nvarchar(max)")
    var extracted: String? = null


}