package day6

import common.resourceAsString
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day6KtTest : FunSpec({

    context("test") {
        test("a") {
            day6a("bvwbjplbgvbhsrlpgdmjqwftvncz").shouldBe(5)
            day6a("nppdvjthqldpwncqszvftbrmjlhg").shouldBe(6)
            day6a("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").shouldBe(10)
            day6a("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").shouldBe(11)
        }
        test("b") {
            day6b("bvwbjplbgvbhsrlpgdmjqwftvncz").shouldBe(23)
            day6b("nppdvjthqldpwncqszvftbrmjlhg").shouldBe(23)
            day6b("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").shouldBe(29)
            day6b("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").shouldBe(26)
        }
    }

    xcontext("input") {
        val fileName = "day6/day6.input"
        test("a") {
            day6a(resourceAsString(fileName)).let { println(it) }
        }
        test("b") {
            day6b(resourceAsString(fileName)).let { println(it) }
        }
    }
})
