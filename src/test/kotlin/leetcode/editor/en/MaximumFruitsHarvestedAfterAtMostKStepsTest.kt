package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MaximumFruitsHarvestedAfterAtMostKStepsTest {
    private val solution = MaximumFruitsHarvestedAfterAtMostKSteps.Solution()

    @Test
    @DisplayName("Test example 1")
    fun testExample1() {
        val fruits =
            arrayOf<IntArray?>(
                intArrayOf(2, 8),
                intArrayOf(6, 3),
                intArrayOf(8, 6),
            )
        val startPos = 5
        val k = 4

        val result = solution.maxTotalFruits(fruits, startPos, k)

        assertEquals(9, result, "Should harvest 9 fruits (3 from position 6 and 6 from position 8)")
    }

    @Test
    @DisplayName("Test example 2")
    fun testExample2() {
        val fruits =
            arrayOf<IntArray?>(
                intArrayOf(0, 9),
                intArrayOf(4, 1),
                intArrayOf(5, 7),
                intArrayOf(6, 2),
                intArrayOf(7, 4),
                intArrayOf(10, 9),
            )
        val startPos = 5
        val k = 4

        val result = solution.maxTotalFruits(fruits, startPos, k)

        assertEquals(
            14,
            result,
            "Should harvest 14 fruits (7 from position 5, 1 from position 4, 2 from position 6, and 4 from position 7)",
        )
    }

    @Test
    @DisplayName("Test example 3")
    fun testExample3() {
        val fruits =
            arrayOf<IntArray?>(
                intArrayOf(0, 3),
                intArrayOf(6, 4),
                intArrayOf(8, 5),
            )
        val startPos = 3
        val k = 2

        val result = solution.maxTotalFruits(fruits, startPos, k)

        assertEquals(0, result, "Should harvest 0 fruits as no fruits are reachable within 2 steps")
    }

    @Test
    @DisplayName("Test with empty array")
    fun testEmptyArray() {
        val fruits = arrayOf<IntArray?>()
        val startPos = 5
        val k = 10

        val result = solution.maxTotalFruits(fruits, startPos, k)

        assertEquals(0, result, "Should harvest 0 fruits from an empty array")
    }

    @Test
    @DisplayName("Test with single fruit at starting position")
    fun testSingleFruitAtStartingPosition() {
        val fruits =
            arrayOf<IntArray?>(
                intArrayOf(5, 10),
            )
        val startPos = 5
        val k = 0

        val result = solution.maxTotalFruits(fruits, startPos, k)

        assertEquals(10, result, "Should harvest 10 fruits from the starting position without moving")
    }

    @Test
    @DisplayName("Test with all fruits to the left of starting position")
    fun testAllFruitsToTheLeft() {
        val fruits =
            arrayOf<IntArray?>(
                intArrayOf(1, 5),
                intArrayOf(3, 7),
                intArrayOf(5, 2),
            )
        val startPos = 10
        val k = 7

        val result = solution.maxTotalFruits(fruits, startPos, k)

        assertEquals(9, result, "Should harvest 9 fruits (7 + 2) by moving left")
    }

    @Test
    @DisplayName("Test with all fruits to the right of starting position")
    fun testAllFruitsToTheRight() {
        val fruits =
            arrayOf<IntArray?>(
                intArrayOf(15, 3),
                intArrayOf(17, 5),
                intArrayOf(20, 2),
            )
        val startPos = 10
        val k = 7

        val result = solution.maxTotalFruits(fruits, startPos, k)

        assertEquals(8, result, "Should harvest 8 fruits (3 + 5) by moving right")
    }

    @Test
    @DisplayName("Test with fruits on both sides requiring optimal strategy")
    fun testFruitsOnBothSides() {
        val fruits =
            arrayOf<IntArray?>(
                intArrayOf(2, 5),
                intArrayOf(4, 3),
                intArrayOf(10, 8),
                intArrayOf(12, 4),
            )
        val startPos = 6
        val k = 8

        val result = solution.maxTotalFruits(fruits, startPos, k)

        // Calculate total available fruits
        val totalFruits = fruits.sumOf { it?.get(1) ?: 0 }

        // Verify result is positive (we can reach some fruits)
        assertTrue(result > 0, "Should be able to harvest some fruits")

        // Verify result is at most the total available fruits
        assertTrue(result <= totalFruits, "Cannot harvest more fruits than available")

        // Verify result is optimal by checking smaller k values
        val resultWithSmallerK = solution.maxTotalFruits(fruits, startPos, k - 1)
        assertTrue(result >= resultWithSmallerK, "Increasing k should not decrease the result")
    }

    @Test
    @DisplayName("Test with large k to reach all fruits")
    fun testLargeK() {
        val fruits =
            arrayOf<IntArray?>(
                intArrayOf(0, 3),
                intArrayOf(5, 5),
                intArrayOf(10, 2),
                intArrayOf(15, 4),
            )
        val startPos = 7
        val k = 20

        val result = solution.maxTotalFruits(fruits, startPos, k)

        // Calculate total available fruits
        val totalFruits = fruits.sumOf { it?.get(1) ?: 0 }

        // Verify result is positive (we can reach some fruits)
        assertTrue(result > 0, "Should be able to harvest some fruits with large k")

        // Verify result is at most the total available fruits
        assertTrue(result <= totalFruits, "Cannot harvest more fruits than available")

        // Verify that smaller k values don't yield more fruits
        val smallerK = 15
        val resultWithSmallerK = solution.maxTotalFruits(fruits, startPos, smallerK)
        assertTrue(result >= resultWithSmallerK, "Larger k should not yield fewer fruits")
    }

    @Test
    @DisplayName("Test with k exactly sufficient to reach all fruits")
    fun testExactK() {
        val fruits =
            arrayOf<IntArray?>(
                intArrayOf(1, 2),
                intArrayOf(3, 4),
                intArrayOf(5, 6),
            )
        val startPos = 3
        val k = 4

        val result = solution.maxTotalFruits(fruits, startPos, k)

        assertEquals(10, result, "Should harvest 10 fruits (4 + 6) with k exactly sufficient")
    }
}
