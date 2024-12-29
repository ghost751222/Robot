package com.consiliuminc.robot.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix="robot.question")

class QuestionConfig {

    var q1:String?=null
    var q2:String?=null
    var q3:String?=null
    var q4:String?=null
    var q5:String?=null
    var q6:String?=null
    var q7:String?=null
    var q8:String?=null

    var q1TaskId:List<String>?=null
    var q2TaskId:List<String>?=null
    var q3TaskId:List<String>?=null
    var q4TaskId:List<String>?=null
    var q5TaskId:List<String>?=null
    var q6TaskId:List<String>?=null
    var q7TaskId:List<String>?=null
    var q8TaskId:List<String>?=null
}