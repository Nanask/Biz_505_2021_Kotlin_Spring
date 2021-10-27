package com.callor.readbook.service

import com.callor.readbook.model.ReadBook

interface ReadBookService {

    fun selectAll(): Array<ReadBook>
    fun save(readBook: ReadBook):ReadBook
}