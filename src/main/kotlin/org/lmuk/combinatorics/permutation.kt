package org.lmuk.combinatorics

fun List<Any>.permutation(): Int {
    val baseFactorial = size.factorial()
    val repeatingItemsFactorials = groupingBy { it }.eachCount().values.map(Int::factorial).reduce(Int::times)
    return baseFactorial / repeatingItemsFactorials
}