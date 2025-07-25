package leetcode.editor.en
// Given a string s consisting of words and spaces, return the length of the
// last word in the string.
//
// A word is a maximal substring consisting of non-space characters only.
//
//
// Example 1:
//
//
// Input: s = "Hello World"
// Output: 5
// Explanation: The last word is "World" with length 5.
//
//
// Example 2:
//
//
// Input: s = "   fly me   to   the moon  "
// Output: 4
// Explanation: The last word is "moon" with length 4.
//
//
// Example 3:
//
//
// Input: s = "luffy is still joyboy"
// Output: 6
// Explanation: The last word is "joyboy" with length 6.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 10⁴
// s consists of only English letters and spaces ' '.
// There will be at least one word in s.
//
//
// Related Topics String 👍 5861 👎 331

object LengthOfLastWord {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        println(solution.lengthOfLastWord("Hello World"))
        println(solution.lengthOfLastWord("   fly me   to   the moon  "))
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun lengthOfLastWord(s: String): Int {
            // Initialize variables to track word length and if we've found a word
            var size = 0
            var found = false

            // Iterate from end to start of string
            for (i in s.length - 1 downTo 0) {
                if (s[i] != ' ') {
                    // Found a letter, increment size
                    found = true
                    size++
                } else if (found) {
                    // Found a space after word, break since we have the last word
                    break
                }
            }

            return size
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
