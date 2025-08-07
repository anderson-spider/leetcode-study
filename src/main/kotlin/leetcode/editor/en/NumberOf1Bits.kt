package leetcode.editor.en
// Given a positive integer n, write a function that returns the number of set
// bits in its binary representation (also known as the Hamming weight).
//
//
// Example 1:
//
//
// Input: n = 11
//
//
// Output: 3
//
// Explanation:
//
// The input binary string 1011 has a total of three set bits.
//
// Example 2:
//
//
// Input: n = 128
//
//
// Output: 1
//
// Explanation:
//
// The input binary string 10000000 has a total of one set bit.
//
// Example 3:
//
//
// Input: n = 2147483645
//
//
// Output: 30
//
// Explanation:
//
// The input binary string 1111111111111111111111111111101 has a total of
// thirty set bits.
//
//
// Constraints:
//
//
// 1 <= n <= 2³¹ - 1
//
//
//
// Follow up: If this function is called many times, how would you optimize it?
//
// Related Topics Divide and Conquer Bit Manipulation 👍 6898 👎 1354

object NumberOf1Bits {
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun hammingWeight(n: Int): Int {
            var n = n
            var res = 0
            while (n > 0) {
                res += n and 1
                n = n shr 1
            }

            return res
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
