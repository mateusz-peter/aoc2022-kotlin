package day6

fun day6a(input: String): Int {
    return firstDistinctWindow(input, 4)
}

fun day6b(input: String): Int {
    return firstDistinctWindow(input, 14)
}

fun firstDistinctWindow(input: String, windowSize: Int): Int {
    return input.windowed(windowSize).asSequence()
        .mapIndexed { index, window -> (window.toSet().size == windowSize) to index }
        .filter { it.first }
        .map { it.second + windowSize }
        .first()
}