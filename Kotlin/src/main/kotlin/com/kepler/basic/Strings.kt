package com.kepler.basic

import java.util.*

fun main() {
    // repeat text
    println("${"some text".uppercase()} ${"!".repeat(10)}")

    // all, none, count functions
    var name: String
    name= "235356346"
    println(name.all { it.isDigit() })
    name= "#$#%^&^%$"
    println(name.none() { it.isLetter() })
    name= "qweasdzxc"
    println(name.count() { it.lowercase() in "aeiou" })

    // loop for chars
    val str = "abcde"
    for (c in str) {
        val char: Char = c
        print(char.uppercase() + 1 + "#" + '\t')
    }
    println()
    println("$str.length = ${str.length}")

    // multiline raw text
    val multilineText = """
    >line 1
    >line 2
    >line 3
    """.trimMargin(">")
    println(multilineText)

    println(
        """
            some "raw text' $$$ 
        """.trimIndent()
    )

    // regular expressions
    regularExpression()

    // find in string
    val findMe = "aaaa1aaaa"
    println("1 in string $findMe in index: ${findMe.indexOf("1")}")

    // substring / indexOf / count
    val subsub = "aaabbbbbcc"
    println(
        """
            ${subsub.substring(0, 3)}
            ${subsub.substring(subsub.indexOf("b"), subsub.lastIndexOf("b") + 1)}
            ${subsub.substring(subsub.indexOf("c"), subsub.lastIndexOf("c") + 1)}
            'b' find in string - ${subsub.count { it == 'b' }} times
        """.trimIndent()
    )

    // split
    for (i in "ff#fff#ffff#uuu#uu#u".split("#")) {
        print(i)
    }
    println()

    // equals
    println("aaa".equals("aaa"))
    println("aaa" == "aaa")  // equals
    println("aaa" === "aaa") // equals by links

    // unicode
    val capitalA: Char = 'A'
    val unicodeCapitalA: Char = '\u0041'
    val omSymbol = '\u0950'
    println("$capitalA $unicodeCapitalA $omSymbol")

    val args: Array<String> = arrayOf("1", "2", "3", "4", "5")
    println("$args - ${args.joinToString("#")}")

}

fun typedInput() {
    var scanner = Scanner(System.`in`)
    scanner.nextInt()       // Reading Int
    scanner.nextFloat()     // Reading Float
    scanner.nextDouble()    // Reading Double
    scanner.nextBoolean()   // Reading Boolean
    scanner.nextShort()     // Reading Short
    scanner.nextLong()      // Reading Long
    scanner.nextLine()      // Reading String
}

fun simpleInput() {
    var input1 = readln()       // String
    var input2 = readlnOrNull() // String?

    var input3: Int = readLine()!!.toInt() // read integer value
    var input4: Int? = readLine()?.toIntOrNull() // read integer value
}

fun regularExpression() {
    // match 1
    val sourceString1 = "3573563785672"
    if (sourceString1.matches("""\d+""".toRegex())) {
        println("Only number in text")
    }

    // match 2
    val sourceString2 = "3573563785672"
    val regex: Regex = Regex("\\d+")
    if (sourceString2.matches(regex)) {
        println("Only number in text")
    }

    // replace
    println("1#2$%%$34%%#567#%$$##89%##$#0".replace("[#$%]".toRegex(), ""))

    // find all
    val sourceString3 = "192.168.1.150 some text 192.168.1.200 some text 192.168.1.123"
    val regex3 = """(\d+)\.(\d+)\.(\d+)\.(\d+)""".toRegex()

    regex3.findAll(sourceString3).forEach {
        println(
            "Value - ${it.value}, " +
                    "by groups - ${it.groupValues[1]} " +
                    "--- ${it.groupValues[2]} " +
                    "--- ${it.groupValues[3]} " +
                    "--- ${it.groupValues[4]}"
        )
    }

    // find first
    val sourceString4 = "129.168.1.150 some text 129.168.1.200 some text 129.168.1.123"
    val regex4 = """(\d+)\.(\d+)\.(\d+)\.(\d+)""".toRegex()

    println("Find first value -  ${regex4.find(sourceString4)?.value}")

}