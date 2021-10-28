package com.callor.readbook.service

import com.callor.readbook.model.Book

interface BookService {

    fun findByIsbn(isbn:String): Book
    fun save(book:Book):Book
}