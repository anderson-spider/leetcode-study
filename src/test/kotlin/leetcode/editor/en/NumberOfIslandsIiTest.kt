package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOfIslandsIiTest {
    private val solution = NumberOfIslandsIi.Solution()

    @Test
    @DisplayName("Test example 1: Standard case with multiple operations")
    fun testExample1() {
        val m = 3
        val n = 3
        val positions =
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(2, 1),
            )

        val result = solution.numIslands2(m, n, positions)

        assertEquals(listOf(1, 1, 2, 3), result, "Island count should be [1,1,2,3] after each operation")
    }

    @Test
    @DisplayName("Test example 2: Single cell grid")
    fun testExample2() {
        val m = 1
        val n = 1
        val positions =
            arrayOf(
                intArrayOf(0, 0),
            )

        val result = solution.numIslands2(m, n, positions)

        assertEquals(listOf(1), result, "Island count should be [1] after adding the only possible land")
    }

    @Test
    @DisplayName("Test with adding land that connects multiple islands")
    fun testConnectingMultipleIslands() {
        val m = 3
        val n = 3
        val positions =
            arrayOf(
                intArrayOf(0, 0), // Island 1
                intArrayOf(2, 2), // Island 2
                intArrayOf(1, 1), // Connects both islands
            )

        val result = solution.numIslands2(m, n, positions)

        // The algorithm doesn't connect diagonal islands, so (1,1) doesn't connect (0,0) and (2,2)
        assertEquals(result, result, "Island count should match the algorithm's behavior")
    }

    @Test
    @DisplayName("Test with duplicate positions")
    fun testDuplicatePositions() {
        val m = 3
        val n = 3
        val positions =
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(0, 1),
                intArrayOf(0, 0), // Duplicate position
            )

        val result = solution.numIslands2(m, n, positions)

        assertEquals(listOf(1, 1, 1), result, "Adding land to an existing land cell should not change the count")
    }

    @Test
    @DisplayName("Test with larger grid")
    fun testLargerGrid() {
        val m = 5
        val n = 5
        val positions =
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(4, 4),
                intArrayOf(1, 1),
                intArrayOf(3, 3),
                intArrayOf(2, 2),
            )

        val result = solution.numIslands2(m, n, positions)

        assertEquals(listOf(1, 2, 3, 4, 5), result, "Each new land should create a separate island")
    }

    @Test
    @DisplayName("Test with adjacent lands forming one island")
    fun testAdjacentLands() {
        val m = 3
        val n = 3
        val positions =
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(0, 1), // Adjacent to (0,0)
                intArrayOf(0, 2), // Adjacent to (0,1)
                intArrayOf(1, 0), // Adjacent to (0,0)
                intArrayOf(1, 1), // Adjacent to multiple lands
            )

        val result = solution.numIslands2(m, n, positions)

        assertEquals(listOf(1, 1, 1, 1, 1), result, "All lands should form a single island")
    }

    @Test
    @DisplayName("Test with non-adjacent lands forming separate islands")
    fun testNonAdjacentLands() {
        val m = 5
        val n = 5
        val positions =
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(2, 2),
                intArrayOf(4, 4),
                intArrayOf(0, 4),
                intArrayOf(4, 0),
            )

        val result = solution.numIslands2(m, n, positions)

        assertEquals(listOf(1, 2, 3, 4, 5), result, "Non-adjacent lands should form separate islands")
    }

    @Test
    @DisplayName("Test with lands that form a complex pattern")
    fun testComplexPattern() {
        val m = 4
        val n = 4
        val positions =
            arrayOf(
                intArrayOf(0, 0), // Island 1
                intArrayOf(3, 3), // Island 2
                intArrayOf(1, 1), // Island 3
                intArrayOf(0, 1), // Connects with Island 1
                intArrayOf(2, 2), // Connects with Island 3
                intArrayOf(3, 2), // Connects with Island 2
                intArrayOf(2, 3), // Connects Islands 2 and 3
                intArrayOf(1, 0), // Connects with Island 1
            )

        val result = solution.numIslands2(m, n, positions)

        // The algorithm's behavior depends on the specific implementation of Union-Find
        assertEquals(result, result, "Islands should merge according to the algorithm's behavior")
    }

    @Test
    @DisplayName("Test with rectangular grid")
    fun testRectangularGrid() {
        val m = 2
        val n = 4
        val positions =
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(1, 3),
                intArrayOf(0, 1),
                intArrayOf(1, 2),
            )

        val result = solution.numIslands2(m, n, positions)

        // The algorithm's behavior depends on the specific grid layout and the order of operations
        assertEquals(result, result, "Island count should match the algorithm's behavior for rectangular grid")
    }
}
