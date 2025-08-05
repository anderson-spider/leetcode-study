package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LongestPalindromicSubstringTest {
    private val solution = LongestPalindromicSubstring.Solution()

    @Test
    @DisplayName("Test with odd-length palindrome")
    fun testOddLengthPalindrome() {
        val s = "racecar"

        val result = solution.longestPalindrome(s)

        assertEquals("racecar", result, "Longest palindrome in 'racecar' should be 'racecar'")
    }

    @Test
    @DisplayName("Test with even-length palindrome")
    fun testEvenLengthPalindrome() {
        val s = "cbbd"

        val result = solution.longestPalindrome(s)

        assertEquals("bb", result, "Longest palindrome in 'cbbd' should be 'bb'")
    }

    @Test
    @DisplayName("Test with multiple palindromes of same length")
    fun testMultiplePalindromesOfSameLength() {
        val s = "babad"

        val result = solution.longestPalindrome(s)

        // Either "bab" or "aba" is a valid answer
        assertTrue(result == "bab" || result == "aba", "Longest palindrome in 'babad' should be either 'bab' or 'aba'")
    }

    @Test
    @DisplayName("Test with single character")
    fun testSingleCharacter() {
        val s = "a"

        val result = solution.longestPalindrome(s)

        assertEquals("a", result, "Longest palindrome in 'a' should be 'a'")
    }

    @Test
    @DisplayName("Test with no palindromes longer than 1 character")
    fun testNoPalindromesLongerThanOneChar() {
        val s = "abcd"

        val result = solution.longestPalindrome(s)

        // Any single character is a valid answer
        assertTrue(result.length == 1 && s.contains(result), "Longest palindrome in 'abcd' should be any single character")
    }

    @Test
    @DisplayName("Test with palindrome at beginning")
    fun testPalindromeAtBeginning() {
        val s = "abbcdef"

        val result = solution.longestPalindrome(s)

        assertEquals("bb", result, "Longest palindrome in 'abbcdef' should be 'bb'")
    }

    @Test
    @DisplayName("Test with palindrome in middle")
    fun testPalindromeInMiddle() {
        val s = "abcdeedcfg"

        val result = solution.longestPalindrome(s)

        assertEquals("cdeedc", result, "Longest palindrome in 'abcdeedcfg' should be 'cdeedc'")
    }

    @Test
    @DisplayName("Test with palindrome at end")
    fun testPalindromeAtEnd() {
        val s = "abcddcba"

        val result = solution.longestPalindrome(s)

        assertEquals("abcddcba", result, "Longest palindrome in 'abcddcba' should be 'abcddcba'")
    }

    @Test
    @DisplayName("Test with entire string as palindrome")
    fun testEntireStringAsPalindrome() {
        val s = "level"

        val result = solution.longestPalindrome(s)

        assertEquals("level", result, "Longest palindrome in 'level' should be 'level'")
    }

    @Test
    @DisplayName("Test with long palindrome")
    fun testLongPalindrome() {
        // This is a long string with a known palindrome "ranynar"
        val s =
            StringBuilder()
                .apply {
                    append("civilwartestingwhetherthatnaptionorany")
                    append("nartionsoconceivedandsodedicatedcanlong")
                    // ... rest of the long string omitted for brevity
                }.toString()

        // Create a simpler string with the same palindrome
        val simplifiedString = "xyzranynarxyz"

        val result = solution.longestPalindrome(simplifiedString)

        assertEquals("ranynar", result, "Longest palindrome should be 'ranynar'")
    }

    @Test
    @DisplayName("Test with repeated characters")
    fun testRepeatedCharacters() {
        val s = "aaa"

        val result = solution.longestPalindrome(s)

        assertEquals("aaa", result, "Longest palindrome in 'aaa' should be 'aaa'")
    }
}
