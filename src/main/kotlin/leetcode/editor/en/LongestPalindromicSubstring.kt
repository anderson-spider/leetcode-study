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
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestPalindrome(source: String): String {
            val word = createPalindromeStructure(source) // (#b#a#b#a#d#)
            val radiusArray = computePalindromeRadius(word)
            val longestString = extractLongestString(radiusArray, word)
            return longestString
        }

        private fun computePalindromeRadius(word: StringBuilder): IntArray {
            val radiusArray = IntArray(word.length)
            var center = 0
            var rightLimit = 0

            for (i in 1 until word.length - 1) {
                val mirror = center * 2 - i
                if (i < rightLimit) {
                    radiusArray[i] = (rightLimit - i).coerceAtMost(maximumValue = radiusArray[mirror])
                }

                expandAroundCenter(word, i, radiusArray)

                if (i + radiusArray[i] > rightLimit) {
                    center = i
                    rightLimit = i + radiusArray[i]
                }
            }
            return radiusArray
        }

        private fun expandAroundCenter(
            word: StringBuilder,
            i: Int,
            radiusArray: IntArray,
        ) {
            while (word[i - 1 - radiusArray[i]] == word[i + 1 + radiusArray[i]]) {
                radiusArray[i]++
            }
        }

        private fun createPalindromeStructure(word: String): StringBuilder =
            StringBuilder(word.length * 2 + 1).apply {
                append("(")
                append("#")
                word.forEach { append(it).append("#") }
                append(")")
            }

        private fun extractLongestString(
            lcp: IntArray,
            word: StringBuilder,
        ): String {
            val maxIndex = findHighestValueIndex(lcp)
            val maxLen = lcp[maxIndex]
            return word.substring(maxIndex - maxLen, maxIndex + maxLen).replace("#", "")
        }

        private fun findHighestValueIndex(array: IntArray): Int {
            var maxValue = 0
            var maxIndex = 0
            for (i in 1 until array.size) {
                if (array[i] > maxValue) {
                    maxValue = array[i]
                    maxIndex = i
                }
            }
            return maxIndex
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
