package com.callor.readbook.model

import javax.persistence.*

@Entity
@Table(name= "tbl_readbook", schema = "naraDB")
data class ReadBook(

        @Id
        @Column(columnDefinition = "BIGINT")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var seq: Long,
        var isbn : String,
        var rdate : String,
        var stime : String,
        var etime : String,
        var rating : String,
        var comment : String,
)
