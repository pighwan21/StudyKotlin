package com.group.libraryapp.repository.book

import com.group.libraryapp.domain.book.QBook.book
import com.group.libraryapp.dto.book.response.BookStatResponse
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class BookQuerydslRepository(
    private val queryFactory: JPAQueryFactory,
) {

    fun getStats(): List<BookStatResponse> {
        return queryFactory
            .select(
                Projections.constructor(            // 주어진 DTO의 생성자를 호출한다는 의미.
                    BookStatResponse::class.java,   // 주어진 DTO
                    book.type,                      // 주어진 DTO의 뒤에 나오는 파라미터들(book.type, book.id.count())이
                    book.id.count()                 // 생성자로 들어간다.
                )
            )
            .from(book)                             // 여기까지의 쿼리를 SQL로 바꾸면 select type, count(book.id) from book;
            .groupBy(book.type)                     // group by type
            .fetch()                                // 전체쿼리를 실행시켜서 결과를 가져온다는 의미.
    }   // select type, count(book.id) from book group by type; 으로 생각할 수 있음
}