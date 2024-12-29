package com.consiliuminc.robot.controller.robot

import com.consiliuminc.robot.service.robot.TWMService
import com.consiliuminc.robot.util.GsonUtil
import com.consiliuminc.robot.vo.ResponseDataVo
import com.consiliuminc.robot.vo.robot.Plans
import com.consiliuminc.robot.vo.robot.UserVo
import com.google.gson.JsonElement
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
@RequestMapping(value = ["/twm"])
class TWMController @Autowired constructor(val twmService: TWMService)
{
    private val logger: Logger = LoggerFactory.getLogger(TWMController::class.java)

    @RequestMapping(method = [RequestMethod.GET])
    fun twm():String
    {
        return "twm"
    }


    @RequestMapping(method = [RequestMethod.GET],value = ["/plans"])
    @ResponseBody
    fun plansGet(): Plans
    {
        return twmService.getPlansData()
    }


    @RequestMapping(method = [RequestMethod.POST],value = ["/plans"])
    @ResponseBody
    fun plansPost(@RequestBody plans: Plans): Plans
    {
        return twmService.savePlansData(plans);
    }

    @RequestMapping( method = [RequestMethod.POST],value = ["/user"])
    @ResponseBody
    fun getTWMUserData(@RequestBody _data: String):String {
        logger.info("getTWMUserData request params={}",_data)
        val data=  twmService.getTWMUserData(GsonUtil.fromJson(_data, JsonObject::class.java))
        var responseDataVo = ResponseDataVo(data)
        responseDataVo.status = true
        return GsonUtil.toJson(responseDataVo)
    }
}