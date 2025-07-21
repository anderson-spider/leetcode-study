package leetcode.editor.en

// Given an integer array nums, rotate the array to the right by k steps, where
// k is non-negative.
//
//
// Example 1:
//
//
// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
//
//
// Example 2:
//
//
// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation:
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁵
// -2³¹ <= nums[i] <= 2³¹ - 1
// 0 <= k <= 10⁵
//
//
//
// Follow up:
//
//
// Try to come up with as many solutions as you can. There are at least three
// different ways to solve this problem.
// Could you do it in-place with O(1) extra space?
//
//
// Related Topics Array Math Two Pointers 👍 19704 👎 2116

object RotateArray {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        // Test case 1
        val nums1 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        solution.rotate(nums1, 3)
        check(nums1.contentEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4))) { "Test case 1 failed" }

        // Test case 2
        val nums2 = intArrayOf(-1, -100, 3, 99)
        solution.rotate(nums2, 2)
        check(nums2.contentEquals(intArrayOf(3, 99, -1, -100))) { "Test case 2 failed" }

        // Test case 3
        val nums3 = intArrayOf(1, 2, 3)
        solution.rotate(nums3, 3)
        check(nums3.contentEquals(intArrayOf(1, 2, 3))) { "Test case 3 failed" }

        println("All test cases passed!")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun rotate(
            nums: IntArray,
            k: Int,
        ) {
            // Reverse the entire array
            reverse(nums = nums, start = 0, end = nums.size - 1)
            // Reverse first k elements
            reverse(nums = nums, start = 0, end = k % nums.size - 1)
            // Reverse remaining elements
            reverse(nums = nums, start = k % nums.size, end = nums.size - 1)
        }

        fun reverse(
            nums: IntArray,
            start: Int,
            end: Int,
        ) {
            var left = start
            var right = end
            while (left < right) {
                val temp = nums[left]
                nums[left] = nums[right]
                nums[right] = temp
                left++
                right--
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
