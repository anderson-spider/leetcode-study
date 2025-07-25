package leetcode.editor.en

// Given an integer array nums and an integer val, remove all occurrences of val
// in nums in-place. The order of the elements may be changed. Then return the
// number of elements in nums which are not equal to val.
//
// Consider the number of elements in nums which are not equal to val be k, to
// get accepted, you need to do the following things:
//
//
// Change the array nums such that the first k elements of nums contain the
// elements which are not equal to val. The remaining elements of nums are not
// important as well as the size of nums.
// Return k.
//
//
// Custom Judge:
//
// The judge will test your solution with the following code:
//
//
// int[] nums = [...]; // Input array
// int val = ...; // Value to remove
// int[] expectedNums = [...]; // The expected answer with correct length.
//                            // It is sorted with no values equaling val.
//
// int k = removeElement(nums, val); // Calls your implementation
//
// assert k == expectedNums.length;
// sort(nums, 0, k); // Sort the first k elements of nums
// for (int i = 0; i < actualLength; i++) {
//    assert nums[i] == expectedNums[i];
// }
//
//
// If all assertions pass, then your solution will be accepted.
//
//
// Example 1:
//
//
// Input: nums = [3,2,2,3], val = 3
// Output: 2, nums = [2,2,_,_]
// Explanation: Your function should return k = 2, with the first two elements
// of nums being 2.
// It does not matter what you leave beyond the returned k (hence they are
// underscores).
//
//
// Example 2:
//
//
// Input: nums = [0,1,2,2,3,0,4,2], val = 2
// Output: 5, nums = [0,1,4,0,3,_,_,_]
// Explanation: Your function should return k = 5, with the first five elements
// of nums containing 0, 0, 1, 3, and 4.
// Note that the five elements can be returned in any order.
// It does not matter what you leave beyond the returned k (hence they are
// underscores).
//
//
//
// Constraints:
//
//
// 0 <= nums.length <= 100
// 0 <= nums[i] <= 50
// 0 <= val <= 100
//
//
// Related Topics Array Two Pointers 👍 4032 👎 4899

object RemoveElement {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        // Test case 1: Basic case
        val nums1 = intArrayOf(3, 2, 2, 3)
        check(solution.removeElement(nums1, 3) == 2) { "Test case 1 failed: wrong length" }
        check(nums1.slice(0..1).toList() == listOf(2, 2)) { "Test case 1 failed: wrong elements" }

        // Test case 2: Multiple occurrences
        val nums2 = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        check(solution.removeElement(nums2, 2) == 5) { "Test case 2 failed: wrong length" }
        check(nums2.slice(0..4).toList() == listOf(0, 1, 3, 0, 4)) { "Test case 2 failed: wrong elements" }

        // Test case 3: Empty array
        val nums3 = intArrayOf()
        check(solution.removeElement(nums3, 1) == 0) { "Test case 3 failed: wrong length" }

        // Test case 4: No matches
        val nums4 = intArrayOf(1, 2, 3, 4)
        check(solution.removeElement(nums4, 5) == 4) { "Test case 4 failed: wrong length" }
        check(nums4.toList() == listOf(1, 2, 3, 4)) { "Test case 4 failed: wrong elements" }

        println("All test cases passed!")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun removeElement(
            nums: IntArray,
            `val`: Int,
        ): Int {
            var k = 0
            for (i in nums.indices) {
                if (nums[i] != `val`) {
                    nums[k] = nums[i]
                    k++
                }
            }
            return k
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
