package com.kepler.basic


const val PLAYER: String = "Ololoshka" // global constant
private const val CAMERA: String = "camera" // local constant

fun main() {
    val x1: Int = 3
    val one = 1 // Int
    val threeBillion = 3000000000 // Long
    val oneLong = 1L // Long
    val oneByte: Byte = 1
    val pi = 3.14 // Double
    // val oneDouble: Double = 1 // Error: type mismatch
    val oneDouble = 1.0 // Double
    val e = 2.7182818284 // Double
    val eFloat = 2.7182818284f // Float -> 2.7182817

    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    val tab = '\t'
    val boolVal = true
    val boolNull: Boolean? = null

    var x2 = 1000 // var - mutable type, val - immutable
    x2 = 500

    println(
        """
            $PLAYER
            $CAMERA
            $x1
            $one
            $threeBillion
            $oneLong
            $oneByte
            $pi
            $oneDouble
            $e
            $eFloat
            $oneMillion
            $creditCardNumber
            $socialSecurityNumber
            $hexBytes
            $bytes
            $tab
            $boolVal
            $boolNull
            $x2
        """.trimIndent()
    )
}