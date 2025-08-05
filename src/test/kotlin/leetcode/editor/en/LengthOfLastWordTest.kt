package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LengthOfLastWordTest {
    private val solution = LengthOfLastWord.Solution()

    @Test
    @DisplayName("Test with standard case - 'Hello World'")
    fun testStandardCase() {
        val s = "Hello World"
        val result = solution.lengthOfLastWord(s)
        assertEquals(5, result, "Should correctly calculate the length of the last word 'World'")
    }

    @Test
    @DisplayName("Test with multiple spaces - '   fly me   to   the moon  '")
    fun testMultipleSpaces() {
        val s = "   fly me   to   the moon  "
        val result = solution.lengthOfLastWord(s)
        assertEquals(4, result, "Should correctly calculate the length of the last word 'moon'")
    }

    @Test
    @DisplayName("Test with single word")
    fun testSingleWord() {
        val s = "Hello"
        val result = solution.lengthOfLastWord(s)
        assertEquals(5, result, "Should correctly calculate the length of the only word 'Hello'")
    }

    @Test
    @DisplayName("Test with single word with trailing spaces")
    fun testSingleWordWithTrailingSpaces() {
        val s = "Hello    "
        val result = solution.lengthOfLastWord(s)
        assertEquals(5, result, "Should correctly calculate the length of the word 'Hello' ignoring trailing spaces")
    }

    @Test
    @DisplayName("Test with single word with leading spaces")
    fun testSingleWordWithLeadingSpaces() {
        val s = "    Hello"
        val result = solution.lengthOfLastWord(s)
        assertEquals(5, result, "Should correctly calculate the length of the word 'Hello' ignoring leading spaces")
    }

    @Test
    @DisplayName("Test with multiple words")
    fun testMultipleWords() {
        val s = "luffy is still joyboy"
        val result = solution.lengthOfLastWord(s)
        assertEquals(6, result, "Should correctly calculate the length of the last word 'joyboy'")
    }

    @Test
    @DisplayName("Test with single character word")
    fun testSingleCharacterWord() {
        val s = "a"
        val result = solution.lengthOfLastWord(s)
        assertEquals(1, result, "Should correctly calculate the length of a single character word")
    }

    @Test
    @DisplayName("Test with last word as single character")
    fun testLastWordSingleCharacter() {
        val s = "Hello World a"
        val result = solution.lengthOfLastWord(s)
        assertEquals(1, result, "Should correctly calculate the length of the last word 'a'")
    }
}
