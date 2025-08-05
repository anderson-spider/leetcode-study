package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JumpGameTest {
    private val solution = JumpGame.Solution()

    @Test
    @DisplayName("Test with standard case - can reach end")
    fun testCanReachEnd() {
        val nums = intArrayOf(2, 3, 1, 1, 4)
        val result = solution.canJump(nums)
        assertEquals(true, result, "Should correctly identify that the last index can be reached")
    }

    @Test
    @DisplayName("Test with standard case - cannot reach end")
    fun testCannotReachEnd() {
        val nums = intArrayOf(3, 2, 1, 0, 4)
        val result = solution.canJump(nums)
        assertEquals(false, result, "Should correctly identify that the last index cannot be reached")
    }

    @Test
    @DisplayName("Test with single element array")
    fun testSingleElement() {
        val nums = intArrayOf(0)
        val result = solution.canJump(nums)
        assertEquals(true, result, "Single element array should always be reachable")
    }

    @Test
    @DisplayName("Test with all zeros except first")
    fun testAllZerosExceptFirst() {
        val nums = intArrayOf(1, 0, 0, 0)
        val result = solution.canJump(nums)
        assertEquals(false, result, "Should correctly identify that the last index cannot be reached")
    }

    @Test
    @DisplayName("Test with exact jumps needed")
    fun testExactJumpsNeeded() {
        val nums = intArrayOf(1, 1, 1, 1)
        val result = solution.canJump(nums)
        assertEquals(true, result, "Should correctly identify that the last index can be reached with exact jumps")
    }

    @Test
    @DisplayName("Test with large jump at start")
    fun testLargeJumpAtStart() {
        val nums = intArrayOf(5, 0, 0, 0, 0, 0)
        val result = solution.canJump(nums)
        assertEquals(true, result, "Should correctly identify that the last index can be reached with a large initial jump")
    }

    @Test
    @DisplayName("Test with zero at start")
    fun testZeroAtStart() {
        val nums = intArrayOf(0, 1, 2, 3)
        val result = solution.canJump(nums)
        assertEquals(false, result, "Should correctly identify that no progress can be made with zero at start")
    }

    @Test
    @DisplayName("Test with empty array")
    fun testEmptyArray() {
        val nums = intArrayOf()
        val result = solution.canJump(nums)
        assertEquals(false, result, "Empty array should return false")
    }
}
