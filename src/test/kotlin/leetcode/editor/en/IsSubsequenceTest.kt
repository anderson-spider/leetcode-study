package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IsSubsequenceTest {
    private val solution = IsSubsequence.Solution()

    @Test
    @DisplayName("Test with basic subsequence")
    fun testBasicSubsequence() {
        val s = "abc"
        val t = "ahbgdc"
        val result = solution.isSubsequence(s, t)
        assertEquals(true, result, "isSubsequence should correctly identify if '$s' is a subsequence of '$t'")
    }

    @Test
    @DisplayName("Test with non-subsequence")
    fun testNonSubsequence() {
        val s = "axc"
        val t = "ahbgdc"
        val result = solution.isSubsequence(s, t)
        assertEquals(false, result, "isSubsequence should correctly identify if '$s' is a subsequence of '$t'")
    }

    @Test
    @DisplayName("Test with empty s string")
    fun testEmptyS() {
        val s = ""
        val t = "ahbgdc"
        val result = solution.isSubsequence(s, t)
        assertEquals(true, result, "Empty string should be a subsequence of any string")
    }

    @Test
    @DisplayName("Test with empty t string")
    fun testEmptyT() {
        val s = "abc"
        val t = ""
        val result = solution.isSubsequence(s, t)
        assertEquals(false, result, "Non-empty string cannot be a subsequence of an empty string")
    }

    @Test
    @DisplayName("Test with both empty strings")
    fun testBothEmpty() {
        val s = ""
        val t = ""
        val result = solution.isSubsequence(s, t)
        assertEquals(true, result, "Empty string should be a subsequence of empty string")
    }

    @Test
    @DisplayName("Test with s longer than t")
    fun testSLongerThanT() {
        val s = "abcdef"
        val t = "abc"
        val result = solution.isSubsequence(s, t)
        assertEquals(false, result, "String s cannot be a subsequence if it's longer than t")
    }

    @Test
    @DisplayName("Test with s equal to t")
    fun testSEqualToT() {
        val s = "abc"
        val t = "abc"
        val result = solution.isSubsequence(s, t)
        assertEquals(true, result, "String s should be a subsequence if it's equal to t")
    }

    @Test
    @DisplayName("Test with characters in wrong order")
    fun testWrongOrder() {
        val s = "acb"
        val t = "ahbgdc"
        val result = solution.isSubsequence(s, t)
        assertEquals(false, result, "String s is not a subsequence if characters appear in wrong order")
    }
}
