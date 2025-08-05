package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ValidParenthesesTest {
    private val solution = ValidParentheses.Solution()

    @Test
    @DisplayName("Test with simple valid parentheses")
    fun testSimpleValidParentheses() {
        val input = "()"
        val result = solution.isValid(input)
        assertEquals(true, result, "isValid should correctly identify if '$input' is valid")
    }

    @Test
    @DisplayName("Test with multiple valid parentheses")
    fun testMultipleValidParentheses() {
        val input = "()[]{}"
        val result = solution.isValid(input)
        assertEquals(true, result, "isValid should correctly identify if '$input' is valid")
    }

    @Test
    @DisplayName("Test with mismatched parentheses")
    fun testMismatchedParentheses() {
        val input = "(]"
        val result = solution.isValid(input)
        assertEquals(false, result, "isValid should correctly identify if '$input' is valid")
    }

    @Test
    @DisplayName("Test with nested valid parentheses")
    fun testNestedValidParentheses() {
        val input = "([])"
        val result = solution.isValid(input)
        assertEquals(true, result, "isValid should correctly identify if '$input' is valid")
    }

    @Test
    @DisplayName("Test with interleaved invalid parentheses")
    fun testInterleavedInvalidParentheses() {
        val input = "([)]"
        val result = solution.isValid(input)
        assertEquals(false, result, "isValid should correctly identify if '$input' is valid")
    }

    @Test
    @DisplayName("Test with only closing bracket")
    fun testOnlyClosingBracket() {
        val input = "]"
        val result = solution.isValid(input)
        assertEquals(false, result, "isValid should correctly identify if '$input' is valid")
    }

    @Test
    @DisplayName("Test with empty string")
    fun testEmptyString() {
        val input = ""
        val result = solution.isValid(input)
        assertEquals(true, result, "isValid should correctly identify if '$input' is valid")
    }

    @Test
    @DisplayName("Test with unmatched opening bracket")
    fun testUnmatchedOpeningBracket() {
        val input = "("
        val result = solution.isValid(input)
        assertEquals(false, result, "isValid should correctly identify if '$input' is valid")
    }

    @Test
    @DisplayName("Test with complex nested valid parentheses")
    fun testComplexNestedValidParentheses() {
        val input = "{[()]}"
        val result = solution.isValid(input)
        assertEquals(true, result, "isValid should correctly identify if '$input' is valid")
    }

    @Test
    @DisplayName("Test with multiple sets of valid parentheses")
    fun testMultipleSetsOfValidParentheses() {
        val input = "{}[](){}[]"
        val result = solution.isValid(input)
        assertEquals(true, result, "isValid should correctly identify if '$input' is valid")
    }
}
