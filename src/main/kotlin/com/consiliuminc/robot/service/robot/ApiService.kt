package com.consiliuminc.robot.service.robot

import com.consiliuminc.robot.vo.robot.DataVo
import com.consiliuminc.robot.vo.robot.UserVo
import com.google.gson.Gson
import org.apache.commons.io.IOUtils
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import java.io.InputStream
import java.nio.charset.StandardCharsets


@Service
class ApiService {

    @Value("\${transfer.url}")
    private val transferUrl: String = ""

    val fileName = "data.json";
    fun getUserData(id: String): UserVo? {

        val data = ClassPathResource(fileName).inputStream.bufferedReader().use { it.readText() }
        val gson = Gson()
        val dataVo = gson.fromJson(data, DataVo::class.java)
        return dataVo.data.find { userVo -> userVo.id == id };
        //return gson.toJson(dataVo.data.filter { userVo -> userVo.id == id })
    }

    fun getAllData(): DataVo {
        val data = ClassPathResource(fileName).inputStream.bufferedReader().use { it.readText() }
        return Gson().fromJson(data, DataVo::class.java);
    }


    fun transferToAgent(data: String?): String {
        var inputStream: InputStream? = null
        val relativeUrl = "/CTIMW/robotPost"
        val completeUrl = "$transferUrl$relativeUrl"
        try {
            val httpclient: HttpClient = HttpClientBuilder.create().build();
            val httpPost = HttpPost(completeUrl)

            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");

            val stringEntity = StringEntity(data, ContentType.APPLICATION_JSON)
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