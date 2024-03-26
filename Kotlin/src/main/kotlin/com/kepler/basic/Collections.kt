package com.kepler.basic

import java.io.File

fun main() {
    listFun()
    fileFunc()
    setFun()
    castCollections()
    arraysFun()
    deleteFromArray()
    iteratorFun()
    letterPrinterUseless()
    letterPrinterUseful()
    mapFun()
    castMapList()
    packUnpack()
}

fun castMapList() {
    val price = List(4) {
        (100..1000).random()
    }
    val title = listOf("pencil", "rule", "eraser", "book")

    // way 1
    val magazine1: Map<String, Int> = List(title.size) { index ->
        title[index] to price[index]
    }.toMap()
    println(magazine1)

    // way 2
    val pairs: List<Pair<String, Int>> = List(title.size) { index ->
        title[index] to price[index]
    }
    val magazine2 = pairs.toMap()
    println(magazine2)

    // loop for map
    magazine1.forEach { (title, price) ->
        println("$title = ${"%.2f".format(price / 3.0)}")
    }

    magazine2.forEach {
        println("${it.key} = ${"%.2f".format(it.value / 3.0)}")
    }

}

fun mapFun() {
    val map1 = mapOf(
        1 to "one",
        2 to "two",
        3 to "three",
    )
    println(map1)
    map1.forEach { println(it) }

    val map2 = mapOf(
        Pair(1, "one"),
        Pair(2, "two"),
        Pair(3, "three"),
    )
    println(map2)

    println("${map1[1]}")
    println("${map1.getValue(1)}")
    println(
        "${
            map1.getOrElse(
                500, {
                    // lambda
                    "pitsot"
                })
        }"
    )
    // println(map1.getOrDefault(500, "pitsot?")) // todo fix it!

    val map3: MutableMap<Int, String> = mutableMapOf()
    map3 += 1 to "one"
    map3.put(2, "two")
    map3.putAll(
        listOf(
            3 to "three",
            4 to "four",
        )
    )
    // map3.putIfAbsent(3 to "???") // todo fix it!
    println("1 is contains in map: ${map3.contains(1)} and has value: ${map2[1]}")
    map3.put(1, "pitsot")
    println(map3.getOrPut(1) { "ololo" })
    println(map3.getOrPut(500) { "ololo" })
    println(map3)
    println(map3.remove(500))
    map3 -= 1
    println(map3)
    map3.clear()

}

fun letterPrinterUseful() {
    // using return mark
    ('a'..'z').forEach mark@{ letter ->
        if ("aeiouy".contains(letter)) {
            return@mark
        }
        print(letter)
    }
    println()
}

fun letterPrinterUseless() {
    ('a'..'z').forEach { letter ->
        if ("aeiouy".contains(letter)) {
            return
        }
        print(letter)
    }
    println()
}

fun iteratorFun() {
    val array = intArrayOf(1, 2, 3, 4, 5)
    val iterator = array.iterator()
    while (iterator.hasNext()) {
        print("${iterator.nextInt()}")
        if (!iterator.hasNext()) {
            println()
        }
    }
}

fun deleteFromArray() {
    // remove 5 from array
    // way 1 - filter
    val array1 = intArrayOf(1, 2, 3, 4, 5)
    array1.filter { it != 5 }.forEach { println(it) } // this is a list!!!
    val array1_1 = array1.filter { it != 5 }.toTypedArray()
    array1_1.forEach { println(it) }

    // way 2 - obvious cast to list
    var array2 = intArrayOf(1, 2, 3, 4, 5)
    val list = array2.toMutableList()
    list.removeAt(4)
    array2 = list.toIntArray()
    array2.forEach { println(it) }
}

fun arraysFun() {
    val arr1: IntArray = intArrayOf(1, 2, 3)
    println(arr1)
    arr1.forEach {
        println(it)
    }
    arr1[0] = 500
    println(arr1[0])
}

fun castCollections() {
    val coll1 = listOf(1, 2, 3, 1, 2, 3, 1, 2, 3)
        .toSet()
        .toMutableList()
    coll1.forEach {
        println("${it}")
    }

    val coll2 = listOf(1, 2, 3)
    (coll2 as MutableList)[0] = 500
    println(coll2)
}

