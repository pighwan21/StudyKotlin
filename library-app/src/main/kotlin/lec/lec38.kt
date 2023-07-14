package lec

// 38강. Querydsl 사용하기 - 첫 번째 방법

// UserRepository가 UserRepositoryCustom를 상속받도록함.
// UserRepositoryCustomImpl을 생성하고 로직 작성
// @Configuration가 붙은 QuerydslConfig를 생성

// 이 방식의 장점
// - 서비스단에서 UserRepository 하나만 사용하면 된다.
// (UserRepositoryCustom를 상속받았기 때문에)

// 이 방식의 단점
// - 인터페이스와 클래스를 항상 같이 만들어 주어야 하는 것이 부담이고 여러모로 번거롭다.

// 다음 시간에는 새로운 방식을 활용해 BookRepository의 getStatus()를 바꿔보자.