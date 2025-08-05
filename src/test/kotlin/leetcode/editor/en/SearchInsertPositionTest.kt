package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SearchInsertPositionTest {
    private val solution = SearchInsertPosition.Solution()

    @Test
    @DisplayName("Test with target found in array")
    fun testTargetFound() {
        val nums = intArrayOf(1, 3, 5, 6)
        val target = 5
        val result = solution.searchInsert(nums, target)
        assertEquals(2, result, "Should return the correct index when target is found in the array")
    }

    @Test
    @DisplayName("Test with target not found - insert in middle")
    fun testTargetNotFoundMiddle() {
        val nums = intArrayOf(1, 3, 5, 6)
        val target = 2
        val result = solution.searchInsert(nums, target)
        assertEquals(1, result, "Should return the correct insertion index when target is not found")
    }

    @Test
    @DisplayName("Test with target not found - insert at end")
    fun testTargetNotFoundEnd() {
        val nums = intArrayOf(1, 3, 5, 6)
        val target = 7
        val result = solution.searchInsert(nums, target)
        assertEquals(4, result, "Should return the correct insertion index when target should be inserted at the end")
    }

    @Test
    @DisplayName("Test with target not found - insert at beginning")
    fun testTargetNotFoundBeginning() {
        val nums = intArrayOf(1, 3, 5, 6)
        val target = 0
        val result = solution.searchInsert(nums, target)
        assertEquals(0, result, "Should return the correct insertion index when target should be inserted at the beginning")
    }

    @Test
    @DisplayName("Test with single element array - target found")
    fun testSingleElementArrayTargetFound() {
        val nums = intArrayOf(5)
        val target = 5
        val result = solution.searchInsert(nums, target)
        assertEquals(0, result, "Should return the correct index when target is found in a single element array")
    }

    @Test
    @DisplayName("Test with single element array - target not found")
    fun testSingleElementArrayTargetNotFound() {
        val nums = intArrayOf(5)
        val target = 3
        val result = solution.searchInsert(nums, target)
        assertEquals(0, result, "Should return the correct insertion index when target is not found in a single element array")
    }

    @Test
    @DisplayName("Test with duplicate target value")
    fun testDuplicateTargetValue() {
        val nums = intArrayOf(1, 3, 5, 5, 6)
        val target = 5
        val result = solution.searchInsert(nums, target)
        assertEquals(2, result, "Should return the first occurrence index when target appears multiple times")
    }
}
