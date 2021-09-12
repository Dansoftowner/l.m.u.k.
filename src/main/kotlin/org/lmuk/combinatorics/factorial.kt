package org.lmuk.combinatorics

fun Int.factorial(): Int {
    if (this < 2)
        return 1
    return this * (this - 1).factorial()
}