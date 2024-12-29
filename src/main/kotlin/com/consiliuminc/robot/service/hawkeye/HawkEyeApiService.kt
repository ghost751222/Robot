package com.consiliuminc.robot.service.hawkeye

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.apache.commons.io.IOUtils
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.InputStream
import java.nio.charset.StandardCharsets


@Service
class HawkEyeApiService {

    @Value("\${hawkeye.url}")
    val hawkEyeUrl: String = ""


    fun getAnalyzeResult(agentId: String): Map<String, Any?>? {
        var relativeUrl = "realTime/analyzeResult/extracted"
        var completeUrl = "$hawkEyeUrl/$relativeUrl?agentid=$agentId"


        var map: Map<String, Any?>? = null
        var inputStream: InputStream? = null
        try {

            val httpclient: HttpClient = HttpClientBuilder.create().build();
            val httpget = HttpGet(completeUrl)
            val response: HttpResponse = httpclient.execute(httpget)
            inputStream = response.entity.content
            val content: String = IOUtils.toString(inputStream, StandardCharsets.UTF_8.displayName())
            map = Gson().fromJson(content, object : TypeToken<Map<String, Any?>?>() {}.type)


        } catch (e: Exception) {
            throw e
        } finally {
            IOUtils.closeQuietly(inputStream)
        }
        return map

    }
}