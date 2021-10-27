package com.callor.readbook.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name= "tbl_book", schema = "naraDB")
data class Book(

        @Id
        @Column(columnDefinition = "CHAR(13)", nullable = false, unique = true, name = "isbn")
        var isbn : String?="0",
        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        var title : String?="0",
        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        var comp : String?="0",
        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        var author : String?="0",
        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        var price : String?="0",

)
