package leetcode.editor.en
// You are given an array of positive integers nums and want to erase a subarray
// containing unique elements. The score you get by erasing the subarray is equal
// to the sum of its elements.
//
// Return the maximum score you can get by erasing exactly one subarray.
//
// An array b is called to be a subarray of a if it forms a contiguous
// subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
//
//
// Example 1:
//
//
// Input: nums = [4,2,4,5,6]
// Output: 17
// Explanation: The optimal subarray here is [2,4,5,6].
//
//
// Example 2:
//
//
// Input: nums = [5,2,1,2,5,2,1,2,5]
// Output: 8
// Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁴
//
//
// Related Topics Array Hash Table Sliding Window 👍 3274 👎 61

object MaximumErasureValue {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        val result = solution.maximumUniqueSubarray(intArrayOf(4, 2, 4, 5, 6))
        check(result == 17) { "result:$result should be 17" }
        val result2 = solution.maximumUniqueSubarray(intArrayOf(5, 2, 1, 2, 5, 2, 1, 2, 5))
        check(result2 == 8) { "result:$result2 should be 8" }
        val result3 = solution.maximumUniqueSubarray(intArrayOf(1, 2, 3, 4, 5))
        check(result3 == 15) { "result:$result3 should be 15" }
        val result5 = solution.maximumUniqueSubarray(intArrayOf(1, 1, 1, 1, 1))
        check(result5 == 1) { "result:$result5 should be 1" }
        val result6 = solution.maximumUniqueSubarray(intArrayOf(10, 2, 5, 9))
        check(result6 == 26) { "result:$result6 should be 17" }
        println("All test cases passed!")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maximumUniqueSubarray(nums: IntArray): Int {
            val lastIndex = IntArray(10001) { -1 }
            val sum = IntArray(nums.size + 1)
            var max = 0
            var l = 0

            for (r in 0 until nums.size) {
                val x = nums[r]

                // update prefix sum
                sum[r + 1] = sum[r] + x

                // move the left pointer
                l = maxOf(l, lastIndex[x] + 1)

                // update max if needed
                max = maxOf(max, sum[r + 1] - sum[l])

                // update the last seen index
                lastIndex[x] = r
            }

            return max
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
