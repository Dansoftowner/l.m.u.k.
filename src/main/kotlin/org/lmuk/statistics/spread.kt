package org.lmuk.statistics

fun Iterable<Int>.spread(): Int {

    val max = maxOrNull()
    val min = minOrNull()

    return try {
        max!! - min!!
    } catch (e: NullPointerException) {
        0
    }
}