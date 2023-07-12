package com.group.libraryapp.domain.book

import javax.persistence.*

@Entity
class Book(
    val name: String,

    @Enumerated(EnumType.STRING)
    val type: BookType,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

) {

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다.")
        }
    }

    // Object Mother 페턴, Test Fixture라고도 부름.
    companion object {  // companion object : 해당 클래스와 연관된 객체, 다른 프로그래밍 언어의 정적(static) 메소드와 유사한 역할.
        fun fixture(    // 새로운 컬럼이 추가되더라도 테스트 코드에 영향을 주지 않고, 이곳에서 빨간줄이 뜸.
            name: String = "책 이름",      // 책의 이름을 나타냄. 값이 제공되지 않으면 기본값으로 "책 이름"이 설정됨.
            type: BookType = BookType.COMPUTER,    // 책의 유형을 나타냄. 값이 제공되지 않으면 기본값 "COMPUTER"가 설정됨.
            id: Long? = null,             // 책의 식별자(ID)를 나타냄. 선택적 매개변수이며(null 가능) 값이 제공되지 않ㄹ으면 null일 수 있음.
        ): Book {
            return Book(
                name = name,
                type = type,
                id = id,
            )
        }
    }
}