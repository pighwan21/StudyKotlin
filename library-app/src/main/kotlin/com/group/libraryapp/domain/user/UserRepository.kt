package com.group.libraryapp.domain.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>, UserRepositoryCustom {    // UserRepositoryCustom도 상속받게 함.
    fun findByName(name: String): User?

//    @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.userLoanHistories")
//    fun findAllWithHistories(): List<User>      // 이 기능은 우리가 직접 JPQL을 작성해주어야함.

    // SELECT u FROM User u : findAll과 동일
    // DISTINCT 를 추가하면 u를 기준으로 같은 u에 대해서는 하나만 최종적으로 결과를 반환
    // FETCH 를 추가하면 join을 한번만 함

}