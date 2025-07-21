package leetcode.editor.en

//You are given an integer array nums. You are initially positioned at the
//array's first index, and each element in the array represents your maximum jump 
//length at that position. 
//
// Return true if you can reach the last index, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum 
//jump length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics Array Dynamic Programming Greedy 👍 20777 👎 1403

object JumpGame {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        // Test case 1: Can reach end
        assert(solution.canJump(intArrayOf(2, 3, 1, 1, 4))) { "Test case 1 failed" }
        // Test case 2: Cannot reach end
        assert(!solution.canJump(intArrayOf(3, 2, 1, 0, 4))) { "Test case 2 failed" }
        // Test case 3: Single element
        assert(solution.canJump(intArrayOf(0))) { "Test case 3 failed" }
        // Test case 4: All zeros except first
        assert(!solution.canJump(intArrayOf(1, 0, 0, 0))) { "Test case 4 failed" }
        // Test case 5: Exact jumps needed
        assert(solution.canJump(intArrayOf(1, 1, 1, 1))) { "Test case 5 failed" }
        println("All test cases passed!")
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun canJump(nums: IntArray): Boolean {
            if (nums.isEmpty()) return false
            if (nums.size == 1) return true
            if (nums[0] == 0) return false
            if (nums[0] >= nums.size - 1) return true

            var maxPos = 0
            for (i in 0 until  nums.size) {
                if (i > maxPos)
                    return false
                maxPos = kotlin.math.max(maxPos, i + nums[i])
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}