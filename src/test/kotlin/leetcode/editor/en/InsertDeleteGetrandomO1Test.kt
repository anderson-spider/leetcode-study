package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class InsertDeleteGetrandomO1Test {
    @Test
    @DisplayName("Test basic operations")
    fun testBasicOperations() {
        val randomizedSet = InsertDeleteGetrandomO1.RandomizedSet()

        // Insert 1, should return true as 1 is not in the set
        assertTrue(randomizedSet.insert(1), "Insert 1 should return true")

        // Remove 2, should return false as 2 is not in the set
        assertFalse(randomizedSet.remove(2), "Remove 2 should return false")

        // Insert 2, should return true as 2 is not in the set
        assertTrue(randomizedSet.insert(2), "Insert 2 should return true")

        // Get random, should return either 1 or 2
        val random1 = randomizedSet.getRandom()
        assertTrue(random1 == 1 || random1 == 2, "getRandom should return 1 or 2")

        // Remove 1, should return true as 1 is in the set
        assertTrue(randomizedSet.remove(1), "Remove 1 should return true")

        // Insert 2 again, should return false as 2 is already in the set
        assertFalse(randomizedSet.insert(2), "Insert 2 should return false")

        // Get random, should return 2 as it's the only element
        assertEquals(2, randomizedSet.getRandom(), "getRandom should return 2")
    }

    @Test
    @DisplayName("Test insert and remove multiple elements")
    fun testInsertAndRemoveMultipleElements() {
        val randomizedSet = InsertDeleteGetrandomO1.RandomizedSet()

        // Insert multiple elements
        assertTrue(randomizedSet.insert(10), "Insert 10 should return true")
        assertTrue(randomizedSet.insert(20), "Insert 20 should return true")
        assertTrue(randomizedSet.insert(30), "Insert 30 should return true")

        // Insert duplicate element
        assertFalse(randomizedSet.insert(20), "Insert 20 again should return false")

        // Remove elements
        assertTrue(randomizedSet.remove(20), "Remove 20 should return true")
        assertFalse(randomizedSet.remove(20), "Remove 20 again should return false")

        // Get random, should be either 10 or 30
        val random = randomizedSet.getRandom()
        assertTrue(random == 10 || random == 30, "getRandom should return 10 or 30")

        // Remove remaining elements
        assertTrue(randomizedSet.remove(10), "Remove 10 should return true")
        assertTrue(randomizedSet.remove(30), "Remove 30 should return true")

        // Insert after removing all elements
        assertTrue(randomizedSet.insert(40), "Insert 40 should return true")
        assertEquals(40, randomizedSet.getRandom(), "getRandom should return 40")
    }

    @Test
    @DisplayName("Test with negative values")
    fun testWithNegativeValues() {
        val randomizedSet = InsertDeleteGetrandomO1.RandomizedSet()

        // Insert negative values
        assertTrue(randomizedSet.insert(-5), "Insert -5 should return true")
        assertTrue(randomizedSet.insert(-10), "Insert -10 should return true")

        // Remove negative value
        assertTrue(randomizedSet.remove(-5), "Remove -5 should return true")

        // Get random, should be -10
        assertEquals(-10, randomizedSet.getRandom(), "getRandom should return -10")
    }

    @Test
    @DisplayName("Test with large values")
    fun testWithLargeValues() {
        val randomizedSet = InsertDeleteGetrandomO1.RandomizedSet()

        val maxValue = Int.MAX_VALUE
        val minValue = Int.MIN_VALUE

        // Insert large values
        assertTrue(randomizedSet.insert(maxValue), "Insert MAX_VALUE should return true")
        assertTrue(randomizedSet.insert(minValue), "Insert MIN_VALUE should return true")

        // Get random, should be either MAX_VALUE or MIN_VALUE
        val random = randomizedSet.getRandom()
        assertTrue(random == maxValue || random == minValue, "getRandom should return MAX_VALUE or MIN_VALUE")
    }

    @Test
    @DisplayName("Test random distribution")
    fun testRandomDistribution() {
        val randomizedSet = InsertDeleteGetrandomO1.RandomizedSet()

        // Insert values 1 to 5
        for (i in 1..5) {
            randomizedSet.insert(i)
        }

        // Count occurrences of each value
        val counts = IntArray(6) // 0-based, so we need 6 elements for values 1-5
        val iterations = 10000

        for (i in 1..iterations) {
            val random = randomizedSet.getRandom()
            counts[random]++
        }

        // Check that each value appears approximately the same number of times
        // We expect each value to appear about iterations/5 times
        val expected = iterations / 5
        val tolerance = expected * 0.2 // Allow 20% deviation

        for (i in 1..5) {
            assertTrue(
                counts[i] > expected - tolerance && counts[i] < expected + tolerance,
                "Value $i should appear approximately $expected times, but appeared ${counts[i]} times",
            )
        }
    }
}
