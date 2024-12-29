package com.consiliuminc.robot.service.robot

import com.consiliuminc.robot.entity.RobotTaskResult
import com.consiliuminc.robot.repository.RobotTaskResultRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class RobotTaskResultService @Autowired constructor(val robotTaskResultRepository: RobotTaskResultRepository) {

    fun findAll(): List<RobotTaskResult> {
        return robotTaskResultRepository.findAll()
    }
    fun save(robotTaskResult: RobotTaskResult)
    {
        robotTaskResultRepository.save(robotTaskResult)
    }

    fun findByTaskCode(taskCode:String?): ArrayList<RobotTaskResult>
    {
        return robotTaskResultRepository.findByTaskCode(taskCode)
    }

    fun findByRobotFlowAndStartTimeBetween(taskCode: String?, startTime: LocalDateTime, endTime: LocalDateTime): ArrayList<RobotTaskResult>
    {
        return robotTaskResultRepository.findByRobotFlowAndStartTimeBetween(taskCode,startTime,endTime)
    }
}