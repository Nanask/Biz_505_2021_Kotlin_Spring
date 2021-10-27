package com.callor.readbook.service.impl

import com.callor.readbook.model.ReadBook
import com.callor.readbook.repository.ReadBookRepository
import com.callor.readbook.service.ReadBookService
import org.springframework.stereotype.Service


@Service
class ReadBookServiceImpl(val rbRepo:ReadBookRepository):ReadBookService {

    override fun selectAll(): Array<ReadBook> {
        return rbRepo.findAll().toTypedArray()
    }

    override fun save(readBook: ReadBook): ReadBook {
        return rbRepo.save(readBook)
    }


}