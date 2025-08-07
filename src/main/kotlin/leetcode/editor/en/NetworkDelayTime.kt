package leetcode.editor.en

import java.util.PriorityQueue

// You are given a network of n nodes, labeled from 1 to n. You are also given
// times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui
// is the source node, vi is the target node, and wi is the time it takes for a
// signal to travel from source to target.
//
// We will send a signal from a given node k. Return the minimum time it takes
// for all the n nodes to receive the signal. If it is impossible for all the n
// nodes to receive the signal, return -1.
//
//
// Example 1:
//
//
// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
// Output: 2
//
//
// Example 2:
//
//
// Input: times = [[1,2,1]], n = 2, k = 1
// Output: 1
//
//
// Example 3:
//
//
// Input: times = [[1,2,1]], n = 2, k = 2
// Output: -1
//
//
//
// Constraints:
//
//
// 1 <= k <= n <= 100
// 1 <= times.length <= 6000
// times[i].length == 3
// 1 <= ui, vi <= n
// ui != vi
// 0 <= wi <= 100
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
//
//
// Related Topics Depth-First Search Breadth-First Search Graph Heap (Priority
// Queue) Shortest Path 👍 8040 👎 387

// 743 - Network Delay Time

object NetworkDelayTime {
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun networkDelayTime(
            times: Array<IntArray>,
            n: Int,
            k: Int,
        ): Int {
            val graph = mutableMapOf<Int, MutableMap<Int, Int>>()
            for (i in 0 until times.size) {
                val node = times[i][0]
                val adjacentNode = times[i][1]
                val delayTime = times[i][2]
                val edges = graph.computeIfAbsent(node) { mutableMapOf() }
                edges[adjacentNode] = delayTime
            }

            println(graph)
            val distances = dijkstra(graph, k)

            return if (distances.size < n) {
                -1
            } else {
                distances.values.max()
            }
        }

        fun dijkstra(
            graph: MutableMap<Int, MutableMap<Int, Int>>,
            start: Int,
        ): Map<Int, Int> {
            val distances = mutableMapOf<Int, Int>().withDefault { Int.MAX_VALUE }
            val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
            val visited = mutableSetOf<Int>()

            priorityQueue.add(start to 0)
            distances[start] = 0

            while (priorityQueue.isNotEmpty()) {
                val (node, currentDist) = priorityQueue.poll()

                if (visited.add(node)) {
                    graph[node]?.forEach { (adjacent, weight) ->

                        val totalDist = currentDist + weight

                        if (totalDist < distances.getValue(adjacent)) {
                            distances[adjacent] = totalDist
                            priorityQueue.add(adjacent to totalDist)
                        }
                    }
                }
            }
            return distances
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
