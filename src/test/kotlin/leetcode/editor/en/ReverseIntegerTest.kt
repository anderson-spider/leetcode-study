package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ReverseIntegerTest {
    private val solution = ReverseInteger.Solution()

    @Test
    @DisplayName("Test with positive integer")
    fun testPositiveInteger() {
        val x = 123
        val result = solution.reverse(x)
        assertEquals(321, result, "Should correctly reverse the digits of a positive integer")
    }

    @Test
    @DisplayName("Test with negative integer")
    fun testNegativeInteger() {
        val x = -123
        val result = solution.reverse(x)
        assertEquals(-321, result, "Should correctly reverse the digits of a negative integer")
    }

    @Test
    @DisplayName("Test with trailing zeros")
    fun testTrailingZeros() {
        val x = 120
        val result = solution.reverse(x)
        assertEquals(21, result, "Should correctly reverse the digits and remove trailing zeros")
    }

    @Test
    @DisplayName("Test with single digit")
    fun testSingleDigit() {
        val x = 7
        val result = solution.reverse(x)
        assertEquals(7, result, "Should return the same digit for a single digit number")
    }

    @Test
    @DisplayName("Test with zero")
    fun testZero() {
        val x = 0
        val result = solution.reverse(x)
        assertEquals(0, result, "Should return 0 for input 0")
    }

    @Test
    @DisplayName("Test with integer overflow")
    fun testIntegerOverflow() {
        val x = 1534236469 // This will overflow when reversed
        val result = solution.reverse(x)
        assertEquals(0, result, "Should return 0 when the reversed integer would overflow")
    }

    @Test
    @DisplayName("Test with minimum integer value")
    fun testMinimumIntegerValue() {
        val x = Int.MIN_VALUE // -2147483648
        val result = solution.reverse(x)
        assertEquals(0, result, "Should return 0 when the reversed integer would overflow")
    }
}
