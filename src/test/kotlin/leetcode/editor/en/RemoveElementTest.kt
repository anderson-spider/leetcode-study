package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RemoveElementTest {
    private val solution = RemoveElement.Solution()

    @Test
    @DisplayName("Test with basic case")
    fun testBasicCase() {
        val nums = intArrayOf(3, 2, 2, 3)
        val valToRemove = 3
        val result = solution.removeElement(nums, valToRemove)

        assertEquals(2, result, "removeElement should return the correct number of elements")

        // Check that the first 'result' elements don't contain the removed value
        for (i in 0 until result) {
            assertTrue(nums[i] != valToRemove, "The first $result elements should not contain $valToRemove")
        }
    }

    @Test
    @DisplayName("Test with multiple occurrences")
    fun testMultipleOccurrences() {
        val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        val valToRemove = 2
        val result = solution.removeElement(nums, valToRemove)

        assertEquals(5, result, "removeElement should return the correct number of elements")

        // Check that the first 'result' elements don't contain the removed value
        for (i in 0 until result) {
            assertTrue(nums[i] != valToRemove, "The first $result elements should not contain $valToRemove")
        }

        // Verify the expected elements are present (order may vary)
        val expectedElements = listOf(0, 1, 3, 0, 4)
        val actualElements = nums.slice(0 until result).sorted()
        assertEquals(expectedElements.sorted(), actualElements, "The first $result elements should contain the expected values")
    }

    @Test
    @DisplayName("Test with empty array")
    fun testEmptyArray() {
        val nums = intArrayOf()
        val valToRemove = 1
        val result = solution.removeElement(nums, valToRemove)

        assertEquals(0, result, "removeElement should return 0 for an empty array")
    }

    @Test
    @DisplayName("Test with no matches")
    fun testNoMatches() {
        val nums = intArrayOf(1, 2, 3, 4)
        val valToRemove = 5
        val result = solution.removeElement(nums, valToRemove)

        assertEquals(4, result, "removeElement should return the original length when no elements match")

        // Verify the array is unchanged
        val expected = intArrayOf(1, 2, 3, 4)
        for (i in nums.indices) {
            assertEquals(expected[i], nums[i], "The array should remain unchanged")
        }
    }

    @Test
    @DisplayName("Test with all elements matching")
    fun testAllElementsMatching() {
        val nums = intArrayOf(2, 2, 2, 2)
        val valToRemove = 2
        val result = solution.removeElement(nums, valToRemove)

        assertEquals(0, result, "removeElement should return 0 when all elements match")
    }

    @Test
    @DisplayName("Test with single element matching")
    fun testSingleElementMatching() {
        val nums = intArrayOf(1, 2, 3, 4)
        val valToRemove = 3
        val result = solution.removeElement(nums, valToRemove)

        assertEquals(3, result, "removeElement should return the correct number of elements")

        // Check that the first 'result' elements don't contain the removed value
        for (i in 0 until result) {
            assertTrue(nums[i] != valToRemove, "The first $result elements should not contain $valToRemove")
        }

        // Verify the expected elements are present (order may vary)
        val expectedElements = listOf(1, 2, 4)
        val actualElements = nums.slice(0 until result).sorted()
        assertEquals(expectedElements.sorted(), actualElements, "The first $result elements should contain the expected values")
    }

    @Test
    @DisplayName("Test with single element array matching")
    fun testSingleElementArrayMatching() {
        val nums = intArrayOf(1)
        val valToRemove = 1
        val result = solution.removeElement(nums, valToRemove)

        assertEquals(0, result, "removeElement should return 0 when the single element matches")
    }

    @Test
    @DisplayName("Test with single element array not matching")
    fun testSingleElementArrayNotMatching() {
        val nums = intArrayOf(1)
        val valToRemove = 2
        val result = solution.removeElement(nums, valToRemove)

        assertEquals(1, result, "removeElement should return 1 when the single element doesn't match")
        assertEquals(1, nums[0], "The array should remain unchanged")
    }
}
