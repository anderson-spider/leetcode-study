package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumSizeSubarraySumTest {
    private val solution = MinimumSizeSubarraySum.Solution()

    @Test
    @DisplayName("Test example 1: Standard case with subarray in the middle")
    fun testExample1() {
        val target = 7
        val nums = intArrayOf(2, 3, 1, 2, 4, 3)

        val result = solution.minSubArrayLen(target, nums)

        assertEquals(2, result, "Minimum length subarray should be [4,3] with length 2")
    }

    @Test
    @DisplayName("Test example 2: Single element equals target")
    fun testExample2() {
        val target = 4
        val nums = intArrayOf(1, 4, 4)

        val result = solution.minSubArrayLen(target, nums)

        assertEquals(1, result, "Minimum length subarray should be [4] with length 1")
    }

    @Test
    @DisplayName("Test example 3: No subarray sums to target")
    fun testExample3() {
        val target = 11
        val nums = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)

        val result = solution.minSubArrayLen(target, nums)

        assertEquals(0, result, "No subarray sums to 11, should return 0")
    }

    @Test
    @DisplayName("Test with entire array needed")
    fun testEntireArrayNeeded() {
        val target = 15
        val nums = intArrayOf(1, 2, 3, 4, 5)

        val result = solution.minSubArrayLen(target, nums)

        assertEquals(5, result, "Entire array is needed to reach sum 15")
    }

    @Test
    @DisplayName("Test with subarray at beginning")
    fun testSubarrayAtBeginning() {
        val target = 8
        val nums = intArrayOf(5, 3, 1, 2, 4)

        val result = solution.minSubArrayLen(target, nums)

        assertEquals(2, result, "Minimum length subarray should be [5,3] at the beginning")
    }

    @Test
    @DisplayName("Test with subarray at end")
    fun testSubarrayAtEnd() {
        val target = 9
        val nums = intArrayOf(1, 2, 3, 4, 5)

        val result = solution.minSubArrayLen(target, nums)

        assertEquals(2, result, "Minimum length subarray should be [4,5] at the end")
    }

    @Test
    @DisplayName("Test with multiple possible subarrays")
    fun testMultiplePossibleSubarrays() {
        val target = 11
        val nums = intArrayOf(1, 2, 3, 4, 5)

        val result = solution.minSubArrayLen(target, nums)

        assertEquals(3, result, "Minimum length subarray should be [3,4,5] or [1,2,3,5] with length 3")
    }

    @Test
    @DisplayName("Test with large target requiring multiple elements")
    fun testLargeTarget() {
        val target = 15
        val nums = intArrayOf(5, 1, 3, 5, 10, 7, 4, 9, 2, 8)

        val result = solution.minSubArrayLen(target, nums)

        assertEquals(2, result, "Minimum length subarray should be [10,7] or similar with length 2")
    }

    @Test
    @DisplayName("Test with empty array")
    fun testEmptyArray() {
        val target = 5
        val nums = intArrayOf()

        val result = solution.minSubArrayLen(target, nums)

        assertEquals(0, result, "Empty array should return 0")
    }

    @Test
    @DisplayName("Test with all elements smaller than target")
    fun testAllElementsSmallerThanTarget() {
        val target = 100
        val nums = intArrayOf(1, 2, 3, 4, 5)

        val result = solution.minSubArrayLen(target, nums)

        assertEquals(0, result, "No subarray can sum to 100, should return 0")
    }
}
