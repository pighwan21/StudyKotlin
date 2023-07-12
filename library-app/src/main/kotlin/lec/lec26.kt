package lec

// 26강. 유저 대출 현황 보여주기 - 테스트 코드 개발

// 무엇을 검증해야 할까?
// 1. 사용자가 지금까지 한 번도 책을 빌리지 않은 경우 API 응답에 잘 포함되어 있어야 한다.
// 2. 사용자가 책을 빌리고 아직 반납하지 않은 경우 isReturn 값이 false로 잘 들어 있어야 한다.
// 3. 사용자가 책을 빌리고 반납한 경우 isReturn 값이 true로 잘 들어 있어야 한다.
// 4. 사용자가 책을 여러권 빌렸는데, 반납을 한 책도 있고 하지 않은 책도 있는 경우,
//    중첩된 리스트에 여러 권이 정상적으로 들어가 있어야 한다.

// 2번, 3번은 4번을 검증할 때 자연스럽게 검증될 것이므로 1번 case와 4번 case에 대한 테스트를 작성해보자~

// 큰 테스트 코드 1개보다 작은 테스트 코드 2개가 나은 이유
// (개인적으로) 복잡한 테스트 1개 보다, 간단한 테스트 2개가 유지보수하기 용이하다.
// 테스트가 합쳐지게 되면, 앞 부분에서 실패가 나는 경우 뒷 부분은 아예 검증되지 않는다.
// 따라서 복잡한 테스트 1개보다 작은 테스트 N개를 선호.