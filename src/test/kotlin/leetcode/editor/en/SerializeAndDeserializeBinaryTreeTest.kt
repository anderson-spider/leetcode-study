package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class SerializeAndDeserializeBinaryTreeTest {
    private val codec = SerializeAndDeserializeBinaryTree.Codec()

    @Test
    @DisplayName("Test with empty tree")
    fun testEmptyTree() {
        val serialized = codec.serialize(null)
        val deserialized = codec.deserialize(serialized)
        assertNull(deserialized, "Deserialized empty tree should be null")
    }

    @Test
    @DisplayName("Test with single node tree")
    fun testSingleNodeTree() {
        val root = TreeNode(1)
        val serialized = codec.serialize(root)
        val deserialized = codec.deserialize(serialized)

        assertNotNull(deserialized, "Deserialized tree should not be null")
        assertEquals(1, deserialized.`val`, "Root value should be 1")
        assertNull(deserialized.left, "Left child should be null")
        assertNull(deserialized.right, "Right child should be null")
    }

    @Test
    @DisplayName("Test with complete binary tree")
    fun testCompleteBinaryTree() {
        val root =
            TreeNode(1).apply {
                left = TreeNode(2)
                right =
                    TreeNode(3).apply {
                        left = TreeNode(4)
                        right = TreeNode(5)
                    }
            }

        val serialized = codec.serialize(root)
        val deserialized = codec.deserialize(serialized)

        assertNotNull(deserialized, "Deserialized tree should not be null")
        assertEquals(1, deserialized.`val`, "Root value should be 1")

        assertNotNull(deserialized.left, "Left child should not be null")
        assertEquals(2, deserialized.left?.`val`, "Left child value should be 2")

        assertNotNull(deserialized.right, "Right child should not be null")
        assertEquals(3, deserialized.right?.`val`, "Right child value should be 3")

        assertNotNull(deserialized.right?.left, "Right-left child should not be null")
        assertEquals(4, deserialized.right?.left?.`val`, "Right-left child value should be 4")

        assertNotNull(deserialized.right?.right, "Right-right child should not be null")
        assertEquals(5, deserialized.right?.right?.`val`, "Right-right child value should be 5")
    }
}
