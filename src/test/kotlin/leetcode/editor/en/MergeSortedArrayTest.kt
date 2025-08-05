package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class MergeSortedArrayTest {
    private val solution = MergeSortedArray.Solution()

    @Test
    @DisplayName("Test with basic merge")
    fun testBasicMerge() {
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val m = 3
        val nums2 = intArrayOf(2, 5, 6)
        val n = 3

        solution.merge(nums1, m, nums2, n)

        val expected = intArrayOf(1, 2, 2, 3, 5, 6)
        assertTrue(
            nums1.contentEquals(expected),
            "merge should correctly merge the two arrays",
        )
    }

    @Test
    @DisplayName("Test with single element array")
    fun testSingleElementArray() {
        val nums1 = intArrayOf(1)
        val m = 1
        val nums2 = intArrayOf()
        val n = 0

        solution.merge(nums1, m, nums2, n)

        val expected = intArrayOf(1)
        assertTrue(
            nums1.contentEquals(expected),
            "merge should correctly handle a single element array",
        )
    }

    @Test
    @DisplayName("Test with empty first array")
    fun testEmptyFirstArray() {
        val nums1 = intArrayOf(0)
        val m = 0
        val nums2 = intArrayOf(1)
        val n = 1

        solution.merge(nums1, m, nums2, n)

        val expected = intArrayOf(1)
        assertTrue(
            nums1.contentEquals(expected),
            "merge should correctly handle an empty first array",
        )
    }

    @Test
    @DisplayName("Test with arrays containing duplicate elements")
    fun testArraysWithDuplicateElements() {
        val nums1 = intArrayOf(1, 2, 2, 0, 0, 0)
        val m = 3
        val nums2 = intArrayOf(1, 2, 3)
        val n = 3

        solution.merge(nums1, m, nums2, n)

        val expected = intArrayOf(1, 1, 2, 2, 2, 3)
        assertTrue(
            nums1.contentEquals(expected),
            "merge should correctly handle arrays with duplicate elements",
        )
    }

    @Test
    @DisplayName("Test with arrays containing negative numbers")
    fun testArraysWithNegativeNumbers() {
        val nums1 = intArrayOf(-3, -1, 0, 0, 0, 0)
        val m = 3
        val nums2 = intArrayOf(-2, -1, 5)
        val n = 3

        solution.merge(nums1, m, nums2, n)

        val expected = intArrayOf(-3, -2, -1, -1, 0, 5)
        assertTrue(
            nums1.contentEquals(expected),
            "merge should correctly handle arrays with negative numbers",
        )
    }

    @Test
    @DisplayName("Test with empty second array")
    fun testEmptySecondArray() {
        val nums1 = intArrayOf(1, 2, 3)
        val m = 3
        val nums2 = intArrayOf()
        val n = 0

        solution.merge(nums1, m, nums2, n)

        val expected = intArrayOf(1, 2, 3)
        assertTrue(
            nums1.contentEquals(expected),
            "merge should correctly handle an empty second array",
        )
    }

    @Test
    @DisplayName("Test with both arrays empty")
    fun testBothArraysEmpty() {
        val nums1 = intArrayOf()
        val m = 0
        val nums2 = intArrayOf()
        val n = 0

        solution.merge(nums1, m, nums2, n)

        val expected = intArrayOf()
        assertTrue(
            nums1.contentEquals(expected),
            "merge should correctly handle both arrays being empty",
        )
    }

    @Test
    @DisplayName("Test with larger arrays")
    fun testLargerArrays() {
        val nums1 = intArrayOf(1, 3, 5, 7, 9, 0, 0, 0, 0, 0)
        val m = 5
        val nums2 = intArrayOf(2, 4, 6, 8, 10)
        val n = 5

        solution.merge(nums1, m, nums2, n)

        val expected = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertTrue(
            nums1.contentEquals(expected),
            "merge should correctly handle larger arrays",
        )
    }

    @Test
    @DisplayName("Test with second array having all smaller elements")
    fun testSecondArrayAllSmallerElements() {
        val nums1 = intArrayOf(4, 5, 6, 0, 0, 0)
        val m = 3
        val nums2 = intArrayOf(1, 2, 3)
        val n = 3

        solution.merge(nums1, m, nums2, n)

        val expected = intArrayOf(1, 2, 3, 4, 5, 6)
        assertTrue(
            nums1.contentEquals(expected),
            "merge should correctly handle second array having all smaller elements",
        )
    }

    @Test
    @DisplayName("Test with second array having all larger elements")
    fun testSecondArrayAllLargerElements() {
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val m = 3
        val nums2 = intArrayOf(4, 5, 6)
        val n = 3

        solution.merge(nums1, m, nums2, n)

        val expected = intArrayOf(1, 2, 3, 4, 5, 6)
        assertTrue(
            nums1.contentEquals(expected),
            "merge should correctly handle second array having all larger elements",
        )
    }
}
