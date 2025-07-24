package leetcode.editor.en

// Given a string s, reverse the order of characters in each word within a
// sentence while still preserving whitespace and initial word order.
//
//
// Example 1:
//
//
// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
//
//
// Example 2:
//
//
// Input: s = "Mr Ding"
// Output: "rM gniD"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 5 * 10⁴
// s contains printable ASCII characters.
// s does not contain any leading or trailing spaces.
// There is at least one word in s.
// All the words in s are separated by a single space.
//
//
// Related Topics Two Pointers String 👍 6082 👎 252

object ReverseWordsInAStringIii {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        val case1 = solution.reverseWords("Let's take LeetCode contest")
        val case1Expected = "s'teL ekat edoCteeL tsetnoc"
        check(case1 == case1Expected) {
            "Test case 1 failed: Basic string reversal. Expected: \"$case1Expected\" but got: \"$case1\""
        }
        println("All test cases passed!")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reverseWords(s: String): String =
            buildString(s.length) {
                var wordStart = 0

                for (i in s.indices) {
                    if (s[i] == ' ') {
                        // Append the reversed word
                        appendReversedWord(s, wordStart, i - 1)
                        append(' ')
                        wordStart = i + 1
                    }
                }

                // Append the last word (reversed)
                appendReversedWord(s = s, start = wordStart, end = s.length - 1)
            }

        // Optimized method to append a reversed word directly to StringBuilder
        private fun StringBuilder.appendReversedWord(
            s: String,
            start: Int,
            end: Int,
        ) {
            for (i in end downTo start) {
                append(s[i])
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
