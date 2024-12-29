package com.consiliuminc.robot.util

import org.apache.http.HttpHeaders
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase
import org.apache.http.client.methods.HttpPost
import org.apache.http.conn.ssl.SSLConnectionSocketFactory
import org.apache.http.conn.ssl.TrustStrategy
import org.apache.http.entity.ContentType
import org.apache.http.impl.client.HttpClients
import org.apache.http.message.AbstractHttpMessage
import org.apache.http.message.BasicHeader
import org.apache.http.ssl.SSLContextBuilder
import java.net.URI
import java.security.KeyManagementException
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException


object HttpClientUtils {


    val httpClient: HttpClient
        get() {
            val sslBuilder = SSLContextBuilder()
            sslBuilder.loadTrustMaterial(null, TrustStrategy { _, _ -> true } as TrustStrategy?)
            val sslConnectionSocketFactory = SSLConnectionSocketFactory(sslBuilder.build()) { _, _ -> true }
            return HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build()

        }

    fun getHttpGetMethod(uri: String?): HttpGet {
        return HttpGet(uri)
    }

    fun getHttpPostMethod(uri: String?): HttpPost {
        return HttpPost(uri)
    }

    fun addHeaderContentJson(httpMessage: AbstractHttpMessage) {
        httpMessage.addHeader(BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType))
    }


    class HttpGet(uri: String?) : HttpEntityEnclosingRequestBase() {

        companion object {
            const val method = "GET"
        }

        init {
            setURI(URI.create(uri))
           // addHeader(BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType))
        }

        override fun getMethod(): String {
           return  method;
        }

    }
}