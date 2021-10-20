package com.callor.spring.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * DTO(VO) 클래스
 */
@Entity
@Table(name="tbl_buyer", schema = "naraDB")
data class Buyer(
    @Id
    @Column(columnDefinition = "CHAR(4)",
        nullable = false, // not null
        unique = true,// UNIQUE
        name="userid")
    val userid: String,

    @Column(columnDefinition = "VARCHAR(25)", nullable = false)
    val name: String,

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    val tel: String,

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
     val manager: String,

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
     val man_tel: String,

    @Column(columnDefinition = "CHAR(4)", nullable = true)
     val buy_total: Int?=0,

    @Column(nullable = true)
    val address: String,
)