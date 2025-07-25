package leetcode.editor.en
// Given a string s, return the maximum length of a substring such that it
// contains at most two occurrences of each character.
//
//
// Example 1:
//
//
// Input: s = "bcbbbcba"
//
//
// Output: 4
//
// Explanation: The following substring has a length of 4 and contains at most
// two occurrences of each character:
// "bcbbbcba".
//
// Example 2:
//
//
// Input: s = "aaaa"
//
//
// Output: 2
//
// Explanation: The following substring has a length of 2 and contains at most
// two occurrences of each character:
// "aaaa".
//
//
// Constraints:
//
//
// 2 <= s.length <= 100
// s consists only of lowercase English letters.
//
//
// Related Topics Hash Table String Sliding Window 👍 221 👎 19

object MaximumLengthSubstringWithTwoOccurrences {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        val result = solution.maximumLengthSubstring("abcabcbb")
        println(result)
        val result2 = solution.maximumLengthSubstring("bbbbb")
        println(result2)
        val result3 = solution.maximumLengthSubstring("pwwkew")
        println(result3)
        val result4 = solution.maximumLengthSubstring("abba")
        println(result4)
        val result5 = solution.maximumLengthSubstring("abbbbbbbbbbbbbbbbbbbbbb")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maximumLengthSubstring(s: String): Int {
            // Initialize pointers for sliding window
            var l = 0
            var r = 0
            // Track maximum length found
            var max = 1
            // Map to count occurrences of each character
            val counter = mutableMapOf<Char, Int>()
            // Initialize first character count
            counter[s[0]] = 1

            // Expand window to the right
            while (r < s.length - 1) {
                r++
                // Update count for current character
                if (counter.containsKey(s[r])) {
                    counter[s[r]] = counter[s[r]]!! + 1
                } else {
                    counter[s[r]] = 1
                }

                // Shrink window if character count exceeds 2
                while (counter[s[r]]!! == 3) {
                    counter[s[l]] = counter[s[l]]!! - 1
                    l++
                }
                // Update maximum length
                max = maxOf(max, r - l + 1)
            }
            return max
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
