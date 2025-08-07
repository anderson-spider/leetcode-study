package leetcode.editor.en
// You are given a positive integer n. Determine whether n is divisible by the
// sum of the following two values:
//
//
// The digit sum of n (the sum of its digits).
// The digit product of n (the product of its digits).
//
//
// Return true if n is divisible by this sum; otherwise, return false.
//
//
// Example 1:
//
//
// Input: n = 99
//
//
// Output: true
//
// Explanation:
//
// Since 99 is divisible by the sum (9 + 9 = 18) plus product (9 * 9 = 81) of
// its digits (total 99), the output is true.
//
// Example 2:
//
//
// Input: n = 23
//
//
// Output: false
//
// Explanation:
//
// Since 23 is not divisible by the sum (2 + 3 = 5) plus product (2 * 3 = 6) of
// its digits (total 11), the output is false.
//
//
// Constraints:
//
//
// 1 <= n <= 10⁶
//
//
// Related Topics Math 👍 27 👎 0

object CheckDivisibilityByDigitSumAndProduct {
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun checkDivisibility(n: Int): Boolean {
            val digitSum = calculateDigitSum(n)
            val digitProduct = calculateDigitProduct(n)
            return n % (digitSum + digitProduct) == 0
        }

        private fun calculateDigitSum(n: Int): Int {
            var num = n
            var sum = 0
            while (num > 0) {
                sum += num % 10
                num /= 10
            }
            return sum
        }

        private fun calculateDigitProduct(n: Int): Int {
            var num = n
            var product = 1
            while (num > 0) {
                product *= num % 10
                num /= 10
            }
            return product
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
