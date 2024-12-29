package com.consiliuminc.robot.vo.piod

import com.google.gson.annotations.SerializedName

data class Callout(@SerializedName("task_code") var taskCode: String, @SerializedName("call_infos") var callInfos: ArrayList<CallInfo>)