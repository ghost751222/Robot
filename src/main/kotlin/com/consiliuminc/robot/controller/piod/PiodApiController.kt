package com.consiliuminc.robot.controller.piod

import com.consiliuminc.robot.service.iod.PiodApiService
import com.consiliuminc.robot.util.GsonUtil
import com.consiliuminc.robot.vo.piod.CallInfo
import com.consiliuminc.robot.vo.piod.Callout
import com.google.gson.JsonObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value = ["/api/piod"])
class PiodApiController @Autowired constructor(val piodApiService: PiodApiService) {


    @RequestMapping(value = ["/callout"], method = [RequestMethod.POST])
    @ResponseBody
    fun callOut(@RequestBody callout: Callout): JsonObject {
        return GsonUtil.fromJson(piodApiService.callOut(callout),JsonObject::class.java)

    }

    @RequestMapping(value = ["/questionnaire"], method = [RequestMethod.POST])
    @ResponseBody
    fun questionnaire(@RequestBody reqData: String): String {

        var data = GsonUtil.fromJson(reqData,JsonObject::class.java)
        val product = data.get("product").asString
        val name = data.get("surname").asString
        val phone = data.get("phone").asString
        val callInfos = ArrayList<CallInfo>()
        val callInfo =CallInfo(data,name,phone,data)
        callInfos.add(callInfo)
         var callout :Callout
        return if(product == "世紀安穩外幣變額年金保險") {
            callout = Callout("d15ad72ad8c345caae50252d942f9278",callInfos = callInfos)
            GsonUtil.toJson(callOut(callout))
        }else if (product == "世紀安心外幣變額年金保險") {
            callout = Callout("a323229c841f4240bfddbd3349dec497",callInfos = callInfos)
            GsonUtil.toJson(callOut(callout))
        }else if (product == "世紀達利變額萬能終身壽險Ａ型"){
            callout = Callout("15df2df46312401c8da18d1d0f7a103f",callInfos = callInfos)
            GsonUtil.toJson(callOut(callout))

        }else if (product == "保費來源解約金"){
            callout = Callout("6a2dd58ed20c4219ac07c0d9dbbe5626",callInfos = callInfos)
            GsonUtil.toJson(callOut(callout))

        }else if (product == "生存調查表"){
            callout = Callout("74c0ea0900a74c729a541c7bbaa7ef44",callInfos = callInfos)
            GsonUtil.toJson(callOut(callout))

        } else{
            reqData
        }


    }



}