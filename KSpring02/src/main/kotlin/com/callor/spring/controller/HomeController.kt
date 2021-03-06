package com.callor.spring.controller

import com.callor.spring.service.BuyerService
import model.Buyer
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    /**
     * BuyerService 인터페이스를 사용하여
     * bService 객체를 선언하고
     * Spring 에게 객체 주입을 요청하기 위하여 Autowire를 선언했다
     * 
     * Kotlin은 절대 null값, 없는값으로 변수, 객체 선언 금지
     * 이럴때는 반드시 iateinit를 부착해야 한다
     * "나중에 초기화 할래"라는 뜻
     */

    private lateinit var bService : BuyerService 

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
    @ResponseBody
    @RequestMapping(value = ["/list"], method = [RequestMethod.GET])
    fun list() : Array<Buyer> {
        return bService.selectAll()
    }
    @ResponseBody
    @RequestMapping(value = ["/getuser"], method = [RequestMethod.GET])
    fun getUser() : Buyer {
        return bService.findById( "user")
    }
}