package com.callor.ReadBook.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbl_books")
data class BookDTO(
    @Id
    @Column(columnDefinition = "VARCHAR(13)", nullable = false)
    var isbn:String,
    @Column(columnDefinition = "VARCHAR(125)", nullable = false, unique = false)
    var title:String?=null,

    var comp:String?=null,
    var author:String?=null,
    var price:Int?=0

)
