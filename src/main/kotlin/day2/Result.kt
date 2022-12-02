package day2

sealed class Result(val score: Int)
object Win : Result(6)
object Draw : Result(3)
object Lose : Result(0)

fun Char.toResult(): Result {
    return when (this) {
        'X' -> Lose
        'Y' -> Draw
        'Z' -> Win
        else -> error("Invalid Result: $this")
    }
}