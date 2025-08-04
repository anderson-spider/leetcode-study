package leetcode.editor.en

// Serialization is the process of converting a data structure or object into a
// sequence of bits so that it can be stored in a file or memory buffer, or
// transmitted across a network connection link to be reconstructed later in the same or
// another computer environment.
//
// Design an algorithm to serialize and deserialize a binary tree. There is no
// restriction on how your serialization/deserialization algorithm should work. You
// just need to ensure that a binary tree can be serialized to a string and this
// string can be deserialized to the original tree structure.
//
// Clarification: The input/output format is the same as how LeetCode
// serializes a binary tree. You do not necessarily need to follow this format, so please be
// creative and come up with different approaches yourself.
//
//
// Example 1:
//
//
// Input: root = [1,2,3,null,null,4,5]
// Output: [1,2,3,null,null,4,5]
//
//
// Example 2:
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
// The number of nodes in the tree is in the range [0, 10⁴].
// -1000 <= Node.val <= 1000
//
//
// Related Topics String Tree Depth-First Search Breadth-First Search Design
// Binary Tree 👍 10767 👎 421

object SerializeAndDeserializeBinaryTree {
    @JvmStatic
    fun main(args: Array<String>) {
        val codec = Codec()

        // Test case 1: Empty tree
        check(codec.deserialize(codec.serialize(null)) == null) { "Failed: Empty tree test" }

        // Test case 2: Single node tree
        val singleNode = TreeNode(1)
        check(codec.deserialize(codec.serialize(singleNode))?.`val` == 1) { "Failed: Single node test" }

        // Test case 3: Complete binary tree
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

        check(deserialized?.`val` == 1) { "Failed: Root value test" }
        check(deserialized.left?.`val` == 2) { "Failed: Left child test" }
        check(deserialized.right?.`val` == 3) { "Failed: Right child test" }
        check(deserialized.right?.left?.`val` == 4) { "Failed: Right-left child test" }
        check(deserialized.right?.right?.`val` == 5) { "Failed: Right-right child test" }

        println("All test cases passed!")
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     * Your Codec object will be instantiated and called as such:
     * var ser = Codec()
     * var deser = Codec()
     * var data = ser.serialize(longUrl)
     * var ans = deser.deserialize(data)
     */
    class Codec {
        // Encodes a URL to a shortened URL.
        fun serialize(root: TreeNode?): String {
            val sb = StringBuilder()
            serializeDfs(root, sb)
            return sb.substring(0, sb.length - 1)
        }

        fun serializeDfs(
            root: TreeNode?,
            sb: StringBuilder,
        ) {
            if (root == null) {
                sb.append("null,")
                return
            }

            sb.append("${root.`val`},")
            serializeDfs(root.left, sb)
            serializeDfs(root.right, sb)
        }

        // Decodes your encoded data to tree.
        fun deserialize(data: String): TreeNode? = deserializeDfs(data.split(',').iterator())

        fun deserializeDfs(i: Iterator<String>): TreeNode? {
            if (!i.hasNext()) {
                return null
            }

            val data = i.next().toIntOrNull() ?: return null
            val node = TreeNode(data)
            node.left = deserializeDfs(i)
            node.right = deserializeDfs(i)
            return node
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
}
