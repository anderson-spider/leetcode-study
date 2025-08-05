package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JumpGameIiTest {
    private val solution = JumpGameIi.Solution()

    @Test
    @DisplayName("Test with standard case 1")
    fun testStandardCase1() {
        val nums = intArrayOf(2, 3, 1, 1, 4)
        val result = solution.jump(nums)
        assertEquals(2, result, "Should correctly calculate the minimum number of jumps needed")
    }

    @Test
    @DisplayName("Test with standard case 2")
    fun testStandardCase2() {
        val nums = intArrayOf(2, 3, 0, 1, 4)
        val result = solution.jump(nums)
        assertEquals(2, result, "Should correctly calculate the minimum number of jumps needed")
    }

    @Test
    @DisplayName("Test with single element array")
    fun testSingleElement() {
        val nums = intArrayOf(0)
        val result = solution.jump(nums)
        assertEquals(0, result, "Single element array should require 0 jumps")
    }

    @Test
    @DisplayName("Test with array where each element is 1")
    fun testAllOnes() {
        val nums = intArrayOf(1, 1, 1, 1, 1)
        val result = solution.jump(nums)
        assertEquals(4, result, "Should correctly calculate the minimum number of jumps needed")
    }

    @Test
    @DisplayName("Test with array where first element can reach the end")
    fun testFirstElementReachesEnd() {
        val nums = intArrayOf(5, 1, 1, 1, 1)
        val result = solution.jump(nums)
        assertEquals(1, result, "Should correctly calculate the minimum number of jumps needed")
    }

    @Test
    @DisplayName("Test with array where optimal path is not greedy")
    fun testOptimalPathNotGreedy() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val result = solution.jump(nums)
        assertEquals(3, result, "Should correctly calculate the minimum number of jumps needed")
    }

    @Test
    @DisplayName("Test with larger array")
    fun testLargerArray() {
        val nums = intArrayOf(5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0)
        val result = solution.jump(nums)
        assertEquals(3, result, "Should correctly calculate the minimum number of jumps needed")
    }
}
