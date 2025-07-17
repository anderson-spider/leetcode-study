package leetcode.editor.en

import kotlin.test.assertContentEquals
import kotlin.test.assertEquals


//Given an array of integers nums and an integer target, return indices of the
//two numbers such that they add up to target.
//
// You may assume that each input would have exactly one solution, and you may
//not use the same element twice.
//
// You can return the answer in any order.
//
//
// Example 1:
//
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//
// Example 2:
//
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//
//
// Example 3:
//
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
//
//
//
// Constraints:
//
//
// 2 <= nums.length <= 10⁴
// -10⁹ <= nums[i] <= 10⁹
// -10⁹ <= target <= 10⁹
// Only one valid answer exists.
//
//
//
//Follow-up: Can you come up with an algorithm that is less than
//O(n²)
// time complexity?
//
// Related Topics Array Hash Table 👍 62813 👎 2272

object TwoSumTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        val case1 = solution.twoSum(nums = intArrayOf(2, 7, 11, 15), target = 9)
        assertContentEquals(intArrayOf(0,1), case1)

        val case2 = solution.twoSum(nums = intArrayOf(3, 2, 4), target = 6)
        assertContentEquals(intArrayOf(1,2), case2)

        val case3 = solution.twoSum(nums = intArrayOf(3, 3), target = 6)
        assertContentEquals(intArrayOf(0,1), case3)
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun twoSum(nums: IntArray, target: Int): IntArray {
            val seen = mutableMapOf<Int, Int>()
            nums.forEachIndexed { index, num ->
                val complement = target - num
                val element = seen[complement]
                element?.let { element ->
                    return intArrayOf(element, index)
                }
                seen[num] = index
            }
            return intArrayOf()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}