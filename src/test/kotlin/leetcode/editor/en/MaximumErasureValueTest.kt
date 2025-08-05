package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumErasureValueTest {
    private val solution = MaximumErasureValue.Solution()

    @Test
    @DisplayName("Test with example 1")
    fun testExample1() {
        val nums = intArrayOf(4, 2, 4, 5, 6)
        val result = solution.maximumUniqueSubarray(nums)

        assertEquals(17, result, "Maximum erasure value for [4,2,4,5,6] should be 17 (subarray [2,4,5,6])")
    }

    @Test
    @DisplayName("Test with example 2")
    fun testExample2() {
        val nums = intArrayOf(5, 2, 1, 2, 5, 2, 1, 2, 5)
        val result = solution.maximumUniqueSubarray(nums)

        assertEquals(8, result, "Maximum erasure value for [5,2,1,2,5,2,1,2,5] should be 8 (subarray [5,2,1] or [1,2,5])")
    }

    @Test
    @DisplayName("Test with all unique elements")
    fun testAllUniqueElements() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val result = solution.maximumUniqueSubarray(nums)

        assertEquals(15, result, "Maximum erasure value for [1,2,3,4,5] should be 15 (the entire array)")
    }

    @Test
    @DisplayName("Test with all same elements")
    fun testAllSameElements() {
        val nums = intArrayOf(1, 1, 1, 1, 1)
        val result = solution.maximumUniqueSubarray(nums)

        assertEquals(1, result, "Maximum erasure value for [1,1,1,1,1] should be 1 (any single element)")
    }

    @Test
    @DisplayName("Test with single element")
    fun testSingleElement() {
        val nums = intArrayOf(10)
        val result = solution.maximumUniqueSubarray(nums)

        assertEquals(10, result, "Maximum erasure value for [10] should be 10 (the only element)")
    }

    @Test
    @DisplayName("Test with duplicates at beginning")
    fun testDuplicatesAtBeginning() {
        val nums = intArrayOf(3, 3, 1, 2, 4)
        val result = solution.maximumUniqueSubarray(nums)

        assertEquals(10, result, "Maximum erasure value should be 10 (subarray [3,1,2,4] or [1,2,3,4])")
    }

    @Test
    @DisplayName("Test with duplicates at end")
    fun testDuplicatesAtEnd() {
        val nums = intArrayOf(1, 2, 4, 5, 5)
        val result = solution.maximumUniqueSubarray(nums)

        assertEquals(12, result, "Maximum erasure value should be 12 (subarray [1,2,4,5])")
    }

    @Test
    @DisplayName("Test with duplicates in middle")
    fun testDuplicatesInMiddle() {
        val nums = intArrayOf(1, 2, 3, 3, 4, 5)
        val result = solution.maximumUniqueSubarray(nums)

        assertEquals(12, result, "Maximum erasure value should be 12 (subarray [3,4,5] or similar)")
    }

    @Test
    @DisplayName("Test with multiple duplicates")
    fun testMultipleDuplicates() {
        val nums = intArrayOf(4, 2, 4, 5, 6, 2, 7)
        val result = solution.maximumUniqueSubarray(nums)

        assertEquals(24, result, "Maximum erasure value should be 24 (subarray [4,5,6,2,7] or similar)")
    }

    @Test
    @DisplayName("Test with larger values")
    fun testLargerValues() {
        val nums = intArrayOf(10000, 1000, 100, 10, 1)
        val result = solution.maximumUniqueSubarray(nums)

        assertEquals(11111, result, "Maximum erasure value should be 11111 (the entire array)")
    }
}
