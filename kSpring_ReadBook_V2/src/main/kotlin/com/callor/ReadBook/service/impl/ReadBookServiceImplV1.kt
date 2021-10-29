package com.callor.ReadBook.service.impl

import com.callor.ReadBook.model.BookDTO
import com.callor.ReadBook.model.ReadBookDTO
import com.callor.ReadBook.model.ReadBookVO
import com.callor.ReadBook.repository.BookRepository
import com.callor.ReadBook.repository.ReadBookRepository
import com.callor.ReadBook.service.ReadBookService
import org.springframework.stereotype.Service

@Service("readBookServiceV1")
class ReadBookServiceImplV1(val reabookDao:ReadBookRepository,
                            val bookDao: BookRepository):ReadBookService {
    override fun readBookInsert(readbook: ReadBookVO) {
        val readBookDTO = ReadBookDTO(
                isbn= readbook.isbn,
                title = readbook.title,
                content = readbook.content)
        val bookDTO = BookDTO(
                isbn = readbook.isbn,
                title= readbook.title)

        reabookDao.save(readBookDTO)
        bookDao.save(bookDTO)
    }
}