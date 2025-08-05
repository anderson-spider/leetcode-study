package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ReverseWordsInAStringTest {
    private val solution = ReverseWordsInAString.Solution()

    @Test
    @DisplayName("Test with basic string reversal")
    fun testBasicStringReversal() {
        val s = "the sky is blue"
        val result = solution.reverseWords(s)
        assertEquals(
            "blue is sky the",
            result,
            "Should correctly reverse the order of words",
        )
    }

    @Test
    @DisplayName("Test with leading and trailing spaces")
    fun testLeadingTrailingSpaces() {
        val s = "  hello world  "
        val result = solution.reverseWords(s)
        assertEquals(
            "world hello",
            result,
            "Should remove leading and trailing spaces and reverse the order of words",
        )
    }

    @Test
    @DisplayName("Test with multiple spaces between words")
    fun testMultipleSpacesBetweenWords() {
        val s = "a good   example"
        val result = solution.reverseWords(s)
        assertEquals(
            "example good a",
            result,
            "Should reduce multiple spaces to a single space and reverse the order of words",
        )
    }

    @Test
    @DisplayName("Test with single word")
    fun testSingleWord() {
        val s = "hello"
        val result = solution.reverseWords(s)
        assertEquals(
            "hello",
            result,
            "Should return the same word for a single word input",
        )
    }

    @Test
    @DisplayName("Test with single word with spaces")
    fun testSingleWordWithSpaces() {
        val s = "   hello   "
        val result = solution.reverseWords(s)
        assertEquals(
            "hello",
            result,
            "Should remove leading and trailing spaces for a single word input",
        )
    }

    @Test
    @DisplayName("Test with empty string")
    fun testEmptyString() {
        val s = ""
        val result = solution.reverseWords(s)
        assertEquals(
            "",
            result,
            "Should handle empty string correctly",
        )
    }

    @Test
    @DisplayName("Test with only spaces")
    fun testOnlySpaces() {
        val s = "     "
        val result = solution.reverseWords(s)
        assertEquals(
            "",
            result,
            "Should return empty string for input with only spaces",
        )
    }
}
