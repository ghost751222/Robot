package com.consiliuminc.robot.repository

import com.consiliuminc.robot.entity.RobotTaskResult
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface RobotTaskResultRepository : JpaRepository<RobotTaskResult, Long> {
    fun findByTaskCode(taskCode: String?): ArrayList<RobotTaskResult>

    fun findByRobotFlowAndStartTimeBetween(
        robotFlow: String?,
        startTime: LocalDateTime,
        endTime: LocalDateTime
    ): ArrayList<RobotTaskResult>

}