package com.kepler.basic


fun main() {
    // try 1
    try {
        badFun1()
    } catch (e: Exception) {
        println("Vse ploho - ${e.message} - ${e.stackTrace.asList()}")
    } finally {
        println("Nu okey =/\n")
    }

    // try 2
    val message = try {
        badFun2()
    } catch (e: IllegalArgumentException) {
        "No vse slomalos =)"
    }
    println("$message\n")

    // try3
    try {
        badFun3()
    } catch (e: IllegalStateException) {
        println("Ili net...")
    }
    println()

    // test expression
    assert(false, {"Assert taki srabotal"}) // add "-ea" key option in run JVM

}

fun badFun1() {
    throw MyBadException()
}

fun badFun2(x: Int = -1) {
    require(x > 0) {
        println("Vse horosho!")
    }
}

fun badFun3() {
    checkNotNull(null) {
        println("Normas!")
    }
}

class MyBadException():
    IllegalArgumentException("$$$ MyBadException $$$")
