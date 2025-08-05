package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SameTreeTest {
    private val solution = SameTree.Solution()

    @Test
    @DisplayName("Test identical trees")
    fun testIdenticalTrees() {
        // Create first tree: [1,2,3]
        val p1 = TreeNode(1)
        p1.left = TreeNode(2)
        p1.right = TreeNode(3)

        // Create second tree: [1,2,3]
        val q1 = TreeNode(1)
        q1.left = TreeNode(2)
        q1.right = TreeNode(3)

        assertTrue(solution.isSameTree(p1, q1), "Trees with identical structure and values should be the same")
    }

    @Test
    @DisplayName("Test trees with different structure")
    fun testDifferentStructure() {
        // Create first tree: [1,2]
        val p2 = TreeNode(1)
        p2.left = TreeNode(2)

        // Create second tree: [1,null,2]
        val q2 = TreeNode(1)
        q2.right = TreeNode(2)

        assertFalse(solution.isSameTree(p2, q2), "Trees with different structure should not be the same")
    }

    @Test
    @DisplayName("Test trees with different values")
    fun testDifferentValues() {
        // Create first tree: [1,2,1]
        val p3 = TreeNode(1)
        p3.left = TreeNode(2)
        p3.right = TreeNode(1)

        // Create second tree: [1,1,2]
        val q3 = TreeNode(1)
        q3.left = TreeNode(1)
        q3.right = TreeNode(2)

        assertFalse(solution.isSameTree(p3, q3), "Trees with different values should not be the same")
    }

    @Test
    @DisplayName("Test with null trees")
    fun testNullTrees() {
        // Both trees are null
        assertTrue(solution.isSameTree(null, null), "Two null trees should be the same")

        // One tree is null, the other is not
        val tree = TreeNode(1)
        assertFalse(solution.isSameTree(tree, null), "A tree and null should not be the same")
        assertFalse(solution.isSameTree(null, tree), "Null and a tree should not be the same")
    }
}
