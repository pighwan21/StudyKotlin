package lec

// 22강. Enum Class를 활용해 책의 분야 리팩토링 하기

// 기존 구조의 문제점 1.
// - 요청을 검증하고 있지 않다.(실제 DB에 잘못된 값이 들어갈 수도 있다)
// ex) COMPUTER를 COMPPUTER로 요청한다던지
// - 검증을 할 수는 있지만, 번거롭다.
// ex)
// init {
//   if (name.isEmpty()) {
//     throw IllegalArgumentException("이름은 비어 있을 수 없습니다.")
//   }
//
//   if (type !in AVAILABLE_BOOK_TYPES) {
//     throw IllegalArgumentException("들어올 수 없는 타입입니다.")
//   }
// }
//
// companion object {
//   private val AVAILABLE_BOOK_TYPES = listOf("COMPUTER", "ECONOMY", "SOCIETY", "LANGUAGE", "SCIENCE")
// }

// 기존 구조의 문제점 2.
// - 코드만 보았을 때, DB 테이블에 어떤 값이 들어가는지 알 수 없다.

// 기존 구조의 문제점 3.
// - type과 관련된 새로운 로직을 작성할 때 번거롭다.
// ex) 책을 대출할 때마다 분야별로 '이벤트 점수'를 준다면..?
// fun getEventScore(): Int {
//   return when (type) {
//     "COMPUTER" -> 10
//     "ECONOMY" -> 8
//     "SOCIETY", "LANGUAGE", "SCIENCE" -> 5
//     else -> throw IllegalArgumentException("잘못된 타입입니다.")
//   }
// }
// 1) 코드에 분기(when)가 들어가고,
// 2) 실행되지 않을 else문이 존재하며,
// 3) 문자열 타이핑을 실수할 여지가 많고,
// 4) 새로운 type이 생기는 경우 로직 추가를 놓칠 수 있다.

// type: String의 단점 정리
// 1. 현재 검증이 되고 있지 않으며, 검증 코드를 추가 작성하기 번거롭다.(관리하기도 쉽지 않다.)
// 2. 코드만 보았을 때 어떤 값이 DB에 있는지 알 수 없다.
// 3. type과 관련한 새로운 로직을 작성할 때 번거롭다.

// 이러한 단점들을 어떻게 해결할 수 있을까?!
// -> Enum Class를 활용하자!
// enum class BookType {
//   COMPUTER,
//   ECONOMY,
//   SOCIETY,
//   LANGUAGE,
//   SCIENCE,
//   ;
// }

// 기존 구조의 문제점 1 - 해결
// - DTO에서 Enum을 사용하고 있기 때문에 바로 검증된다.

// 기존 구조의 문제점 2 - 해결
// - Enum 클래스를 보면 알 수 있다.
// - 심지어 주석을 적절히 활용하면 유지보수도 용이하다.(BookType의 주석 참고)

// 기존 구조의 문제점 3 - 해결
// - enum도 하나의 클래스이기 때문에 프로퍼티를 넣을 수도 있고, enum 자체의 프로퍼티에 초기값을 줄 수도 있다.
// ex 1)
// enum class BookType(val score: Int) {
//   COMPUTER(10),
//   ECONOMY(8),
//   SOCIETY(5),
//   LANGUAGE(5),
//   SCIENCE(5),
//   ;
// }

// ex 2)
// fun getEventScore(): Int {
//   return type.score
// }
// 1) 다형성을 활용해 코드에 분기가 없고
// 2) 실행되지 않을 else문도 제거되어 함수가 깔끔해졌으며,
// 3) BookType 클래스에 score를 위임해 문자열 타이핑도 사라졌고
// 4) 새로운 Type이 추가될 때 score를 빠뜨릴 수 없다. - 유지보수성 탁월

// 추가로 개선할 부분!
// Enum을 사용하면 DB에는 어떻게 데이터가 들어갈까?
// - 숫자로 저장이 됨..

// Enum이 숫자로 DB에 저장되면 발생하는 문제
// 1) 기존 Enum의 순서가 바뀌면 아주 큰 일이 난다.
// 2) 기존 Enum 타입의 삭제, 새로운 Enum 타입의 추가가 제한적이다.

// 위에 대한 해결 방법으로 @Enumerated(EnumType.STRING)이 있다.

// 정리
// 1. Type을 문자열로 관리할 때는 몇 가지 단점이 존재한다.
// 2. Enum Class를 활용하면 손쉽게 단점을 제거할 수 있다.
// 3. Enum Class를 Entity에 사용할 때는 @Enumerated(EnumType.String)을 잘 활용해 주어야 한다.