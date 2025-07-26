package leetcode.editor.en

// Given an array of positive integers nums and a positive integer target,
// return the minimal length of a subarray whose sum is greater than or equal to target.
// If there is no such subarray, return 0 instead.
//
//
// Example 1:
//
//
// Input: target = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: The subarray [4,3] has the minimal length under the problem
// constraint.
//
//
// Example 2:
//
//
// Input: target = 4, nums = [1,4,4]
// Output: 1
//
//
// Example 3:
//
//
// Input: target = 11, nums = [1,1,1,1,1,1,1,1]
// Output: 0
//
//
//
// Constraints:
//
//
// 1 <= target <= 10⁹
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁴
//
//
//
// Follow up: If you have figured out the
// O(n) solution, try coding another solution of which the time complexity is
// O(n log(n)).
//
// Related Topics Array Binary Search Sliding Window Prefix Sum 👍 13610 👎 506

object MinimumSizeSubarraySum {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        check(solution.minSubArrayLen(target = 7, nums = intArrayOf(2, 3, 1, 2, 4, 3)) == 2) {}
        check(solution.minSubArrayLen(target = 4, nums = intArrayOf(1, 4, 4)) == 1) {}
        check(solution.minSubArrayLen(target = 11, nums = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)) == 0) {}
        check(solution.minSubArrayLen(target = 15, nums = intArrayOf(1, 2, 3, 4, 5)) == 5) {}
        check(solution.minSubArrayLen(target = 11, nums = intArrayOf(1, 2, 3, 4, 5)) == 3) {}
        check(solution.minSubArrayLen(target = 15, nums = intArrayOf(5, 1, 3, 5, 10, 7, 4, 9, 2, 8)) == 5) {}

// Output: 0
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minSubArrayLen(
            target: Int,
            nums: IntArray,
        ): Int {
            // Initialize variables for sliding window
            var l = 0
            var sum = 0
            var min = nums.size + 1
            for (r in nums.indices) {
                // If we find a single number equal to target, return 1
                if (nums[r] == target) {
                    min = 1
                    break
                }
                // Add current number to running sum
                sum += nums[r]
                // Shrink window from left while sum >= target
                while (l < nums.size && sum >= target) {
                    min = minOf(min, r - l + 1)
                    sum -= nums[l++]
                }
            }
            // Return 0 if no subarray found, otherwise return min length
            return if (min > nums.size) 0 else min
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
