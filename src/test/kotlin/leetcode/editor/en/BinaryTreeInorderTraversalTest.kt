package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BinaryTreeInorderTraversalTest {
    private val solution = BinaryTreeInorderTraversal.Solution()

    @Test
    @DisplayName("Test with simple tree")
    fun testSimpleTree() {
        // Create tree: [1,null,2,3]
        val root = TreeNode(1)
        root.right = TreeNode(2)
        root.right?.left = TreeNode(3)

        val result = solution.inorderTraversal(root)
        val expected = listOf(1, 3, 2)

        assertEquals(expected, result, "Inorder traversal of [1,null,2,3] should be [1,3,2]")
    }

    @Test
    @DisplayName("Test with complex tree")
    fun testComplexTree() {
        // Create tree: [1,2,3,4,5,null,8,null,null,6,7,9]
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left?.left = TreeNode(4)
        root.left?.right = TreeNode(5)
        root.right?.right = TreeNode(8)
        root.left?.right?.left = TreeNode(6)
        root.left?.right?.right = TreeNode(7)
        root.right?.right?.left = TreeNode(9)

        val result = solution.inorderTraversal(root)
        val expected = listOf(4, 2, 6, 5, 7, 1, 3, 9, 8)

        assertEquals(expected, result, "Inorder traversal should match the expected order")
    }

    @Test
    @DisplayName("Test with empty tree")
    fun testEmptyTree() {
        val result = solution.inorderTraversal(null)
        val expected = emptyList<Int>()

        assertEquals(expected, result, "Inorder traversal of empty tree should be empty list")
    }

    @Test
    @DisplayName("Test with single node tree")
    fun testSingleNodeTree() {
        val root = TreeNode(1)

        val result = solution.inorderTraversal(root)
        val expected = listOf(1)

        assertEquals(expected, result, "Inorder traversal of single node tree should contain only that node's value")
    }

    @Test
    @DisplayName("Test with left-skewed tree")
    fun testLeftSkewedTree() {
        // Create tree: [3,2,null,1]
        val root = TreeNode(3)
        root.left = TreeNode(2)
        root.left?.left = TreeNode(1)

        val result = solution.inorderTraversal(root)
        val expected = listOf(1, 2, 3)

        assertEquals(expected, result, "Inorder traversal of left-skewed tree should be in ascending order")
    }

    @Test
    @DisplayName("Test with right-skewed tree")
    fun testRightSkewedTree() {
        // Create tree: [1,null,2,null,3]
        val root = TreeNode(1)
        root.right = TreeNode(2)
        root.right?.right = TreeNode(3)

        val result = solution.inorderTraversal(root)
        val expected = listOf(1, 2, 3)

        assertEquals(expected, result, "Inorder traversal of right-skewed tree should be in ascending order")
    }
}
