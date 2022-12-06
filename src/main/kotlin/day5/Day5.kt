package day5

import java.util.SortedMap

typealias Stack = MutableList<Char>

data class Move(val from: Int, val to: Int, val by: Int)

fun day5a(input: String): String {
    return simulateStacks(input, removeElements = MutableList<Char>::removeLastElementsReversed)
}

fun day5b(input: String): String {
    return simulateStacks(input, removeElements = MutableList<Char>::removeLastElements)
}

fun simulateStacks(input: String, removeElements: (MutableList<Char>, Int) -> List<Char>): String {
    val (stacksText, movesText) = input.split("\n\n")
    val stacks = readStacks(stacksText)

    readMoves(movesText)
        .forEach { move ->
            val from = stacks[move.from]!!
            val to = stacks[move.to]!!
            val elements = removeElements.invoke(from, move.by)
            to.addAll(elements)
        }

    return (1 .. stacks.size)
        .map { stacks[it]!!.last() }
        .joinToString(separator = "")
}
fun readStacks(text: String): SortedMap<Int, Stack> {
    val indices = text.lines().last()
        .trim()
        .split(" ").filter { it.isNotBlank() }
        .map { it.toInt() }
    return text.lines()
        .dropLast(1)
        .flatMap { line ->
            line.chunked(4)
                .mapIndexed { i, s -> i to s[1] }
                .filter { it.second.isLetter() }
        }.groupBy(
            { it.first },
            { it.second }
        ).mapValues { ArrayDeque(it.value.reversed()) }
        .mapKeys { (k, _) -> indices[k] }
        .toSortedMap()
}

fun readMoves(text: String): List<Move> {
    return text.lines()
        .filter { it.isNotBlank() }
        .map {
            it.filterNot { it.isLetter() }.trim()
                .split(" ")
                .filter { it.isNotBlank() }
                .map { it.trim().toInt() }
        }.map { val (by, from, to) = it; Move(from, to, by) }
}

fun <T> MutableList<T>.removeLastElementsReversed(n: Int): List<T> {
    return this.removeLastElements(n).reversed()
}

fun <T> MutableList<T>.removeLastElements(n: Int): List<T> {
    val firstIndex = this.lastIndex - n + 1
    val slice = this.slice(firstIndex..this.lastIndex)
    repeat(n) { this.removeLast() }
    return slice
}