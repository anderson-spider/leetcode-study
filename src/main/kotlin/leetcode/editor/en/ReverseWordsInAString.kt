package leetcode.editor.en

// Given an input string s, reverse the order of the words.
//
// A word is defined as a sequence of non-space characters. The words in s will
// be separated by at least one space.
//
// Return a string of the words in reverse order concatenated by a single space.
//
//
// Note that s may contain leading or trailing spaces or multiple spaces
// between two words. The returned string should only have a single space separating the
// words. Do not include any extra spaces.
//
//
// Example 1:
//
//
// Input: s = "the sky is blue"
// Output: "blue is sky the"
//
//
// Example 2:
//
//
// Input: s = "  hello world  "
// Output: "world hello"
// Explanation: Your reversed string should not contain leading or trailing
// spaces.
//
//
// Example 3:
//
//
// Input: s = "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single
// space in the reversed string.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 10⁴
// s contains English letters (upper-case and lower-case), digits, and spaces '
// '.
// There is at least one word in s.
//
//
//
// Follow-up: If the string data type is mutable in your language, can you
// solve it in-place with O(1) extra space?
//
// Related Topics Two Pointers String 👍 9634 👎 5403

object ReverseWordsInAString {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
//        // Test case 1: Basic string reversal
//        val case1 = solution.reverseWords("the sky is blue")
//        check(case1 == "blue is sky the") { "Test case 1 failed: Expected 'blue is sky the' but got '$case1'" }

        // Test case 2: Leading/trailing spaces
        val case2 = solution.reverseWords("  hello world  ")
        check(case2 == "world hello") { "Test case 2 failed: Expected 'world hello' but got '$case2'" }

//        // Test case 3: Multiple spaces between words
//        val case3 = solution.reverseWords("a good   example")
//        check(case3 == "example good a") { "Test case 3 failed: Expected 'example good a' but got '$case3'" }
//
//        // Test case 4: Single word
//        val case4 = solution.reverseWords("hello")
//        check(case4 == "hello") { "Test case 4 failed: Expected 'hello' but got '$case4'" }
//
//        println("All test cases passed!")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reverseWords(s: String): String {
            val result = StringBuilder()
            var i = s.length - 1

            while (i >= 0) {
                while (i >= 0 && s[i] == ' ') {
                    i--
                }

                if (i < 0) {
                    break
                }
                val end = i

                while (i >= 0 && s[i] != ' ') {
                    i--
                }

                if (result.isNotEmpty()) {
                    result.append(' ')
                }
                result.append(s.substring(i + 1, end + 1))
            }

            return result.toString()
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
