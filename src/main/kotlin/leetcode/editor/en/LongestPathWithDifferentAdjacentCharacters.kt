package leetcode.editor.en
// You are given a tree (i.e. a connected, undirected graph that has no cycles)
// rooted at node 0 consisting of n nodes numbered from 0 to n - 1. The tree is
// represented by a 0-indexed array parent of size n, where parent[i] is the parent of
// node i. Since node 0 is the root, parent[0] == -1.
//
// You are also given a string s of length n, where s[i] is the character
// assigned to node i.
//
// Return the length of the longest path in the tree such that no pair of
// adjacent nodes on the path have the same character assigned to them.
//
//
// Example 1:
//
//
// Input: parent = [-1,0,0,1,1,2], s = "abacbe"
// Output: 3
// Explanation: The longest path where each two adjacent nodes have different
// characters in the tree is the path: 0 -> 1 -> 3. The length of this path is 3, so 3
// is returned.
// It can be proven that there is no longer path that satisfies the conditions.
//
//
// Example 2:
//
//
// Input: parent = [-1,0,0,0], s = "aabc"
// Output: 3
// Explanation: The longest path where each two adjacent nodes have different
// characters is the path: 2 -> 0 -> 3. The length of this path is 3, so 3 is
// returned.
//
//
//
// Constraints:
//
//
// n == parent.length == s.length
// 1 <= n <= 10⁵
// 0 <= parent[i] <= n - 1 for all i >= 1
// parent[0] == -1
// parent represents a valid tree.
// s consists of only lowercase English letters.
//
//
// Related Topics Array String Tree Depth-First Search Graph Topological Sort 👍
// 2481 👎 61

object LongestPathWithDifferentAdjacentCharacters {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        // Test Example 1
        val parent1 = intArrayOf(-1, 0, 0, 1, 1, 2)
        val s1 = "abacbe"
        val result1 = solution.longestPath(parent1, s1)
        println("Example 1 Result: $result1, Expected: 3")

        // Test Example 2
        val parent2 = intArrayOf(-1, 0, 0, 0)
        val s2 = "aabc"
        val result2 = solution.longestPath(parent2, s2)
        println("Example 2 Result: $result2, Expected: 3")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestPath(
            parent: IntArray,
            s: String,
        ): Int {
            val n = parent.size
            // Build adjacency list
            val children = Array(n) { mutableListOf<Int>() }

            // Skip index 0 as it's the root with parent -1
            for (i in 1 until n) {
                children[parent[i]].add(i)
            }

            // Global variable to track maximum path length
            var maxPath = 1

            // DFS function to find longest path
            fun dfs(node: Int): Int {
                // If no children, path length is 1 (just the node itself)
                if (children[node].isEmpty()) return 1

                // Find the two longest paths from children
                var longest = 0
                var secondLongest = 0

                for (child in children[node]) {
                    // Get longest path starting from this child
                    val childPath = dfs(child)

                    // Only consider paths where child has different character than current node
                    if (s[child] != s[node]) {
                        when {
                            childPath > longest -> {
                                secondLongest = longest
                                longest = childPath
                            }
                            childPath > secondLongest -> {
                                secondLongest = childPath
                            }
                        }
                    }
                }

                // Update global maximum path
                // The path can go through the current node connecting the two longest child paths
                maxPath = maxOf(maxPath, longest + secondLongest + 1)

                // Return the longest path starting from this node
                return longest + 1
            }

            // Start DFS from the root (node 0)
            dfs(0)

            return maxPath
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
