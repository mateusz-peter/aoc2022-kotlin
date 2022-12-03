package day2

fun scoreA(opponents: Shape, mine: Shape): Int {
    val result = when (mine) {
        opponents.loseTo -> Win
        opponents -> Draw
        else -> Lose
    }

    return mine.shapeScore + result.score
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