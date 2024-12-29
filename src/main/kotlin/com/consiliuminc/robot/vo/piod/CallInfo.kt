package com.consiliuminc.robot.vo.piod

import com.google.gson.annotations.SerializedName

data class CallInfo (
        @SerializedName("crm_data")
        val crmData:Any? = null,
        val name: String,
        val phone: String,
        @SerializedName("flow_data")
        val flowData: Any? = null
)