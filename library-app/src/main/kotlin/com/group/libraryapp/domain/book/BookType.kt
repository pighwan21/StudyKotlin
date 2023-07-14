package com.group.libraryapp.domain.book

enum class BookType {
    COMPUTER,
    ECONOMY,

    // 사회 분야는 2022-12-31 이후로 입고되지 않지만,
    // DB에는 과거 기록이 있다.
    SOCIETY,
    LANGUAGE,
    SCIENCE,
    MYSTERY,
}