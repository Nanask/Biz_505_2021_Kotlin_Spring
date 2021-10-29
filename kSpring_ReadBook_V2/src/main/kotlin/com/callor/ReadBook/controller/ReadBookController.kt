package com.callor.ReadBook.controller

import com.callor.ReadBook.config.logger
import com.callor.ReadBook.model.BookDTO
import com.callor.ReadBook.model.ReadBookDTO
import com.callor.ReadBook.model.ReadBookVO
import com.callor.ReadBook.repository.BookRepository
import com.callor.ReadBook.repository.ReadBookRepository
import com.callor.ReadBook.service.ReadBookService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class ReadBookController(
        // 생성자 주입으로 2개의 Repository 를 가져온다.
//        val readBookDao:ReadBookRepository,
//        val bookDao:BookRepository) {
        val readBookService:ReadBookService){

    @RequestMapping(value = ["","/"], method =[ RequestMethod.GET])
    fun home() : String {
        return "redirect:/insert"
    }
    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert() : String {
        return "readbook/write"
    }
    @RequestMapping(value = ["/insert"], method = [RequestMethod.POST])
    fun insert(readbook: ReadBookVO):String {
        logger().debug(""">
            수신한데이터 {}""", readbook.toString())

//        val readBookDTO = ReadBookDTO(
//                isbn= readbook.isbn,
//                title = readbook.title,
//                content = readbook.content)
//        val bookDTO = BookDTO(
//                isbn = readbook.isbn,
//                title= readbook.title)
//
//        readBookDao.save(readBookDTO)
//        bookDao.save(bookDTO)

        readBookService.readBookInsert(readbook)

        return "redirect:/insert"
    }
}