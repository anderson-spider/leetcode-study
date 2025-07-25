package leetcode.editor.en
//There is an undirected connected tree with n nodes labeled from 0 to n - 1 
//and n - 1 edges. 
//
// You are given a 0-indexed integer array nums of length n where nums[i] 
//represents the value of the iᵗʰ node. You are also given a 2D integer array edges of 
//length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between 
//nodes ai and bi in the tree. 
//
// Remove two distinct edges of the tree to form three connected components. 
//For a pair of removed edges, the following steps are defined: 
//
// 
// Get the XOR of all the values of the nodes for each of the three components 
//respectively. 
// The difference between the largest XOR value and the smallest XOR value is 
//the score of the pair. 
// 
//
// 
// For example, say the three components have the node values: [4,5,7], [1,9], 
//and [3,3,3]. The three XOR values are 4 ^ 5 ^ 7 = 6, 1 ^ 9 = 8, and 3 ^ 3 ^ 3 = 3
//. The largest XOR value is 8 and the smallest XOR value is 3. The score is then 
//8 - 3 = 5. 
// 
//
// Return the minimum score of any possible pair of edge removals on the given 
//tree. 
//
// 
// Example 1: 
// 
// 
//Input: nums = [1,5,5,4,11], edges = [[0,1],[1,2],[1,3],[3,4]]
//Output: 9
//Explanation: The diagram above shows a way to make a pair of removals.
//- The 1ˢᵗ component has nodes [1,3,4] with values [5,4,11]. Its XOR value is 5
// ^ 4 ^ 11 = 10.
//- The 2ⁿᵈ component has node [0] with value [1]. Its XOR value is 1 = 1.
//- The 3ʳᵈ component has node [2] with value [5]. Its XOR value is 5 = 5.
//The score is the difference between the largest and smallest XOR value which 
//is 10 - 1 = 9.
//It can be shown that no other pair of removals will obtain a smaller score 
//than 9.
// 
//
// Example 2: 
// 
// 
//Input: nums = [5,5,2,4,4,2], edges = [[0,1],[1,2],[5,2],[4,3],[1,3]]
//Output: 0
//Explanation: The diagram above shows a way to make a pair of removals.
//- The 1ˢᵗ component has nodes [3,4] with values [4,4]. Its XOR value is 4 ^ 4 
//= 0.
//- The 2ⁿᵈ component has nodes [1,0] with values [5,5]. Its XOR value is 5 ^ 5 
//= 0.
//- The 3ʳᵈ component has nodes [2,5] with values [2,2]. Its XOR value is 2 ^ 2 
//= 0.
//The score is the difference between the largest and smallest XOR value which 
//is 0 - 0 = 0.
//We cannot obtain a smaller score than 0.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 3 <= n <= 1000 
// 1 <= nums[i] <= 10⁸ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// edges represents a valid tree. 
// 
//
// Related Topics Array Bit Manipulation Tree Depth-First Search 👍 756 👎 42

