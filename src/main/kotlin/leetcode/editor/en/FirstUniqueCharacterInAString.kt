package leetcode.editor.en
// Given a string s, find the first non-repeating character in it and return its
// index. If it does not exist, return -1.
//
//
// Example 1:
//
//
// Input: s = "leetcode"
//
//
// Output: 0
//
// Explanation:
//
// The character 'l' at index 0 is the first character that does not occur at
// any other index.
//
// Example 2:
//
//
// Input: s = "loveleetcode"
//
//
// Output: 2
//
// Example 3:
//
//
// Input: s = "aabb"
//
//
// Output: -1
//
//
// Constraints:
//
//
// 1 <= s.length <= 10⁵
// s consists of only lowercase English letters.
//
//
// Related Topics Hash Table String Queue Counting 👍 9372 👎 314

object FirstUniqueCharacterInAString {
    // leetcode submit region begin(Prohibit modification and deletion)
    const val NUM_CHARS = 26

    class Solution {
        fun firstUniqChar(s: String): Int {
            val counts = calcCounts(s)
            var c: Char
            for (i in s.indices) {
                c = s[i]
                if (counts[c - 'a'] == 1) return i
            }
            return -1
        }

        private fun calcCounts(s: String): IntArray {
            val output = IntArray(NUM_CHARS)
            for (c in s) {
                val i = c - 'a'
                output[i] += 1
            }
            return output
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
