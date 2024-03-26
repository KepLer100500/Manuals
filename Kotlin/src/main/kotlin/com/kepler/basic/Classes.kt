package com.kepler.basic

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * public
 * private
 * protected
 * internal
 */

// init class

data class MyPoint private constructor(var x: Int, var y: Int) {
    class Builder() {
        private var x: Int = 0
        private var y: Int = 0
        fun x(x: Int) = apply { this.x = x } // TODO
        fun y(y: Int): Builder {
            val builder = this
            builder.y = y
            return builder
        }

        fun build(): MyPoint {
            return MyPoint(x, y)
        }
    }
}

class Employee {
    var name: String = ""
        get() = field.uppercase()
    var surname: String = "Ololoev"
        private set
    private val fio: String // calculated private field
        get() {
            return "$name $surname"
        }
    var salary: Int = 500
        get() {
            return if (name == "KepLer") {
                100000000
            } else {
                field
            }
        }
        set(value) {
            field = value * 10
        }

    override fun toString(): String {
        return "Employee(name='$name', surname='$surname', fio='$fio' salary=$salary)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Employee

        if (name != other.name) return false
        if (surname != other.surname) return false
        if (salary != other.salary) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + surname.hashCode()
        result = 31 * result + salary
        return result
    }

}

class MyColor(var r: Int = 0, g: Int = 0, b: Int = 0) {
    var g: Int = g
    var b: Int = b

    override fun toString(): String {
        return when {
            r == 255 && g == 0 && b == 0 -> "RED"
            r == 0 && g == 255 && b == 0 -> "GREEN"
            r == 0 && g == 0 && b == 255 -> "BLUE"
            else -> "hZ =)"
        }
    }
}

class MyLine(private var point1: MyPoint, private var point2: MyPoint) {
    // var color: MyColor? = MyColor()
    // var color: MyColor? = null

    var color: MyColor? = null
    lateinit var typeLine: String // see to create instance
    val alpha by lazy { // initialize before call field ("by" - delegate)
        (0..100).random()
    }

    constructor(initPoint1: MyPoint, initPoint2: MyPoint, color: MyColor) : this(
        point1 = initPoint1,
        point2 = initPoint2
    ) {
        this.color = color
    }

    init {
        println("Init block! Instance is created! Color = $color")
    }

    fun printDistanceWithTwoPoints() {
        val distance = sqrt((point2.x - point1.x).toDouble().pow(2) + (point2.y - point1.y).toDouble().pow(2))
        println("Distance from points: $point1, $point2 = ${myRound(distance, 2)}")
        print("Color this line: $color - #")
        color?.let {// check - color is not Null
            println("${it.r}/${it.g}/${it.b}")
        }
    }

    private fun myRound(number: Double, decimals: Int): Double {
        return "%.${decimals}f".format(number).replace(",", ".").toDouble()
    }

}

///////////////////////////////////////

// inheritance

open class MyShape(val title: String, protected open var color: String) {
    constructor() : this("title for empty constructor", "color for empty constructor")

    operator fun component1() = color
    operator fun component2() = title

    open fun printDetails() {
        println("title = $title, color = $color")
    }

    final fun generalDetails() {
        println("General details!!!")
    }

    override fun toString(): String {
        return "MyShape(title='$title', color='$color')"
    }

    companion object {
        private const val MY_CONST = "Constanta 1"

        init {
            println("Companion is created") // run in first call parent class
        }

        fun companionFunction() {
            println("It is 'Static' method!!! $MY_CONST")
        }
    }
}

class MyCircle : MyShape("default title", "default color") {
    public override var color: String = "default circle color"

    override fun printDetails() {
        println("This is Circle! Color = $color")
        generalDetails() // method from superclass
    }

    fun printCircleDetails() {
        println("This is Circle!!!")
    }

    override fun toString(): String {
        return "MyCircle(title='$title', color='$color')"
    }

}

fun useEveryShape(element: MyShape) {
    element.printDetails()
}

fun printAny(any: Any) {
    println("Any: $any")
    when (any) {
        is MyCircle -> println("This is circle")
        is MyShape -> println("This is shape")
        else -> println("o_O")
    }
}

// singleton - object

object Game {
    init {
        println("Game is started")
    }

    fun someUselessFunction() {
        1 + 1
    }

    class Player(val name: String) { // nested class
        fun printName() {
            println(name)
        }
    }
}

data class Coordinate(val x: Int, val y: Int) {
    operator fun plus(other: Coordinate): Coordinate {
        return Coordinate(x + other.x, y + other.y)
    }
    operator fun minus(other: Coordinate) = Coordinate(x - other.x, y - other.y)
    operator fun compareTo(other: Coordinate): Int { // compare only if X and Y > other coordinate
        return when {
            x > other.x && y > other.y -> 1
            x < other.x && y < other.y -> -1
            else -> 0
        }
    }
}
enum class Direction(private val directionCoordinate: Coordinate) {
    UP(Coordinate(0, - 1)),
    DOWN(Coordinate(0, 1)),
    LEFT(Coordinate(-1, 0)),
    RIGHT(Coordinate(1, 0)); // ; <- !!!

