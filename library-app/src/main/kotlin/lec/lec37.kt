package lec

// 섹션6. 네 번째 요구사항 추가하기 - Querydsl

// 37강. Querydsl 도입하기

// 목표
// 1. JPQL과 Querydsl의 장단점을 이해할 수 있다.
// 2. Querydsl을 Kotlin + Spring Boot와 함께 사용할 수 있다.
// 3. Querydsl을 활용해 기존에 존재하던 Repository를 리팩토링 할 수 있다.

// 기술적인 요구사항
// - 현재 사용하는 JPQL은 몇 가지 단점이 있다.
// - Querydsl을 적용해서 단점을 극복하자.

// JPQL은 무슨 단점이 있을까?
// ex) @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.userLoanHistories")
//     fun findAllWithHistories(): List<User>
// - 문자열이기 때문에 '버그'를 찾기가 어렵다.
// - JPQL 문법이 일반 SQL과 조금 달라 복잡한 쿼리를 작성할 때마다 찾아보아야 한다.

// ex) fun findByName(userName: String): User?
//     fun findByNameAndAge(userName: String, age: Int?): User?
//     fun findByNameAndAgeAndId(userName: String, age: Int?, id: Long?): User?
// - 조건이 복잡한 동적쿼리를 작성할 때 함수가 계속해서 늘어난다.

// ex) fun findByBookNameAndStatus(bookName: String, status: UserLoanStatus): UserLoanHistory?
// - 프로덕션 코드 변경에 취약하다.

// JPQL과 Spring Data JPA의 단점 정리
// 1. 문자열로 쿼리를 작성하기에 버그를 찾기 어렵다.
// 2. 문법이 조금 달라 그때마다 검색해 찾아보아야 한다.
// 3. 동적 쿼리 작성이 어렵다.
// 4. 도메인 코드 변경에 취약하다.

// 이런 단점을 보완하기 위해 Querydsl이 등장.
// - Spring Data JPA와 Querydsl을 함께 사용하며 서로를 보완해야 한다.
// - Querydsl : 코드로 쿼리를 작성하게 해주는 도구.
// ex)
// fun findAll(name: String): List<User> {
//   return queryFactory.select(user)
//     .from(user)
//     .where(
//        user.name.eq(name)
//     )
//     .fetch()
// }


// build.gradle에 querydsl 관련 코드 추가.
// -> build/generated/source/kapt/main/.../Qbook.java 가 추가 되었씀!!