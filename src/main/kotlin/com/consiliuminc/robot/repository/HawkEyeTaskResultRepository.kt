package com.consiliuminc.robot.repository

import com.consiliuminc.robot.entity.HawkEyeTaskResult
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HawkEyeTaskResultRepository : JpaRepository<HawkEyeTaskResult, Long> {

     fun findAllByOrderByCallTimeDesc(): MutableList<HawkEyeTaskResult>


}