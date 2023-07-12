package lec

// 23강. Boolean에도 Enum 활용하기 - 책 반납 로직 수정

// Boolean이 2개가 되면 문제가 생긴다!
// 문제 1. Boolean이 2개 있기 때문에 코드가 이해하기 어려워진다.
// - 한 객체가 여러 상태를 표현할 수록 이해하기 어렵다.
// - 강의 예시의 경우 수는 2^2, 즉 4가지 이다.
// - 4가지로도 충분히 어렵지만, Boolean이 1개 더 늘어나면 2^3, 8가지 경우의 수가 나온다.

// 문제 2. Boolean 2개로 표현되는 4가지 상태가 모두 유의미하지 않다.
// - (isActive, isDeleted)는 총 4가지 경우가 있다.
// - (false, false) : 휴면 상태인 유져
// - (false, true) : 휴면이면서 탈퇴한 유저일 수는 없다.(휴면을 해지하고 로그인을 해야만 탈퇴할 수 있기에 존재할 수 없음)
// - (true, false) : 활성화된 유저이다.
// - (true, true) : 탈퇴한 유져이다.(활성화되어 있고, 탈퇴를 했으니 탈퇴한 유져)
// - 2번째 경우는 DB에 존재할 수 없는 조합이고, 이런 경우가 '코드'에서 가능한 것은 유지보수를 어렵게 만든다.

// 이를 해결하기 위해 Enum을 도입해보자!
// ex)
// enum class UserStatus {
//   ACTIVE,
//   IN_ACTIVE,
//   DELETED,
// }

// 이렇게 Enum을 활용하게 되면
// 1. 필드 1개로 여러 상태를 표현할 수 있기 때문에 코드의 이해가 쉬워지고
// 2. 정확하게 유이미한 상태만 나타낼 수 있기 때문에 코드의 유지보수가 용이해진다.