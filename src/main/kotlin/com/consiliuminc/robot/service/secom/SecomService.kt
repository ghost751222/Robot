package com.consiliuminc.robot.service.secom

import com.consiliuminc.robot.util.GsonUtil
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.time.LocalDate


@Service
class SecomService {

    fun getSecomUser(requestData: JsonObject) : JsonElement? {
        val twmFileName = "secom.json";
        val data = ClassPathResource(twmFileName).inputStream.bufferedReader().use { it.readText() }
        val id = requestData.get("id").asString
        val twmUserData =  GsonUtil.fromJson(data, JsonObject::class.java)
        return twmUserData.getAsJsonArray("data").find { _data-> _data.asJsonObject.get("id").asString == id}

    }

    fun getSignal(requestData: JsonObject) : List<JsonElement> {
        val twmFileName = "secom.json";
        val data = ClassPathResource(twmFileName).inputStream.bufferedReader().use { it.readText() }
        val id = requestData.get("id").asString
        var date = LocalDate.now().year.toString() +"年"+ requestData.get("date").asString.replace("號","日")
        val signal = requestData.get("signal").asString


        val sdf = SimpleDateFormat("yyyy年MM月dd日")
        val sdFormat  = SimpleDateFormat("yyyyMMdd")
        date =sdFormat.format(sdf.parse(date))
        val signalData =  GsonUtil.fromJson(data, JsonObject::class.java)
        return signalData.getAsJsonArray("signal_data").filter { _data-> _data.asJsonObject.get("id").asString == id && _data.asJsonObject.get("date").asString == date && _data.asJsonObject.get("signal").asString == signal}.sortedByDescending { it.asJsonObject.get("time").asInt }

    }

}