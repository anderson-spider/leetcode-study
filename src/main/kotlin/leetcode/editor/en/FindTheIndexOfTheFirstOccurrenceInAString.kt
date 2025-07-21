package leetcode.editor.en
// Given two strings needle and haystack, return the index of the first
// occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//
// Example 1:
//
//
// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.
//
//
// Example 2:
//
//
// Input: haystack = "leetcode", needle = "leeto"
// Output: -1
// Explanation: "leeto" did not occur in "leetcode", so we return -1.
//
//
//
// Constraints:
//
//
// 1 <= haystack.length, needle.length <= 10⁴
// haystack and needle consist of only lowercase English characters.
//
//
// Related Topics Two Pointers String String Matching 👍 6858 👎 511

object FindTheIndexOfTheFirstOccurrenceInAString {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        // Test case 1: Normal case with match at beginning
        check(solution.strStr("sadbutsad", "sad") == 0) { "Test case 1 failed" }

        // Test case 2: No match
        check(solution.strStr("leetcode", "leeto") == -1) { "Test case 2 failed" }

        // Test case 3: Match at end
        check(solution.strStr("hello", "lo") == 3) { "Test case 3 failed" }

        // Test case 4: Single character match
        check(solution.strStr("aaaaa", "a") == 0) { "Test case 4 failed" }

        // Test case 5: Needle longer than haystack
        check(solution.strStr("abc", "abcd") == -1) { "Test case 5 failed" }

        println("All test cases passed!")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun strStr(
            haystack: String,
            needle: String,
        ): Int {
            if (needle.isEmpty()) return 0

            val n = haystack.length
            val m = needle.length

            for (i in 0..n - m) {
                var match = true
                for (j in needle.indices) {
                    if (haystack[i + j] != needle[j]) {
                        match = false
                        break
                    }
                }
                if (match) return i
            }

            return -1
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
