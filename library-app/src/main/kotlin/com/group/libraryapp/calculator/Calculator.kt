package com.group.libraryapp.calculator

class Calculator(
    var number: Int
) {
//  커스텀 겟터 사용(위의 private var number: Int를 private var _number: Int로 바꾼 후)
//    val number: Int
//        get() = this._number

    fun add(operand: Int) {
        this.number += operand
    }

    fun minus(operand: Int) {
        this.number -= operand
    }

    fun multiply(operand: Int) {
        this.number *= operand
    }

    fun divide(operand: Int) {
        if (operand == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
        this.number /= operand
    }
}