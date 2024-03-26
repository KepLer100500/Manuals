package com.kepler.basic

import java.text.NumberFormat
import kotlin.math.round
import kotlin.math.roundToInt

fun main() {
    // signed types
    val byte: Byte
    val short: Short
    val int: Int
    val long: Long

    val float: Float
    val double: Double

    // unsigned values
    val uByte: UByte
    val uShort: UShort
    val uInt: UInt
    val uLong: ULong

    var level: UInt = 5u // 5 - unsigned, only positive!
    level++
    level += 1u
    // level += 1 // error! UInt + Int
    // level = 10 // error! UInt = Int
    // level = -1 // error! UInt = negative value
    val newLevel = level.toInt() + 10
    level = newLevel.toUInt()

    println((-1).toUInt())                  // 4294967295
    println((1000000000000000000).toInt())  // -1486618624
    println((1000000000000000000).toUInt()) // 2808348672

    // values with point
    println(5 / 2)
    println(5 / 2.0)
    println(5 % 2)

    println(0.01f * 5 == 0.05f) // false - float
    println(0.01 * 5 == 0.05)   // true - double

    println("${123.45678} - ${round(123.45678 * 100) / 100}") // round by 2 digits after comma

    // format
    println(String.format("%07d", 123))
    println(String.format("$%.2f", 123.123456))
    println("#%,.2f".format(123456789.123456789))

    val formatter = NumberFormat.getCurrencyInstance()
    println(formatter.format(123456789.123456789))

    // cast
    println((123.789).toInt())      // 123
    println((123.789).roundToInt()) // 124
    println((123).toDouble())       // 123.0

    // constants
    println(Double.POSITIVE_INFINITY)
    println(Double.NEGATIVE_INFINITY)
    println(Double.NaN)
    println(Int.MAX_VALUE)
    println(Int.MIN_VALUE)

    // base systems
    println(123.toString(radix = 2))
    println(123.toString(radix = 16))

    // bit operations
    val a: Int = 42
    println(a.shl(2)) // << 2
    println(a.shr(2)) // >> 2
    println(a.inv()) // inversion bits
    println(a.xor(33)) // 001011
    println(a.and(10)) // 1010

}