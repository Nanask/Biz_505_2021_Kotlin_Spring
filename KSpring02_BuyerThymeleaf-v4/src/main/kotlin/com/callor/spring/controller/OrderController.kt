package com.callor.spring.controller

import com.callor.spring.model.Sales
import com.callor.spring.service.OrderService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

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
    @RequestMapping(value = ["/detail"], method = [RequestMethod.GET])
    fun detail(model: Model, @RequestParam("seq") seq:Long):String {

        val sales = orService.findById(seq)

        model ["SALES"] = sales

        return "/order/detail"
    }

    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert(model: Model):String {

        model["ORDER"] = Sales()
        return "/order/write"
    }
    @RequestMapping(value = ["/insert"], method = [RequestMethod.POST])
    fun insert(sales:Sales, model: Model):String {
        val order = orService.insert(sales)

        model["SALES"] = order
//        localhost:8080/order/list
        return "redirect:/order"
    }
    @RequestMapping(value = ["/update/{seq}"], method = [RequestMethod.GET])
    fun update(model: Model , @PathVariable("seq") seq:Long):String {

        val order = orService.findById(seq)

        model["ORDER"] = order
        return "/order/write"
    }

    @RequestMapping(value = ["/update/{seq}"], method = [RequestMethod.POST])
    fun update(model: Model , sales: Sales):String {

        val order = orService.insert(sales)

        model["SALES"] = order
        return "redirect:/order"
    }

    @RequestMapping(value = ["/delete/{seq}"], method=[RequestMethod.GET])
    fun delete(@PathVariable("seq") seq:Long):String {
         orService.delete(seq)

        return "redirect:/order"
    }



}