package org.lmuk.statistics

import org.lmuk.checkExit

private val tasks: Map<String, (items: List<Int>) -> Unit> = mapOf(
    "frequency" to fun(items) {
        print("Specify the number you want the frequency of: ")
        val input = checkExit(readLine())?.toInt()
        println("Frequency of '$input' is '${items.frequency(input)}'")
    },
    "relative-frequency" to fun(items) {
        print("Specify the number you want the relative frequency of: ")
        val input = checkExit(readLine())?.toInt()
        println("The relative frequency of '$input' is '$input/${items.size}' -> '${items.relativeFrequency(input)}'")
    },
    "spread" to fun(items) = println("Spread: ${items.spread()}"),
    "average" to fun(items) = println("Average: ${items.average()}"),
    "median" to fun(items) = println("Median: ${items.median()}"),
    "modus" to fun(items) = println("Modus: ${items.modus()}")
)

fun main() {
    printHeader()
    val items = parseUserInput(checkExit(readLine())!!)

    while (true) {
        println("Select the tasks you want to perform:")
        println("* " + tasks.keys.joinToString(separator = "\n* "))
        val input = checkExit(readLine())
        tasks[input]?.invoke(items) ?: throw RuntimeException("The task '$input' does not exists")
        println()
    }
}

private fun parseUserInput(input: String): List<Int> =
    input.split(",").map(String::trim).map(String::toInt)

private fun printHeader() {
    println("-".repeat(50))
    println("Statistics")
    println("-".repeat(50))
    println("Specify integer numbers separated by commas (,):")
}