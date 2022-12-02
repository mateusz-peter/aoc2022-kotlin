package day2

sealed class Shape(val shapeScore: Int)
object Rock : Shape(1)
object Paper : Shape(2)
object Scissors : Shape(3)

val Shape.loseTo: Shape
    get() = when (this) {
        is Rock -> Paper
        is Paper -> Scissors
        is Scissors -> Rock
    }

val Shape.winAgainst: Shape
    get() = when (this) {
        is Rock -> Scissors
        is Paper -> Rock
        is Scissors -> Paper
    }

fun Char.toShape(): Shape {
    return when (this) {
        'A', 'X' -> Rock
        'B', 'Y' -> Paper
        'C', 'Z' -> Scissors
        else -> throw Exception()
    }
}

sealed class Result(val score: Int)
object Win : Result(6)
object Draw : Result(3)
object Lose : Result(0)

fun Char.toResult(): Result {
    return when (this) {
        'X' -> Lose
        'Y' -> Draw
        'Z' -> Win
        else -> throw Exception()
    }
}

fun scoreA(opponents: Shape, mine: Shape): Int {
    val vsScore = when (mine) {
        opponents.loseTo -> 6
        opponents -> 3
        else -> 0
    }

    return mine.shapeScore + vsScore
}

fun scoreB(opponents: Shape, result: Result): Int {
    val shape = when (result) {
        Lose -> opponents.winAgainst
        Draw -> opponents
        Win -> opponents.loseTo
    }

    return shape.shapeScore + result.score
}


fun day2A(lines: Sequence<String>): Int {
    return lines
        .filter { it.isNotBlank() }
        .map { it.trim().split(' ') }
        .map { it[0].single().toShape() to it[1].single().toShape() }
        .map { scoreA(it.first, it.second) }
        .sum()
}

fun day2B(lines: Sequence<String>): Int {
    return lines.filter { it.isNotBlank() }
        .map { it.trim().split(' ') }
        .map { it[0].single().toShape() to it[1].single().toResult() }
        .map { scoreB(it.first, it.second) }
        .sum()
}