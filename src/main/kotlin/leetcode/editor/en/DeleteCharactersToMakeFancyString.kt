package leetcode.editor.en
// A fancy string is a string where no three consecutive characters are equal.
//
// Given a string s, delete the minimum possible number of characters from s to
// make it fancy.
//
// Return the final string after the deletion. It can be shown that the answer
// will always be unique.
//
//
// Example 1:
//
//
// Input: s = "leeetcode"
// Output: "leetcode"
// Explanation:
// Remove an 'e' from the first group of 'e's to create "leetcode".
// No three consecutive characters are equal, so return "leetcode".
//
//
// Example 2:
//
//
// Input: s = "aaabaaaa"
// Output: "aabaa"
// Explanation:
// Remove an 'a' from the first group of 'a's to create "aabaaaa".
// Remove two 'a's from the second group of 'a's to create "aabaa".
// No three consecutive characters are equal, so return "aabaa".
//
//
// Example 3:
//
//
// Input: s = "aab"
// Output: "aab"
// Explanation: No three consecutive characters are equal, so return "aab".
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 10⁵
// s consists only of lowercase English letters.
//
//
// Related Topics String 👍 1134 👎 52

object DeleteCharactersToMakeFancyString {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        check(solution.makeFancyString("leeetcode") == "leetcode")
        check(solution.makeFancyString("aaabaaaa") == "aabaa")
        check(solution.makeFancyString("aab") == "aab")
        println("All test cases passed!")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun makeFancyString(s: String): String {
            if (s.length <= 2) return s

            return buildString(capacity = s.length) {
                var count = 1
                for (i in s.indices) {
                    if (i > 0 && s[i] == s[i - 1]) {
                        count++
                    } else {
                        count = 1
                    }
                    if (count <= 2) {
                        append(s[i])
                    }
                }
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
