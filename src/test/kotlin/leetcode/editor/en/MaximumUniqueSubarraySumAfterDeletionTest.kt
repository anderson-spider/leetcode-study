package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumUniqueSubarraySumAfterDeletionTest {
    private val solution = MaximumUniqueSubarraySumAfterDeletion.Solution()

    @Test
    @DisplayName("Test example 1: All unique positive numbers")
    fun testExample1() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val result = solution.maxSum(nums)

        assertEquals(15, result, "Maximum sum should be 15 (entire array)")
    }

    @Test
    @DisplayName("Test example 2: Array with duplicates")
    fun testExample2() {
        val nums = intArrayOf(1, 1, 0, 1, 1)
        val result = solution.maxSum(nums)

        assertEquals(1, result, "Maximum sum should be 1 (after removing duplicates)")
    }

    @Test
    @DisplayName("Test example 3: Mix of positive and negative numbers")
    fun testExample3() {
        val nums = intArrayOf(1, 2, -1, -2, 1, 0, -1)
        val result = solution.maxSum(nums)

        assertEquals(3, result, "Maximum sum should be 3 (subarray [2, 1])")
    }

    @Test
    @DisplayName("Test with all negative numbers")
    fun testAllNegativeNumbers() {
        val nums = intArrayOf(-1, -2, -3)
        val result = solution.maxSum(nums)

        assertEquals(-1, result, "Maximum sum should be -1 (the maximum value)")
    }

    @Test
    @DisplayName("Test with single element")
    fun testSingleElement() {
        val nums = intArrayOf(5)
        val result = solution.maxSum(nums)

        assertEquals(5, result, "Maximum sum should be 5 (the only element)")
    }

    @Test
    @DisplayName("Test with positive and negative numbers")
    fun testPositiveAndNegativeNumbers() {
        val nums = intArrayOf(-20, 20)
        val result = solution.maxSum(nums)

        assertEquals(20, result, "Maximum sum should be 20 (only the positive number)")
    }

    @Test
    @DisplayName("Test with all zeros")
    fun testAllZeros() {
        val nums = intArrayOf(0, 0, 0)
        val result = solution.maxSum(nums)

        assertEquals(0, result, "Maximum sum should be 0 (the maximum value)")
    }

    @Test
    @DisplayName("Test with many duplicates")
    fun testManyDuplicates() {
        val nums = intArrayOf(5, 5, 5, 5, 5, 1, 2, 3, 3, 3)
        val result = solution.maxSum(nums)

        assertEquals(11, result, "Maximum sum should be 11 (unique positive numbers: 5 + 1 + 2 + 3)")
    }

    @Test
    @DisplayName("Test with mixed positive and negative duplicates")
    fun testMixedDuplicates() {
        val nums = intArrayOf(10, -5, 10, 5, -5, 20)
        val result = solution.maxSum(nums)

        assertEquals(35, result, "Maximum sum should be 35 (unique positive numbers: 10 + 5 + 20)")
    }

    @Test
    @DisplayName("Test with large positive numbers")
    fun testLargePositiveNumbers() {
        val nums = intArrayOf(100, 50, 75, 25)
        val result = solution.maxSum(nums)

        assertEquals(250, result, "Maximum sum should be 250 (all unique positive numbers)")
    }
}
