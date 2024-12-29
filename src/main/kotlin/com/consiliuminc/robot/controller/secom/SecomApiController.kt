package com.consiliuminc.robot.controller.secom

import com.consiliuminc.robot.service.secom.SecomService
import com.consiliuminc.robot.util.GsonUtil
import com.consiliuminc.robot.vo.ResponseDataVo
import com.google.gson.JsonObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value = ["/secom"])
class SecomApiController @Autowired constructor(val secomService: SecomService) {


    private val logger: Logger = LoggerFactory.getLogger(SecomApiController::class.java)

    @RequestMapping(method = [RequestMethod.POST], value = ["/user"])
    @ResponseBody
    fun getSecomUser(@RequestBody _data: String): String {
        logger.info("getSecomUser request params={}", _data)
        val data = secomService.getSecomUser(GsonUtil.fromJson(_data, JsonObject::class.java))
        var responseDataVo = ResponseDataVo(data)
        responseDataVo.status = true
        return GsonUtil.toJson(responseDataVo)
    }



    @RequestMapping(method = [RequestMethod.POST], value = ["/signal"])
    @ResponseBody
    fun getSignal(@RequestBody _data: String): String {
        logger.info("getSignal request params={}", _data)
        val data = secomService.getSignal(GsonUtil.fromJson(_data, JsonObject::class.java))
        var responseDataVo = ResponseDataVo(data)
        responseDataVo.status = true
        return GsonUtil.toJson(responseDataVo)
    }

}