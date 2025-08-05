package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CheckDivisibilityByDigitSumAndProductTest {
    private val solution = CheckDivisibilityByDigitSumAndProduct.Solution()

    @Test
    @DisplayName("Test with n=99 (divisible)")
    fun testDivisible99() {
        val n = 99
        val result = solution.checkDivisibility(n)

        assertTrue(result, "99 should be divisible by the sum of its digit sum (18) and digit product (81)")
    }

    @Test
    @DisplayName("Test with n=23 (not divisible)")
    fun testNotDivisible23() {
        val n = 23
        val result = solution.checkDivisibility(n)

        assertFalse(result, "23 should not be divisible by the sum of its digit sum (5) and digit product (6)")
    }

    @Test
    @DisplayName("Test with n=100 (divisible)")
    fun testDivisible100() {
        val n = 100
        val result = solution.checkDivisibility(n)

        assertTrue(result, "100 should be divisible by the sum of its digit sum (1) and digit product (0)")
    }

    @Test
    @DisplayName("Test with single digit n=5")
    fun testSingleDigit() {
        val n = 5
        val result = solution.checkDivisibility(n)

        assertFalse(result, "5 should not be divisible by the sum of its digit sum (5) and digit product (5)")
    }

    @Test
    @DisplayName("Test with n=11 (not divisible)")
    fun testNotDivisible11() {
        val n = 11
        val result = solution.checkDivisibility(n)

        assertFalse(result, "11 should not be divisible by the sum of its digit sum (2) and digit product (1)")
    }

    @Test
    @DisplayName("Test with n=12 (not divisible)")
    fun testNotDivisible12() {
        val n = 12
        val result = solution.checkDivisibility(n)

        assertFalse(result, "12 should not be divisible by the sum of its digit sum (3) and digit product (2)")
    }

    @Test
    @DisplayName("Test with n=1000 (divisible)")
    fun testDivisible1000() {
        val n = 1000
        val result = solution.checkDivisibility(n)

        assertTrue(result, "1000 should be divisible by the sum of its digit sum (1) and digit product (0)")
    }

    @Test
    @DisplayName("Test with n=999 (not divisible)")
    fun testNotDivisible999() {
        val n = 999
        val result = solution.checkDivisibility(n)

        assertFalse(result, "999 should not be divisible by the sum of its digit sum (27) and digit product (729)")
    }

    @Test
    @DisplayName("Test with maximum constraint n=1000000")
    fun testMaximumConstraint() {
        val n = 1000000
        val result = solution.checkDivisibility(n)

        assertTrue(result, "1000000 should be divisible by the sum of its digit sum (1) and digit product (0)")
    }
}
