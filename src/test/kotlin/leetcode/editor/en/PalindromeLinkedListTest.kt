package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PalindromeLinkedListTest {
    private val solution = PalindromeLinkedList.Solution()

    @Test
    @DisplayName("Test with palindrome linked list")
    fun testPalindromeLinkedList() {
        val values = listOf(1, 2, 2, 1)
        val head = createLinkedList(values)
        val result = solution.isPalindrome(head)
        assertEquals(true, result, "isPalindrome should correctly identify if linked list $values is a palindrome")
    }

    @Test
    @DisplayName("Test with non-palindrome linked list")
    fun testNonPalindromeLinkedList() {
        val values = listOf(1, 2)
        val head = createLinkedList(values)
        val result = solution.isPalindrome(head)
        assertEquals(false, result, "isPalindrome should correctly identify if linked list $values is a palindrome")
    }

    @Test
    @DisplayName("Test with single node")
    fun testSingleNode() {
        val values = listOf(5)
        val head = createLinkedList(values)
        val result = solution.isPalindrome(head)
        assertEquals(true, result, "isPalindrome should correctly identify if linked list $values is a palindrome")
    }

    @Test
    @DisplayName("Test with empty list")
    fun testEmptyList() {
        val values = emptyList<Int>()
        val head = createLinkedList(values)
        val result = solution.isPalindrome(head)
        assertEquals(true, result, "isPalindrome should correctly identify if linked list $values is a palindrome")
    }

    @Test
    @DisplayName("Test with odd length palindrome")
    fun testOddLengthPalindrome() {
        val head = createLinkedList(listOf(1, 2, 3, 2, 1))
        val result = solution.isPalindrome(head)
        assertEquals(true, result, "Odd length palindrome should be correctly identified")
    }

    @Test
    @DisplayName("Test with odd length non-palindrome")
    fun testOddLengthNonPalindrome() {
        val head = createLinkedList(listOf(1, 2, 3, 4, 5))
        val result = solution.isPalindrome(head)
        assertEquals(false, result, "Odd length non-palindrome should be correctly identified")
    }

    @Test
    @DisplayName("Test with repeated values palindrome")
    fun testRepeatedValuesPalindrome() {
        val head = createLinkedList(listOf(1, 1, 1, 1, 1))
        val result = solution.isPalindrome(head)
        assertEquals(true, result, "Linked list with repeated values should be correctly identified as palindrome")
    }

    @Test
    @DisplayName("Test with repeated values non-palindrome")
    fun testRepeatedValuesNonPalindrome() {
        val head = createLinkedList(listOf(1, 1, 2, 1))
        val result = solution.isPalindrome(head)
        assertEquals(false, result, "Linked list with repeated values should be correctly identified as non-palindrome")
    }

    // Helper function to create a linked list from a list of integers
    private fun createLinkedList(values: List<Int>): PalindromeLinkedList.ListNode? {
        if (values.isEmpty()) return null

        val head = PalindromeLinkedList.ListNode(values[0])
        var current = head

        for (i in 1 until values.size) {
            current.next = PalindromeLinkedList.ListNode(values[i])
            current = current.next!!
        }

        return head
    }
}
