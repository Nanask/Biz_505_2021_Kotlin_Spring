package com.callor.spring.service

import model.Buyer

interface BuyerService {
    fun selectAll():Array<Buyer>
    fun findById(id: String):Buyer
}