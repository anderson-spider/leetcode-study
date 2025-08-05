package leetcode.editor.en
// You are given an empty 2D binary grid grid of size m x n. The grid represents
// a map where 0's represent water and 1's represent land. Initially, all the
// cells of grid are water cells (i.e., all the cells are 0's).
//
// We may perform an add land operation which turns the water at position into
// a land. You are given an array positions where positions[i] = [ri, ci] is the
// position (ri, ci) at which we should operate the iᵗʰ operation.
//
// Return an array of integers answer where answer[i] is the number of islands
// after turning the cell (ri, ci) into a land.
//
// An island is surrounded by water and is formed by connecting adjacent lands
// horizontally or vertically. You may assume all four edges of the grid are all
// surrounded by water.
//
//
// Example 1:
//
//
// Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
// Output: [1,1,2,3]
// Explanation:
// Initially, the 2d grid is filled with water.
// - Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We
// have 1 island.
// - Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We
// still have 1 island.
// - Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We
// have 2 islands.
// - Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We
// have 3 islands.
//
//
// Example 2:
//
//
// Input: m = 1, n = 1, positions = [[0,0]]
// Output: [1]
//
//
//
// Constraints:
//
//
// 1 <= m, n, positions.length <= 10⁴
// 1 <= m * n <= 10⁴
// positions[i].length == 2
// 0 <= ri < m
// 0 <= ci < n
//
//
//
// Follow up: Could you solve it in time complexity O(k log(mn)), where k ==
// positions.length?
//
// Related Topics Array Hash Table Union Find 👍 1945 👎 76

object NumberOfIslandsIi {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        // Test Example 1
        val m1 = 3
        val n1 = 3
        val positions1 =
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(2, 1),
            )
        val result1 = solution.numIslands2(m1, n1, positions1)
        println("Example 1 Result: $result1") // Expected: [1, 1, 2, 3]

        // Test Example 2
        val m2 = 1
        val n2 = 1
        val positions2 = arrayOf(intArrayOf(0, 0))
        val result2 = solution.numIslands2(m2, n2, positions2)
        println("Example 2 Result: $result2") // Expected: [1]
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun numIslands2(
            m: Int,
            n: Int,
            positions: Array<IntArray>,
        ): List<Int> {
            // Union-Find data structure to track connected components
            val uf = UnionFind(m * n)
            val grid = Array(m) { BooleanArray(n) { false } } // false = water, true = land
            val result = mutableListOf<Int>()
            var count = 0 // Number of islands

            // Directions for adjacent cells: up, right, down, left
            val directions = arrayOf(intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1))

            for (position in positions) {
                val row = position[0]
                val col = position[1]

                // Skip if this cell is already land
                if (grid[row][col]) {
                    result.add(count)
                    continue
                }

                // Convert to land
                grid[row][col] = true
                count++

                // Check all 4 adjacent cells
                for (dir in directions) {
                    val newRow = row + dir[0]
                    val newCol = col + dir[1]

                    // Skip if out of bounds or if it's water
                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || !grid[newRow][newCol]) {
                        continue
                    }

                    // Get the indices in the 1D array
                    val currentIndex = row * n + col
                    val neighborIndex = newRow * n + newCol

                    // If they are not already connected, connect them and reduce island count
                    if (uf.find(currentIndex) != uf.find(neighborIndex)) {
                        uf.union(currentIndex, neighborIndex)
                        count--
                    }
                }

                result.add(count)
            }

            return result
        }

        // Union-Find data structure
        private class UnionFind(
            size: Int,
        ) {
            private val parent = IntArray(size) { it } // Each element is its own parent initially
            private val rank = IntArray(size) { 1 } // Rank (or size) of each set

            // Find the root of the set that element belongs to
            fun find(x: Int): Int {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]) // Path compression
                }
                return parent[x]
            }

            // Union two sets
            fun union(
                x: Int,
                y: Int,
            ) {
                val rootX = find(x)
                val rootY = find(y)

                if (rootX != rootY) {
                    // Union by rank: attach smaller tree under root of larger tree
                    if (rank[rootX] > rank[rootY]) {
                        parent[rootY] = rootX
                    } else if (rank[rootX] < rank[rootY]) {
                        parent[rootX] = rootY
                    } else {
                        parent[rootY] = rootX
                        rank[rootX]++
                    }
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
