package org.lmuk.combinatorics

fun List<Any>.combination(k: Int): Int {
    return variation(k) / k.factorial()
}