package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BestTimeToBuyAndSellStockIiTest {
    private val solution = BestTimeToBuyAndSellStockIi.Solution()

    @Test
    @DisplayName("Test with multiple buy-sell opportunities")
    fun testMultipleBuySellOpportunities() {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)
        val result = solution.maxProfit(prices)
        assertEquals(7, result, "maxProfit should return the correct maximum profit")
    }

    @Test
    @DisplayName("Test with continuously increasing prices")
    fun testContinuouslyIncreasingPrices() {
        val prices = intArrayOf(1, 2, 3, 4, 5)
        val result = solution.maxProfit(prices)
        assertEquals(4, result, "maxProfit should return the correct maximum profit")
    }

    @Test
    @DisplayName("Test with continuously decreasing prices")
    fun testContinuouslyDecreasingPrices() {
        val prices = intArrayOf(7, 6, 4, 3, 1)
        val result = solution.maxProfit(prices)
        assertEquals(0, result, "maxProfit should return the correct maximum profit")
    }

    @Test
    @DisplayName("Test edge case with empty array")
    fun testEmptyArray() {
        val result = solution.maxProfit(intArrayOf())
        assertEquals(0, result, "maxProfit should return 0 for an empty array")
    }

    @Test
    @DisplayName("Test edge case with single element array")
    fun testSingleElementArray() {
        val result = solution.maxProfit(intArrayOf(5))
        assertEquals(0, result, "maxProfit should return 0 for a single element array")
    }
}
