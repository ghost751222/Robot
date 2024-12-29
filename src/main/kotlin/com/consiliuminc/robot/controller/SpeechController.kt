package com.consiliuminc.robot.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping(value = ["/speech"])
class SpeechController {
    @RequestMapping(method = [RequestMethod.GET])
    fun speech(): ModelAndView {

        val modelAndView = ModelAndView()
        with(modelAndView) {
            viewName = "speech"
        }
        return modelAndView
    }


}