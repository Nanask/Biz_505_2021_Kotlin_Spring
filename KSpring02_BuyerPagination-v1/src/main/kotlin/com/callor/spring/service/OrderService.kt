package com.callor.spring.service

import com.callor.spring.model.Buyer
import com.callor.spring.model.Sales
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


interface OrderService {

    fun selectAll(): Array<Sales>
    fun selectAll(pageable: Pageable):Page<Sales>

    //    id값으로 조회하는 것을 제외하면 모두 Array 형식
    fun findById(seq: Long): Sales

    fun findByUserId(userid: String): Array<Sales>
    fun findByPname(pname: String): Array<Sales>

    fun findByDateDestance(sDate: String, eDate: String): Array<Sales>

    fun insert(sales: Sales): Sales
    fun delete(seq: Long)
    fun update(sales: Sales): Sales

    fun selectWithPageable(intPage:Int) : Array<Sales>
}