package org.lmuk.statistics

fun <T> Iterable<T>.frequency(value: T): Int {
    return count { it == value }
}

fun <T> List<T>.relativeFrequency(value: T): Float {
    return frequency(value).toFloat() / size
}