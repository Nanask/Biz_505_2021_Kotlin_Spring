package com.callor.spring.controller

import com.callor.spring.model.Buyer
import com.callor.spring.service.BuyerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    @Autowired
    private lateinit var bService : BuyerService


    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun home(model: Model):String {

        var bs = bService.selectAll()

        model.addAttribute("BuyerList", bs)

        return "home"
    }

    @RequestMapping(value = ["/hello"], method = [RequestMethod.GET])
    fun hello():String {
        return "hello"
    }

//    @RequestMapping(value = ["/home"], method =[RequestMethod.GET])
//    fun list():String {
////        model.addAttribute("BuyerList", bService.selectAll())
//        return "home"
//    }
}