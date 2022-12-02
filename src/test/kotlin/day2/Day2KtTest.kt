package day2

import common.resourceAsLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day2KtTest : FunSpec({

    test("day2.test.a") {
        val input = resourceAsLines("day2/day2.test")
        day2A(input).shouldBe(15)
    }

    xtest("day2.input.a") {
        val input = resourceAsLines("day2/day2.input")
        day2A(input).let { println(it) }
    }

    test("day2.test.b") {
        val input = resourceAsLines("day2/day2.test")
        day2B(input).shouldBe(12)
    }

    xtest("day2.input.b") {
        val input = resourceAsLines("day2/day2.input")
        day2B(input).let { println(it) }
    }
})
