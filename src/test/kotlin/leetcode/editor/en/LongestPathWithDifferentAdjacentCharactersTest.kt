package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestPathWithDifferentAdjacentCharactersTest {
    private val solution = LongestPathWithDifferentAdjacentCharacters.Solution()

    @Test
    @DisplayName("Test with example 1")
    fun testExample1() {
        val parent = intArrayOf(-1, 0, 0, 1, 1, 2)
        val s = "abacbe"

        val result = solution.longestPath(parent, s)

        assertEquals(3, result, "Longest path for example 1 should be 3 (0 -> 1 -> 3)")
    }

    @Test
    @DisplayName("Test with example 2")
    fun testExample2() {
        val parent = intArrayOf(-1, 0, 0, 0)
        val s = "aabc"

        val result = solution.longestPath(parent, s)

        assertEquals(3, result, "Longest path for example 2 should be 3 (2 -> 0 -> 3)")
    }

    @Test
    @DisplayName("Test with single node")
    fun testSingleNode() {
        val parent = intArrayOf(-1)
        val s = "a"

        val result = solution.longestPath(parent, s)

        assertEquals(1, result, "Longest path for a single node should be 1")
    }

    @Test
    @DisplayName("Test with all same characters")
    fun testAllSameCharacters() {
        val parent = intArrayOf(-1, 0, 1, 2, 3)
        val s = "aaaaa"

        val result = solution.longestPath(parent, s)

        assertEquals(1, result, "Longest path when all characters are the same should be 1")
    }

    @Test
    @DisplayName("Test with all different characters")
    fun testAllDifferentCharacters() {
        val parent = intArrayOf(-1, 0, 1, 2, 3)
        val s = "abcde"

        val result = solution.longestPath(parent, s)

        assertEquals(5, result, "Longest path when all characters are different should be 5 (0 -> 1 -> 2 -> 3 -> 4)")
    }

    @Test
    @DisplayName("Test with linear tree")
    fun testLinearTree() {
        val parent = intArrayOf(-1, 0, 1, 2)
        val s = "abca"

        val result = solution.longestPath(parent, s)

        assertEquals(4, result, "Longest path in linear tree should be 4")
    }

    @Test
    @DisplayName("Test with balanced tree")
    fun testBalancedTree() {
        val parent = intArrayOf(-1, 0, 0, 1, 1, 2, 2)
        val s = "abcdefg"

        val result = solution.longestPath(parent, s)

        assertEquals(5, result, "Longest path in balanced tree should be 5")
    }

    @Test
    @DisplayName("Test with path not through root")
    fun testPathNotThroughRoot() {
        val parent = intArrayOf(-1, 0, 0, 1, 1, 2, 2)
        val s = "aabcdef"

        val result = solution.longestPath(parent, s)

        assertEquals(3, result, "Longest path not through root should be 3")
    }

    @Test
    @DisplayName("Test with alternating characters")
    fun testAlternatingCharacters() {
        val parent = intArrayOf(-1, 0, 0, 1, 1, 2, 2)
        val s = "abababa"

        val result = solution.longestPath(parent, s)

        assertEquals(3, result, "Longest path with alternating characters should be 3")
    }

    @Test
    @DisplayName("Test with complex tree structure")
    fun testComplexTreeStructure() {
        val parent = intArrayOf(-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6)
        val s = "abcdefghijklmno"

        val result = solution.longestPath(parent, s)

        assertEquals(7, result, "Longest path in complex tree should be 7")
    }
}
