package com.consiliuminc.robot.entity.iod

import java.time.LocalDateTime
import javax.persistence.*

//@Entity
//@Table(name = "iod_task")
class IodTask {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    var id: Int? = null

    var title: String? = null

    var gateway: String? = null

    @Column(name = "caller_number")
    var callerNumber: String? = null

    @Column(name = "robot_flow")
    var robotFlow: Int? = null

    @Column(name = "task_description")
    var taskDescription: String? = null

    var status: Int? = null

    @Column(name = "user_id")
    var userId: Int? = null

    @Column(name = "task_code",columnDefinition = "char")
    var taskCode: String? = null

    @Column(name = "create_time")
    var createTime: LocalDateTime? = null

    @Column(name = "create_user")
    var createUser: String? = null

    @Column(name = "modify_time")
    var modifyTime: LocalDateTime? = null

    @Column(name = "modify_user")
    var modifyUser: String? = null

    @Column(name = "voice_name")
    var voiceName: String? = null


}