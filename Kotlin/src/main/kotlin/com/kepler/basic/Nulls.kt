package com.kepler.basic

fun main() {
    var x1 = if ((0..10).random() > 1) null else "some text"

    println("x1?.length - ${x1?.length}")
    // println(x1!!.length) // error, x1 = null

    // let - work only if x1 != null
    val length = x1?.let {
        println("got it!")
        it.length
    }
    println(length)

    // Elvis
    val x2: String? = null
    println(x2?.length ?: "Ouch!")
}