package com.callor.readbook.service.impl

import com.callor.readbook.model.Book
import com.callor.readbook.repository.BookRepository
import com.callor.readbook.service.BookService
import org.springframework.stereotype.Service

@Service("book")
class BookServiceImpl(val bRepo: BookRepository):BookService {

    override fun findByIsbn(isbn: String): Book {
        TODO("Not yet implemented")
    }

    override fun save(book: Book): Book {
        return bRepo.save(book)
    }


}