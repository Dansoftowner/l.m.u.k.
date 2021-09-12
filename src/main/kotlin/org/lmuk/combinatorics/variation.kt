package org.lmuk.combinatorics

import kotlin.math.pow

fun List<Any>.variation(k: Int, canReuseElements: Boolean = false): Int {
    require(k <= size)
    return if (canReuseElements) size.toDouble().pow(k.toDouble()).toInt() else permutation() / (size - k).factorial()
}