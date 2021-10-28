package com.callor.readbook.controller

import com.callor.readbook.model.Book
import com.callor.readbook.model.ReadBook
import com.callor.readbook.service.BookService
import com.callor.readbook.service.ReadBookService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value = ["/read"])
class ReadBookController() {

    private val logger = LoggerFactory.getLogger(ReadBookController::class.java)

    @Autowired
    private lateinit var rbService:ReadBookService

    @Autowired
    private lateinit var bService: BookService

    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert():String {
//        var rbList = rbService.selectAll()
//
//        logger.debug("rbList 보기", rbList)
        return "read/write"
    }

//    @ResponseBody
    @RequestMapping(value = ["/insert"], method = [RequestMethod.POST])
    fun insert(model:Model, readBook: ReadBook, book:Book):String {
    var rbList = rbService.save(readBook)
    var bList = bService.save(book)

        logger.debug("rbList 보기", rbList)
    return "redirect:/read/insert"
//        return "read/write"
//        return rbList;
    }


}