package com.callor.spring.repository

import com.callor.spring.model.Sales
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

// Repository Interface 생성
// JpaRepository를 상속받고 데이터 DTO와 테이블의 PK 값을 Generic으로 설정해준다
interface SalesRepository : JpaRepository<Sales, Long> {

    fun findByPname(pname: String): Array<Sales>
    fun findByUserid(userid: String): Array<Sales>
    @Query("SELECT S FROM Sales S")
    fun findWithPagination(pageRequest: PageRequest): List<Sales>

}