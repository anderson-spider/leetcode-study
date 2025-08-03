package leetcode.editor.en
// Given a string s, return the longest palindromic substring in s.
//
//
// Example 1:
//
//
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
//
//
// Example 2:
//
//
// Input: s = "cbbd"
// Output: "bb"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s consist of only digits and English letters.
//
//
// Related Topics Two Pointers String Dynamic Programming 👍 31162 👎 1919

object LongestPalindromicSubstring {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        assert(solution.longestPalindrome("cacac") == "cacac")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestPalindrome(s: String): String {
            if (s.length < 2) return s

            val oddString =
                buildString {
                    append("#")
                    s.forEach { append(it).append("#") }
                }

            val p = manacher(oddString)

            var maxLen = 0
            var c = 0
            for (i in oddString.indices) {
                val palindromeLength = p[i]
                if (palindromeLength > maxLen) {
                    maxLen = palindromeLength
                    c = i
                }
            }

            val start = (c - maxLen) / 2
            return s.substring(start, start + maxLen)
        }

        private fun manacher(str: String): IntArray {
            val lps = IntArray(str.length)
            var l = 0
            var r = 0

            for (i in str.indices) {
                if (i < r) {
                    val iMirror = 2 * l - i
                    lps[i] = minOf(r - i, lps[iMirror])
                }

                var a = i + (lps[i] + 1)
                var b = i - (lps[i] + 1)
                while (a < str.length && b >= 0 && str[a] == str[b]) {
                    lps[i]++
                    a++
                    b--
                }

                if (i + lps[i] > r) {
                    l = i
                    r = i + lps[i]
                }
            }
            return lps
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
