package com.group.libraryapp.domain.user


import com.group.libraryapp.domain.user.QUser.user
import com.group.libraryapp.domain.user.loanhistory.QUserLoanHistory.userLoanHistory
import com.querydsl.jpa.impl.JPAQueryFactory

class UserRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory,
) : UserRepositoryCustom {

    override fun findAllWithHistories(): List<User> {
        return queryFactory.select(user).distinct()
            .from(user)
            .leftJoin(userLoanHistory).on(userLoanHistory.user.id.eq(user.id)).fetchJoin()
            .fetch()
    }
    // 의미
    // .select(user) : select *
    // .distinct() : distinct
    // .from(user) : from user
    // .leftJoin(userLoanHistory) : left join user_loan_history
    // .on(userLoanHistory.user.id.eq(user.id)) : on user_loan_history.user_id = user.id
    // .fetchJoin() : 앞의 join을 fetch join으로 간주한다. // 이게 없다면 N+1문제가 발생.
    // .fetch() : 쿼리를 실행한다.
}