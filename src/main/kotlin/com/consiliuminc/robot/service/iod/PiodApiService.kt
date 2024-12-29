package com.consiliuminc.robot.service.iod

import com.consiliuminc.robot.vo.piod.Callout
import com.google.gson.Gson
import org.apache.commons.io.IOUtils
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.InputStream
import java.nio.charset.StandardCharsets


@Service
class PiodApiService {

    @Value("\${piod.url}")
    private val piodUrl: String = ""

    fun callOut(callout: Callout): String {
        var inputStream: InputStream? = null
        val relativeUrl = "/iod/api/v1/job/"
        val completeUrl = "$piodUrl$relativeUrl"


        try {

            val httpclient: HttpClient = HttpClientBuilder.create().build();
            val httpPost = HttpPost(completeUrl)

            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");

            val stringEntity = StringEntity(Gson().toJson(callout).toString(), ContentType.APPLICATION_JSON)
            stringEntity.setContentEncoding("UTF-8")


            httpPost.entity = stringEntity


            val response: HttpResponse = httpclient.execute(httpPost)

            inputStream = response.entity.content
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8.displayName())

        } catch (e: Exception) {
            throw e
        } finally {
            IOUtils.closeQuietly(inputStream)
        }
    }

}