package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BestTimeToBuyAndSellStockTest {
    private val solution = BestTimeToBuyAndSellStock.Solution()

    @Test
    @DisplayName("Test with profit possible")
    fun testProfitPossible() {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)
        val result = solution.maxProfit(prices)
        assertEquals(5, result, "maxProfit should return the correct maximum profit")
    }

    @Test
    @DisplayName("Test with no profit possible")
    fun testNoProfitPossible() {
        val prices = intArrayOf(7, 6, 4, 3, 1)
        val result = solution.maxProfit(prices)
        assertEquals(0, result, "maxProfit should return 0 when no profit is possible")
    }

    @Test
    @DisplayName("Test with single element array")
    fun testSingleElementArray() {
        val prices = intArrayOf(5)
        val result = solution.maxProfit(prices)
        assertEquals(0, result, "maxProfit should return 0 for a single element array")
    }

    @Test
    @DisplayName("Test with two elements in ascending order")
    fun testTwoElementsAscending() {
        val prices = intArrayOf(1, 2)
        val result = solution.maxProfit(prices)
        assertEquals(1, result, "maxProfit should return the correct profit for two elements in ascending order")
    }

    @Test
    @DisplayName("Test with two elements in descending order")
    fun testTwoElementsDescending() {
        val prices = intArrayOf(2, 1)
        val result = solution.maxProfit(prices)
        assertEquals(0, result, "maxProfit should return 0 for two elements in descending order")
    }

    @Test
    @DisplayName("Test with flat prices")
    fun testFlatPrices() {
        val prices = intArrayOf(3, 3, 3, 3)
        val result = solution.maxProfit(prices)
        assertEquals(0, result, "maxProfit should return 0 for flat prices")
    }

    @Test
    @DisplayName("Test with profit at the end")
    fun testProfitAtEnd() {
        val prices = intArrayOf(3, 2, 1, 5)
        val result = solution.maxProfit(prices)
        assertEquals(4, result, "maxProfit should find profit when it's at the end")
    }

    @Test
    @DisplayName("Test with profit at the beginning")
    fun testProfitAtBeginning() {
        val prices = intArrayOf(1, 5, 2, 3)
        val result = solution.maxProfit(prices)
        assertEquals(4, result, "maxProfit should find profit when it's at the beginning")
    }

    @Test
    @DisplayName("Test with larger array")
    fun testLargerArray() {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4, 8, 2, 9, 0, 3)
        val result = solution.maxProfit(prices)
        assertEquals(8, result, "maxProfit should find the maximum profit in a larger array")
    }
}
