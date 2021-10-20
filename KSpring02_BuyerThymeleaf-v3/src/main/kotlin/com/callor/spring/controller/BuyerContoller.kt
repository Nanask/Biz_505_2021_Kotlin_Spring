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
    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun write():String {

        return  "buyer/write"
    }

    @RequestMapping(value = ["/insert"], method=[RequestMethod.POST])
    fun write(buyer: Buyer):String {
        bService.insert(buyer);

//        return "buyer/list"
        return "redirect:/"
    }

}