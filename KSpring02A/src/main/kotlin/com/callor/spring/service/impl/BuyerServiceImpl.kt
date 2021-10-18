package com.callor.spring.service.impl

import com.callor.spring.model.Buyer
import com.callor.spring.service.BuyerService
import org.springframework.stereotype.Service

@Service
class BuyerServiceImpl: BuyerService {

    companion object {
        val BuyerList = arrayOf(
            Buyer("B001" ,"롯데상사", "02-222-9999", "서울시 영등포구", "홍길동", "010-9999-8766",
        91000)
        )
    }

    override fun selectAll(): Array<Buyer> {
        return BuyerList

    }


}