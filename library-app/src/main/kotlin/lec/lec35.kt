package lec

// 35강. 애플리케이션 대신 DB로 기능 구현하기

// 1. fun findAllByStatus(status: UserLoanStatus): List<UserLoanHistory>
// select * from user_loan_history where status = ?;
// 1) DB에 존재하는 데이터를 모두 가져와서
// 2) 애플리케이션이 그 size를 계산한다: .size

// 2. fun countByStatus(status: UserLoanStatus): Long
// select count(*) from user_loan_history where status = ?;
// 1) DB로부터 숫자를 가져와
// 2) 적절히 타입을 변환해준다: .toInt()

// 겉보기에 두 기능은 완전히 동일하다.
// - 하지만 내부 동작은 전혀 다르다.

// 1번 방법 : 전체 데이터 쿼리 메모리 로딩 + size
// 2번 방법 : count 쿼리 + 타입 변환

// 두 방법 중 후자인 2번 방법이 더 좋음.
// - DB 및 Network 부하, 애플리케이션 부하가 덜 든다.
// - 10만건, 100만건, 1000만건, 1억건 -> 부하를 고려해야 한다.

// 1번 방법
// return bookRepository.findAll()         // List<Book>
//            .groupBy { book -> book.type }      // Map<BookType, List<Book>>
//            .map { (type, books) -> BookStatResponse(type, books.size) } // List<BookStatResponse>
// - 1번 방법은 책 데이터를 메모리에 모두 가져온 다음에, 모두 가져온 리스트를 가지고 함수형 프로그래밍을 돌리는 코드

// 2번 방법
// return bookRepository.getStats()
// - 2번 방법은 애당초 DB에서 데이터를 가져올 때 group by 쿼리를 보내 필요한 데이터만 가져오는 기능


// 정리
// 1번 방법 : 전체 데이터 쿼리. 메모리 로딩 + grouping
// 2번 방법 : group by 쿼리
// - (상황에 따라 다르지만) Network 부하, 애플리케이션 부하가 후자쪽이 덜 든다.
// - 인덱스를 이용해 튜닝할 여지가 있다.

// 데이터의 양 / 트래픽 / 다른 비지니스 요구사항 등에 따라 또 다른 방법을 사용해야 할 수도 있다.
// (그때 그때 달라요~)

// 다음 시간에는 이번 섹션에 대해 간단히 정리해보겠음.

