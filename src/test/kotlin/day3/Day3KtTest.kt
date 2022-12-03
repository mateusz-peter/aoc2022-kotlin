package day3

import common.resourceAsLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day3KtTest : FunSpec({

    test("day3A.test") {
        val input = resourceAsLines("day3/day3.test")
        day3A(input).shouldBe(157)
    }

    xtest("day3A.input") {
        val input = resourceAsLines("day3/day3.input")
        day3A(input).let { println(it) }
    }

    test("day3B.test") {
        val input = resourceAsLines("day3/day3.test")
        day3B(input).shouldBe(70)
    }

    xtest("day3B.input") {
        val input = resourceAsLines("day3/day3.input")
        day3B(input).let { println(it) }
    }
})
