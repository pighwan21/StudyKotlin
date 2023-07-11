package lec

// #2 Java 서버를 Kotlin 서버로 리펙토링 하자! 목표
// 1. Java로 작성된 도서관리 애플리케이션을 Kotlin으로 완전히 리팩토링 한다.
// 2. Kotlin + JPA 코드를 작성하며, 사용에 익숙해진다.
// 3. Kotlin + Spring 코드를 작성하며, 사용에 익숙해진다.
// 4. Java 프로젝트를 Kotlin으로 리팩토링 해야 하는 상황에 대한 경험을 쌓는다.

// 11강. Kotlin 리팩토링 계획 세우기
// 1. 가장 먼저 Domain 부터 Kotlin으로 변경할 예정
// - 특징 : POJO, JPA Entity 객체
// 2. 다음으로 Repository를 리펙토링
// - 특징 : Spring Bean, 의존성 x
// 3. 대망의 Service를 리펙토링
// - 특징 : Spring Bean, 의존성 o, 비지니스 로직
// 4. 마지막으로 Controller와 DTO를 리펙토링
// - 특징 : Spring Bean, 의존성 o, DTO의 경우 간단하지만 그 숫자가 많음

// 이제부터 리팩토링을 진행하며 다양한 방법으로 활용해볼 예정.
// 또한, 각 단계별로 작성해둔 테스트를 지속적으로 실행시키며 모든 기능이 동작하는지 검증할 예정.
// 다음 시간 예고 : 도메인 계층부터 Kotlin으로 변경!