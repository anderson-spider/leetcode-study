package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class FloodFillTest {
    private val solution = FloodFill.Solution()

    @Test
    @DisplayName("Test standard flood fill")
    fun testStandardFloodFill() {
        // Test case 1: Standard flood fill
        val image =
            arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 0, 1),
            )

        val expected =
            arrayOf(
                intArrayOf(2, 2, 2),
                intArrayOf(2, 2, 0),
                intArrayOf(2, 0, 1),
            )

        val result = solution.floodFill(image, 1, 1, 2)

        assertTrue(
            result.contentDeepEquals(expected),
            "Flood fill should correctly change connected pixels of the same color",
        )
    }

    @Test
    @DisplayName("Test flood fill with same color")
    fun testFloodFillSameColor() {
        // Test case 2: Starting pixel already has the target color
        val image =
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 0, 0),
            )

        val expected =
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 0, 0),
            )

        val result = solution.floodFill(image, 0, 0, 0)

        assertTrue(
            result.contentDeepEquals(expected),
            "Flood fill should not change anything when starting pixel already has the target color",
        )
    }

    @Test
    @DisplayName("Test flood fill with isolated pixel")
    fun testFloodFillIsolatedPixel() {
        // Test case 3: Isolated pixel (no adjacent pixels of the same color)
        val image =
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9),
            )

        val expected =
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 10, 6),
                intArrayOf(7, 8, 9),
            )

        val result = solution.floodFill(image, 1, 1, 10)

        assertTrue(
            result.contentDeepEquals(expected),
            "Flood fill should only change the starting pixel when it has no adjacent pixels of the same color",
        )
    }

    @Test
    @DisplayName("Test flood fill with single pixel image")
    fun testFloodFillSinglePixel() {
        // Test case 4: Single pixel image
        val image =
            arrayOf(
                intArrayOf(5),
            )

        val expected =
            arrayOf(
                intArrayOf(7),
            )

        val result = solution.floodFill(image, 0, 0, 7)

        assertTrue(
            result.contentDeepEquals(expected),
            "Flood fill should work correctly on a single pixel image",
        )
    }
}
