package leetcode.editor.en
// Given the head of a singly linked list, return true if it is a palindrome or
// false otherwise.
//
//
// Example 1:
//
//
// Input: head = [1,2,2,1]
// Output: true
//
//
// Example 2:
//
//
// Input: head = [1,2]
// Output: false
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [1, 10⁵].
// 0 <= Node.val <= 9
//
//
//
// Follow up: Could you do it in
// O(n) time and
// O(1) space?
//
// Related Topics Linked List Two Pointers Stack Recursion 👍 17589 👎 944

object PalindromeLinkedList {
    class ListNode(
        var `val`: Int,
    ) {
        var next: ListNode? = null
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     *
     class ListNode(var `val`: Int) {
     var next: ListNode? = null
     }
     */

    class Solution {
        fun isPalindrome(head: ListNode?): Boolean {
            if (head?.next == null) return true // Single node or empty list is a palindrome

            // Find the middle of the linked list using slow and fast pointers
            var slow = head
            var fast = head
            while (fast?.next != null) {
                slow = slow?.next
                fast = fast.next?.next
            }

            // If the list has odd number of nodes, move slow one step forward
            if (fast != null) {
                slow = slow?.next
            }

            // Reverse the second half of the linked list
            var reversedSecondHalf = reverseList(slow)
            var firstHalf = head

            // Compare the first half with the reversed second half
            while (reversedSecondHalf != null) {
                if (firstHalf?.`val` != reversedSecondHalf.`val`) {
                    return false
                }
                firstHalf = firstHalf.next
                reversedSecondHalf = reversedSecondHalf.next
            }

            return true
        }

        // Helper function to reverse a linked list
        private fun reverseList(head: ListNode?): ListNode? {
            var prev: ListNode? = null
            var current = head

            while (current != null) {
                val next = current.next
                current.next = prev
                prev = current
                current = next
            }

            return prev
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
