package common

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SequenceUtilsKtTest : FunSpec({

    test("case1") {
        sequenceOf(
            "AAA",
            "BBB",
            "CCC",
            "",
            "DDD"
        ).splitByEmptyLines().toList().size.shouldBe(2)
    }

    test("case2") {
        sequenceOf(
            "AAA",
            "",
            "",
            "BBB"
        ).filter { it.isNotEmpty() }.toList().size.shouldBe(2)
    }
})
