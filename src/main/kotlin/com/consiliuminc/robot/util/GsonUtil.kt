package com.consiliuminc.robot.util

import com.google.gson.*
import com.google.gson.internal.Primitives
import java.lang.reflect.Type
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GsonUtil {

    companion object {




        @Throws(JsonSyntaxException::class)
        fun <T> fromJson(json: String?, classOfT: Class<T>?): T {
            return gsonBuilder().fromJson(json,classOfT)
        }


        fun toJson(src:Any?):String{
            return gsonBuilder().toJson(src);
        }

        private fun gsonBuilder(): Gson {
            return GsonBuilder().serializeNulls().registerTypeAdapter(LocalDateTime::class.java, object : JsonDeserializer<LocalDateTime?> {
                @Throws(JsonParseException::class)
                override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): LocalDateTime? {
                    return LocalDateTime.parse(json.asString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                }
            }).create()
        }
    }


}