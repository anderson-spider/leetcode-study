package leetcode.editor.en
// You are given an m x n binary matrix grid, where 0 represents a sea cell and 1
// represents a land cell.
//
// A move consists of walking from one land cell to another adjacent (4-
// directionally) land cell or walking off the boundary of the grid.
//
// Return the number of land cells in grid for which we cannot walk off the
// boundary of the grid in any number of moves.
//
//
// Example 1:
//
//
// Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
// Output: 3
// Explanation: There are three 1s that are enclosed by 0s, and one 1 that is
// not enclosed because its on the boundary.
//
//
// Example 2:
//
//
// Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
// Output: 0
// Explanation: All 1s are either on the boundary or can reach the boundary.
//
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 500
// grid[i][j] is either 0 or 1.
//
//
// Related Topics Array Depth-First Search Breadth-First Search Union Find
// Matrix 👍 4410 👎 86

object NumberOfEnclaves {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        val result =
            solution.numEnclaves(
                arrayOf(
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(1, 0, 1, 0),
                    intArrayOf(0, 1, 1, 0),
                    intArrayOf(0, 0, 0, 0),
                ),
            )
        check(result == 3) { "result:$result but expected:3" }
        val result2 =
            solution.numEnclaves(
                arrayOf(
                    intArrayOf(0, 1, 1, 0),
                    intArrayOf(0, 0, 1, 0),
                    intArrayOf(0, 0, 1, 0),
                    intArrayOf(0, 0, 0, 0),
                ),
            )
        check(result2 == 0) { "result:$result2 but expected:0" }
        val result3 =
            solution.numEnclaves(
                arrayOf(
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 1, 1, 0),
                    intArrayOf(0, 0, 1, 0),
                    intArrayOf(0, 0, 0, 0),
                ),
            )
        check(result3 == 3) { "result:$result3 but expected:3" }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun numEnclaves(grid: Array<IntArray>): Int {
            val rows = grid.size
            val cols = grid[0].size
            println("==================================")
            println("Current grid state:")
            grid.forEach { row -> println(row.joinToString(" ")) }

            // Mark all land cells connected to boundary
            for (row in 0 until rows) {
                dfsFloodFill(grid = grid, row = row, col = 0)
                dfsFloodFill(grid = grid, row = row, col = cols - 1)
            }
            println("After flood fill, land col cells marked as 0:")
            grid.forEach { row -> println(row.joinToString(" ")) }

            for (col in 0 until cols) {
                dfsFloodFill(grid = grid, row = 0, col = col)
                dfsFloodFill(grid = grid, row = rows - 1, col = col)
            }

            println("After flood fill, land row cells marked as 0:")
            grid.forEach { row -> println(row.joinToString(" ")) }

            // Count remaining land cells
            var count = 0
            for (row in 1 until rows - 1) {
                for (col in 1 until cols - 1) {
                    if (grid[row][col] == 1) {
                        count++
                    }
                }
            }
            return count
        }

        private fun dfsFloodFill(
            grid: Array<IntArray>,
            row: Int,
            col: Int,
        ) {
            if (!isCoordinateValid(grid, row, col) || grid[row][col] != 1) {
                return
            }

            grid[row][col] = 0

            dfsFloodFill(grid, row + 1, col)
            dfsFloodFill(grid, row - 1, col)
            dfsFloodFill(grid, row, col + 1)
            dfsFloodFill(grid, row, col - 1)
        }

        private fun isCoordinateValid(
            grid: Array<IntArray>,
            row: Int,
            col: Int,
        ): Boolean = row in grid.indices && col in grid[0].indices
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
