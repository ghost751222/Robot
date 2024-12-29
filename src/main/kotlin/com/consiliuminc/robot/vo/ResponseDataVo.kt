package com.consiliuminc.robot.vo

data class ResponseDataVo<T>(var user: T?) {
    var status = false
}