package day1

import common.resourceAsLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day1KtTest : FunSpec({

    test("a.test") {
        val input = resourceAsLines("day1/a.test")
        maxCalories(input).shouldBe(24000)
    }

    xtest("a.input") {
        val input = resourceAsLines("day1/day1.input")
        maxCalories(input).let { println(it) }
    }

    test("b.test") {
        val input = resourceAsLines("day1/a.test")
        topKHolders(input, 3).shouldBe(24000+11000+10000)
    }

    xtest("b.input"){
        val input = resourceAsLines("day1/day1.input")
        topKHolders(input, 3).let { println(it) }
    }
})
