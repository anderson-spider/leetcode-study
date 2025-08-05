package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestCommonPrefixTest {
    private val solution = LongestCommonPrefix.Solution()

    @Test
    @DisplayName("Test with common prefix")
    fun testWithCommonPrefix() {
        val strs = arrayOf("flower", "flow", "flight")
        val result = solution.longestCommonPrefix(strs)
        assertEquals("fl", result, "longestCommonPrefix should correctly find the common prefix")
    }

    @Test
    @DisplayName("Test with no common prefix")
    fun testWithNoCommonPrefix() {
        val strs = arrayOf("dog", "racecar", "car")
        val result = solution.longestCommonPrefix(strs)
        assertEquals("", result, "longestCommonPrefix should return empty string when there is no common prefix")
    }

    @Test
    @DisplayName("Test with empty array")
    fun testWithEmptyArray() {
        val strs = arrayOf<String>()
        val result = solution.longestCommonPrefix(strs)
        assertEquals("", result, "longestCommonPrefix should return empty string for an empty array")
    }

    @Test
    @DisplayName("Test with single string")
    fun testWithSingleString() {
        val strs = arrayOf("a")
        val result = solution.longestCommonPrefix(strs)
        assertEquals("a", result, "longestCommonPrefix should return the string itself for a single string")
    }

    @Test
    @DisplayName("Test with identical strings")
    fun testWithIdenticalStrings() {
        val strs = arrayOf("c", "c")
        val result = solution.longestCommonPrefix(strs)
        assertEquals("c", result, "longestCommonPrefix should return the string for identical strings")
    }

    @Test
    @DisplayName("Test with empty string in array")
    fun testWithEmptyStringInArray() {
        val strs = arrayOf("flower", "", "flight")
        val result = solution.longestCommonPrefix(strs)
        assertEquals("", result, "longestCommonPrefix should return empty string when there is an empty string in the array")
    }

    @Test
    @DisplayName("Test with longer common prefix")
    fun testWithLongerCommonPrefix() {
        val strs = arrayOf("leetcode", "leetc", "leetcoder", "leetcoding")
        val result = solution.longestCommonPrefix(strs)
        assertEquals("leetc", result, "longestCommonPrefix should correctly find a longer common prefix")
    }

    @Test
    @DisplayName("Test with strings of different lengths")
    fun testWithStringsOfDifferentLengths() {
        val strs = arrayOf("a", "ab", "abc", "abcd")
        val result = solution.longestCommonPrefix(strs)
        assertEquals("a", result, "longestCommonPrefix should correctly handle strings of different lengths")
    }

    @Test
    @DisplayName("Test with prefix at beginning only")
    fun testWithPrefixAtBeginningOnly() {
        val strs = arrayOf("abc", "abd", "abf")
        val result = solution.longestCommonPrefix(strs)
        assertEquals("ab", result, "longestCommonPrefix should find prefix at the beginning only")
    }
}
