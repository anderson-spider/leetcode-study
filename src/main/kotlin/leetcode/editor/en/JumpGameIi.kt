package leetcode.editor.en
// You are given a 0-indexed array of integers nums of length n. You are
// initially positioned at nums[0].
//
// Each element nums[i] represents the maximum length of a forward jump from
// index i. In other words, if you are at nums[i], you can jump to any nums[i + j]
// where:
//
//
// 0 <= j <= nums[i] and
// i + j < n
//
//
// Return the minimum number of jumps to reach nums[n - 1]. The test cases are
// generated such that you can reach nums[n - 1].
//
//
// Example 1:
//
//
// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
// step from index 0 to 1, then 3 steps to the last index.
//
//
// Example 2:
//
//
// Input: nums = [2,3,0,1,4]
// Output: 2
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁴
// 0 <= nums[i] <= 1000
// It's guaranteed that you can reach nums[n - 1].
//
//
// Related Topics Array Dynamic Programming Greedy 👍 15707 👎 668

object JumpGameIi {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        check(solution.jump(intArrayOf(2, 3, 1, 1, 4)) == 2)
        check(solution.jump(intArrayOf(2, 3, 0, 1, 4)) == 2)
        println("All test cases passed!")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun jump(nums: IntArray): Int {
            var end = 0
            var maxPos = 0
            var steps = 0
            for (i in 0 until nums.size - 1) {
                maxPos = kotlin.math.max(maxPos, i + nums[i])
                if (i == end) {
                    end = maxPos
                    steps++
                }
            }
            return steps
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
