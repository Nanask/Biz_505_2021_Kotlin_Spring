package com.callor.readbook.service.impl

import com.callor.readbook.model.BookDTO
import com.callor.readbook.model.ReadBookDTO
import com.callor.readbook.model.ReadBookVO
import com.callor.readbook.repository.BookRepository
import com.callor.readbook.repository.ReadBookRepository
import com.callor.readbook.service.ReadBookService
import org.springframework.stereotype.Service


@Service
class ReadBookServiceImplV1(val readbookDao:ReadBookRepository,
                            val bookDao: BookRepository):ReadBookService {

    override fun readBookInsert(readbook: ReadBookVO) {
        val readBookDTO = ReadBookDTO(
                isbn= readbook.isbn,
                title = readbook.title,
                content = readbook.content)
        val bookDTO = BookDTO(
                isbn = readbook.isbn,
                title= readbook.title)

        readbookDao.save(readBookDTO)
        bookDao.save(bookDTO)
    }

    override fun readBookList() {

        readbookDao.findAll()
        bookDao.findAll()
    }
}