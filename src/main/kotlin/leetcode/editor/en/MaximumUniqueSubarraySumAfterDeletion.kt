package leetcode.editor.en
// You are given an integer array nums.
//
// You are allowed to delete any number of elements from nums without making it
// empty. After performing the deletions, select a subarray of nums such that:
//
//
// All elements in the subarray are unique.
// The sum of the elements in the subarray is maximized.
//
//
// Return the maximum sum of such a subarray.
//
//
// Example 1:
//
//
// Input: nums = [1,2,3,4,5]
//
//
// Output: 15
//
// Explanation:
//
// Select the entire array without deleting any element to obtain the maximum
// sum.
//
// Example 2:
//
//
// Input: nums = [1,1,0,1,1]
//
//
// Output: 1
//
// Explanation:
//
// Delete the element nums[0] == 1, nums[1] == 1, nums[2] == 0, and nums[3] == 1
// . Select the entire array [1] to obtain the maximum sum.
//
// Example 3:
//
//
// Input: nums = [1,2,-1,-2,1,0,-1]
//
//
// Output: 3
//
// Explanation:
//
// Delete the elements nums[2] == -1 and nums[3] == -2, and select the subarray
// [2, 1] from [1, 2, 1, 0, -1] to obtain the maximum sum.
//
//
// Constraints:
//
//
// 1 <= nums.length <= 100
// -100 <= nums[i] <= 100
//
//
// Related Topics Array Hash Table Greedy 👍 300 👎 44

object MaximumUniqueSubarraySumAfterDeletion {
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Finds the maximum sum of a subarray with unique elements after performing deletions.
         *
         * Approach:
         * 1. We want to maximize the sum, so we should include only positive unique numbers
         * 2. If there are no positive numbers (or their sum is not positive), we return the maximum value
         *    in the array as the best possible result
         *
         * @param nums The input array of integers
         * @return The maximum possible sum of a subarray with unique elements
         */
        fun maxSum(nums: IntArray): Int {
            // Track which numbers we've already seen (constraint: -100 <= nums[i] <= 100)
            val exists = BooleanArray(101)

            // Running sum of unique positive numbers
            var sum = 0

            // Track the maximum value in the array (initialized to minimum possible value)
            var max = -100

            for (num in nums) {
                // Update the maximum value seen so far
                max = maxOf(max, num)

                // Only include positive numbers that haven't been seen before
                // This ensures we maximize our sum with unique elements
                if (num > 0 && !exists[num]) {
                    exists[num] = true
                    sum += num
                }
            }

            // If we have a positive sum, return it
            // Otherwise, return the maximum value (best we can do with negative/zero numbers)
            return if (sum > 0) sum else max
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
