package day5

import common.resourceAsString
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day5KtTest : FunSpec({

    context("test") {
        val fileName = "day5/day5.test"
        test("a") {
            day5a(resourceAsString(fileName)).shouldBe("CMZ")
        }
        test("b") {
            day5b(resourceAsString(fileName)).shouldBe("MCD")
        }
    }

    xcontext("input") {
        val fileName = "day5/day5.input"
        test("a") {
            day5a(resourceAsString(fileName)).let { println(it) }
        }
        test("b") {
            day5b(resourceAsString(fileName)).let { println(it) }
        }
    }
})
