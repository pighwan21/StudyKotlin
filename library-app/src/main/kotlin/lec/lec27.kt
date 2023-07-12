package lec

// 27강. N+1 문제와 N+1 문제가 발생하는 이유

// 서버 코드를 보고 Query를 생각할 수 있어야 한다.
// 1. 저장 기능. userRepository.save(newUser) : insert user 쿼리가 발생
// 2. 조회 기능. userRepository.findAll() : select user 쿼리가 발생

// UserService의 getUserLoanHistories 메소드의 경우
// - 최초에 모든 유져를 가져오고(쿼리 1회), Loop를 통해 유저별로 히스토리를 가져온다(쿼리 N회) - 유저가 10명이면 10번의 쿼리가 발생

// 만약 유저가 100명이면? 1,000명이면? 100,000명이면? -> 데이터베이스에 부하가 발생하고 전체 시스템에 장애가 올 수도 있음. 이를 N+1 문제라 함.

// * JPA 1:N 연관관계의 동작 원리
// - 최초 유저 로딩시 가짜 List<UserLoanHistory>가 들어간다.
// - 시작부터 모든 진짜 히스토리를 들고오는 것은 상황에 따라 비효율적일 수도 있기 때문.
// - 실제 히스토리에 접근할때에 진짜 UserLoanHistory를 불러온다.
// - 이러한 전략을 Lazy Fetching이라고 한다.

// * N+1 문제를 해결하는 방법
// - SQL의 join query를 알아야 한다.

// 다음 시간에는 join query에 대해 알아보겠음~~
