package com.group.libraryapp.calculator

fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest()
    calculatorTest.minusTest()
    calculatorTest.multiplyTest()
    calculatorTest.divideTest()
}
class CalculatorTest {

    fun addTest() {
        // 1단계 : 테스트 대상을 만드는 과정(given)
        val calculator = Calculator(5)

        // 2단계 : 테스트 하고 싶은 기능을 호출하는 과정(when)
        calculator.add(3)

        // 3단계 : 의도한대로 결과가 나오는지 확인하는 과정(then)

//  클래스 앞에 data 붙여줄 경우
//        val expectedCalculator = Calculator(8)
//        if (calculator != expectedCalculator) {
//            throw IllegalArgumentException()
//        }

//  커스텀 겟터 사용할 경우
        if (calculator.number != 8) {
            throw IllegalArgumentException()
        }
    }

    fun minusTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.minus(3)

        // then
        if (calculator.number != 2) {
            throw IllegalArgumentException()
        }
    }

    fun multiplyTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.multiply(3)

        // then
        if (calculator.number != 15) {
            throw IllegalArgumentException()
        }
    }

    fun divideTest() {
        // given
        val calculator = Calculator(15)

        // when
        calculator.divide(5)

        // then
        if (calculator.number != 3) {
            throw IllegalArgumentException()
        }
    }

    // 미리 나눗셈 테스트도 맹글어놨는데 다음 시간에 나눗셈 테스트 맹근다고 예고함..
}