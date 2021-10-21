package com.callor.spring.controller

import com.callor.spring.ConfigData
import com.callor.spring.model.Buyer
import com.callor.spring.service.BuyerService
import com.callor.spring.service.impl.BuyerServiceImplV1
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*
import java.io.Console

@Controller
@RequestMapping(value = ["/buyer"])
class BuyerContoller( val bService:BuyerService) {


    @RequestMapping(value = ["/list"], method=[RequestMethod.GET])
//    @GetMapping(name=["/list"])
    fun list(model:Model):String {
        val buyerList = bService.selectAll()
        model["BUYERS"] = buyerList
        return "buyer/list"
    }

    @RequestMapping(value = ["/detail"], method = [RequestMethod.GET])
    fun detail(model: Model, @RequestParam("userid") userid:String): String {
//        var userInfo = bService.findById(userid)("userid") user
//        model["USERINFO"] = userInfo
        var buyer = bService.findById(userid)
        model["BUYER"] = buyer

//        var proInfo = bService.selectAll()
//        model["PRODUCT"] = proInfo

        return "buyer/detail"
    }

    // json타입으로 보내서 결과값을 확인해보기 위한 코드였음
    @ResponseBody
    @RequestMapping(value = ["/insertOld"], method=[RequestMethod.GET])
    fun insert():Buyer {

//         val insertBuyer = BuyerServiceImplV1.BUYER_LIST[0]
        val insertBuyer = ConfigData.BUYER_LIST[0]
        bService.insert(insertBuyer)

        return insertBuyer
    }

    /**
     * ModelAndAttribute 속성, 기능
     * controller 에서 Model 객체를 담고
     * form 화면을 rendering 하면
     *
     * 보통은 form의 value 속성에 일일이
     * 데이터를 추가하여 작성을 한다
     *
     * ModelAttr 을 사용하면
     * 각각 view Template 의 고유 기능을 사용하여
     * id, name, value 값을 자동으로 채워넣는 기능을 만들 수 있다.
     *
     * thymeleaf template를 사용할 때는
     * form tag에 model에 담긴 object를 지정해 주고
     * 각 input box에서는 field 속성으로 해당 맴버변수(요소,속성)을 지정해주면
     * template 엔진이 rendering을 수행하면서
     * input에 필요한 요소들을 적절하게 생성해준다.
     */
    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun write(model: Model):String {
//        val insertBuyer = ConfigData.BUYER_LIST[0]

//        model["BUYER"] = insertBuyer
        model["BUYER"] = Buyer()
        return  "buyer/write"
    }

    @RequestMapping(value = ["/insert"], method=[RequestMethod.POST])
    fun write(buyer: Buyer):String {
        bService.insert(buyer);

//        return "buyer/list"
        return "redirect:/"
    }
    @RequestMapping(value = ["/update/{userid}"], method = [RequestMethod.GET])
    fun update(model:Model, @PathVariable("userid") userid:String) : String {

        val buyer = bService.findById(userid)
        model["BUYER"] = buyer
        return "buyer/write"
    }

}