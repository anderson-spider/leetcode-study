package leetcode.editor.en
// The thief has found himself a new place for his thievery again. There is only
// one entrance to this area, called root.
//
// Besides the root, each house has one and only one parent house. After a tour,
// the smart thief realized that all houses in this place form a binary tree. It
// will automatically contact the police if two directly-linked houses were broken
// into on the same night.
//
// Given the root of the binary tree, return the maximum amount of money the
// thief can rob without alerting the police.
//
//
// Example 1:
//
//
// Input: root = [3,2,3,null,3,null,1]
// Output: 7
// Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
//
//
// Example 2:
//
//
// Input: root = [3,4,5,1,3,null,1]
// Output: 9
// Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 10⁴].
// 0 <= Node.val <= 10⁴
//
//
// Related Topics Dynamic Programming Tree Depth-First Search Binary Tree 👍 888
// 3 👎 153

object HouseRobberIii {
    private fun createComplexTree(): TreeNode =
        TreeNode(3).apply {
            left =
                TreeNode(4).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                }
            right =
                TreeNode(5).apply {
                    right = TreeNode(1)
                }
        }

    private fun createSimpleTree(
        rootVal: Int,
        leftVal: Int,
        rightVal: Int,
    ): TreeNode =
        TreeNode(rootVal).apply {
            left = TreeNode(leftVal)
            right = TreeNode(rightVal)
        }

    private fun createSingleChildTree(
        rootVal: Int,
        childVal: Int,
    ): TreeNode =
        TreeNode(rootVal).apply {
            left = TreeNode(childVal)
        }

    // leetcode submit region begin(Prohibit modification and deletion)

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
        private data class Result(
            val rob: Int,
            val notRob: Int,
        )

        private fun dfs(node: TreeNode?): Result {
            if (node == null) return Result(0, 0)

            val left = dfs(node.left)
            val right = dfs(node.right)

            val rob = node.`val` + left.notRob + right.notRob
            val notRob = maxOf(left.rob, left.notRob) + maxOf(right.rob, right.notRob)

            return Result(rob, notRob)
        }

        fun rob(root: TreeNode?): Int {
            val result = dfs(root)
            return maxOf(result.rob, result.notRob)
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
