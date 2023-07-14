package com.group.libraryapp.domain.user.loanhistory

import org.springframework.data.jpa.repository.JpaRepository

interface UserLoanHistoryRepository : JpaRepository<UserLoanHistory, Long> {

    fun findByBookNameAndStatus(bookName: String, status: UserLoanStatus): UserLoanHistory?

    fun findAllByStatus(status: UserLoanStatus): List<UserLoanHistory>
    // select * from user_loan_history where status = ?;
    // 1) DB에 존재하는 데이터를 모두 가져와서
    // 2) 애플리케이션이 그 size를 계산한다: .size

    fun countByStatus(status: UserLoanStatus): Long
    // select count(*) from user_loan_history where status = ?;
    // 1) DB로부터 숫자를 가져와
    // 2) 적절히 타입을 변환해준다: .toInt()
}