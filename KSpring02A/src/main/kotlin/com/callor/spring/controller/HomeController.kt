package com.callor.spring.controller

import com.callor.spring.service.BuyerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam


@Controller
class HomeController {

    /**
     * lateinit var
     *  특별히 변수, 객체를 선언할 때 즉시 초기화하지 않고 나중에 초기화를 하겠다
     *
     * Spring 환경에서는 Component(Service, Dao 등등) 객체는 코드에서 직접 초기화를 하지 않는다
     * 코드에서는 선언만 해두고 @Autowired 설정을 하면
     *  Spring의 Ioc(Invert of Control), DI(Dependency Injection..?) 등에 의해 자동으로 주입
     *
     *  반드시 lateinit 키워드를 부착하여 선언해야 한다
     */
    @Autowired
    private lateinit var bService:BuyerService



    /**
     * Spring 일반 Controller 예시
     * method가 문자열을 return하면 view 파일을 열어서 rendering하여 client로 보내라
     *
     * RESTful API 방식
     * RestController 또는 method에 @ResponseBody가 부착되면 문자열을 그대로 client로 보내라
     */
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun home(model:Model): String {

        val userList = bService.selectAll()
//        model.addAttribute("USERS", userList)
        model["USERS"] = userList

        return "home"
    }

    @RequestMapping(value = ["/list"], method = [RequestMethod.GET])
    fun list(): String {
        return "home";
    }
    @RequestMapping(value = ["/detail"], method = [RequestMethod.GET])
    fun detail(model:Model ,@RequestParam("userid") userid:String):String {
        //@RequestParam를 붙이면 뒤에 userid:String는 변수명을 맘대로 사용해도 되지만
        // @RequestParam를 붙이지 않으면 이름이 같아야 한다

        val buyer = bService.findById(userid)

        model["BUYER"] = buyer // buyer 정보를 찾아서 모델에 담아 detail에 보내기

        return "detail" // detail.html 을 열어라
    }
}