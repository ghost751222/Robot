package com.consiliuminc.robot.controller.piod

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping(value =["/piod"])
class PiodController
{

    @RequestMapping(method = [RequestMethod.GET])
    fun piod():String
    {
        return "piod";
    }
}