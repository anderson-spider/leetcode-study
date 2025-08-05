package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DeleteCharactersToMakeFancyStringTest {
    private val solution = DeleteCharactersToMakeFancyString.Solution()

    @Test
    @DisplayName("Test with three consecutive characters")
    fun testThreeConsecutiveCharacters() {
        val s = "leeetcode"
        val result = solution.makeFancyString(s)

        assertEquals("leetcode", result, "Should remove one 'e' to make 'leeetcode' fancy")
    }

    @Test
    @DisplayName("Test with multiple groups of consecutive characters")
    fun testMultipleGroups() {
        val s = "aaabaaaa"
        val result = solution.makeFancyString(s)

        assertEquals("aabaa", result, "Should remove one 'a' from first group and two 'a's from second group")
    }

    @Test
    @DisplayName("Test with already fancy string")
    fun testAlreadyFancyString() {
        val s = "aab"
        val result = solution.makeFancyString(s)

        assertEquals("aab", result, "Already fancy string should remain unchanged")
    }

    @Test
    @DisplayName("Test with empty string")
    fun testEmptyString() {
        val s = ""
        val result = solution.makeFancyString(s)

        assertEquals("", result, "Empty string should remain empty")
    }

    @Test
    @DisplayName("Test with single character")
    fun testSingleCharacter() {
        val s = "a"
        val result = solution.makeFancyString(s)

        assertEquals("a", result, "Single character string should remain unchanged")
    }

    @Test
    @DisplayName("Test with two characters")
    fun testTwoCharacters() {
        val s = "aa"
        val result = solution.makeFancyString(s)

        assertEquals("aa", result, "Two character string should remain unchanged")
    }

    @Test
    @DisplayName("Test with many consecutive characters")
    fun testManyConsecutiveCharacters() {
        val s = "aaaaaaaaa" // 9 consecutive 'a's
        val result = solution.makeFancyString(s)

        assertEquals("aa", result, "Should keep only two 'a's from nine consecutive 'a's")
    }

    @Test
    @DisplayName("Test with alternating characters")
    fun testAlternatingCharacters() {
        val s = "ababababab"
        val result = solution.makeFancyString(s)

        assertEquals("ababababab", result, "Alternating characters should remain unchanged")
    }

    @Test
    @DisplayName("Test with mixed patterns")
    fun testMixedPatterns() {
        val s = "aaabbbbccccc"
        val result = solution.makeFancyString(s)

        assertEquals("aabbcc", result, "Should keep only two characters from each consecutive group")
    }

    @Test
    @DisplayName("Test with exactly three consecutive characters")
    fun testExactlyThreeConsecutiveCharacters() {
        val s = "aaaleetcode"
        val result = solution.makeFancyString(s)

        assertEquals("aaleetcode", result, "Should remove one 'a' from three consecutive 'a's")
    }
}
