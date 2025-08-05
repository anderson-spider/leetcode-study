package leetcode.editor.en
// Given the roots of two binary trees p and q, write a function to check if
// they are the same or not.
//
// Two binary trees are considered the same if they are structurally identical,
// and the nodes have the same value.
//
//
// Example 1:
//
//
// Input: p = [1,2,3], q = [1,2,3]
// Output: true
//
//
// Example 2:
//
//
// Input: p = [1,2], q = [1,null,2]
// Output: false
//
//
// Example 3:
//
//
// Input: p = [1,2,1], q = [1,1,2]
// Output: false
//
//
//
// Constraints:
//
//
// The number of nodes in both trees is in the range [0, 100].
// -10⁴ <= Node.val <= 10⁴
//
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 12
// 370 👎 270

object SameTree {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        // Test case 1: Identical trees [1,2,3]
        val p1 = TreeNode(1)
        p1.left = TreeNode(2)
        p1.right = TreeNode(3)
        val q1 = TreeNode(1)
        q1.left = TreeNode(2)
        q1.right = TreeNode(3)
        assert(solution.isSameTree(p1, q1)) { "Test case 1 failed" }

        // Test case 2: Different structure [1,2] and [1,null,2]
        val p2 = TreeNode(1)
        p2.left = TreeNode(2)
        val q2 = TreeNode(1)
        q2.right = TreeNode(2)
        assert(!solution.isSameTree(p2, q2)) { "Test case 2 failed" }

        // Test case 3: Different values [1,2,1] and [1,1,2]
        val p3 = TreeNode(1)
        p3.left = TreeNode(2)
        p3.right = TreeNode(1)
        val q3 = TreeNode(1)
        q3.left = TreeNode(1)
        q3.right = TreeNode(2)
        assert(!solution.isSameTree(p3, q3)) { "Test case 3 failed" }

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
        fun isSameTree(
            p: TreeNode?,
            q: TreeNode?,
        ): Boolean {
            if (p == null && q == null) return true

            if (p?.`val` != q?.`val`) return false

            return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
