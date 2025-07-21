package leetcode.editor.en

import kotlin.math.abs

// Given a signed 32-bit integer x, return x with its digits reversed. If
// reversing x causes the value to go outside the signed 32-bit integer range [-2³¹, 2³¹ -
// 1], then return 0.
//
// Assume the environment does not allow you to store 64-bit integers (signed
// or unsigned).
//
//
// Example 1:
//
//
// Input: x = 123
// Output: 321
//
//
// Example 2:
//
//
// Input: x = -123
// Output: -321
//
//
// Example 3:
//
//
// Input: x = 120
// Output: 21
//
//
//
// Constraints:
//
//
// -2³¹ <= x <= 2³¹ - 1
//
//
// Related Topics Math 👍 14345 👎 13806

object ReverseInteger {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        check(solution.reverse(x = 123) == 321) { "Test case 1 failed" }
        check(solution.reverse(x = -123) == -321) { "Test case 2 failed" }
        check(solution.reverse(x = 120) == 21) { "Test case 3 failed" }
        println("All test cases passed!")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reverse(x: Int): Int {
            val negative = x < 0
            var num = abs(x.toLong())
            var revNum = 0L

            while (num != 0L) {
                val factor = 10L
                val mod = num % factor
                num = num / factor
                revNum = revNum * factor + mod
            }

            return if (revNum > Int.MAX_VALUE) {
                0
            } else if (negative) {
                0 - revNum.toInt()
            } else {
                revNum.toInt()
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
