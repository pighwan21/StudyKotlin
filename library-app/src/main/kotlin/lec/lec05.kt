package lec;

// 5강. 사칙연산 계산기의 나눗셈 테스트 작성

// 수동으로 만든 테스트 코드의 단점
// 1) 테스트 클래스와 메소드가 생길 때마다 메인 메소드에 수동으로 코드를 작성해주어야 하고, 메인 메소드가 아주 커진다.
//    테스트 메소드를 개별적으로 실행하기도 어렵다.
// 2) 테스트가 실패한 경우 무엇을 기대하였고, 어떤 잘못된 값이 들어와 실패했는지 알려주지 않는다.
//    예외를 던지거나, try~catch를 사용해야 하는 등 직접 구현해야할 부분이 많아 불편하다.
// 3) 테스트 메소드 별로 공통적으로 처리해야 하는 기능이 있다면, 메소드마다 중복이 생긴다.

// 이러한 단점을 극복하기 위해 나온 것이 Junit!
// 다음 시간에는 Junit5의 사용법을 알아보고, 사칙연산 계산기 Test 코드를 Junit5로 리펙토링 해보겠음!