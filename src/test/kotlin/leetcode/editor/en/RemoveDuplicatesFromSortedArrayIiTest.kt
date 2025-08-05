package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RemoveDuplicatesFromSortedArrayIiTest {
    private val solution = RemoveDuplicatesFromSortedArrayIi.Solution()

    @Test
    @DisplayName("Test with standard case 1")
    fun testStandardCase1() {
        val nums = intArrayOf(1, 1, 1, 2, 2, 3)
        val result = solution.removeDuplicates(nums)
        assertEquals(5, result, "Should return the correct length after removing duplicates")
        assertTrue(
            nums.slice(0 until result) == listOf(1, 1, 2, 2, 3),
            "Array should be modified correctly with each element appearing at most twice",
        )
    }

    @Test
    @DisplayName("Test with standard case 2")
    fun testStandardCase2() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
        val result = solution.removeDuplicates(nums)
        assertEquals(7, result, "Should return the correct length after removing duplicates")
        assertTrue(
            nums.slice(0 until result) == listOf(0, 0, 1, 1, 2, 3, 3),
            "Array should be modified correctly with each element appearing at most twice",
        )
    }

    @Test
    @DisplayName("Test with empty array")
    fun testEmptyArray() {
        val nums = intArrayOf()
        val result = solution.removeDuplicates(nums)
        assertEquals(0, result, "Should return 0 for an empty array")
    }

    @Test
    @DisplayName("Test with array of single element")
    fun testSingleElement() {
        val nums = intArrayOf(1)
        val result = solution.removeDuplicates(nums)
        assertEquals(1, result, "Should return 1 for an array with a single element")
        assertEquals(1, nums[0], "The single element should remain unchanged")
    }

    @Test
    @DisplayName("Test with array of all same elements")
    fun testAllSameElements() {
        val nums = intArrayOf(1, 1, 1, 1, 1)
        val result = solution.removeDuplicates(nums)
        assertEquals(2, result, "Should return 2 for an array with all same elements")
        assertTrue(
            nums.slice(0 until result) == listOf(1, 1),
            "Array should be modified to contain exactly two of the same element",
        )
    }
}