fun setFun() {
    println("!!! Set functions !!!")
    val planets = setOf("Mercury", "Venus", "Earth", "Earth", "Earth")
    println(planets)
    println(planets.contains("Pluto"))
    println("Earth" in planets)
    println(planets.elementAt(2))

    val names = setOf("Alex", "Mordoc", "Sophie", "Tariq")
    val surnames = setOf("Ironfoot", "Fernsworth", "Baggins", "Downstrider")
    val fio: MutableSet<String> = mutableSetOf()
    repeat(5) {
        fio.add(" ${"!".repeat(it + 1)} ${names.random()} ${surnames.random()}")
    }
    fio.forEachIndexed { index, item ->
        println("${index} - ${item}")
    }

    val someSet = mutableSetOf(1, 2)
    println(someSet)
    someSet.add(3)
    println(someSet)
    someSet.addAll(listOf(1, 2, 3, 4, 5))
    println(someSet)
    someSet -= 5
    println(someSet)
    someSet += 5
    println(someSet)
    someSet.remove(1)
    println(someSet)
    someSet.removeAll(listOf(4, 5))
    println(someSet)
    someSet.clear()
    println(someSet)

}

fun listFun() {
    println("!!! List functions !!!")
    // immutable list
    val x0 = listOf("one", "two", "three")
    println(x0)

    val x1: List<String> = listOf("one", "two", "three")
    println(x1)

    val x2: List<Any> = listOf("one", 1, { 1 == 2 })
    println(x2)

    // mutable list
    var x3: MutableList<Int> = mutableListOf(1, 2, 3)
    x3.add(4)                  // add after last element
    x3.add(0, 0) // add with index
    x3.removeAt(0)       // by index
    x3.remove(4)       // by element
    x3.removeAll(listOf(1, 2)) // removing list of items
    x3.clear()
    println(x3)
    x3 = mutableListOf(1, 2, 3)

    // create list with constructor
    val xx = List(4) {
        "ololo"
    }
    println(xx)

    // get values
    println("x0[0] = ${x0[0]} = ${x0.get(0)}")
    println("${x0.first()} .. ${x0.last()}")
    println(x0.getOrElse(5) { "ololo, unknown number" }) // control ArrayIndexOutOfBoundsException with lambda
    println(x0.getOrNull(5)) // control ArrayIndexOutOfBoundsException returned Null

    // set values
    x3[0] = 500
    println("${x3[0]}")
    x3.set(0, 1)

    println("${x1.toMutableList() - "one"} *** ${x1.toMutableList() + "four"}")

    // contains
    if (x0.contains("one")) {
        println("x0 contains One")
    }

    if (x3.containsAll(listOf(1, 2, 3))) {
        println("x3 contains 1, 2, 3")
    }

    // cast mutable / immutable
    var x4 = listOf(1)
    val x5 = x4.toMutableList()
    x5.addAll(listOf(2, 3))
    x5.toList()
    x4 = x5
    println(x4)

    // iterators
    for (item in x0) {
        println(item)
    }

    x0.forEach {
        println(it)
    }

    x0.forEach(::println) // transfer method as parameter

    x0.forEachIndexed { index, item ->
        println("$index --- $item")
    }

    for (i in x0.size - 1 downTo 0) {
        println("desc - ${x0[i]}")
    }
}

fun fileFunc() {
    println("!!! File functions !!!")
    val data1: List<String> = File("data/data1.txt")
        .readText()
        .split("\r\n")
    println(data1)
    println("")

    val data2 = File("data/data1.txt").readLines()
    data2.forEach(::println)
    println()

    val data3 = Thread.currentThread().contextClassLoader.getResource("data3.txt")
        ?.readText()
        ?.split("\r\n")
    println(data3)

    val data4 = File("data/data4.txt").readLines()
    val items4 = List(data4.size) { index ->
        val (_, name, _, salary) = data4[index].split(";")
        println(salary)
        name
    }
    println(items4)
    println(items4.random())
}

fun packUnpack() {
    val juniors = arrayOf("Ivan", "Oleg", "Igor")
    val middles = listOf("Joan", "Tim")

    juniors.forEach {
        print(it)
    }
    println()
    printAny(*juniors)
    println()

    val salaryFork = mutableMapOf(
        *juniors.map { // unpack array
            it to 500
        }.toTypedArray(), // cast type to map
        *middles.map {
            it to 1500
        }.toTypedArray(),
    )

    println(salaryFork)
}

fun printAny(vararg somebody: String) {
    somebody.forEach(::print)
}