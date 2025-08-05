package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LruCacheTest {
    @Test
    @DisplayName("Test basic operations from example")
    fun testBasicOperations() {
        val lruCache = LruCache.LRUCache(2)

        // Initial puts
        lruCache.put(1, 1)
        lruCache.put(2, 2)

        // Get existing key
        assertEquals(1, lruCache.get(1), "Should return value 1 for key 1")

        // Put that evicts least recently used key (key 2)
        lruCache.put(3, 3)

        // Get evicted key
        assertEquals(-1, lruCache.get(2), "Should return -1 for evicted key 2")

        // Put that evicts least recently used key (key 1)
        lruCache.put(4, 4)

        // Get evicted key
        assertEquals(-1, lruCache.get(1), "Should return -1 for evicted key 1")

        // Get existing keys
        assertEquals(3, lruCache.get(3), "Should return value 3 for key 3")
        assertEquals(4, lruCache.get(4), "Should return value 4 for key 4")
    }

    @Test
    @DisplayName("Test with capacity 1")
    fun testCapacityOne() {
        val lruCache = LruCache.LRUCache(1)

        lruCache.put(1, 1)
        assertEquals(1, lruCache.get(1), "Should return value 1 for key 1")

        // This should evict key 1
        lruCache.put(2, 2)
        assertEquals(-1, lruCache.get(1), "Should return -1 for evicted key 1")
        assertEquals(2, lruCache.get(2), "Should return value 2 for key 2")
    }

    @Test
    @DisplayName("Test updating existing key")
    fun testUpdateExistingKey() {
        val lruCache = LruCache.LRUCache(2)

        lruCache.put(1, 1)
        lruCache.put(2, 2)

        // Update key 1
        lruCache.put(1, 10)
        assertEquals(10, lruCache.get(1), "Should return updated value 10 for key 1")

        // Key 1 is now most recently used, so key 2 should be evicted
        lruCache.put(3, 3)
        assertEquals(-1, lruCache.get(2), "Should return -1 for evicted key 2")
        assertEquals(10, lruCache.get(1), "Should return value 10 for key 1")
    }

    @Test
    @DisplayName("Test LRU eviction order")
    fun testLruEvictionOrder() {
        val lruCache = LruCache.LRUCache(3)

        lruCache.put(1, 1)
        lruCache.put(2, 2)
        lruCache.put(3, 3)

        // Access key 1, making it most recently used
        lruCache.get(1)

        // This should evict key 2 (least recently used)
        lruCache.put(4, 4)

        assertEquals(1, lruCache.get(1), "Should return value 1 for key 1")
        assertEquals(-1, lruCache.get(2), "Should return -1 for evicted key 2")
        assertEquals(3, lruCache.get(3), "Should return value 3 for key 3")
        assertEquals(4, lruCache.get(4), "Should return value 4 for key 4")
    }

    @Test
    @DisplayName("Test with larger capacity")
    fun testLargerCapacity() {
        val lruCache = LruCache.LRUCache(5)

        // Add 5 items
        for (i in 1..5) {
            lruCache.put(i, i * 10)
        }

        // Verify all items are present
        for (i in 1..5) {
            assertEquals(i * 10, lruCache.get(i), "Should return value ${i * 10} for key $i")
        }

        // Add a new item, should evict key 1
        lruCache.put(6, 60)

        assertEquals(-1, lruCache.get(1), "Should return -1 for evicted key 1")
        for (i in 2..6) {
            assertEquals(i * 10, lruCache.get(i), "Should return value ${i * 10} for key $i")
        }
    }

    @Test
    @DisplayName("Test with repeated access changing LRU order")
    fun testRepeatedAccess() {
        val lruCache = LruCache.LRUCache(3)

        lruCache.put(1, 1)
        lruCache.put(2, 2)
        lruCache.put(3, 3)

        // Access keys in reverse order
        lruCache.get(3)
        lruCache.get(2)
        lruCache.get(1)

        // Now key 3 is least recently used, key 1 is most recently used

        // This should evict key 3
        lruCache.put(4, 4)

        assertEquals(1, lruCache.get(1), "Should return value 1 for key 1")
        assertEquals(2, lruCache.get(2), "Should return value 2 for key 2")
        assertEquals(-1, lruCache.get(3), "Should return -1 for evicted key 3")
        assertEquals(4, lruCache.get(4), "Should return value 4 for key 4")
    }
}
