package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MajorityElementTest {
    private val solution = MajorityElement.Solution()

    @Test
    @DisplayName("Test with example 1")
    fun testExample1() {
        val nums = intArrayOf(3, 2, 3)
        val result = solution.majorityElement(nums)

        assertEquals(3, result, "Majority element in [3,2,3] should be 3")
    }

    @Test
    @DisplayName("Test with example 2")
    fun testExample2() {
        val nums = intArrayOf(2, 2, 1, 1, 1, 2, 2)
        val result = solution.majorityElement(nums)

        assertEquals(2, result, "Majority element in [2,2,1,1,1,2,2] should be 2")
    }

    @Test
    @DisplayName("Test with single element")
    fun testSingleElement() {
        val nums = intArrayOf(1)
        val result = solution.majorityElement(nums)

        assertEquals(1, result, "Majority element in [1] should be 1")
    }

    @Test
    @DisplayName("Test with all same elements")
    fun testAllSameElements() {
        val nums = intArrayOf(5, 5, 5, 5, 5)
        val result = solution.majorityElement(nums)

        assertEquals(5, result, "Majority element in [5,5,5,5,5] should be 5")
    }

    @Test
    @DisplayName("Test with minimum majority")
    fun testMinimumMajority() {
        // Array of size 5, majority element needs to appear at least 3 times
        val nums = intArrayOf(1, 2, 1, 2, 1)
        val result = solution.majorityElement(nums)

        assertEquals(1, result, "Majority element in [1,2,1,2,1] should be 1")
    }

    @Test
    @DisplayName("Test with negative numbers")
    fun testNegativeNumbers() {
        val nums = intArrayOf(-1, -1, -1, 2, 2)
        val result = solution.majorityElement(nums)

        assertEquals(-1, result, "Majority element in [-1,-1,-1,2,2] should be -1")
    }

    @Test
    @DisplayName("Test with majority element at beginning")
    fun testMajorityAtBeginning() {
        val nums = intArrayOf(3, 3, 3, 1, 2)
        val result = solution.majorityElement(nums)

        assertEquals(3, result, "Majority element in [3,3,3,1,2] should be 3")
    }

    @Test
    @DisplayName("Test with majority element at end")
    fun testMajorityAtEnd() {
        val nums = intArrayOf(1, 2, 4, 4, 4)
        val result = solution.majorityElement(nums)

        assertEquals(4, result, "Majority element in [1,2,4,4,4] should be 4")
    }

    @Test
    @DisplayName("Test with majority element scattered")
    fun testMajorityScattered() {
        val nums = intArrayOf(2, 3, 2, 4, 2, 5, 2)
        val result = solution.majorityElement(nums)

        assertEquals(2, result, "Majority element in [2,3,2,4,2,5,2] should be 2")
    }

    @Test
    @DisplayName("Test with large array")
    fun testLargeArray() {
        // Create an array of size 101 with 51 occurrences of 7
        val nums = IntArray(101) { if (it < 51) 7 else 0 }
        val result = solution.majorityElement(nums)

        assertEquals(7, result, "Majority element should be 7")
    }
}
