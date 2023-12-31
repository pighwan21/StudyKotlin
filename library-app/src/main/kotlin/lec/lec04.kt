package lec;

// 4강. 사칙연산 계산기에 대한 테스트 코드 작성하기
// 계산기 요구사항
// 1) 계산기는 정수만을 취급한다.
// 2) 계산기가 생성될 때 숫자를 1개 받는다.
// 3) 최초 숫자가 기록된 이후에는 연산자 함수를 통해 숫자를 받아 지속적으로 계산한다.

// package com.group.libraryapp.calculator에 계산기(Calculator) 맹글어둠.

// 테스트 코드는 크게 3부분으로 나누어졌다.
// 1) 테스트 대상을 만들어 준비하는 과정 : given
// 2) 실제 우리가 테스트 하고 싶은 기능을 호출하는 과정 : when
// 3) 호출 이후 의도한대로 결과가 나왔는지 확인하는 과정 : then
// -> given-when-then 패턴