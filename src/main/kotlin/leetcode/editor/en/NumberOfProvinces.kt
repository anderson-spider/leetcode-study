package leetcode.editor.en
// There are n cities. Some of them are connected, while some are not. If city a
// is connected directly with city b, and city b is connected directly with city c,
// then city a is connected indirectly with city c.
//
// A province is a group of directly or indirectly connected cities and no
// other cities outside of the group.
//
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
// iᵗʰ city and the jᵗʰ city are directly connected, and isConnected[i][j] = 0
// otherwise.
//
// Return the total number of provinces.
//
//
// Example 1:
//
//
// Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Output: 2
//
//
// Example 2:
//
//
// Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
// Output: 3
//
//
//
// Constraints:
//
//
// 1 <= n <= 200
// n == isConnected.length
// n == isConnected[i].length
// isConnected[i][j] is 1 or 0.
// isConnected[i][i] == 1
// isConnected[i][j] == isConnected[j][i]
//
//
// Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 10
// 634 👎 399

object NumberOfProvinces {
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findCircleNum(isConnected: Array<IntArray>): Int {
            val size = isConnected.size
            val visited = BooleanArray(size)
            var provinces = 0

            for (city in 0 until size) {
                if (!visited[city]) {
                    dfs(city, visited, isConnected)
                    provinces++
                }
            }
            return provinces
        }

        fun dfs(
            city: Int,
            visited: BooleanArray,
            isConnected: Array<IntArray>,
        ) {
            visited[city] = true
            for (nextCity in 0 until isConnected.size) {
                if (isConnected[city][nextCity] == 1 && !visited[nextCity]) {
                    dfs(nextCity, visited, isConnected)
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
