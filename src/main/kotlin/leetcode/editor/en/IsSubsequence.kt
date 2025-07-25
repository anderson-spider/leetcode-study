package leetcode.editor.en
// Given two strings s and t, return true if s is a subsequence of t, or false
// otherwise.
//
// A subsequence of a string is a new string that is formed from the original
// string by deleting some (can be none) of the characters without disturbing the
// relative positions of the remaining characters. (i.e., "ace" is a subsequence of
// "abcde" while "aec" is not).
//
//
// Example 1:
// Input: s = "abc", t = "ahbgdc"
// Output: true
//
// Example 2:
// Input: s = "axc", t = "ahbgdc"
// Output: false
//
//
// Constraints:
//
//
// 0 <= s.length <= 100
// 0 <= t.length <= 10⁴
// s and t consist only of lowercase English letters.
//
//
//
// Follow up: Suppose there are lots of incoming
// s, say
// s1, s2, ..., sk where
// k >= 10⁹, and you want to check one by one to see if
// t has its subsequence. In this scenario, how would you change your code?
//
// Related Topics Two Pointers String Dynamic Programming 👍 10367 👎 586

object IsSubsequence {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isSubsequence(
            s: String,
            t: String,
        ): Boolean {
            // Check if s is empty, which means it's a valid subsequence
            if (s.isEmpty()) return true
            // Initialize pointers for both strings
            var sp = 0
            var tp = 0
            // Iterate through both strings until we reach the end of either
            while (sp < s.length && tp < t.length) {
                // If characters match, move s pointer forward
                if (s[sp] == t[tp]) {
                    sp++
                }
                // Always move t pointer forward
                tp++
            }
            // Return true if we found all characters in s
            return sp == s.length
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
