package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ValidPalindromeTest {
    private val solution = ValidPalindrome.Solution()

    @Test
    @DisplayName("Test with regular palindrome with special characters")
    fun testRegularPalindromeWithSpecialCharacters() {
        val input = "A man, a plan, a canal: Panama"
        val result = solution.isPalindrome(input)
        assertEquals(true, result, "isPalindrome should correctly identify if '$input' is a palindrome")
    }

    @Test
    @DisplayName("Test with non-palindrome")
    fun testNonPalindrome() {
        val input = "race a car"
        val result = solution.isPalindrome(input)
        assertEquals(false, result, "isPalindrome should correctly identify if '$input' is a palindrome")
    }

    @Test
    @DisplayName("Test with empty string with spaces")
    fun testEmptyStringWithSpaces() {
        val input = " "
        val result = solution.isPalindrome(input)
        assertEquals(true, result, "isPalindrome should correctly identify if '$input' is a palindrome")
    }

    @Test
    @DisplayName("Test with alphanumeric palindrome")
    fun testAlphanumericPalindrome() {
        val input = "ab2ba"
        val result = solution.isPalindrome(input)
        assertEquals(true, result, "isPalindrome should correctly identify if '$input' is a palindrome")
    }

    @Test
    @DisplayName("Test with single character")
    fun testSingleCharacter() {
        val input = "a"
        val result = solution.isPalindrome(input)
        assertEquals(true, result, "isPalindrome should correctly identify if '$input' is a palindrome")
    }

    @Test
    @DisplayName("Test with empty string")
    fun testEmptyString() {
        val result = solution.isPalindrome("")
        assertEquals(true, result, "Empty string should be considered a palindrome")
    }

    @Test
    @DisplayName("Test with only special characters")
    fun testOnlySpecialCharacters() {
        val result = solution.isPalindrome("!@#$%^&*()")
        assertEquals(true, result, "String with only special characters should be considered a palindrome")
    }

    @Test
    @DisplayName("Test with mixed case palindrome")
    fun testMixedCasePalindrome() {
        val result = solution.isPalindrome("RaCeCaR")
        assertEquals(true, result, "Mixed case palindrome should be correctly identified")
    }

    @Test
    @DisplayName("Test with numbers only")
    fun testNumbersOnly() {
        val result = solution.isPalindrome("12321")
        assertEquals(true, result, "Numeric palindrome should be correctly identified")
    }

    @Test
    @DisplayName("Test with numbers only - not a palindrome")
    fun testNumbersOnlyNotPalindrome() {
        val result = solution.isPalindrome("12345")
        assertEquals(false, result, "Non-palindrome numeric string should be correctly identified")
    }
}
