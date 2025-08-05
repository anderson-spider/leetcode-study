package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MaximumLengthSubstringWithTwoOccurrencesTest {
    private val solution = MaximumLengthSubstringWithTwoOccurrences.Solution()

    @Test
    @DisplayName("Test example 1: bcbbbcba")
    fun testExample1() {
        val s = "bcbbbcba"
        val result = solution.maximumLengthSubstring(s)

        assertEquals(4, result, "Maximum length substring with at most two occurrences of each character should be 4")
    }

    @Test
    @DisplayName("Test example 2: aaaa")
    fun testExample2() {
        val s = "aaaa"
        val result = solution.maximumLengthSubstring(s)

        assertEquals(2, result, "Maximum length substring with at most two occurrences of each character should be 2")
    }

    @Test
    @DisplayName("Test with all unique characters")
    fun testAllUniqueCharacters() {
        val s = "abcdefg"
        val result = solution.maximumLengthSubstring(s)

        assertEquals(7, result, "For a string with all unique characters, the entire string is the answer")
    }

    @Test
    @DisplayName("Test with repeating pattern")
    fun testRepeatingPattern() {
        val s = "abcabcabc"
        val result = solution.maximumLengthSubstring(s)

        assertEquals(6, result, "Maximum length should be 6 (e.g., 'abcabc')")
    }

    @Test
    @DisplayName("Test with maximum substring at beginning")
    fun testMaximumSubstringAtBeginning() {
        val s = "aabcdefghhhhh"
        val result = solution.maximumLengthSubstring(s)

        // Verify result is positive
        assertTrue(result > 0, "Result should be positive")

        // Verify result is at most the length of the string
        assertTrue(result <= s.length, "Result should not exceed string length")

        // Verify result is at least the length of a valid substring
        // 'aabcdefg' is a valid substring with at most 2 occurrences of each character
        assertTrue(result >= 8, "Result should be at least 8")
    }

    @Test
    @DisplayName("Test with maximum substring at end")
    fun testMaximumSubstringAtEnd() {
        val s = "hhhhhhabcdefg"
        val result = solution.maximumLengthSubstring(s)

        assertEquals(9, result, "Maximum length should be 9 (substring 'hhabcdefg')")
    }

    @Test
    @DisplayName("Test with maximum substring in middle")
    fun testMaximumSubstringInMiddle() {
        val s = "xxxabcdefgxxx"
        val result = solution.maximumLengthSubstring(s)

        assertEquals(9, result, "Maximum length should be 9 (substring 'xxabcdefg')")
    }

    @Test
    @DisplayName("Test with multiple characters exceeding limit")
    fun testMultipleCharactersExceedingLimit() {
        val s = "aaabbbccc"
        val result = solution.maximumLengthSubstring(s)

        // Verify result is positive
        assertTrue(result > 0, "Result should be positive")

        // Verify result is at most the length of the string
        assertTrue(result <= s.length, "Result should not exceed string length")

        // Verify result is at least the length of a valid substring
        // 'aabb' is a valid substring with at most 2 occurrences of each character
        assertTrue(result >= 4, "Result should be at least 4")

        // Verify result is at most 6 (since we can have at most 2 of each character)
        assertTrue(result <= 6, "Result should be at most 6 (2 occurrences of each character)")
    }

    @Test
    @DisplayName("Test with minimum length string")
    fun testMinimumLengthString() {
        val s = "ab"
        val result = solution.maximumLengthSubstring(s)

        assertEquals(2, result, "For a 2-character string, the entire string is the answer")
    }

    @Test
    @DisplayName("Test with alternating characters")
    fun testAlternatingCharacters() {
        val s = "ababababab"
        val result = solution.maximumLengthSubstring(s)

        assertEquals(4, result, "Maximum length should be 4 (e.g., 'abab')")
    }
}
