package day4

import common.resourceAsLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day4KtTest : FunSpec({

    context("test") {
        val testInput = "day4/day4.test"

        test("a") {
            day4a(resourceAsLines(testInput)).shouldBe(2)
        }

        test("b") {
            day4b(resourceAsLines(testInput)).shouldBe(4)
        }
    }

    xcontext("input") {
        val input = "day4/day4.input"

        test("a") {
            day4a(resourceAsLines(input)).let { println(it) }
        }

        test("b") {
            day4b(resourceAsLines(input)).let { println(it) }
        }
    }
})
