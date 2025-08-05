package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CombinationSumTest {
    private val solution = CombinationSum.Solution()

    @Test
    @DisplayName("Test with standard case 1")
    fun testStandardCase1() {
        val candidates = intArrayOf(2, 3, 6, 7)
        val target = 7

        val result = solution.combinationSum(candidates, target)
        val expected =
            listOf(
                listOf(2, 2, 3),
                listOf(7),
            )

        // Sort the lists for consistent comparison
        val sortedResult = result.map { it.sorted() }.sortedBy { it.toString() }
        val sortedExpected = expected.map { it.sorted() }.sortedBy { it.toString() }

        assertEquals(sortedExpected, sortedResult, "Combination sum for [2,3,6,7] with target 7 should be [[2,2,3],[7]]")
    }

    @Test
    @DisplayName("Test with standard case 2")
    fun testStandardCase2() {
        val candidates = intArrayOf(2, 3, 5)
        val target = 8

        val result = solution.combinationSum(candidates, target)
        val expected =
            listOf(
                listOf(2, 2, 2, 2),
                listOf(2, 3, 3),
                listOf(3, 5),
            )

        // Sort the lists for consistent comparison
        val sortedResult = result.map { it.sorted() }.sortedBy { it.toString() }
        val sortedExpected = expected.map { it.sorted() }.sortedBy { it.toString() }

        assertEquals(sortedExpected, sortedResult, "Combination sum for [2,3,5] with target 8 should be [[2,2,2,2],[2,3,3],[3,5]]")
    }

    @Test
    @DisplayName("Test with no possible combinations")
    fun testNoPossibleCombinations() {
        val candidates = intArrayOf(2)
        val target = 1

        val result = solution.combinationSum(candidates, target)
        val expected = emptyList<List<Int>>()

        assertEquals(expected, result, "Combination sum for [2] with target 1 should be empty list")
    }

    @Test
    @DisplayName("Test with single candidate equal to target")
    fun testSingleCandidateEqualToTarget() {
        val candidates = intArrayOf(5)
        val target = 5

        val result = solution.combinationSum(candidates, target)
        val expected = listOf(listOf(5))

        assertEquals(expected, result, "Combination sum for [5] with target 5 should be [[5]]")
    }

    @Test
    @DisplayName("Test with multiple identical combinations")
    fun testMultipleIdenticalCombinations() {
        val candidates = intArrayOf(1, 2, 3)
        val target = 3

        val result = solution.combinationSum(candidates, target)
        val expected =
            listOf(
                listOf(1, 1, 1),
                listOf(1, 2),
                listOf(3),
            )

        // Sort the lists for consistent comparison
        val sortedResult = result.map { it.sorted() }.sortedBy { it.toString() }
        val sortedExpected = expected.map { it.sorted() }.sortedBy { it.toString() }

        assertEquals(sortedExpected, sortedResult, "Combination sum for [1,2,3] with target 3 should be [[1,1,1],[1,2],[3]]")
    }

    @Test
    @DisplayName("Test with larger target")
    fun testLargerTarget() {
        val candidates = intArrayOf(2, 3, 5)
        val target = 15

        val result = solution.combinationSum(candidates, target)

        // Verify the sum of each combination equals the target
        result.forEach { combination ->
            val sum = combination.sum()
            assertEquals(target, sum, "Each combination should sum to the target value")
        }

        // Verify some expected combinations are present
        val expectedCombinations =
            listOf(
                listOf(3, 3, 3, 3, 3),
                listOf(5, 5, 5),
                listOf(5, 5, 2, 3),
            )

        for (expected in expectedCombinations) {
            val sortedExpected = expected.sorted()
            val found =
                result.any { combination ->
                    combination.sorted() == sortedExpected
                }
            assertTrue(found, "Expected combination $expected should be in the result")
        }
    }

    private fun assertTrue(
        condition: Boolean,
        message: String,
    ) {
        if (!condition) {
            throw AssertionError(message)
        }
    }
}
