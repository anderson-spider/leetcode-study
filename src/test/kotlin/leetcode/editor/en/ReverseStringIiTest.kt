package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ReverseStringIiTest {
    private val solution = ReverseStringIi.Solution()

    @Test
    @DisplayName("Test with basic reversal")
    fun testBasicReversal() {
        val s = "abcdefg"
        val k = 2
        val result = solution.reverseStr(s, k)
        assertEquals("bacdfeg", result, "Should correctly reverse every first k characters of 2k groups")
    }

    @Test
    @DisplayName("Test with string length equal to k")
    fun testStringLengthEqualToK() {
        val s = "abcd"
        val k = 2
        val result = solution.reverseStr(s, k)
        assertEquals("bacd", result, "Should correctly handle when string length is equal to k")
    }

    @Test
    @DisplayName("Test with string length less than k")
    fun testStringLengthLessThanK() {
        val s = "abc"
        val k = 4
        val result = solution.reverseStr(s, k)
        assertEquals("cba", result, "Should reverse all characters when string length is less than k")
    }

    @Test
    @DisplayName("Test with k=1")
    fun testKEqualsOne() {
        val s = "abcdef"
        val k = 1
        val result = solution.reverseStr(s, k)
        assertEquals("abcdef", result, "Should handle k=1 correctly")
    }

    @Test
    @DisplayName("Test with empty string")
    fun testEmptyString() {
        val s = ""
        val k = 2
        val result = solution.reverseStr(s, k)
        assertEquals("", result, "Should handle empty string correctly")
    }

    @Test
    @DisplayName("Test with single character")
    fun testSingleCharacter() {
        val s = "a"
        val k = 3
        val result = solution.reverseStr(s, k)
        assertEquals("a", result, "Should handle single character correctly")
    }

    @Test
    @DisplayName("Test with large k")
    fun testLargeK() {
        val s = "abcdefghij"
        val k = 5
        val result = solution.reverseStr(s, k)
        assertEquals("edcbafghij", result, "Should handle large k correctly")
    }
}
