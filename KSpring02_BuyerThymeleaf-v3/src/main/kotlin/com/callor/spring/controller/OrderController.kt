package com.callor.spring.controller

import com.callor.spring.service.OrderService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping(value = ["/order"])
class OrderController(val orService:OrderService) {

    // localhost:8080/order/
    // localhost:8080/order
    @RequestMapping(value = ["","/"], method = [RequestMethod.GET])
    fun list(model:Model):String {

        val salesList = orService.selectAll()
        model["SALES"] = salesList

        return "order/list"
    }

}