package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class PlusOneTest {
    private val solution = PlusOne.Solution()

    @Test
    @DisplayName("Test with no carrying needed")
    fun testNoCarrying() {
        val digits = intArrayOf(1, 2, 3)
        val expected = intArrayOf(1, 2, 4)

        val result = solution.plusOne(digits)

        assertTrue(result.contentEquals(expected), "Adding 1 to [1,2,3] should result in [1,2,4]")
    }

    @Test
    @DisplayName("Test with carrying needed but same length")
    fun testCarryingSameLength() {
        val digits = intArrayOf(4, 3, 2, 9)
        val expected = intArrayOf(4, 3, 3, 0)

        val result = solution.plusOne(digits)

        assertTrue(result.contentEquals(expected), "Adding 1 to [4,3,2,9] should result in [4,3,3,0]")
    }

    @Test
    @DisplayName("Test with carrying affecting array length")
    fun testCarryingNewLength() {
        val digits = intArrayOf(9, 9, 9)
        val expected = intArrayOf(1, 0, 0, 0)

        val result = solution.plusOne(digits)

        assertTrue(result.contentEquals(expected), "Adding 1 to [9,9,9] should result in [1,0,0,0]")
    }

    @Test
    @DisplayName("Test with single digit - no carrying")
    fun testSingleDigitNoCarrying() {
        val digits = intArrayOf(5)
        val expected = intArrayOf(6)

        val result = solution.plusOne(digits)

        assertTrue(result.contentEquals(expected), "Adding 1 to [5] should result in [6]")
    }

    @Test
    @DisplayName("Test with single digit - with carrying")
    fun testSingleDigitWithCarrying() {
        val digits = intArrayOf(9)
        val expected = intArrayOf(1, 0)

        val result = solution.plusOne(digits)

        assertTrue(result.contentEquals(expected), "Adding 1 to [9] should result in [1,0]")
    }

    @Test
    @DisplayName("Test with multiple 9s at different positions")
    fun testMultipleNinesAtDifferentPositions() {
        val digits = intArrayOf(2, 9, 9)
        val expected = intArrayOf(3, 0, 0)

        val result = solution.plusOne(digits)

        assertTrue(result.contentEquals(expected), "Adding 1 to [2,9,9] should result in [3,0,0]")
    }

    @Test
    @DisplayName("Test with 9s at beginning")
    fun testNinesAtBeginning() {
        val digits = intArrayOf(9, 8, 7)
        val expected = intArrayOf(9, 8, 8)

        val result = solution.plusOne(digits)

        assertTrue(result.contentEquals(expected), "Adding 1 to [9,8,7] should result in [9,8,8]")
    }

    @Test
    @DisplayName("Test with all 9s")
    fun testAllNines() {
        val digits = intArrayOf(9, 9, 9, 9, 9)
        val expected = intArrayOf(1, 0, 0, 0, 0, 0)

        val result = solution.plusOne(digits)

        assertTrue(result.contentEquals(expected), "Adding 1 to [9,9,9,9,9] should result in [1,0,0,0,0,0]")
    }

    @Test
    @DisplayName("Test with large number")
    fun testLargeNumber() {
        val digits = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val expected = intArrayOf(1, 2, 3, 4, 5, 6, 7, 9, 0)

        val result = solution.plusOne(digits)

        assertTrue(result.contentEquals(expected), "Adding 1 to [1,2,3,4,5,6,7,8,9] should result in [1,2,3,4,5,6,7,9,0]")
    }
}
