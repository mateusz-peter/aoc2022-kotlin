package day3


fun Char.itemValue(): Int = when (this) {
    in 'a'..'z' -> this - 'a' + 1
    in 'A'..'Z' -> this - 'A' + 27
    else -> error("Char out of range: $this")
}
fun day3A(lines: Sequence<String>): Int {
    return lines.filter { it.isNotBlank() }
        .map { it.trim() }
        .map { it.take(it.length/2) to it.drop(it.length/2) }
        .map { commonChar(it.first, it.second).itemValue() }
        .sum()
}

fun day3B(lines: Sequence<String>): Int {
    return lines.filter { it.isNotBlank() }
        .map { it.trim() }
        .chunked(3)
        .map { commonChar(it).itemValue() }
        .sum()
}

fun commonChar(s1: String, s2: String): Char = s1.toSet().intersect(s2.toSet()).single()

fun commonChar(strings: List<String>): Char = strings.map { it.toSet() }
    .reduce {acc, chars -> acc.intersect(chars) }
    .single()