package com.group.libraryapp.dto.book.response

import com.group.libraryapp.domain.book.BookType

class BookStatResponse(
    val type: BookType,
    val count: Long,
) {
//    fun plusOne() {
//        count++
//    } // 이 함수가 사라짐에 따라 위의 count 필드도 다시 val로 바뀜.
}