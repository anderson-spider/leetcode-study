package leetcode.editor.en
// Given the root of a binary tree and an integer targetSum, return true if the
// tree has a root-to-leaf path such that adding up all the values along the path
// equals targetSum.
//
// A leaf is a node with no children.
//
//
// Example 1:
//
//
// Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
// Output: true
// Explanation: The root-to-leaf path with the target sum is shown.
//
//
// Example 2:
//
//
// Input: root = [1,2,3], targetSum = 5
// Output: false
// Explanation: There are two root-to-leaf paths in the tree:
// (1 --> 2): The sum is 3.
// (1 --> 3): The sum is 4.
// There is no root-to-leaf path with sum = 5.
//
//
// Example 3:
//
//
// Input: root = [], targetSum = 0
// Output: false
// Explanation: Since the tree is empty, there are no root-to-leaf paths.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 5000].
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000
//
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 10
// 315 👎 1186

object PathSum {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        val codec = SerializeAndDeserializeBinaryTree.Codec()
        codec.deserialize(codec.serialize(null))
        // Test case 1: Path with sum exists
        val root1 =
            TreeNode(5).apply {
                left =
                    TreeNode(4).apply {
                        left =
                            TreeNode(11).apply {
                                left = TreeNode(7)
                                right = TreeNode(2)
                            }
                    }
                right =
                    TreeNode(8).apply {
                        left = TreeNode(13)
                        right =
                            TreeNode(4).apply {
                                right = TreeNode(1)
                            }
                    }
            }
        check(solution.hasPathSum(root1, 22)) { "Test case 1 failed" }

        // Test case 2: Path with sum doesn't exist
        val root2 =
            TreeNode(1).apply {
                left = TreeNode(2)
                right = TreeNode(3)
            }
        check(!solution.hasPathSum(root2, 5)) { "Test case 2 failed" }

        // Test case 3: Empty tree
        check(!solution.hasPathSum(null, 0)) { "Test case 3 failed" }

        println("All test cases passed!")
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
        fun hasPathSum(
            root: TreeNode?,
            targetSum: Int,
        ): Boolean = findPathWithSum(root = root, targetSum = targetSum, sum = 0)

        fun findPathWithSum(
            root: TreeNode?,
            targetSum: Int,
            sum: Int,
        ): Boolean {
            if (root == null) return false

            if (root.left == null && root.right == null) return sum + root.`val` == targetSum

            return findPathWithSum(root.left, targetSum, sum + root.`val`) ||
                findPathWithSum(root.right, targetSum, sum + root.`val`)
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
