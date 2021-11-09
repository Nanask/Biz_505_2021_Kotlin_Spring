package com.callor.readbook.Controller

import com.callor.readbook.model.ReadBookVO
import com.callor.readbook.service.ReadBookService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    private val logger = LoggerFactory.getLogger(HomeController::class.java)

    @Autowired
    private lateinit var rbService:ReadBookService;

//    @ResponseBody
    @RequestMapping(value = ["/",""], method = [RequestMethod.GET])
    fun main():String {
        return "readbook/write"
//        return "왜안나오냐"
//        return "redirect:/member/mypage"
    }

    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert():String {
        return "readbook/write"
    }

    @RequestMapping(value = ["/insert"], method = [RequestMethod.POST])
    fun insert(readbook:ReadBookVO):String {

        logger.debug("readBook 나와라예", readbook)
        var rbList = rbService.readBookInsert(readbook)
        logger.debug("rbList", rbList)
        return "redirect:/ "
    }

    @RequestMapping(value = ["list"], method = [RequestMethod.GET])
    fun list(model:Model):String {

        var rbList = rbService.readBookList()
        logger.debug("rbList", rbList)
        model.addAttribute("LIST", rbList)
        return "readbook/list"

    }
}