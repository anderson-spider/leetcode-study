package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BinaryTreeLevelOrderTraversalTest {
    private val solution = BinaryTreeLevelOrderTraversal.Solution()
    private val treeNode = BinaryTreeLevelOrderTraversal::TreeNode

    @Test
    @DisplayName("Test with standard tree")
    fun testStandardTree() {
        // Create tree: [3,9,20,null,null,15,7]
        val root = treeNode(3)
        root.left = treeNode(9)
        root.right = treeNode(20)
        root.right?.left = treeNode(15)
        root.right?.right = treeNode(7)

        val result = solution.levelOrder(root)
        val expected = listOf(listOf(3), listOf(9, 20), listOf(15, 7))

        assertEquals(expected, result, "Level order traversal of [3,9,20,null,null,15,7] should be [[3],[9,20],[15,7]]")
    }

    @Test
    @DisplayName("Test with single node tree")
    fun testSingleNodeTree() {
        val root = treeNode(1)

        val result = solution.levelOrder(root)
        val expected = listOf(listOf(1))

        assertEquals(expected, result, "Level order traversal of single node tree should be [[1]]")
    }

    @Test
    @DisplayName("Test with empty tree")
    fun testEmptyTree() {
        val result = solution.levelOrder(null)
        val expected = emptyList<List<Int>>()

        assertEquals(expected, result, "Level order traversal of empty tree should be empty list")
    }

    @Test
    @DisplayName("Test with complete binary tree")
    fun testCompleteBinaryTree() {
        // Create tree: [1,2,3,4,5,6,7]
        val root = treeNode(1)
        root.left = treeNode(2)
        root.right = treeNode(3)
        root.left?.left = treeNode(4)
        root.left?.right = treeNode(5)
        root.right?.left = treeNode(6)
        root.right?.right = treeNode(7)

        val result = solution.levelOrder(root)
        val expected = listOf(listOf(1), listOf(2, 3), listOf(4, 5, 6, 7))

        assertEquals(expected, result, "Level order traversal should match the expected order")
    }

    @Test
    @DisplayName("Test with left-skewed tree")
    fun testLeftSkewedTree() {
        // Create tree: [1,2,null,3,null,4]
        val root = treeNode(1)
        root.left = treeNode(2)
        root.left?.left = treeNode(3)
        root.left?.left?.left = treeNode(4)

        val result = solution.levelOrder(root)
        val expected = listOf(listOf(1), listOf(2), listOf(3), listOf(4))

        assertEquals(expected, result, "Level order traversal of left-skewed tree should have each node in its own level")
    }

    @Test
    @DisplayName("Test with right-skewed tree")
    fun testRightSkewedTree() {
        // Create tree: [1,null,2,null,3,null,4]
        val root = treeNode(1)
        root.right = treeNode(2)
        root.right?.right = treeNode(3)
        root.right?.right?.right = treeNode(4)

        val result = solution.levelOrder(root)
        val expected = listOf(listOf(1), listOf(2), listOf(3), listOf(4))

        assertEquals(expected, result, "Level order traversal of right-skewed tree should have each node in its own level")
    }

    @Test
    @DisplayName("Test with unbalanced tree")
    fun testUnbalancedTree() {
        // Create tree: [3,9,20,null,null,15,7,null,null,null,null,10,null,20,30]
        val root = treeNode(3)
        root.left = treeNode(9)
        root.right = treeNode(20)
        root.right?.left = treeNode(15)
        root.right?.right = treeNode(7)
        root.right?.left?.left = treeNode(10)
        root.right
            ?.left
            ?.left
            ?.left = treeNode(20)
        root.right
            ?.left
            ?.left
            ?.right = treeNode(30)

        val result = solution.levelOrder(root)
        val expected =
            listOf(
                listOf(3),
                listOf(9, 20),
                listOf(15, 7),
                listOf(10),
                listOf(20, 30),
            )

        assertEquals(expected, result, "Level order traversal of unbalanced tree should match the expected order")
    }
}