object MinimumScoreAfterRemovalsOnATree {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        
        // Test Example 1
        println("Testing Example 1:")
        val nums1 = intArrayOf(1, 5, 5, 4, 11)
        val edges1 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(3, 4)
        )
        val result1 = solution.minimumScore(nums1, edges1)
        println("Input: nums = [1,5,5,4,11], edges = [[0,1],[1,2],[1,3],[3,4]]")
        println("Expected: 9")
        println("Actual: $result1")
        println("Test 1 ${if (result1 == 9) "PASSED" else "FAILED"}")
        println()
        
        // Test Example 2
        println("Testing Example 2:")
        val nums2 = intArrayOf(5, 5, 2, 4, 4, 2)
        val edges2 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(5, 2),
            intArrayOf(4, 3),
            intArrayOf(1, 3)
        )
        val result2 = solution.minimumScore(nums2, edges2)
        println("Input: nums = [5,5,2,4,4,2], edges = [[0,1],[1,2],[5,2],[4,3],[1,3]]")
        println("Expected: 0")
        println("Actual: $result2")
        println("Test 2 ${if (result2 == 0) "PASSED" else "FAILED"}")
        println()
        
        // Test a simple case
        println("Testing Simple Case:")
        val nums3 = intArrayOf(1, 2, 3)
        val edges3 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2)
        )
        val result3 = solution.minimumScore(nums3, edges3)
        println("Input: nums = [1,2,3], edges = [[0,1],[1,2]]")
        println("Expected: 2 (components: [1], [2], [3] -> XORs: 1, 2, 3 -> score: 3-1=2)")
        println("Actual: $result3")
        println("Test 3 ${if (result3 == 2) "PASSED" else "FAILED"}")
        
        println("\nAll tests completed!")
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * Finds the minimum score after removing two edges from a tree.
     * 
     * Algorithm Overview:
     * 1. Build adjacency list representation of the tree
     * 2. Use DFS to compute subtree XOR sums and establish parent-child relationships
     * 3. For each pair of edges, determine the three resulting components
     * 4. Calculate XOR values for each component and find the minimum score
     * 
     * Time Complexity: O(n²) where n is the number of nodes
     * Space Complexity: O(n) for adjacency list and auxiliary arrays
     */
    fun minimumScore(nums: IntArray, edges: Array<IntArray>): Int {
        val n = nums.size
        
        // Input validation
        if (n < 3 || edges.size != n - 1) {
            throw IllegalArgumentException("Invalid tree structure")
        }
        
        // Build adjacency list representation of the tree
        val adjacencyList = Array(n) { mutableListOf<Int>() }
        for ((nodeA, nodeB) in edges) {
            adjacencyList[nodeA].add(nodeB)
            adjacencyList[nodeB].add(nodeA)
        }
        
        // Arrays to store tree properties after DFS
        val subtreeXorSum = IntArray(n) { nums[it] }  // XOR sum of each subtree
        val parentNode = IntArray(n) { -1 }           // Parent of each node
        val entryTime = IntArray(n)                   // DFS entry time for each node
        val exitTime = IntArray(n)                    // DFS exit time for each node
        var currentTime = 0
        
        /**
         * DFS to compute subtree XOR sums and establish tree structure.
         * Also records entry/exit times to determine ancestor-descendant relationships.
         */
        fun buildTreeStructure(node: Int, parent: Int) {
            entryTime[node] = ++currentTime
            
            for (neighbor in adjacencyList[node]) {
                if (neighbor == parent) continue
                
                parentNode[neighbor] = node
                buildTreeStructure(neighbor, node)
                
                // Accumulate XOR sum from child subtrees
                subtreeXorSum[node] = subtreeXorSum[node] xor subtreeXorSum[neighbor]
            }
            
            exitTime[node] = ++currentTime
        }
        
        // Build tree structure starting from node 0
        buildTreeStructure(0, -1)
        
        val totalXorSum = subtreeXorSum[0]
        var minimumScore = Int.MAX_VALUE
        
        // Try all possible pairs of edges to remove
        for (firstEdgeIndex in 0 until n - 1) {
            val (node1, node2) = edges[firstEdgeIndex]
            val childNode1 = if (parentNode[node1] == node2) node1 else node2
            
            for (secondEdgeIndex in firstEdgeIndex + 1 until n - 1) {
                val (node3, node4) = edges[secondEdgeIndex]
                val childNode2 = if (parentNode[node3] == node4) node3 else node4
                
                // Calculate score directly without creating intermediate array
                val score = calculateScoreOptimized(
                    childNode1, childNode2, subtreeXorSum, entryTime, exitTime, totalXorSum
                )
                
                minimumScore = minOf(minimumScore, score)
                
                // Early termination if we find the optimal score of 0
                if (minimumScore == 0) return 0
            }
        }
        
        return minimumScore
    }
    
    /**
     * Optimized function to calculate the score directly without intermediate arrays.
     * This reduces memory allocation and improves performance in the critical path.
     */
    private fun calculateScoreOptimized(
        child1: Int,
        child2: Int,
        subtreeXorSum: IntArray,
        entryTime: IntArray,
        exitTime: IntArray,
        totalXorSum: Int
    ): Int {
        // Check ancestor-descendant relationships using DFS timing
        val isChild1AncestorOfChild2 = entryTime[child1] <= entryTime[child2] && 
                                       exitTime[child2] <= exitTime[child1]
        val isChild2AncestorOfChild1 = entryTime[child2] <= entryTime[child1] && 
                                       exitTime[child1] <= exitTime[child2]
        
        // Calculate the three component XOR values based on relationship
        val (xor1, xor2, xor3) = when {
            isChild1AncestorOfChild2 -> {
                // child1 contains child2 as a descendant
                Triple(
                    subtreeXorSum[child2],                           // child2's subtree
                    subtreeXorSum[child1] xor subtreeXorSum[child2], // child1's subtree minus child2
                    totalXorSum xor subtreeXorSum[child1]            // remaining nodes
                )
            }
            isChild2AncestorOfChild1 -> {
                // child2 contains child1 as a descendant
                Triple(
                    subtreeXorSum[child1],                           // child1's subtree
                    subtreeXorSum[child2] xor subtreeXorSum[child1], // child2's subtree minus child1
                    totalXorSum xor subtreeXorSum[child2]            // remaining nodes
                )
            }
            else -> {
                // child1 and child2 are in separate subtrees
                Triple(
                    subtreeXorSum[child1],                                        // child1's subtree
                    subtreeXorSum[child2],                                        // child2's subtree
                    totalXorSum xor subtreeXorSum[child1] xor subtreeXorSum[child2] // remaining nodes
                )
            }
        }
        
        // Calculate min and max directly without creating arrays
        val maxXor = maxOf(xor1, maxOf(xor2, xor3))
        val minXor = minOf(xor1, minOf(xor2, xor3))
        
        return maxXor - minXor
    }
    
    /**
     * Calculates XOR values for the three components formed by removing two edges.
     * Uses DFS timing to determine ancestor-descendant relationships efficiently.
     * 
     * @deprecated Use calculateScoreOptimized for better performance
     */
    private fun calculateComponentXorValues(
        child1: Int,
        child2: Int,
        subtreeXorSum: IntArray,
        entryTime: IntArray,
        exitTime: IntArray,
        totalXorSum: Int
    ): IntArray {
        val componentXors = IntArray(3)
        
        // Check if child1 is an ancestor of child2
        val isChild1AncestorOfChild2 = entryTime[child1] <= entryTime[child2] && 
                                       exitTime[child2] <= exitTime[child1]
        
        // Check if child2 is an ancestor of child1
        val isChild2AncestorOfChild1 = entryTime[child2] <= entryTime[child1] && 
                                       exitTime[child1] <= exitTime[child2]
        
        when {
            isChild1AncestorOfChild2 -> {
                // child1 contains child2 as a descendant
                componentXors[0] = subtreeXorSum[child2]                           // child2's subtree
                componentXors[1] = subtreeXorSum[child1] xor subtreeXorSum[child2] // child1's subtree minus child2
                componentXors[2] = totalXorSum xor subtreeXorSum[child1]           // remaining nodes
            }
            isChild2AncestorOfChild1 -> {
                // child2 contains child1 as a descendant
                componentXors[0] = subtreeXorSum[child1]                           // child1's subtree
                componentXors[1] = subtreeXorSum[child2] xor subtreeXorSum[child1] // child2's subtree minus child1
                componentXors[2] = totalXorSum xor subtreeXorSum[child2]           // remaining nodes
            }
            else -> {
                // child1 and child2 are in separate subtrees
                componentXors[0] = subtreeXorSum[child1]                                        // child1's subtree
                componentXors[1] = subtreeXorSum[child2]                                        // child2's subtree
                componentXors[2] = totalXorSum xor subtreeXorSum[child1] xor subtreeXorSum[child2] // remaining nodes
            }
        }
        
        return componentXors
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}