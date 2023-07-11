package lec

// 12강. 도메인 계층을 Kotlin으로 변경하기 - Book.java

// 코틀린 폴더에 Book entity 생성, 자바 폴더에 Book entity 제거
// 임포트 맞춰주고 BookServiceTest 돌리면 실패
// - Caused by: java.lang.NoClassDefFoundError: kotlin/reflect/full/KClasses
// - gradle.build의 dependencies에 implementation 'org.jetbrains.kotlin:kotlin-reflect:1.6.21'를 추가해줘야함.
// - 추가 후 테스트 돌리면 정상 작동.