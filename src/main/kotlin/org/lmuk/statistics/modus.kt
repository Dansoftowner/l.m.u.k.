package org.lmuk.statistics

fun <T> Iterable<T>.modus(): List<T> {
    val counts = groupingBy { it }.eachCount()

    var maxCount = 0
    val modusElements = mutableListOf<T>()

    for (it in counts.keys) {
        val count = counts[it]!!
        when {
            maxCount == count -> modusElements.add(it)
            maxCount < count -> {
                modusElements.clear()
                maxCount = count
                modusElements.add(it)
            }
        }
    }

    return modusElements.toList()
}