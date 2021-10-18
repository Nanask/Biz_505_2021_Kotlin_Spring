package com.callor.spring.service

import com.callor.spring.model.Buyer
import org.springframework.stereotype.Service

@Service
interface BuyerService {

    fun selectAll():Array<Buyer>
}