package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestConsecutiveSequenceTest {
    private val solution = LongestConsecutiveSequence.Solution()

    @Test
    @DisplayName("Test with standard case 1")
    fun testStandardCase1() {
        val nums = intArrayOf(100, 4, 200, 1, 3, 2)

        val result = solution.longestConsecutive(nums)

        assertEquals(4, result, "Longest consecutive sequence should be [1,2,3,4] with length 4")
    }

    @Test
    @DisplayName("Test with standard case 2")
    fun testStandardCase2() {
        val nums = intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)

        val result = solution.longestConsecutive(nums)

        assertEquals(9, result, "Longest consecutive sequence should be [0,1,2,3,4,5,6,7,8] with length 9")
    }

    @Test
    @DisplayName("Test with empty array")
    fun testEmptyArray() {
        val nums = intArrayOf()

        val result = solution.longestConsecutive(nums)

        assertEquals(0, result, "Empty array should return 0")
    }

    @Test
    @DisplayName("Test with single number")
    fun testSingleNumber() {
        val nums = intArrayOf(5)

        val result = solution.longestConsecutive(nums)

        assertEquals(1, result, "Array with single number should return 1")
    }

    @Test
    @DisplayName("Test with duplicate numbers")
    fun testDuplicateNumbers() {
        val nums = intArrayOf(1, 2, 2, 3, 3, 4, 5, 5)

        val result = solution.longestConsecutive(nums)

        assertEquals(5, result, "Duplicates should be ignored, longest sequence should be [1,2,3,4,5] with length 5")
    }

    @Test
    @DisplayName("Test with negative numbers")
    fun testNegativeNumbers() {
        val nums = intArrayOf(-5, -4, -3, -2, 0, 1)

        val result = solution.longestConsecutive(nums)

        assertEquals(4, result, "Longest consecutive sequence should be [-5,-4,-3,-2] with length 4")
    }

    @Test
    @DisplayName("Test with multiple sequences")
    fun testMultipleSequences() {
        val nums = intArrayOf(1, 2, 3, 10, 11, 12, 13, 20, 21)

        val result = solution.longestConsecutive(nums)

        assertEquals(4, result, "Longest consecutive sequence should be [10,11,12,13] with length 4")
    }

    @Test
    @DisplayName("Test with non-consecutive numbers")
    fun testNonConsecutiveNumbers() {
        val nums = intArrayOf(5, 10, 15, 20, 25)

        val result = solution.longestConsecutive(nums)

        assertEquals(1, result, "No consecutive numbers, so longest sequence length is 1")
    }

    @Test
    @DisplayName("Test with large sequence")
    fun testLargeSequence() {
        // Create an array with numbers from 1 to 1000
        val nums = IntArray(1000) { it + 1 }

        val result = solution.longestConsecutive(nums)

        assertEquals(1000, result, "Longest consecutive sequence should be [1,2,...,1000] with length 1000")
    }

    @Test
    @DisplayName("Test with mixed positive and negative numbers")
    fun testMixedPositiveAndNegativeNumbers() {
        val nums = intArrayOf(-3, -2, -1, 0, 1, 2, 5, 7, 9)

        val result = solution.longestConsecutive(nums)

        assertEquals(6, result, "Longest consecutive sequence should be [-3,-2,-1,0,1,2] with length 6")
    }
}
