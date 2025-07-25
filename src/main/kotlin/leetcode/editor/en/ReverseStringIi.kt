package leetcode.editor.en
// Given a string s and an integer k, reverse the first k characters for every 2
// k characters counting from the start of the string.
//
// If there are fewer than k characters left, reverse all of them. If there are
// less than 2k but greater than or equal to k characters, then reverse the first
// k characters and leave the other as original.
//
//
// Example 1:
// Input: s = "abcdefg", k = 2
// Output: "bacdfeg"
//
// Example 2:
// Input: s = "abcd", k = 2
// Output: "bacd"
//
//
// Constraints:
//
//
// 1 <= s.length <= 10⁴
// s consists of only lowercase English letters.
// 1 <= k <= 10⁴
//
//
// Related Topics Two Pointers String 👍 2179 👎 4187

object ReverseStringIi {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        // Test case 1: Basic reversal
        val case1 = solution.reverseStr("abcdefg", 2)
        val case1Expected = "bacdfeg"
        check(case1 == case1Expected) {
            "Test case 1 failed: Expected: \"$case1Expected\" but got: \"$case1\""
        }

        // Test case 2: String length equal to k
        val case2 = solution.reverseStr("abcd", 2)
        val case2Expected = "bacd"
        check(case2 == case2Expected) {
            "Test case 2 failed: Expected: \"$case2Expected\" but got: \"$case2\""
        }

        // Test case 3: String length less than k
        val case3 = solution.reverseStr("abc", 4)
        val case3Expected = "cba"
        check(case3 == case3Expected) {
            "Test case 3 failed: Expected: \"$case3Expected\" but got: \"$case3\""
        }

        // Test case 4: String length less than k
        val case4 = solution.reverseStr("ba", 1)
        val case4Expected = "ba"
        check(case4 == case4Expected) {
            "Test case 4 failed: Expected: \"$case4Expected\" but got: \"$case4\""
        }

        println("All test cases passed!")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reverseStr(
            s: String,
            k: Int,
        ): String =
            buildString(s.length) {
                var i = 0

                while (i < s.length) {
                    // Reverse first k characters
                    val end = minOf(i + k - 1, s.lastIndex)
                    for (j in end downTo i) {
                        append(s[j])
                    }

                    // Append next k characters as is
                    val startIndex = end + 1
                    if (startIndex <= s.lastIndex) {
                        val endIndex = minOf(startIndex + k - 1, s.lastIndex)
                        append(s.substring(startIndex, endIndex + 1))
                    }

                    // Move to the next 2k characters
                    i += 2 * k
                }
            }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
