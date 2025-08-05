package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOfProvincesTest {
    private val solution = NumberOfProvinces.Solution()

    @Test
    @DisplayName("Test with two provinces")
    fun testTwoProvinces() {
        val isConnected =
            arrayOf(
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 0, 1),
            )
        val result = solution.findCircleNum(isConnected)
        assertEquals(2, result, "findCircleNum should return the correct number of provinces")
    }

    @Test
    @DisplayName("Test with three provinces (all cities isolated)")
    fun testThreeProvincesAllCitiesIsolated() {
        val isConnected =
            arrayOf(
                intArrayOf(1, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 1),
            )
        val result = solution.findCircleNum(isConnected)
        assertEquals(3, result, "findCircleNum should return the correct number of provinces")
    }

    @Test
    @DisplayName("Test with single city")
    fun testSingleCity() {
        val isConnected = arrayOf(intArrayOf(1))
        val result = solution.findCircleNum(isConnected)
        assertEquals(1, result, "A single city should form one province")
    }

    @Test
    @DisplayName("Test with all cities connected")
    fun testAllCitiesConnected() {
        val isConnected =
            arrayOf(
                intArrayOf(1, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
            )
        val result = solution.findCircleNum(isConnected)
        assertEquals(1, result, "All connected cities should form one province")
    }

    @Test
    @DisplayName("Test with larger graph and multiple provinces")
    fun testLargerGraphMultipleProvinces() {
        val isConnected =
            arrayOf(
                intArrayOf(1, 1, 0, 0, 0),
                intArrayOf(1, 1, 0, 0, 0),
                intArrayOf(0, 0, 1, 1, 1),
                intArrayOf(0, 0, 1, 1, 0),
                intArrayOf(0, 0, 1, 0, 1),
            )
        val result = solution.findCircleNum(isConnected)
        assertEquals(2, result, "Larger graph should correctly identify multiple provinces")
    }

    @Test
    @DisplayName("Test with chain-like connections")
    fun testChainConnections() {
        val isConnected =
            arrayOf(
                intArrayOf(1, 1, 0, 0),
                intArrayOf(1, 1, 1, 0),
                intArrayOf(0, 1, 1, 1),
                intArrayOf(0, 0, 1, 1),
            )
        val result = solution.findCircleNum(isConnected)
        assertEquals(1, result, "Chain-like connections should form one province")
    }

    @Test
    @DisplayName("Test with disconnected pairs")
    fun testDisconnectedPairs() {
        val isConnected =
            arrayOf(
                intArrayOf(1, 1, 0, 0),
                intArrayOf(1, 1, 0, 0),
                intArrayOf(0, 0, 1, 1),
                intArrayOf(0, 0, 1, 1),
            )
        val result = solution.findCircleNum(isConnected)
        assertEquals(2, result, "Disconnected pairs should form two provinces")
    }
}
