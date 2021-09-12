package org.lmuk.statistics

fun List<Int>.median(): Int {
    val asSorted = sortedBy { it }
    return if (size % 2 == 0)
        asSorted[size / 2].plus(asSorted[size / 2 - 1]) / 2
    else asSorted[size / 2]
}