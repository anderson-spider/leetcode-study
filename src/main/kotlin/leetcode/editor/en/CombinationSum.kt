package leetcode.editor.en
//Given an array of distinct integers candidates and a target integer target, 
//return a list of all unique combinations of candidates where the chosen numbers 
//sum to target. You may return the combinations in any order. 
//
// The same number may be chosen from candidates an unlimited number of times. 
//Two combinations are unique if the frequency of at least one of the chosen 
//numbers is different. 
//
// The test cases are generated such that the number of unique combinations 
//that sum up to target is less than 150 combinations for the given input. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple 
//times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
// 
//
// Example 3: 
//
// 
//Input: candidates = [2], target = 1
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// All elements of candidates are distinct. 
// 1 <= target <= 40 
// 
//
// Related Topics Array Backtracking 👍 20079 👎 485

object CombinationSum {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        assert(
            solution.combinationSum(intArrayOf(2, 3, 6, 7), 7) == listOf(
                listOf(2, 2, 3), listOf(7)
            )
        ) { "Test case 1 failed" }
        assert(
            solution.combinationSum(intArrayOf(2, 3, 5), 8) == listOf(
                listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5)
            )
        ) { "Test case 2 failed" }
        assert(solution.combinationSum(intArrayOf(2), 1) == listOf<List<Int>>()) { "Test case 3 failed" }
        println("All test cases passed!")

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            val result = mutableListOf<List<Int>>()

            fun backtrack(index: Int, currentSum: Int, currentCombination: MutableList<Int>) {
                for (i in index until candidates.size) {
                    val candidate = candidates[i]
                    val newSum = currentSum + candidate

                    if (newSum <= target) {
                        val newCombination = ArrayList(currentCombination)
                        newCombination.add(candidate)

                        if (newSum == target) {
                            result.add(newCombination)
                        } else {
                            backtrack(i, newSum, newCombination)
                        }
                    }
                }
            }

            backtrack(0, 0, mutableListOf())
            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}