package leetcode.editor.en

// Write a function to find the longest common prefix string amongst an array of
// strings.
//
// If there is no common prefix, return an empty string "".
//
//
// Example 1:
//
//
// Input: strs = ["flower","flow","flight"]
// Output: "fl"
//
//
// Example 2:
//
//
// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
//
//
//
// Constraints:
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lowercase English letters if it is non-empty.
//
//
// Related Topics Array String Trie 👍 19497 👎 4764

object LongestCommonPrefix {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        check("fl" == solution.longestCommonPrefix(arrayOf("flower", "flow", "flight")))
        check("" == solution.longestCommonPrefix(arrayOf("dog", "racecar", "car")))
        check("" == solution.longestCommonPrefix(arrayOf()))
        check("a" == solution.longestCommonPrefix(arrayOf("a")))
        check("c" == solution.longestCommonPrefix(arrayOf("c", "c")))
        println("All test cases passed!")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestCommonPrefix(strs: Array<String>): String {
            if (strs.isEmpty()) return ""
            if (strs.size == 1) return strs[0]

            var prefix = strs[0]
            for (i in 1 until strs.size) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length - 1)
                    if (prefix.isEmpty()) return ""
                }
            }
            return prefix
        }
    }

// leetcode submit region end(Prohibit modification and deletion)
}
