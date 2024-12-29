package com.consiliuminc.robot.service.robot

import com.consiliuminc.robot.util.GsonUtil
import com.consiliuminc.robot.vo.robot.Plans
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service

@Service
class TWMService {
    val fileName = "plans.json";
    fun getPlansData(): Plans {
        val data = ClassPathResource(fileName).inputStream.bufferedReader().use { it.readText() }
        val gson = Gson()
        return gson.fromJson(data, Plans::class.java);

    }

    fun savePlansData(plans: Plans): Plans {
        ClassPathResource(fileName).file.writeText(Gson().toJson(plans))
        return plans;
    }

    fun getTWMUserData(requestData: JsonObject) : JsonElement? {
        val twmFileName = "twmUsers.json";
        val data = ClassPathResource(twmFileName).inputStream.bufferedReader().use { it.readText() }
        val cellPhone = requestData.get("cellphone").asString
        val twmUserData =  GsonUtil.fromJson(data, JsonObject::class.java)
        return twmUserData.getAsJsonArray("data").find { _data-> _data.asJsonObject.get("cellphone").asString == cellPhone}

    }
}