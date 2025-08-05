package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class TwoSumTest {
    private val solution = TwoSum.Solution()

    @Test
    @DisplayName("Test with standard case")
    fun testStandardCase() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val result = solution.twoSum(nums, target)
        val expected = intArrayOf(0, 1)
        assertTrue(
            result.contentEquals(expected),
            "twoSum should correctly find indices of two numbers that add up to $target",
        )
    }

    @Test
    @DisplayName("Test with numbers not in order")
    fun testNumbersNotInOrder() {
        val nums = intArrayOf(3, 2, 4)
        val target = 6
        val result = solution.twoSum(nums, target)
        val expected = intArrayOf(1, 2)
        assertTrue(
            result.contentEquals(expected),
            "twoSum should correctly find indices of two numbers that add up to $target",
        )
    }

    @Test
    @DisplayName("Test with duplicate numbers")
    fun testDuplicateNumbers() {
        val nums = intArrayOf(3, 3)
        val target = 6
        val result = solution.twoSum(nums, target)
        val expected = intArrayOf(0, 1)
        assertTrue(
            result.contentEquals(expected),
            "twoSum should correctly find indices of two numbers that add up to $target",
        )
    }

    @Test
    @DisplayName("Test with negative numbers")
    fun testNegativeNumbers() {
        val nums = intArrayOf(-1, -2, -3, -4, -5)
        val target = -8
        val result = solution.twoSum(nums, target)

        // Expected: indices of 2 and 4 (values -3 and -5)
        val expected = intArrayOf(2, 4)
        assertTrue(
            result.contentEquals(expected),
            "twoSum should work with negative numbers",
        )
    }

    @Test
    @DisplayName("Test with mixed positive and negative numbers")
    fun testMixedPositiveAndNegativeNumbers() {
        val nums = intArrayOf(-3, 4, 3, 90)
        val target = 0
        val result = solution.twoSum(nums, target)

        val expected = intArrayOf(0, 2)
        assertTrue(
            result.contentEquals(expected),
            "twoSum should work with mixed positive and negative numbers",
        )
    }

    @Test
    @DisplayName("Test with larger array")
    fun testLargerArray() {
        val nums = intArrayOf(1, 5, 8, 3, 9, 12, 7, 2, 15, 6)
        val target = 18
        val result = solution.twoSum(nums, target)

        // Could be [2, 8] for 8+10=18 or other valid pairs
        // Let's check if the sum is correct rather than specific indices
        val sum = nums[result[0]] + nums[result[1]]
        assertTrue(
            sum == target,
            "twoSum should find indices where values sum to $target in a larger array",
        )
    }
}
