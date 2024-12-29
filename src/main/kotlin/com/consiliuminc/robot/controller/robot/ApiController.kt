package com.consiliuminc.robot.controller.robot

import com.consiliuminc.robot.entity.RobotTaskResult
import com.consiliuminc.robot.service.robot.RobotTaskResultService
import com.consiliuminc.robot.service.robot.ApiService
import com.consiliuminc.robot.util.GsonUtil
import com.consiliuminc.robot.vo.RequestDataVo
import com.consiliuminc.robot.vo.ResponseDataVo
import com.consiliuminc.robot.vo.robot.UserVo
import com.consiliuminc.robot.vo.robot.TaskResult
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime


@Controller
@RequestMapping(value = ["/api"])
class ApiController constructor(val apiService: ApiService, val robotTaskResultService: RobotTaskResultService) {

    private val logger: Logger = LoggerFactory.getLogger(ApiController::class.java)

    @RequestMapping(value = ["/user"], method = [RequestMethod.POST])
    @ResponseBody
    fun getUserData(@RequestBody requestDataVo: RequestDataVo): ResponseDataVo<UserVo> {

        val data = apiService.getUserData(requestDataVo.id)
        var responseDataVo = ResponseDataVo(data)
        responseDataVo.status = true
        println("Already Call = " + Gson().toJson(requestDataVo))
        return responseDataVo;
    }


    @RequestMapping(value = ["/iodTask"], method = [RequestMethod.POST])
    @ResponseBody
    fun getIODTask(@RequestBody requestData: String?): ResponseDataVo<String> {
        val responseDataVo = ResponseDataVo("Success")
        logger.info("requestData={}",requestData)
        responseDataVo.status = true




        try{


            val taskResult = GsonUtil.fromJson(requestData, TaskResult::class.java)

            if(taskResult.toccState==1L && taskResult.endTime == null){
                try {
                    apiService.transferToAgent(requestData)
                    logger.info("transfer success")
                }catch (e:Exception){
                    logger.error("ApiService transferToAgent Error ={}",e)
                }
            }


            //if (taskResult.taskCode == "cfa22ad90494467e96adc04f713c578f") {
            //logger.info(taskResult.toString())
            val robotTaskResult = RobotTaskResult()

            with(taskResult)
            {
                robotTaskResult.taskCode = taskCode
                robotTaskResult.crmData = crmData?.let { GsonUtil.toJson(it) }
                robotTaskResult.flowData = flowData?.let { GsonUtil.toJson(it) }
                robotTaskResult.callResult = callResult
                robotTaskResult.callID = callID
                robotTaskResult.robotFlow = robotFlow
                robotTaskResult.caller = caller
                robotTaskResult.called = called
                robotTaskResult.callType = callType
                robotTaskResult.startTime = startTime
                robotTaskResult.ringTime = ringTime
                robotTaskResult.answerTime = answerTime
                robotTaskResult.endTime = endTime
                robotTaskResult.ringSEC = ringSEC
                robotTaskResult.duration = duration
                robotTaskResult.callStatus = callStatus
                robotTaskResult.talkTimes = talkTimes
                robotTaskResult.toccState = toccState

                robotTaskResult.toccTime = toccTime
                robotTaskResult.disconnectReason = disconnectReason
                robotTaskResult.nlpCRMData = Gson().toJson(nlpCRMData)
                robotTaskResult.talkInfos = Gson().toJson(talkInfos)
            }
            robotTaskResultService.save(robotTaskResult)

            //}

        }catch (e:Exception)
        {
            logger.error(e.toString())
            responseDataVo.user = e.toString()
            responseDataVo.status = false
        }


        return responseDataVo

    }


    @RequestMapping(value = ["/taskResult"], method = [RequestMethod.POST,RequestMethod.GET])
    @ResponseBody
    fun getTaskResult(@RequestParam robotFlow:String?,
                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) startTime: LocalDateTime,
                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) endTime : LocalDateTime): ResponseDataVo<ArrayList<RobotTaskResult>>
    {
        val data =  robotTaskResultService.findByRobotFlowAndStartTimeBetween(robotFlow,startTime,endTime)
        //val data =  robotTaskResultService.findByTaskCode(robotFlow)

        val responseDataVo = ResponseDataVo(data)
        responseDataVo.status = true
        return responseDataVo
    }


}