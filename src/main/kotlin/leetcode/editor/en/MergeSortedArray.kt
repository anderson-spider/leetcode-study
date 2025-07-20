package leetcode.editor.en
//You are given two integer arrays nums1 and nums2, sorted in non-decreasing 
//order, and two integers m and n, representing the number of elements in nums1 and 
//nums2 respectively. 
//
// Merge nums1 and nums2 into a single array sorted in non-decreasing order. 
//
// The final sorted array should not be returned by the function, but instead 
//be stored inside the array nums1. To accommodate this, nums1 has a length of m + 
//n, where the first m elements denote the elements that should be merged, and the 
//last n elements are set to 0 and should be ignored. nums2 has a length of n. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming 
//from nums1.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//Explanation: The arrays we are merging are [1] and [].
//The result of the merge is [1].
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//Output: [1]
//Explanation: The arrays we are merging are [] and [1].
//The result of the merge is [1].
//Note that because m = 0, there are no elements in nums1. The 0 is only there 
//to ensure the merge result can fit in nums1.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -10⁹ <= nums1[i], nums2[j] <= 10⁹ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(m + n) time? 
//
// Related Topics Array Two Pointers Sorting 👍 17320 👎 2413

object MergeSortedArray {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        // Test case 1: Basic merge
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        solution.merge(nums1, 3, intArrayOf(2, 5, 6), 3)
        assert(nums1.contentEquals(intArrayOf(1, 2, 2, 3, 5, 6))) { "Test case 1 failed" }

        // Test case 2: Single element array
        val nums2 = intArrayOf(1)
        solution.merge(nums2, 1, intArrayOf(), 0)
        assert(nums2.contentEquals(intArrayOf(1))) { "Test case 2 failed" }

        // Test case 3: Empty first array
        val nums3 = intArrayOf(0)
        solution.merge(nums3, 0, intArrayOf(1), 1)
        assert(nums3.contentEquals(intArrayOf(1))) { "Test case 3 failed" }

        println("All test cases passed!")
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
            var p1 = m - 1
            var p2 = n - 1
            var p = m + n - 1

            while (p2 >= 0) {
                if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                    nums1[p] = nums1[p1]
                    p1--
                } else {
                    nums1[p] = nums2[p2]
                    p2--
                }
                p--
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}