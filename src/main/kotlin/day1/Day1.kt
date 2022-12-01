package day1

import common.splitByEmptyLines
import kotlin.math.max

fun maxCalories(lines: Sequence<String>): Long {
    return lines.fold(0L to 0L) { (maxSum, currSum), line ->
        if (line.isEmpty()) return@fold maxSum to 0
        val newSum = currSum + line.toLong()
        max(maxSum, newSum) to newSum
    }.first
}

fun topKHolders(lines: Sequence<String>, k: Int): Long {
    return lines.splitByEmptyLines()
        .map { it.sumOf(String::toLong) }
        .sortedDescending()
        .take(k).sum()
}