package leetcode.editor.en
//You are given a large integer represented as an integer array digits, where 
//each digits[i] is the iᵗʰ digit of the integer. The digits are ordered from most 
//significant to least significant in left-to-right order. The large integer does 
//not contain any leading 0's. 
//
// Increment the large integer by one and return the resulting array of digits. 
//
//
// 
// Example 1: 
//
// 
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//Incrementing by one gives 123 + 1 = 124.
//Thus, the result should be [1,2,4].
// 
//
// Example 2: 
//
// 
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
//Incrementing by one gives 4321 + 1 = 4322.
//Thus, the result should be [4,3,2,2].
// 
//
// Example 3: 
//
// 
//Input: digits = [9]
//Output: [1,0]
//Explanation: The array represents the integer 9.
//Incrementing by one gives 9 + 1 = 10.
//Thus, the result should be [1,0].
// 
//
// 
// Constraints: 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// digits does not contain any leading 0's. 
// 
//
// Related Topics Array Math 👍 10515 👎 5512

object PlusOne {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        assert(solution.plusOne(intArrayOf(1, 2, 3)).contentEquals(intArrayOf(1, 2, 4))) { "Test case 1 failed" }
        assert(solution.plusOne(intArrayOf(4, 3, 2, 1)).contentEquals(intArrayOf(4, 3, 2, 2))) { "Test case 2 failed" }
        assert(solution.plusOne(intArrayOf(9)).contentEquals(intArrayOf(1, 0))) { "Test case 3 failed" }
        println("All test cases passed!")
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun plusOne(digits: IntArray): IntArray {
            for (i in digits.size - 1 downTo 0) {
                if (digits[i] < 9) {
                    digits[i]++
                    return digits
                }
                digits[i] = 0
            }

            val result = IntArray(digits.size + 1)
            result[0] = 1
            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}