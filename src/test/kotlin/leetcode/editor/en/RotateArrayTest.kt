package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class RotateArrayTest {
    private val solution = RotateArray.Solution()

    @Test
    @DisplayName("Test with standard case 1")
    fun testStandardCase1() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val k = 3
        solution.rotate(nums, k)
        assertTrue(
            nums.contentEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4)),
            "Array should be correctly rotated to the right by $k steps",
        )
    }

    @Test
    @DisplayName("Test with standard case 2")
    fun testStandardCase2() {
        val nums = intArrayOf(-1, -100, 3, 99)
        val k = 2
        solution.rotate(nums, k)
        assertTrue(
            nums.contentEquals(intArrayOf(3, 99, -1, -100)),
            "Array should be correctly rotated to the right by $k steps",
        )
    }

    @Test
    @DisplayName("Test with full rotation")
    fun testFullRotation() {
        val nums = intArrayOf(1, 2, 3)
        val k = 3
        solution.rotate(nums, k)
        assertTrue(
            nums.contentEquals(intArrayOf(1, 2, 3)),
            "Array should remain the same when rotated by its length",
        )
    }

    @Test
    @DisplayName("Test with k greater than array length")
    fun testKGreaterThanLength() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val k = 7
        solution.rotate(nums, k)
        assertTrue(
            nums.contentEquals(intArrayOf(4, 5, 1, 2, 3)),
            "Array should be correctly rotated when k is greater than array length",
        )
    }

    @Test
    @DisplayName("Test with single element array")
    fun testSingleElementArray() {
        val nums = intArrayOf(1)
        val k = 3
        solution.rotate(nums, k)
        assertTrue(
            nums.contentEquals(intArrayOf(1)),
            "Single element array should remain unchanged regardless of k",
        )
    }

    @Test
    @DisplayName("Test with k = 0")
    fun testZeroRotation() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val k = 0
        solution.rotate(nums, k)
        assertTrue(
            nums.contentEquals(intArrayOf(1, 2, 3, 4, 5)),
            "Array should remain unchanged when k = 0",
        )
    }

    @Test
    @DisplayName("Test with large k")
    fun testLargeK() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val k = 1000000
        solution.rotate(nums, k)
        assertTrue(
            nums.contentEquals(intArrayOf(1, 2, 3, 4, 5)),
            "Array should be correctly rotated with large k",
        )
    }
}
