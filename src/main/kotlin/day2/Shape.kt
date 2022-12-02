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
        else -> error("Invalid Shape: $this")
    }
}