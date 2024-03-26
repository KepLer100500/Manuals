package com.kepler.basic

import kotlin.random.Random

data class SomeClass(val text: String) // Class with default equals/hashcode/toString and with constructor

fun main() {
    val a: SomeClass = SomeClass("Hello")
    val b = SomeClass("Hello")

    if (a == b) {
        println("Equals by value")
    } else {
        println("Not equals by value")
    }

    if (a === b) {
        println("Equals by link")
    } else {
        println("Not equals by link")
    }

    var x11 = if ((0..10).random() > 1) null else "some text"

    if (3 in 1..10 step 2) {
        println("3 in 1..10 by step 2 - ${1..10 step 2} - true")
    }

    if (5 is Int) {
        println("5 is Int")
    }

    println(if (false) "false" else "true")

    // when with 1 parameter
    val someString = "one" // if enter "500 ebaso" -> printed 500
    val somethingOutput = when (someString) { // type sets automate
        "two" -> "ONE!!!"
        "one", "three" -> "ONE!!! or three?"
        "500 ebaso" -> 500
        else -> "BAD!!!"
    }
    println(somethingOutput)
    // when with 1 parameter
    val somethingOutput2 = when (val someNumber = 3) {
        1 -> 11
        in 2..10 -> 500
        else -> 1000
    }
    println(somethingOutput2)
    // when with more 1 parameter
    val x1 = 20
    val x2 = 30
    val x3 = when {
        x1 == 200 -> {
            "x1 is true"
        }

        x2 > 20 -> {
            "x2 is true"
        }

        else -> "??"
    }
    println(x3)

    // random
    println(
        """
            random - ${Random.nextInt(0, 10)}
            random - ${(0..10).random()}
        """.trimIndent()
    )

    // loops
    // for
    for (i in 1..5) {
        println(i)
    }

    for (h in 0.."qwerty".length step 2) {
        println(h)
    }

    for (h in "qwerty".length downTo 0) {
        println(h)
    }

    for (h in 0 until "qwerty".length) {
        println(h)
    }

    for (h in (0..10).filter { it % 2 == 0 }) {
        println(h)
    }

    "qwerty".forEach {
        println(it)
    }

    "qwerty".forEach(::println) // transfer method as parameter

    "qwerty".forEachIndexed { index, item ->
        println("$index --- $item")
    }

    // while
    var j = 0
    while (j < 5) {
        println(j)
        j++
    }

    var k = 0
    do {
        println(k)
        k++
    } while (k < 5)

    val secretCode = mutableListOf<Int>()
    while (secretCode.size < 10) {
        secretCode.add("123456789".random().digitToInt())
    }
    println(secretCode.joinToString(prefix = "#", postfix = "!!!", separator = ""))
}


