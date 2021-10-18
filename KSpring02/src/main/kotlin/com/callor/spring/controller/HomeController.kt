package com.callor.spring.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    @ResponseBody
    @RequestMapping(value = ["/"], method = [RequestMethod.GET] )
    fun home() : String {
        return "반갑습니다"
    }

    // hello라는 templete 파일을 열어서 랜더링하여 사용자에게 보여라라
    @RequestMapping(value = ["/hello"],method = [RequestMethod.GET])
    fun hello(model:Model) : String {
        model.addAttribute("name", "홍길동")
        return "hello"
   }
}