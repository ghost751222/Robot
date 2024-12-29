package com.consiliuminc.robot.controller.hawkeye

import com.consiliuminc.robot.entity.HawkEyeTaskResult
import com.consiliuminc.robot.repository.HawkEyeTaskResultRepository
import com.consiliuminc.robot.service.hawkeye.HawkEyeApiService
import com.consiliuminc.robot.util.GsonUtil
import com.consiliuminc.robot.vo.hawkeye.HawkEyeResultVo
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import com.sun.xml.fastinfoset.util.StringArray
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping(value = ["/hawkEye"])
class HawEyeController @Autowired constructor(val hawkEyeApiService: HawkEyeApiService,val hawkEyeTaskResultRepository: HawkEyeTaskResultRepository) {

    private val logger: Logger = LoggerFactory.getLogger(HawEyeController::class.java)

    @RequestMapping(value = [""], method = [RequestMethod.GET])
    fun hawkEye(): String {
        return "hawkEye"
    }

    @RequestMapping(value = ["/hawkEyeReport"], method = [RequestMethod.GET])
    fun hawkEyeReport(): String {
        return "hawkEyeReport"
    }


    @RequestMapping(value = ["/{agentId}"], method = [RequestMethod.GET])
    @ResponseBody
    fun getAnalyzeResult(@PathVariable("agentId") agentId: String): Map<String, Any?>? {
        return hawkEyeApiService.getAnalyzeResult(agentId);
    }


    @RequestMapping(value = ["/getData"], method = [RequestMethod.GET])
    @ResponseBody
    fun getData(): MutableList<HawkEyeTaskResult> {
        return hawkEyeTaskResultRepository.findAllByOrderByCallTimeDesc();
    }


    @RequestMapping(value = ["/hawkEyeResult"], method = [RequestMethod.POST])
    @ResponseBody
    fun hawkEyeResult(@RequestBody data: HawkEyeResultVo) {

        try {
            logger.info("hawkEyeResult RequestData= {}",ObjectMapper().writeValueAsString(data))
            val hawkEyeTaskResult = HawkEyeTaskResult()
            with(data) {
                hawkEyeTaskResult.callID = callId
                hawkEyeTaskResult.agentID = agentId
                hawkEyeTaskResult.account = account
                hawkEyeTaskResult.duration = duration
                hawkEyeTaskResult.caller = caller
                hawkEyeTaskResult.called =called
                hawkEyeTaskResult.extension = extension
                hawkEyeTaskResult.callTime = callTime
                hawkEyeTaskResult.ringTime = ringTime
                hawkEyeTaskResult.direction =direction
                hawkEyeTaskResult.hitModels =hitModels?.let { GsonUtil.toJson(it) }
                hawkEyeTaskResult.extracted =extracted?.let { GsonUtil.toJson(it) }

            }

            hawkEyeTaskResultRepository.save(hawkEyeTaskResult)
        } catch (e: Exception) {
            logger.error(" hawkEyeResult Error ={}", e)
        }

    }
}