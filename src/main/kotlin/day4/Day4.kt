package day4

data class Interval(val left: Int, val right: Int)

fun String.toInterval(): Interval {
    val (left, right) = this.split('-')
    return Interval(left.toInt(), right.toInt())
}

fun Interval.contains(other: Interval): Boolean {
    return this.left <= other.left && this.right >= other.right
}

fun Interval.overlaps(other: Interval): Boolean {
    return (this.left >= other.left && this.left <= other.right)
            || (this.right <= other.right && this.right >= other.left)
            || this.contains(other)
            || other.contains(this)
}

fun intervalSeq(lines: Sequence<String>): Sequence<Pair<Interval, Interval>> {
    return lines.filter { it.isNotBlank() }
        .map {
            val (a, b) = it.split(',')
            a.toInterval() to b.toInterval()
        }
}

fun day4a(lines: Sequence<String>): Int {
    return intervalSeq(lines)
        .count { it.first.contains(it.second) || it.second.contains(it.first) }
}

fun day4b(lines: Sequence<String>): Int {
    return intervalSeq(lines)
        .count { it.first.overlaps(it.second) }
}