package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ContainsDuplicateIiTest {
    private val solution = ContainsDuplicateIi.Solution()

    @Test
    @DisplayName("Test with duplicates within distance k")
    fun testDuplicatesWithinDistance() {
        val nums = intArrayOf(1, 2, 3, 1)
        val k = 3

        val result = solution.containsNearbyDuplicate(nums, k)

        assertTrue(result, "Array [1,2,3,1] should contain duplicates within distance 3")
    }

    @Test
    @DisplayName("Test with adjacent duplicates")
    fun testAdjacentDuplicates() {
        val nums = intArrayOf(1, 0, 1, 1)
        val k = 1

        val result = solution.containsNearbyDuplicate(nums, k)

        assertTrue(result, "Array [1,0,1,1] should contain adjacent duplicates")
    }

    @Test
    @DisplayName("Test with duplicates beyond distance k")
    fun testDuplicatesBeyondDistance() {
        val nums = intArrayOf(1, 2, 3, 1, 2, 3)
        val k = 2

        val result = solution.containsNearbyDuplicate(nums, k)

        assertFalse(result, "Array [1,2,3,1,2,3] should not contain duplicates within distance 2")
    }

    @Test
    @DisplayName("Test with single element array")
    fun testSingleElementArray() {
        val nums = intArrayOf(1)
        val k = 1

        val result = solution.containsNearbyDuplicate(nums, k)

        assertFalse(result, "Single element array cannot contain duplicates")
    }

    @Test
    @DisplayName("Test with all identical elements")
    fun testAllIdenticalElements() {
        val nums = intArrayOf(1, 1, 1, 1)
        val k = 1

        val result = solution.containsNearbyDuplicate(nums, k)

        assertTrue(result, "Array with all identical elements should contain duplicates within distance 1")
    }

    @Test
    @DisplayName("Test with empty array")
    fun testEmptyArray() {
        val nums = intArrayOf()
        val k = 0

        val result = solution.containsNearbyDuplicate(nums, k)

        assertFalse(result, "Empty array cannot contain duplicates")
    }

    @Test
    @DisplayName("Test with k = 0")
    fun testKZero() {
        val nums = intArrayOf(1, 2, 3, 1)
        val k = 0

        val result = solution.containsNearbyDuplicate(nums, k)

        assertFalse(result, "With k = 0, no duplicates can be within distance k")
    }

    @Test
    @DisplayName("Test with large k")
    fun testLargeK() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 1)
        val k = 10

        val result = solution.containsNearbyDuplicate(nums, k)

        assertTrue(result, "With k = 10, duplicates at positions 0 and 9 should be within distance k")
    }

    @Test
    @DisplayName("Test with negative numbers")
    fun testNegativeNumbers() {
        val nums = intArrayOf(-1, -2, -3, -1)
        val k = 3

        val result = solution.containsNearbyDuplicate(nums, k)

        assertTrue(result, "Array [-1,-2,-3,-1] should contain duplicates within distance 3")
    }
}
