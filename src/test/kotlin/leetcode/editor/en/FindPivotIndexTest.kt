package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindPivotIndexTest {
    private val solution = FindPivotIndex.Solution()

    @Test
    @DisplayName("Test with standard case - pivot exists")
    fun testStandardCasePivotExists() {
        val nums = intArrayOf(1, 7, 3, 6, 5, 6)
        val result = solution.pivotIndex(nums)

        assertEquals(3, result, "Pivot index for [1,7,3,6,5,6] should be 3")
    }

    @Test
    @DisplayName("Test with no pivot index")
    fun testNoPivotIndex() {
        val nums = intArrayOf(1, 2, 3)
        val result = solution.pivotIndex(nums)

        assertEquals(-1, result, "Array [1,2,3] should have no pivot index")
    }

    @Test
    @DisplayName("Test with pivot at beginning")
    fun testPivotAtBeginning() {
        val nums = intArrayOf(2, 1, -1)
        val result = solution.pivotIndex(nums)

        assertEquals(0, result, "Pivot index for [2,1,-1] should be 0")
    }

    @Test
    @DisplayName("Test with pivot at end")
    fun testPivotAtEnd() {
        val nums = intArrayOf(-1, 1, 2)
        val result = solution.pivotIndex(nums)

        assertEquals(2, result, "Pivot index for [-1,1,2] should be 2")
    }

    @Test
    @DisplayName("Test with single element array")
    fun testSingleElementArray() {
        val nums = intArrayOf(5)
        val result = solution.pivotIndex(nums)

        assertEquals(0, result, "Single element array should have pivot index 0")
    }

    @Test
    @DisplayName("Test with negative numbers")
    fun testNegativeNumbers() {
        val nums = intArrayOf(-1, -1, -1, -1, -1, 0)
        val result = solution.pivotIndex(nums)

        // At index 2:
        // Left sum = -1 + -1 = -2
        // Right sum = -1 + -1 + 0 = -2
        // These are equal, so index 2 is a pivot
        assertEquals(2, result, "Pivot index for [-1,-1,-1,-1,-1,0] should be 2")
    }

    @Test
    @DisplayName("Test with all zeros")
    fun testAllZeros() {
        val nums = intArrayOf(0, 0, 0, 0)
        val result = solution.pivotIndex(nums)

        assertEquals(0, result, "For array of all zeros, leftmost pivot index should be 0")
    }

    @Test
    @DisplayName("Test with balanced array")
    fun testBalancedArray() {
        val nums = intArrayOf(1, 2, 3, 4, 3, 2, 1)
        val result = solution.pivotIndex(nums)

        assertEquals(3, result, "Pivot index for [1,2,3,4,3,2,1] should be 3")
    }
}
