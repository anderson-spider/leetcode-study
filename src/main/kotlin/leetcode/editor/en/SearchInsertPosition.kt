package leetcode.editor.en
// Given a sorted array of distinct integers and a target value, return the
// index if the target is found. If not, return the index where it would be if it were
// inserted in order.
//
// You must write an algorithm with O(log n) runtime complexity.
//
//
// Example 1:
//
//
// Input: nums = [1,3,5,6], target = 5
// Output: 2
//
//
// Example 2:
//
//
// Input: nums = [1,3,5,6], target = 2
// Output: 1
//
//
// Example 3:
//
//
// Input: nums = [1,3,5,6], target = 7
// Output: 4
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums contains distinct values sorted in ascending order.
// -10⁴ <= target <= 10⁴
//
//
// Related Topics Array Binary Search 👍 17649 👎 837

object SearchInsertPosition {
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun searchInsert(
            nums: IntArray,
            target: Int,
        ): Int {
            var left = 0
            var right = nums.size - 1

            while (left <= right) {
                val mid = left + (right - left) / 2
                when {
                    nums[mid] == target -> return mid
                    nums[mid] < target -> left = mid + 1
                    else -> right = mid - 1
                }
            }
            return left
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
