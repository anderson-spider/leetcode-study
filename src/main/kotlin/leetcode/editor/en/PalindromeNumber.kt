package leetcode.editor.en

// Given an integer x, return true if x is a palindrome, and false otherwise.
//
//
// Example 1:
//
//
// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left.
//
//
// Example 2:
//
//
// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it
// becomes 121-. Therefore it is not a palindrome.
//
//
// Example 3:
//
//
// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//
//
//
// Constraints:
//
//
// -2³¹ <= x <= 2³¹ - 1
//
//
//
// Follow up: Could you solve it without converting the integer to a string?
//
// Related Topics Math 👍 14354 👎 2828

object PalindromeNumber {
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isPalindrome(x: Int): Boolean {
            if (x < 0) return false
            var temp = x // 1221
            var invTemp = 0
            while (temp != 0) {
                invTemp = (invTemp * 10) + (temp % 10)
                temp /= 10
            }
            return invTemp == x
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
