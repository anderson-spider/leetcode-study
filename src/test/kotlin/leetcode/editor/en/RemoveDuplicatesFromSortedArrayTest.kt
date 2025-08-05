package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RemoveDuplicatesFromSortedArrayTest {
    private val solution = RemoveDuplicatesFromSortedArray.Solution()

    @Test
    @DisplayName("Test with some duplicates - example 1")
    fun testSomeDuplicatesExample1() {
        val nums = intArrayOf(1, 1, 2)

        val result = solution.removeDuplicates(nums)

        assertEquals(2, result, "Should return 2 unique elements")

        // Verify the first 'result' elements are correct
        val expected = intArrayOf(1, 2)
        for (i in 0 until result) {
            assertEquals(expected[i], nums[i], "Element at index $i should be ${expected[i]}")
        }
    }

    @Test
    @DisplayName("Test with some duplicates - example 2")
    fun testSomeDuplicatesExample2() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)

        val result = solution.removeDuplicates(nums)

        assertEquals(5, result, "Should return 5 unique elements")

        // Verify the first 'result' elements are correct
        val expected = intArrayOf(0, 1, 2, 3, 4)
        for (i in 0 until result) {
            assertEquals(expected[i], nums[i], "Element at index $i should be ${expected[i]}")
        }
    }

    @Test
    @DisplayName("Test with no duplicates")
    fun testNoDuplicates() {
        val nums = intArrayOf(1, 2, 3, 4, 5)

        val result = solution.removeDuplicates(nums)

        assertEquals(5, result, "Should return 5 unique elements")

        // Verify the array remains unchanged
        val expected = intArrayOf(1, 2, 3, 4, 5)
        for (i in 0 until result) {
            assertEquals(expected[i], nums[i], "Element at index $i should be ${expected[i]}")
        }
    }

    @Test
    @DisplayName("Test with all duplicates")
    fun testAllDuplicates() {
        val nums = intArrayOf(5, 5, 5, 5, 5)

        val result = solution.removeDuplicates(nums)

        assertEquals(1, result, "Should return 1 unique element")
        assertEquals(5, nums[0], "The unique element should be 5")
    }

    @Test
    @DisplayName("Test with single element")
    fun testSingleElement() {
        val nums = intArrayOf(7)

        val result = solution.removeDuplicates(nums)

        assertEquals(1, result, "Should return 1 unique element")
        assertEquals(7, nums[0], "The unique element should be 7")
    }

    @Test
    @DisplayName("Test with duplicates at different positions")
    fun testDuplicatesAtDifferentPositions() {
        val nums = intArrayOf(1, 1, 2, 3, 3, 4, 5, 5)

        val result = solution.removeDuplicates(nums)

        assertEquals(5, result, "Should return 5 unique elements")

        // Verify the first 'result' elements are correct
        val expected = intArrayOf(1, 2, 3, 4, 5)
        for (i in 0 until result) {
            assertEquals(expected[i], nums[i], "Element at index $i should be ${expected[i]}")
        }
    }

    @Test
    @DisplayName("Test with negative numbers")
    fun testNegativeNumbers() {
        val nums = intArrayOf(-3, -3, -2, -1, -1, 0)

        val result = solution.removeDuplicates(nums)

        assertEquals(4, result, "Should return 4 unique elements")

        // Verify the first 'result' elements are correct
        val expected = intArrayOf(-3, -2, -1, 0)
        for (i in 0 until result) {
            assertEquals(expected[i], nums[i], "Element at index $i should be ${expected[i]}")
        }
    }

    @Test
    @DisplayName("Test with mixed positive and negative numbers")
    fun testMixedNumbers() {
        val nums = intArrayOf(-2, -2, -1, 0, 0, 1, 1, 2)

        val result = solution.removeDuplicates(nums)

        assertEquals(5, result, "Should return 5 unique elements")

        // Verify the first 'result' elements are correct
        val expected = intArrayOf(-2, -1, 0, 1, 2)
        for (i in 0 until result) {
            assertEquals(expected[i], nums[i], "Element at index $i should be ${expected[i]}")
        }
    }
}
