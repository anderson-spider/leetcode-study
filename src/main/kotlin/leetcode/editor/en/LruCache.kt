package leetcode.editor.en
// Design a data structure that follows the constraints of a Least Recently Used
// (LRU) cache.
//
// Implement the LRUCache class:
//
//
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//
// int get(int key) Return the value of the key if the key exists, otherwise
// return -1.
// void put(int key, int value) Update the value of the key if the key exists.
// Otherwise, add the key-value pair to the cache. If the number of keys exceeds
// the capacity from this operation, evict the least recently used key.
//
//
// The functions get and put must each run in O(1) average time complexity.
//
//
// Example 1:
//
//
// Input
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]
//
// Explanation
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1);    // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2);    // returns -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1);    // return -1 (not found)
// lRUCache.get(3);    // return 3
// lRUCache.get(4);    // return 4
//
//
//
// Constraints:
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 10⁴
// 0 <= value <= 10⁵
// At most 2 * 10⁵ calls will be made to get and put.
//
//
// Related Topics Hash Table Linked List Design Doubly-Linked List 👍 22141 👎 1
// 157

object LruCache {
    @JvmStatic
    fun main(args: Array<String>) {
        val lRUCache = LRUCache(2)
        lRUCache.put(1, 1)
        lRUCache.put(2, 2)
        check(lRUCache.get(1) == 1)
        lRUCache.put(3, 3)
        check(lRUCache.get(2) == -1)
        lRUCache.put(4, 4)
        check(lRUCache.get(1) == -1)
        check(lRUCache.get(3) == 3)
        check(lRUCache.get(4) == 4)
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Your LRUCache object will be instantiated and called as such:
     * var obj = LRUCache(capacity)
     * var param_1 = obj.get(key)
     * obj.put(key,value)
     */
    class LRUCache(
        private val capacity: Int,
        private val head: Node = Node(0, 0),
        private val tail: Node = Node(0, 0),
        private val map: HashMap<Int, Node> = HashMap((capacity / 0.75f).toInt() + 1),
    ) {
        class Node(
            var key: Int,
            var value: Int,
            var prev: Node? = null,
            var next: Node? = null,
        )

        init {
            head.next = tail
            tail.prev = head
        }

        private fun deleteNode(node: Node) {
            node.prev?.next = node.next
            node.next?.prev = node.prev
        }

        private fun addToHead(node: Node) {
            node.next = head.next
            node.next?.prev = node
            node.prev = head
            head.next = node
        }

        fun get(key: Int): Int {
            val node = map[key] ?: return -1
            deleteNode(node)
            addToHead(node)
            return node.value
        }

        fun put(
            key: Int,
            value: Int,
        ) {
            val node = map[key]
            if (node != null) {
                node.value = value
                deleteNode(node)
                addToHead(node)
            } else {
                val newNode = Node(key, value)
                if (map.size >= capacity) {
                    map.remove(tail.prev!!.key)
                    deleteNode(tail.prev!!)
                }
                map[key] = newNode
                addToHead(newNode)
            }
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
}
