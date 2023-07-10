package lec14

// 14강. Kotlin과 JPA를 함께 사용할 때 이야기거리 3가지
// 1. setter에 관한 이야기
// - setter 대신 updateName이라는 추가적인 함수를 만들어줬었음.
// -> setter 대신 좋은 이름의 함수를 사용하는 것이 훨씬 clean하다.
// - 하지만 name에 대한 setter는 public이기 때문에 유저 이름 업데이트 기능에서 setter를 사용할 '수도' 있다.
// - 이렇듯 코드 상(setter가 열려있어서 .setName을 쓸 수 있음) setter를 사용할 '수도' 있다는 것이 불편하다.
// - public getter는 꼭 필요하기 때문에 setter만 private하게 만드는 것이 최선이다.
// ex) backing property 사용하기
// class User(
//   private var _name: String      // 내부에서는 _name에 접근하여 이름값을 바꿀 수 있고
// ) {
//
//   val name: String               // 외부에서는 불변인 name에 접근해서 단순히 값을 가져갈 수만 있음.
//     get() = this._name
//
// }
// ex) custom setter 이용하기
// class User(
//   name: String
// ) {
//
//   var name = name
//     private set
//
// }
// - 하지만 두 방법 모두 프로퍼티가(필드가) 많아지면 번거롭다!
// - 때문에 (개인적으로) setter를 열어는 두지만 사용하지 않는 방법을 선호!

// 2. 생성자 안의 프로퍼티, 클래스 body 안의 프로퍼티
// 1) 모든 프로퍼티를 생성자에 넣거나
// 2) 프로퍼티를 생성자 혹은 클래스 body 안에 구분해서 넣을 때 명확한 기준이 있으면 됨.

// 3. JPA와 data class
// - Entity에는 data class를 피하는 것이 좋다.
// - 이유: equals, hashCode, toString 모두 JPA Entity와는 100% 어울리지 않는 메소드.

// 작은 Tip)
// - Entity가 생성되는 로직을 찾고 싶다면 constructor 지시어를 명시적으로 작성하고 추적하자!