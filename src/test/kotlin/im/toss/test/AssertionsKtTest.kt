package im.toss.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class AssertionsKtTest {

    @Test
    fun equalsTo() {
        1.equalsTo(1)
        assertThrows<AssertionError> {
            1.equalsTo(2)
        }

        1 equalsTo 1
        assertThrows<AssertionError> {
            1 equalsTo 2
        }
    }

    @Test
    fun doesNotEqualTo() {
        1.doesNotEqualTo(2)
        assertThrows<AssertionError> {
            1.doesNotEqualTo(1)
        }

        1 doesNotEqualTo 2
        assertThrows<AssertionError> {
            1 doesNotEqualTo 1
        }
    }

    @Test
    fun shouldNotBeEmpty() {
        listOf(1).shouldNotBeEmpty()
        assertThrows<AssertionError> {
            emptyList<Int>().shouldNotBeEmpty()
        }
    }

    @Test
    fun shouldBeEmpty() {
        emptyList<Int>().shouldBeEmpty()
        assertThrows<AssertionError> {
            listOf(1).shouldBeEmpty()
        }
    }

    @Test
    fun shouldBeTrue() {
        true.shouldBeTrue()
        assertThrows<AssertionError> {
            false.shouldBeTrue()
        }
    }

    @Test
    fun shouldBeFalse() {
        false.shouldBeFalse()
        assertThrows<AssertionError> {
            true.shouldBeFalse()
        }
    }
}
