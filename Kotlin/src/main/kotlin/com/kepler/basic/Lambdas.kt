package com.kepler.basic

import kotlin.random.Random
import kotlin.random.nextInt


fun main() {
    var message = "ololo"

    // "count" may process lambda expressions
    println("Mississippi".count())
    println("Mississippi".count { letter -> letter == 's' })
    println("Mississippi".count { it == 's' })

    // last line is returned in lambda expression
    println({
        val i = 1
        message.uppercase() + "!".repeat(i)
    }())

    // lambda without parameters
    val myFun0: () -> String = {
        val i: Int = 3
        message.uppercase() + "!".repeat(i)
    }
    println(myFun0())

    // lambda without parameters, auto detect return type
    val myFun1 = {
        val i: Int = 5
        message.uppercase() + "!".repeat(i)
    }
    println(myFun1())

    // lambda with one parameter
    val myFun2: (Int) -> String = {
        message.uppercase() + "!".repeat(it)
    }
    println(myFun2(7))

    // lambda with more than one parameter
    val myFun3: (Int, Int) -> String = { i, j ->
        message.uppercase() + "!".repeat(i + j)
    }
    println(myFun3(7, 2))

    // lambda with more than one parameter, auto detect return type
    val myFun4 = { i: Int, j: Int ->
        message.uppercase() + "!".repeat(i + j)
    }
    println(myFun4(7, 4))

    // put body function into variable
    var myFun5: (String) -> String // init function
    when (Random.nextInt(1..3)) {
        1 -> {
            myFun5 = {
                "$it 1"
            }
        }

        2 -> {
            myFun5 = {
                "$it 2"
            }
        }

        else -> {
            myFun5 = {
                "else - $it 3"
            }
        }
    }
    println(myFun5("test"))

    // lambda as input parameter in function
    val isEven: (Int) -> Boolean = {
        val result: Boolean
        result = (it % 2 == 0)
        result
    }
    val isOdd: (Int) -> Boolean = { it % 2 == 1 }

    val myFun6: (Int, (Int) -> Boolean) -> String = { x, someFunction ->
        if (someFunction(x)) {
            "$someFunction ($x) - it's true"
        } else {
            "$someFunction ($x) - it's false"
        }
    }
    println("isEven function in parameter - ${myFun6(4, isEven)}")
    println("isOdd function in parameter - ${myFun6(4, isOdd)}")

    // put function as parameter by link
    println(myFun6(4, ::standardEvenFunction))
    println(myFun6(5, ::standardEvenFunction))

    // inline functions as parameter
    println(inlineEvenOrOdd(8))

    // work with variables out of lambda expression
    var xxx = 0
    println({
        xxx = 500
        "Value is changed! - $xxx"
    }())

}

inline fun inlineEvenOrOdd(
    x: Int,
    isEvenOrOdd: (Int) -> Boolean = { it % 2 == 0 }
): String {
    return if (isEvenOrOdd(x)) {
        "$x - it's even"
    } else {
        "$x - it's odd"
    }
}

fun standardEvenFunction(x: Int) = (x % 2 == 0)