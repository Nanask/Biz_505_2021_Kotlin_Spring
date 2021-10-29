package com.callor.ReadBook.repository

import com.callor.ReadBook.model.BookDTO
import com.callor.ReadBook.model.ReadBookDTO
import org.springframework.data.jpa.repository.JpaRepository

interface ReadBookRepository:JpaRepository<ReadBookDTO,Long> {}
interface BookRepository:JpaRepository<BookDTO,String>{}