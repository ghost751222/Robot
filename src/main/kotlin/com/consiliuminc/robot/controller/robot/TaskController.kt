package com.consiliuminc.robot.controller.robot

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping(value = ["/task"])
class TaskController {
    @RequestMapping(method = [RequestMethod.GET])
    fun home(): ModelAndView {

        val modelAndView = ModelAndView()
        with(modelAndView) {
            viewName = "task"
        }
        return modelAndView
    }


}