    fun updateCoordinate(coordinate: Coordinate): Coordinate {
        return Coordinate(
            x = coordinate.x + directionCoordinate.x,
            y = coordinate.y + directionCoordinate.y
        )
    }

    fun updateCoordinateImproved(coordinate: Coordinate) = coordinate + directionCoordinate
}

fun main() {
    // initialize

    val point1 = MyPoint.Builder().x(10).y(10).build()
    val point2 = MyPoint.Builder().x(5).y(5).build()

    val line1 = MyLine(point1, point2)
    line1.color = MyColor(255, 0, 0)
    line1.printDistanceWithTwoPoints()
    line1.typeLine = "dashed" // lateinit
    println("line1.typeLine = ${line1.typeLine}")

    val line2 = MyLine(point1, point2, MyColor(0, 255, 0))
    line2.printDistanceWithTwoPoints()
    println("line2.alpha = ${line2.alpha}")

    val employee = Employee()
    employee.name = "Petr"
    println(employee)

    // inheritance

    val shape: MyShape = MyShape("test title", "RED")
    shape.printDetails()

    val circle: MyCircle = MyCircle()
    circle.color = "GREEN"
    circle.printDetails()
    circle.printCircleDetails()

    val circle2: MyShape = MyCircle()
    circle2.printDetails()

    println("--- POLYMORPHISM ---")
    useEveryShape(shape)
    println()
    useEveryShape(circle)
    println()
    useEveryShape(circle2)
    println()

    // check types - "is" function

    println("shape is MyShape and MyCircle: ${shape is MyShape}, ${shape is MyCircle}")
    println("circle is MyShape and MyCircle: ${circle is MyShape}, ${circle is MyCircle}")
    println("circle2 is MyShape and MyCircle: ${circle2 is MyShape}, ${circle2 is MyCircle}")

    val shapeClassName = when (circle) {
        is MyCircle -> "MyCircle"
        is MyShape -> "MyShape"
        else -> {
            "WTF?"
        }
    }
    println("circle is - $shapeClassName")

    // Any superclass
    printAny(shape)
    printAny(circle)
    printAny(circle2)

    // cast - "as" function
    circle.printCircleDetails()
    (circle as MyShape).printDetails() // MyShape don't have printCircleDetails() method

    try {
        println("${5 as String}")
    } catch (err: ClassCastException) {
        println("ClassCastException: ${err.message}")
    }
    println("${5 as? String}") // "as?" - save cast

    // singleton
    // object declaration
    Game.someUselessFunction() // first - call "init" block

    // object expression
    val triangle = object : MyShape() { // anonymous class
        override fun printDetails() {
            super.printDetails()
            println("Object triangle!")
        }
    }
    triangle.printDetails()

    // companion object
    MyShape.companionFunction()

    // nested class
    val player = Game.Player("User1")
    player.printName()

    // data class MyPoint
    val point11: MyPoint = MyPoint.Builder().x(10).y(20).build()
    val point22: MyPoint = MyPoint.Builder().x(10).y(20).build()
    println("point11.toString() = ${point11.toString()}")
    println("point11.hashCode() = ${point11.hashCode()}")
    println("point11.equals(point22) = ${point11.equals(point22)}")
    val point33 = point11.copy()
    val point44 = point11.copy(x = 50)
    println(point33)
    println(point44)

    // destructuring
    val (x, y) = point11
    println("x = $x, y = $y")
    val (color, title) = shape
    println("color = $color, title = $title") // operator fun component1() = color

    // enum
    val directionUp: Direction = Direction.UP
    println(directionUp)
    var currentPosition = Coordinate(x = 0, y = 0)
    currentPosition = Direction.DOWN.updateCoordinate(currentPosition)
    currentPosition = Direction.DOWN.updateCoordinate(currentPosition)
    currentPosition = Direction.RIGHT.updateCoordinate(currentPosition)
    currentPosition = Direction.RIGHT.updateCoordinate(currentPosition)
    currentPosition = Direction.RIGHT.updateCoordinate(currentPosition)
    currentPosition = Direction.LEFT.updateCoordinateImproved(currentPosition)
    println("currentPosition = $currentPosition")

    // overload operators
    println("(0,0) > ${currentPosition}: ${Coordinate(x = 0, y = 0) > currentPosition}")
    println("(0,0) < ${currentPosition}: ${Coordinate(x = 0, y = 0) < currentPosition}")
    println("(5,2) = (5,2): ${Coordinate(5,2 ) == Coordinate(5,2 )}")


    // 356
}
