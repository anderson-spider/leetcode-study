package leetcode.editor.en

// Given an unsorted array of integers nums, return the length of the longest
// consecutive elements sequence.
//
// You must write an algorithm that runs in O(n) time.
//
//
// Example 1:
//
//
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
// Therefore its length is 4.
//
//
// Example 2:
//
//
// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9
//
//
// Example 3:
//
//
// Input: nums = [1,0,1,2]
// Output: 3
//
//
//
// Constraints:
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
//
//
// Related Topics Array Hash Table Union Find 👍 21771 👎 1179

object LongestConsecutiveSequence {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        println(solution.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
        println(solution.longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestConsecutive(nums: IntArray): Int {
            val distinctNumbers = nums.toHashSet()
            var longestSequence = 0

            for (num in distinctNumbers) {
                if (!distinctNumbers.contains(num - 1)) {
                    longestSequence = calculateSequenceLength(num, distinctNumbers, longestSequence)
                }
            }

            return longestSequence
        }

        private fun calculateSequenceLength(
            num: Int,
            distinctNumbers: HashSet<Int>,
            longestSequence: Int,
        ): Int {
            var currentNum = num
            var currentLength = 1

            while (distinctNumbers.contains(currentNum + 1)) {
                currentNum++
                currentLength++
            }

            return maxOf(longestSequence, currentLength)
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
