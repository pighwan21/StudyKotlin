package lec

// 6강. Junit5 사용법과 테스트 코드 리펙토링
// Junit5에서 자주 사용되는 5가지 어노테이션
// 1) @Test : 테스트 메소드를 지정한다. 테스트 메소드를 실행하는 과정에서 오류가 없으면 성공이다.
// 2) @BeforeEach : 각 테스트 메소드가 수행되기 전에 실행되는 메소드를 지정한다.
// 3) @AfterEach : 각 테스트가 수행된 후에 실행되는 메소드를 지정한다.
// 4) @BeforeAll : 모든 테스트를 수행하기 전에 최초 1회 수행되는 메소드를 지정한다.
// 5) @AfterAll : 모든 테스트를 수행한 후 최후 1회 수행하는 메소드를 지정한다.
// - BeforeAll, AfterAll에는 @JvmStatic을 붙여야 한다.

// 단언문
// ex) assertThat(calculator.number).isEqualTo(8)
// - calculator.number : 확인하고자 하는 값 // assertThat(확인하고 싶은 값)
// - .isEqualTo(8) : 기대하는 값           // .isEqualTo(기대값)

// 자주 사용되는 단언문 몇 가지
// 1) 주어진 값이 true인지 / false인지 검증
// val isNew = true
// assertThat(isNew).isTrue
// assertThat(isNew).isFalse

// 2) 주어진 컬렉션의 size가 원하는 값인지 검증
// val people = listOf(Person("A"), Person("B"))
// assertThat(people).hasSize(2)

// 3) 주어진 컬렉션 안의 item들에서 name이라는 프로퍼티를 추출한 후, 그 값이 A와 B인지 검증
//    (이때 순서는 중요하지 않다.)
// val people = listOf(Person("A"), Person("B"))
// assertThat(people).extracting("name").containsExactlyInAnyOrder("A", "B")

// 4) 주어진 컬렉션 안의 item들에서 name이라는 프로퍼티를 추출한 후, 그 값이 A와 B인지 검증
//    (이때 순서도 중요하다.)
// val people = listOf(Person("A"), Person("B"))
// assertThat(people).extracting("name").containsExactly("A", "B")

// 5) function1 함수를 실행했을 때 IllegalArgumentException이 나오는 검증
// assertThrows<IllegalArgumentException> {
//   function1()
// }

// 6) message를 가져와 예외 메시지를 확인할 수도 있다.
// val message = assertThrows<IllegalArgumentException> {
//   function1()
// }.message
// assertThat(message).isEqualto("잘못된 값이 들어왔습니다")


