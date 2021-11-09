package com.callor.readbook.service

import com.callor.readbook.model.ReadBookVO

interface ReadBookService {

    fun readBookInsert(readbook: ReadBookVO)
    fun readBookList()
}