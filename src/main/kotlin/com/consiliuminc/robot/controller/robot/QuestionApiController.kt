package com.consiliuminc.robot.controller.robot

import com.consiliuminc.robot.config.QuestionConfig
import com.consiliuminc.robot.service.robot.RobotTaskResultService
import com.consiliuminc.robot.vo.ResponseDataVo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping(value = ["/api"])
class QuestionApiController constructor(val questionConfig: QuestionConfig, val robotTaskResultService: RobotTaskResultService) {

    private val logger: Logger = LoggerFactory.getLogger(QuestionApiController::class.java)





    @RequestMapping(value = ["/question"], method = [RequestMethod.GET])
    @ResponseBody
    fun getQuestion(): ResponseDataVo<HashMap<String,Any>> {


        val map = HashMap<String,Any>()
        var responseDataVo = ResponseDataVo(map)
        responseDataVo.status=true
        val fields = QuestionConfig::class.java.declaredFields

        with(map){
            for (field in fields){
                field.isAccessible =true
                put(field.name,field.get(questionConfig))
            }
        }
       return responseDataVo

    }




}