package leetcode.editor.en

import kotlin.test.Test
import kotlin.test.assertEquals

class NetworkDelayTimeTest {
    @Test
    fun testSimpleCase() {
        val times =
            arrayOf(
                intArrayOf(2, 1, 1),
                intArrayOf(2, 3, 1),
                intArrayOf(3, 4, 1),
            )
        val n = 4
        val k = 2

        val result = NetworkDelayTime.Solution().networkDelayTime(times, n, k)

        assertEquals(2, result)
    }

    @Test
    fun testDisconnectedGraph() {
        val times =
            arrayOf(
                intArrayOf(1, 2, 1),
            )
        val n = 4
        val k = 1

        val result = NetworkDelayTime.Solution().networkDelayTime(times, n, k)

        assertEquals(-1, result)
    }

    @Test
    fun testCyclicGraph() {
        val times =
            arrayOf(
                intArrayOf(1, 2, 1),
                intArrayOf(2, 3, 1),
                intArrayOf(3, 1, 1),
            )
        val n = 3
        val k = 1

        val result = NetworkDelayTime.Solution().networkDelayTime(times, n, k)

        assertEquals(2, result)
    }

    @Test
    fun testLargeWeights() {
        val times =
            arrayOf(
                intArrayOf(1, 2, 100),
                intArrayOf(2, 3, 200),
                intArrayOf(1, 3, 500),
            )
        val n = 3
        val k = 1

        val result = NetworkDelayTime.Solution().networkDelayTime(times, n, k)

        assertEquals(300, result)
    }
}
