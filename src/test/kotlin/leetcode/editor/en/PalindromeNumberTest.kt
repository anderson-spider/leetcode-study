package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PalindromeNumberTest {
    private val solution = PalindromeNumber.Solution()

    @Test
    @DisplayName("Test with palindrome number")
    fun testPalindromeNumber() {
        val x = 121
        val result = solution.isPalindrome(x)
        assertEquals(true, result, "isPalindrome should correctly identify if $x is a palindrome")
    }

    @Test
    @DisplayName("Test with negative number")
    fun testNegativeNumber() {
        val x = -121
        val result = solution.isPalindrome(x)
        assertEquals(false, result, "isPalindrome should return false for negative numbers")
    }

    @Test
    @DisplayName("Test with number ending in zero")
    fun testNumberEndingInZero() {
        val x = 10
        val result = solution.isPalindrome(x)
        assertEquals(false, result, "isPalindrome should return false for numbers ending in zero (except 0)")
    }

    @Test
    @DisplayName("Test with zero")
    fun testZero() {
        val x = 0
        val result = solution.isPalindrome(x)
        assertEquals(true, result, "isPalindrome should return true for zero")
    }

    @Test
    @DisplayName("Test with single digit")
    fun testSingleDigit() {
        val x = 7
        val result = solution.isPalindrome(x)
        assertEquals(true, result, "isPalindrome should return true for single digit numbers")
    }

    @Test
    @DisplayName("Test with even number of digits palindrome")
    fun testEvenNumberOfDigitsPalindrome() {
        val x = 1221
        val result = solution.isPalindrome(x)
        assertEquals(true, result, "isPalindrome should correctly identify palindromes with even number of digits")
    }

    @Test
    @DisplayName("Test with even number of digits non-palindrome")
    fun testEvenNumberOfDigitsNonPalindrome() {
        val x = 1234
        val result = solution.isPalindrome(x)
        assertEquals(false, result, "isPalindrome should correctly identify non-palindromes with even number of digits")
    }

    @Test
    @DisplayName("Test with odd number of digits palindrome")
    fun testOddNumberOfDigitsPalindrome() {
        val x = 12321
        val result = solution.isPalindrome(x)
        assertEquals(true, result, "isPalindrome should correctly identify palindromes with odd number of digits")
    }

    @Test
    @DisplayName("Test with odd number of digits non-palindrome")
    fun testOddNumberOfDigitsNonPalindrome() {
        val x = 12345
        val result = solution.isPalindrome(x)
        assertEquals(false, result, "isPalindrome should correctly identify non-palindromes with odd number of digits")
    }

    @Test
    @DisplayName("Test with large palindrome")
    fun testLargePalindrome() {
        val x = 1234554321
        val result = solution.isPalindrome(x)
        assertEquals(true, result, "isPalindrome should correctly identify large palindromes")
    }

    @Test
    @DisplayName("Test with large non-palindrome")
    fun testLargeNonPalindrome() {
        val x = 1234567890
        val result = solution.isPalindrome(x)
        assertEquals(false, result, "isPalindrome should correctly identify large non-palindromes")
    }
}
