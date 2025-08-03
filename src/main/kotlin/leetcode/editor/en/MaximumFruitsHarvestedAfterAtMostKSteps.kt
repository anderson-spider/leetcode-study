package leetcode.editor.en

import kotlin.math.max

// Fruits are available at some positions on an infinite x-axis. You are given a
// 2D integer array fruits where fruits[i] = [positioni, amounti] depicts amounti
// fruits at the position positioni. fruits is already sorted by positioni in
// ascending order, and each positioni is unique.
//
// You are also given an integer startPos and an integer k. Initially, you are
// at the position startPos. From any position, you can either walk to the left or
// right. It takes one step to move one unit on the x-axis, and you can walk at
// most k steps in total. For every position you reach, you harvest all the fruits at
// that position, and the fruits will disappear from that position.
//
// Return the maximum total number of fruits you can harvest.
//
//
// Example 1:
//
//
// Input: fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4
// Output: 9
// Explanation:
// The optimal way is to:
// - Move right to position 6 and harvest 3 fruits
// - Move right to position 8 and harvest 6 fruits
// You moved 3 steps and harvested 3 + 6 = 9 fruits in total.
//
//
// Example 2:
//
//
// Input: fruits = [[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]], startPos = 5, k = 4
// Output: 14
// Explanation:
// You can move at most k = 4 steps, so you cannot reach position 0 nor 10.
// The optimal way is to:
// - Harvest the 7 fruits at the starting position 5
// - Move left to position 4 and harvest 1 fruit
// - Move right to position 6 and harvest 2 fruits
// - Move right to position 7 and harvest 4 fruits
// You moved 1 + 3 = 4 steps and harvested 7 + 1 + 2 + 4 = 14 fruits in total.
//
//
// Example 3:
//
//
// Input: fruits = [[0,3],[6,4],[8,5]], startPos = 3, k = 2
// Output: 0
// Explanation:
// You can move at most k = 2 steps and cannot reach any position with fruits.
//
//
//
// Constraints:
//
//
// 1 <= fruits.length <= 10⁵
// fruits[i].length == 2
// 0 <= startPos, positioni <= 2 * 10⁵
// positioni-1 < positioni for any i > 0 (0-indexed)
// 1 <= amounti <= 10⁴
// 0 <= k <= 2 * 10⁵
//
//
// Related Topics Array Binary Search Sliding Window Prefix Sum 👍 584 👎 21

object MaximumFruitsHarvestedAfterAtMostKSteps {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        // Test case 1
        check(
            solution.maxTotalFruits(
                arrayOf(
                    intArrayOf(2, 8),
                    intArrayOf(6, 3),
                    intArrayOf(8, 6),
                ),
                5,
                4,
            ) == 9,
        )

        // Test case 2
        check(
            solution.maxTotalFruits(
                arrayOf(
                    intArrayOf(0, 9),
                    intArrayOf(4, 1),
                    intArrayOf(5, 7),
                    intArrayOf(6, 2),
                    intArrayOf(7, 4),
                    intArrayOf(10, 9),
                ),
                5,
                4,
            ) == 14,
        )

        // Test case 3
        check(
            solution.maxTotalFruits(
                arrayOf(
                    intArrayOf(0, 3),
                    intArrayOf(6, 4),
                    intArrayOf(8, 5),
                ),
                3,
                2,
            ) == 0,
        )

        println("All test cases passed!")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxTotalFruits(
            fruits: Array<IntArray?>,
            startPos: Int,
            k: Int,
        ): Int {
            val n = fruits.size
            val sum = IntArray(n + 1)
            val indices = IntArray(n)
            sum[0] = 0
            for (i in 0..<n) {
                sum[i + 1] = sum[i] + fruits[i]!![1]
                indices[i] = fruits[i]!![0]
            }
            var ans = 0
            for (x in 0..k / 2) {
                // move left x steps, then move right k - x steps.
                var y = k - 2 * x
                var left = startPos - x
                var right = startPos + y
                var start = lowerBound(indices, 0, n - 1, left)
                var end = upperBound(indices, 0, n - 1, right)
                ans = max(ans, sum[end] - sum[start])
                // move right x steps, then move left k - x steps.
                y = k - 2 * x
                left = startPos - y
                right = startPos + x
                start = lowerBound(indices, 0, n - 1, left)
                end = upperBound(indices, 0, n - 1, right)
                ans = max(ans, sum[end] - sum[start])
            }
            return ans
        }

        fun lowerBound(
            arr: IntArray,
            left: Int,
            right: Int,
            `val`: Int,
        ): Int {
            var left = left
            var right = right
            var res = right + 1
            while (left <= right) {
                val mid = left + (right - left) / 2
                if (arr[mid] >= `val`) {
                    res = mid
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            return res
        }

        fun upperBound(
            arr: IntArray,
            left: Int,
            right: Int,
            value: Int,
        ): Int {
            var left = left
            var right = right
            var res = right + 1
            while (left <= right) {
                val mid = left + (right - left) / 2
                if (arr[mid] > value) {
                    res = mid
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            return res
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
