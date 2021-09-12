package org.lmuk.combinatorics

import org.lmuk.checkExit

private val tasks = mapOf<String, (items: List<Any>) -> Unit>(
    "permutation" to fun(items) = println("Permutations: ${items.permutation()}"),
    "variation" to fun(items) {
        print("Specify the number of elements you want to select (should be <= than ${items.size}): ")
        val k = checkExit(readLine())!!.toInt()
        print("Can reuse elements? (Y/N)")
        val canReuseElements = checkExit(readLine())!! == "Y"
        println("Variations: ${items.variation(k, canReuseElements)}")
    },
    "combination" to fun(items) {
        print("Specify the number of elements you want to select (should be <= than ${items.size}): ")
        val k = checkExit(readLine())!!.toInt()
        println("Combinations: ${items.combination(k)}")
    }
)

fun main() {
    printHeader()
    val items = parseUserInput(checkExit(readLine()))

    while (true) {
        println("Select the tasks you want to perform:")
        println("* " + tasks.keys.joinToString(separator = "\n* "))
        val input = checkExit(readLine())
        tasks[input]?.invoke(items) ?: throw RuntimeException("The task '$input' does not exists")
        println()
    }
}

private fun parseUserInput(input: String?): List<Any> =
    input!!.split(",").map(String::trim)

private fun printHeader() {
    println("-".repeat(50))
    println("Combinatorics")
    println("-".repeat(50))
    println("Specify items separated by commas (,):")
}