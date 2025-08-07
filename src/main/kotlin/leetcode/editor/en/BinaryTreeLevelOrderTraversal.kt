package leetcode.editor.en
// Given the root of a binary tree, return the level order traversal of its
// nodes' values. (i.e., from left to right, level by level).
//
//
// Example 1:
//
//
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]
//
//
// Example 2:
//
//
// Input: root = [1]
// Output: [[1]]
//
//
// Example 3:
//
//
// Input: root = []
// Output: []
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000
//
//
// Related Topics Tree Breadth-First Search Binary Tree 👍 16386 👎 353

object BinaryTreeLevelOrderTraversal {
    // leetcode submit region begin(Prohibit modification and deletion)
    class TreeNode(
        var `val`: Int,
    ) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun buildTree(values: Array<Int?>): TreeNode? {
        if (values.isEmpty() || values[0] == null) return null

        val root = TreeNode(values[0]!!)
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var i = 1

        while (queue.isNotEmpty() && i < values.size) {
            val node = queue.removeFirst()

            if (values[i] != null) {
                node.left = TreeNode(values[i]!!)
                queue.add(node.left!!)
            }
            i++

            if (i < values.size && values[i] != null) {
                node.right = TreeNode(values[i]!!)
                queue.add(node.right!!)
            }
            i++
        }

        return root
    }

    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    class Solution {
        fun levelOrder(root: TreeNode?): List<List<Int>> {
            if (root == null) return emptyList()

            val result = mutableListOf<List<Int>>()
            val queue = ArrayDeque<TreeNode>()
            queue.add(root)

            while (queue.isNotEmpty()) {
                val levels = queue.size
                val currentLevel = mutableListOf<Int>()

                repeat(levels) {
                    val node = queue.removeFirst()
                    currentLevel.add(node.`val`)

                    node.left?.let { queue.add(it) }
                    node.right?.let { queue.add(it) }
                }

                result.add(currentLevel)
            }

            return result
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
