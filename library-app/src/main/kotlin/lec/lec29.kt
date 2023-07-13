package lec

// 29강. N+1 문제를 해결하는 방법! fetch join

// 지난 시간에 배웠던 join이라는 개념을 활용해서 N+1문제를 직접 해결해 볼 예정
// - 시작부터 유저만 n개 가져오는게 아니라 user와 user_loan_history를 join을 해서 한번에 모든 정보를 가져오는 것을 해보장

// UserRepository에 findAllWithHistories를 추가 하고 난 후 문제점
// 1) 테스트 자체가 깨진다. - 한 개가 아니라 세 개가 나온다.
// 2) 여전히 n+1문제가 발생한다.

// 해결방법
// 1) 테스트 자체가 깨진다 -> findAllWithHistories의 @Query() 에 DISTINCT를 추가해줘야함.
// 2) 여전히 n+1문제가 발생한다 -> FETCH를 사용하면 쿼리가 한번만 나감.