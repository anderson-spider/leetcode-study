package leetcode.editor.en
// Given an integer array nums and an integer k, return true if there are two
// distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <
// = k.
//
//
// Example 1:
//
//
// Input: nums = [1,2,3,1], k = 3
// Output: true
//
//
// Example 2:
//
//
// Input: nums = [1,0,1,1], k = 1
// Output: true
//
//
// Example 3:
//
//
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// 0 <= k <= 10⁵
//
//
// Related Topics Array Hash Table Sliding Window 👍 6870 👎 3242

object ContainsDuplicateIi {
    @JvmStatic
    fun main(args: Array<String>) {
        fun check(
            nums: IntArray,
            k: Int,
            expected: Boolean,
        ) {
            val solution = Solution()
            val result = solution.containsNearbyDuplicate(nums, k)
            println("Input: nums = ${nums.contentToString()}, k = $k")
            println("Expected: $expected, Actual: $result")
            println("Test ${if (result == expected) "PASSED" else "FAILED"}\n")
        }

        check(intArrayOf(1, 2, 3, 1), 3, true)
        check(intArrayOf(1, 0, 1, 1), 1, true)
        check(intArrayOf(1, 2, 3, 1, 2, 3), 2, false)
        check(intArrayOf(1), 1, false)
        check(intArrayOf(1, 1, 1, 1), 1, true)
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun containsNearbyDuplicate(
            nums: IntArray,
            k: Int,
        ): Boolean {
            val map: MutableMap<Int, Int> = HashMap()
            var i = 0
            while (i < nums.size) {
                val j = map[nums[i]]
                
                if(j != null && i -j <= k) 
                    return true
                
                map[nums[i]] = i
                i++
            }
            return false
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
