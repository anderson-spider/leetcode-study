package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HouseRobberIiiTest {
    private val solution = HouseRobberIii.Solution()

    @Test
    @DisplayName("Test with example 1 - [3,2,3,null,3,null,1]")
    fun testExample1() {
        // Create tree: [3,2,3,null,3,null,1]
        val root = TreeNode(3)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left?.right = TreeNode(3)
        root.right?.right = TreeNode(1)

        val result = solution.rob(root)

        assertEquals(7, result, "Maximum amount should be 3 + 3 + 1 = 7")
    }

    @Test
    @DisplayName("Test with example 2 - [3,4,5,1,3,null,1]")
    fun testExample2() {
        // Create tree: [3,4,5,1,3,null,1]
        val root = TreeNode(3)
        root.left = TreeNode(4)
        root.right = TreeNode(5)
        root.left?.left = TreeNode(1)
        root.left?.right = TreeNode(3)
        root.right?.right = TreeNode(1)

        val result = solution.rob(root)

        assertEquals(9, result, "Maximum amount should be 4 + 5 = 9")
    }

    @Test
    @DisplayName("Test with single node")
    fun testSingleNode() {
        val root = TreeNode(5)

        val result = solution.rob(root)

        assertEquals(5, result, "With a single node, maximum amount should be the node value")
    }

    @Test
    @DisplayName("Test with null root")
    fun testNullRoot() {
        val result = solution.rob(null)

        assertEquals(0, result, "With a null root, maximum amount should be 0")
    }

    @Test
    @DisplayName("Test with simple tree - [2,1,3]")
    fun testSimpleTree() {
        // Create tree: [2,1,3]
        val root = TreeNode(2)
        root.left = TreeNode(1)
        root.right = TreeNode(3)

        val result = solution.rob(root)

        assertEquals(4, result, "Maximum amount should be 1 + 3 = 4")
    }

    @Test
    @DisplayName("Test with left-skewed tree")
    fun testLeftSkewedTree() {
        // Create tree: [3,2,null,1]
        val root = TreeNode(3)
        root.left = TreeNode(2)
        root.left?.left = TreeNode(1)

        val result = solution.rob(root)

        assertEquals(4, result, "Maximum amount should be 3 + 1 = 4")
    }

    @Test
    @DisplayName("Test with right-skewed tree")
    fun testRightSkewedTree() {
        // Create tree: [3,null,2,null,1]
        val root = TreeNode(3)
        root.right = TreeNode(2)
        root.right?.right = TreeNode(1)

        val result = solution.rob(root)

        assertEquals(4, result, "Maximum amount should be 3 + 1 = 4")
    }

    @Test
    @DisplayName("Test with all zeros")
    fun testAllZeros() {
        // Create tree: [0,0,0]
        val root = TreeNode(0)
        root.left = TreeNode(0)
        root.right = TreeNode(0)

        val result = solution.rob(root)

        assertEquals(0, result, "With all zeros, maximum amount should be 0")
    }

    @Test
    @DisplayName("Test with alternating values")
    fun testAlternatingValues() {
        // Create a tree where alternating levels have high/low values
        // to test the dynamic programming logic
        val root = TreeNode(5)
        root.left = TreeNode(10)
        root.right = TreeNode(10)
        root.left?.left = TreeNode(1)
        root.left?.right = TreeNode(1)
        root.right?.left = TreeNode(1)
        root.right?.right = TreeNode(1)

        val result = solution.rob(root)

        // The optimal solution is to rob the two nodes with value 10
        assertEquals(20, result, "Maximum amount should be 2*10 = 20")
    }

    @Test
    @DisplayName("Test with balanced tree")
    fun testBalancedTree() {
        // Create a balanced tree with predictable values
        val root = TreeNode(3)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left?.left = TreeNode(1)
        root.right?.right = TreeNode(1)

        val result = solution.rob(root)

        // The optimal solution would be to rob the root and its grandchildren
        // 3 + 1 + 1 = 5
        assertEquals(5, result, "Should correctly handle a balanced tree")
    }
}
