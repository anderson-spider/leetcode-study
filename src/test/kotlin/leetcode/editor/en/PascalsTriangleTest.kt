package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PascalsTriangleTest {
    private val solution = PascalsTriangle.Solution()

    @Test
    @DisplayName("Test with 5 rows")
    fun testFiveRows() {
        val numRows = 5

        val result = solution.generate(numRows)

        val expected =
            listOf(
                listOf(1),
                listOf(1, 1),
                listOf(1, 2, 1),
                listOf(1, 3, 3, 1),
                listOf(1, 4, 6, 4, 1),
            )

        assertEquals(expected, result, "Pascal's Triangle with 5 rows should match the expected pattern")
    }

    @Test
    @DisplayName("Test with 1 row")
    fun testOneRow() {
        val numRows = 1

        val result = solution.generate(numRows)

        val expected =
            listOf(
                listOf(1),
            )

        assertEquals(expected, result, "Pascal's Triangle with 1 row should be [[1]]")
    }

    // Note: According to the problem constraints, numRows is at least 1, so we don't test with 0 rows

    @Test
    @DisplayName("Test with 10 rows")
    fun testTenRows() {
        val numRows = 10

        val result = solution.generate(numRows)

        // Verify the number of rows
        assertEquals(10, result.size, "Should generate exactly 10 rows")

        // Verify each row has the correct length
        for (i in 0 until numRows) {
            assertEquals(i + 1, result[i].size, "Row ${i + 1} should have ${i + 1} elements")
        }

        // Verify the first and last elements of each row are 1
        for (row in result) {
            assertEquals(1, row.first(), "First element of each row should be 1")
            assertEquals(1, row.last(), "Last element of each row should be 1")
        }

        // Verify the Pascal's Triangle property: each element is the sum of the two elements above it
        for (i in 2 until numRows) {
            for (j in 1 until i) {
                assertEquals(
                    result[i - 1][j - 1] + result[i - 1][j],
                    result[i][j],
                    "Element at position ($i,$j) should be the sum of elements at (${i - 1},${j - 1}) and (${i - 1},$j)",
                )
            }
        }
    }

    @Test
    @DisplayName("Test specific values in larger triangle")
    fun testSpecificValues() {
        val numRows = 15

        val result = solution.generate(numRows)

        // Test some known values in Pascal's Triangle
        assertEquals(1, result[0][0], "Value at (0,0) should be 1")
        assertEquals(1, result[1][0], "Value at (1,0) should be 1")
        assertEquals(1, result[1][1], "Value at (1,1) should be 1")
        assertEquals(2, result[2][1], "Value at (2,1) should be 2")
        assertEquals(6, result[4][2], "Value at (4,2) should be 6")
        assertEquals(10, result[5][2], "Value at (5,2) should be 10")
        assertEquals(35, result[7][4], "Value at (7,4) should be 35")
        assertEquals(120, result[10][3], "Value at (10,3) should be 120")
        assertEquals(1, result[14][0], "Value at (14,0) should be 1")
        assertEquals(14, result[14][1], "Value at (14,1) should be 14")
        assertEquals(1, result[14][14], "Value at (14,14) should be 1")
    }

    @Test
    @DisplayName("Test symmetry property")
    fun testSymmetry() {
        val numRows = 12

        val result = solution.generate(numRows)

        // Test symmetry property: elements equidistant from the ends are equal
        for (i in 0 until numRows) {
            for (j in 0..i / 2) {
                assertEquals(
                    result[i][j],
                    result[i][i - j],
                    "Row $i should be symmetric: elements at positions $j and ${i - j} should be equal",
                )
            }
        }
    }
}
