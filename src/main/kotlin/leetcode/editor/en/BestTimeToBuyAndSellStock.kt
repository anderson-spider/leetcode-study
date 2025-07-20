package leetcode.editor.en
//You are given an array prices where prices[i] is the price of a given stock 
//on the iᵗʰ day. 
//
// You want to maximize your profit by choosing a single day to buy one stock 
//and choosing a different day in the future to sell that stock. 
//
// Return the maximum profit you can achieve from this transaction. If you 
//cannot achieve any profit, return 0. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you 
//must buy before you sell.
// 
//
// Example 2: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁴ 
// 
//
// Related Topics Array Dynamic Programming 👍 33636 👎 1304

object BestTimeToBuyAndSellStock {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        // Test case 1: Basic case with profit
        val prices1 = intArrayOf(7, 1, 5, 3, 6, 4)
        println("Test case 1: ${solution.maxProfit(prices1)} (Expected: 5)")

        // Test case 2: No profit possible
        val prices2 = intArrayOf(7, 6, 4, 3, 1)
        println("Test case 2: ${solution.maxProfit(prices2)} (Expected: 0)")

        // Test case 3: Single element
        val prices3 = intArrayOf(1)
        println("Test case 3: ${solution.maxProfit(prices3)} (Expected: 0)")

        // Test case 4: Two elements with profit
        val prices4 = intArrayOf(1, 2)
        println("Test case 4: ${solution.maxProfit(prices4)} (Expected: 1)")
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxProfit(prices: IntArray): Int {
            var minPrice = Int.MAX_VALUE
            var maxProfit = 0

            prices.forEach { price ->
                if (price < minPrice) {
                    minPrice = price
                } else {
                    maxProfit = maxOf(maxProfit, price - minPrice)
                }
            }

            return maxProfit
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}