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
