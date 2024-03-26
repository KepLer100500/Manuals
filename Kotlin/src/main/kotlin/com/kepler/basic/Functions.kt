package com.kepler.basic

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis


fun main() {
    println(sum(1, 2))
    println(inlineSum(2, 3))

    printSumAndSub(1, 2)
    printSumAndSub(a = 3, b = 4)

    println(sumDefaultArguments())
    println(sumDefaultArguments(1, 2))
    println(sumDefaultArguments(b = 500))

    println(sumEven(1, 2, 3, 4, 5, 6))
    println(sumEven(*intArrayOf(1, 2, 3, 4, 5, 6))) // for vararg fun

    try {
        todoFunction()
    } catch (e: NotImplementedError) {
        println(e.message)
    }

    overloadedFun()
    overloadedFun(1)
    overloadedFun(1, 2)

    `very bad name to function`()

    mapFunc()
    associateFun()
    flattenFun()
    flatMapFun()
    filterFun()
    zipFun()
    sequenceFun()
    profilingFun()
    accumulateFun()

    varargFun("one")
    varargFun("one", "two")
    varargFun("one", "two", "three")

    applySeeFunction()
    letSeeFunction()
    runSeeFunction()
    withSeeFunction()
    alsoSeeFunction()
    takeIfSeeFunction()
}

public fun sum(a: Int, b: Int): Int {
    return a + b
}

private fun inlineSum(a: Int, b: Int): Int = a + b

fun printSumAndSub(a: Int, b: Int) { // Unit -> void
    val c: Int = sum(a, b)

    println("Sum $a and $b = $c")
    println("Sub $a and $b = ${a - b}")
}

fun sumDefaultArguments(a: Int = 10, b: Int = 20): Int {
    return a + b
}

fun sumEven(vararg numbers: Int): Int {
    var result = 0
    numbers.forEach {
        if (it % 2 == 0) {
            result += it
        }
    }
    return result
}

fun todoFunction(): Nothing {
    TODO("This function not finished!!! Zapili!!!") // return error!
    println("This string is not printed!")
}

fun overloadedFun() {
    println("Overload nothing to print!")
}

fun overloadedFun(a: Int) {
    println("Overload printer: $a")
}

fun overloadedFun(a: Int, b: Int) {
    println("Overload printer: $a, $b")
}

fun `very bad name to function`() {
    println("very bad name to function")
}

fun mapFunc() {
    // modify items
    val strings = listOf("1", "2", "3")
    val numbers = strings.map {
        it.toDouble() * 2
    }
    println("$strings - is a List<String> - ${strings is List<String>}")
    println("$numbers - is a List<Double> - ${numbers is List<Double>}")
}

fun associateFun() {
    // create map
    // way 1
    val products1 = listOf(
        "pencil ${(100..1000).random()}",
        "rule ${(100..1000).random()}",
        "eraser ${(100..1000).random()}",
        "book ${(100..1000).random()}",
    )
    println(products1)

    val magazine1 = products1.associate { product ->
        val (title, price) = product.split(" ")
        title to price
    }
    println(magazine1)

    // way 2
    val products2 = listOf(
        listOf("pencil", (100..1000).random()),
        listOf("rule", (100..1000).random()),
        listOf("eraser", (100..1000).random()),
        listOf("book", (100..1000).random()),
    )
    println(products2)
    val magazine2 = products2.associate { (title, price) ->
        title to price
    }
    println(magazine2)
}

fun flattenFun() {
    val chars = listOf(
        listOf("!", "@", "#", "$"),
        listOf("a", "o", "e", "i"),
        listOf("B", "C", "D", "F"),
    )
    println(chars.flatten())
}

fun flatMapFun() {
    val chars = listOf(
        listOf("!", "@", "#", "$"),
        listOf("a", "o", "e", "i"),
        listOf("B", "C", "D", "F"),
    )
    val modifiedList = chars.flatMap { line ->
        line.filter { singleChar ->
            singleChar.contains("[a-z]|[A-Z]".toRegex())
        }
    }
    println(modifiedList)
}

