package com.group.libraryapp.lec01;

// 1강. 도서관리 애플리케이션 리팩토링 준비하기 목표(도서관리 애플리케이션 이해하기)
// 목표 : Java로 만들어진 프로젝트를 Koltin으로 리펙토링 한 후 새로운 요구사항을 구현!
// 1. Java로 작성된 도서관리 애플리케이션을 이해한다.
// 2. 테스트 코드가 무엇인지 왜 필요한지 이해하고, Junit5를 사용해 Spring Boot의 테스트 코드를 작성한다.
// 3. 실제 만들어진 Java 프로젝트에 대해 Kotlin으로 테스트를 작성하며 Kotlin 코드 작성에 익숙해진다.

// 1) 도서관리 애플리케이션 소개 - User 관련 기능
// (1) 도서관의 사용자를 등록할 수 있다.(이름 필수, 나이 선택)
// POST /user (유저 생성 API)
// 요청 :
// {
//   "name" : String
//   "age"  : Int
// }
// 응답 : 성공시 200 OK

// (2) 도서관 사용자의 목록을 볼 수 있다.
// GET /user (유저 목록조회 API)
// 요청 : 파라미터 없음
// 응답 :
// [{
//    "id" : long
//    "name" : String
//    "age" : Int
// }, ...]

// (3) 도서관 사용자 이름을 업데이트 할 수 있다.
// PUT /user (유저 이름변경 API)
// 요청 :
// {
//   "id" : Long
//   "name" : String // 변경되어야 하는 이름
// }
// 응답 : 성공시 200 OK

// (4) 도서관 사용자를 삭제할 수 있다.
// DELETE /user (유저 삭제 API)
// 요청 :
// {
//   "name" : String
// }
// 응답 : 성공시 200 OK

// 2) 도서관리 애플리케이션 소개 - Book 관련 기능
// (1) 도서관에 책을 등록할 수 있다.
// POST /book (도서 등록 API)
// 요청 :
// {
//   "name" : String // 책 이름
// }

// (2) 사용자가 책을 빌릴 수 있다. (진작 대출되어 있는 책을 빌릴 수는 없다.)
// POST /book/loan (도서 대출 API)
// 요청 :
// {
//   "userName" : String
//   "bookNmae" : String
// }
// 응답 : 성공시 200 OK

// (3) 사용자가 책을 반납할 수 있다.
// PUT /book/return (도서 반납 API)
// 요청 :
// {
//   "userName" : String
//   "bookName" : String
// }
// 응답 : 성공시 200 OK