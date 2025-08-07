package leetcode.editor.en
// Given an array nums of size n, return the majority element.
//
// The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.
//
//
// Example 1:
// Input: nums = [3,2,3]
// Output: 3
//
// Example 2:
// Input: nums = [2,2,1,1,1,2,2]
// Output: 2
//
//
// Constraints:
//
//
// n == nums.length
// 1 <= n <= 5 * 10⁴
// -10⁹ <= nums[i] <= 10⁹
//
//
//
// Follow-up: Could you solve the problem in linear time and in
// O(1) space?
//
// Related Topics Array Hash Table Divide and Conquer Sorting Counting 👍 21273
// 👎 744

object MajorityElement {
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun majorityElement(nums: IntArray): Int {
            var count = 0
            var candidate = 0
            for (i in nums.indices) {
                if (count == 0) {
                    candidate = nums[i]
                }
                count += if (nums[i] == candidate) 1 else -1
            }
            return candidate
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
