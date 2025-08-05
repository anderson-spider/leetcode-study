package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PathSumTest {
    private val solution = PathSum.Solution()

    @Test
    @DisplayName("Test with path sum exists")
    fun testPathSumExists() {
        // Create tree: [5,4,8,11,null,13,4,7,2,null,null,null,1]
        val root =
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

        val targetSum = 22
        val result = solution.hasPathSum(root, targetSum)

        assertTrue(result, "Should find a path with sum 22 (5->4->11->2)")
    }

    @Test
    @DisplayName("Test with no path sum exists")
    fun testNoPathSumExists() {
        // Create tree: [1,2,3]
        val root =
            TreeNode(1).apply {
                left = TreeNode(2)
                right = TreeNode(3)
            }

        val targetSum = 5
        val result = solution.hasPathSum(root, targetSum)

        assertFalse(result, "Should not find a path with sum 5")
    }

    @Test
    @DisplayName("Test with empty tree")
    fun testEmptyTree() {
        val root = null
        val targetSum = 0
        val result = solution.hasPathSum(root, targetSum)

        assertFalse(result, "Empty tree should return false for any target sum")
    }

    @Test
    @DisplayName("Test with single node tree - matching sum")
    fun testSingleNodeTreeMatchingSum() {
        val root = TreeNode(5)
        val targetSum = 5
        val result = solution.hasPathSum(root, targetSum)

        assertTrue(result, "Single node tree with value equal to target sum should return true")
    }

    @Test
    @DisplayName("Test with single node tree - non-matching sum")
    fun testSingleNodeTreeNonMatchingSum() {
        val root = TreeNode(5)
        val targetSum = 10
        val result = solution.hasPathSum(root, targetSum)

        assertFalse(result, "Single node tree with value not equal to target sum should return false")
    }

    @Test
    @DisplayName("Test with negative values in tree")
    fun testNegativeValuesInTree() {
        // Create tree with negative values: [10,-5,8,-3,null,null,2]
        val root =
            TreeNode(10).apply {
                left =
                    TreeNode(-5).apply {
                        left = TreeNode(-3)
                    }
                right =
                    TreeNode(8).apply {
                        right = TreeNode(2)
                    }
            }

        val targetSum = 2 // Path: 10 -> -5 -> -3
        val result = solution.hasPathSum(root, targetSum)

        assertTrue(result, "Should find a path with sum 2 (10->-5->-3)")
    }

    @Test
    @DisplayName("Test with negative target sum")
    fun testNegativeTargetSum() {
        // Create tree: [1,-2,3]
        val root =
            TreeNode(1).apply {
                left = TreeNode(-2)
                right = TreeNode(3)
            }

        val targetSum = -1 // Path: 1 -> -2
        val result = solution.hasPathSum(root, targetSum)

        assertTrue(result, "Should find a path with sum -1 (1->-2)")
    }

    @Test
    @DisplayName("Test with path sum exists but not to leaf")
    fun testPathSumExistsButNotToLeaf() {
        // Create tree: [5,4,8,11,null,13,4,7,2,null,null,null,1]
        val root =
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

        val targetSum = 9 // Path: 5 -> 4 (sum = 9, but 4 is not a leaf)
        val result = solution.hasPathSum(root, targetSum)

        assertFalse(result, "Should not find a path with sum 9 because it doesn't end at a leaf")
    }

    @Test
    @DisplayName("Test with multiple valid paths")
    fun testMultipleValidPaths() {
        // Create tree: [5,4,8,11,null,13,4,7,2,null,null,null,1]
        val root =
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

        val targetSum = 26 // Two paths: 5->8->13 and 5->4->11->7
        val result = solution.hasPathSum(root, targetSum)

        assertTrue(result, "Should find at least one path with sum 26")
    }
}