fun filterFun() {
    val chars = listOf(
        listOf("!", "@", "#", "$"),
        listOf("a", "o", "e", "i"),
        listOf("B", "C", "D", "F"),
    ).flatten()

    println("${chars.take(3)} - ${chars.drop(3)}")

    println(
        chars.filter {
            it.contains("[!@#$]".toRegex())
        }.joinToString(" - ")
    )
}

fun zipFun() {
    val firstList = setOf(1, 2, 3)
    val secondList = setOf("a", "b", "c")

    println(
        firstList.zip(secondList) // List Pair
    )

    println(
        firstList.zip(secondList) { firstElement, secondElement ->
            secondElement to firstElement // List Pair
        }
    )

    println(
        firstList.zip(secondList) { firstElement, secondElement ->
            "$firstElement : $secondElement" // List
        }
    )

    println(
        firstList.zip(secondList) { firstElement, secondElement ->
            secondElement.repeat(firstElement) // List
        }
    )

}

fun sequenceFun() {
    val tolpa = generateSequence(11) {// start item - 11
        it + 1
    }.filter { it % 2 == 0 }
        .take(30) // work until we find 30 elements
        .toList()
    println(tolpa)

    val tenElements = generateSequence(0) {
        it + 1
    }.take(10).toList()
    println(tenElements)
}

fun profilingFun() {
    val nanoSeconds = measureNanoTime {
        generateSequence(0) {
            it + 1
        }.filter { it % 2 == 0 }
            .take(10000)
            .toList()
    }

    val milliSeconds = measureTimeMillis {
        generateSequence(0) {
            it + 1
        }.filter { it % 2 == 0 }
            .take(10000)
            .toList()
    }

    println("milliSeconds: $milliSeconds, nanoSeconds: $nanoSeconds")
}

fun accumulateFun() {
    val someList = listOf("a", "b", "c", "d", "e", "f")
    println(
        someList.reduce { acc, s -> // initial element in acc - first element in collection
            acc + s.repeat(acc.length)
        }
    )
    println(
        someList.fold("!") { acc, s -> // initial element in acc - from argument
            acc + s.repeat(acc.length)
        }
    )

    val someDoubleList = listOf(1, 2, 3, 4, 5)
    println(
        someDoubleList.sumOf {
            it * 2
        }
    )

}

fun varargFun(vararg messages: String) {
    messages.forEach {
        print("${it} ")
    }
    println()

}

fun applySeeFunction() {
    // apply - nothing return from lambda
    // apply - into container may call methods by the object -> this
    val someList = mutableListOf<String>().apply {
        if (true) {
            add("one")
        }
        add("two")
        repeat(1) {
            add("three")
        }
    }
    println(someList)
}

fun letSeeFunction() {
    // let - return last expression form lambda
    val someList = mutableListOf<String>()
    var name = someList.firstOrNull().let {
        "$it Ololo"
    }
    println(name)

    name = someList.firstOrNull() ?: "Net nicho"
    println(name)
}

fun runSeeFunction() {
    // return value from lambda, call methods by 'this' object
    val list = mutableListOf("one", "two", "three")
    val firstValue = list.run {
        shuffle()
        first()
    }
    println(firstValue)
}

fun withSeeFunction() {
    // return value from lambda, call methods by 'this' object
    // the same - run
    val list = mutableListOf("one", "two", "three")
    val firstValue = with(list) {
        shuffle()
        first()
    }
    println(firstValue)
}

fun alsoSeeFunction() {
    // not return lambda value
    val list = mutableListOf("one", "two", "three")
    list
        .also {
            println(list)
        }
        .also {
            list.shuffle()
        }
        .also {
            println(list)
        }
        .also {
            list.shuffle()
        }
        .also {
            println(list)
        }
        .also {
            list.shuffle()
        }
}

fun takeIfSeeFunction() {
    val someList = mutableListOf("one", "two", "three")
    val isContainFour = someList.takeIf {
        it.contains("four")
    } ?: "Four is not in collection!"
    println(isContainFour)
}