package com.example.curry

fun main () {
    curry()
}

fun curry() {
    val simpleSpice = SimpleSpice()

    println(
        "${simpleSpice.name} ${simpleSpice.heat}"
    )

}