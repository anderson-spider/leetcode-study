package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ReverseWordsInAStringIiiTest {
    private val solution = ReverseWordsInAStringIii.Solution()

    @Test
    @DisplayName("Test with standard case")
    fun testStandardCase() {
        val s = "Let's take LeetCode contest"
        val result = solution.reverseWords(s)
        assertEquals(
            "s'teL ekat edoCteeL tsetnoc",
            result,
            "Should correctly reverse each word while preserving word order",
        )
    }

    @Test
    @DisplayName("Test with example 2")
    fun testExample2() {
        val s = "Mr Ding"
        val result = solution.reverseWords(s)
        assertEquals(
            "rM gniD",
            result,
            "Should correctly reverse each word while preserving word order",
        )
    }

    @Test
    @DisplayName("Test with single word")
    fun testSingleWord() {
        val s = "Hello"
        val result = solution.reverseWords(s)
        assertEquals(
            "olleH",
            result,
            "Should correctly reverse a single word",
        )
    }

    @Test
    @DisplayName("Test with single character words")
    fun testSingleCharacterWords() {
        val s = "a b c d"
        val result = solution.reverseWords(s)
        assertEquals(
            "a b c d",
            result,
            "Single character words should remain the same when reversed",
        )
    }

    @Test
    @DisplayName("Test with palindrome words")
    fun testPalindromeWords() {
        val s = "level radar kayak"
        val result = solution.reverseWords(s)
        assertEquals(
            "level radar kayak",
            result,
            "Palindrome words should remain the same when reversed",
        )
    }

    @Test
    @DisplayName("Test with special characters")
    fun testSpecialCharacters() {
        val s = "Hello! How are you?"
        val result = solution.reverseWords(s)
        assertEquals(
            "!olleH woH era ?uoy",
            result,
            "Should correctly handle special characters",
        )
    }
}
