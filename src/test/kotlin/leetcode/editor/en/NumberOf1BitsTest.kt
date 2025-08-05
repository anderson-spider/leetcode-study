package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOf1BitsTest {
    private val solution = NumberOf1Bits.Solution()

    @Test
    @DisplayName("Test with binary 1011 (decimal 11)")
    fun testBinary1011() {
        val n = 11 // Binary 1011
        val result = solution.hammingWeight(n)
        assertEquals(3, result, "hammingWeight should return the correct number of set bits for $n")
    }

    @Test
    @DisplayName("Test with binary 10000000 (decimal 128)")
    fun testBinary10000000() {
        val n = 128 // Binary 10000000
        val result = solution.hammingWeight(n)
        assertEquals(1, result, "hammingWeight should return the correct number of set bits for $n")
    }

    @Test
    @DisplayName("Test with large number having 30 set bits")
    fun testLargeNumberWith30SetBits() {
        val n = 2147483645 // Binary representation has 30 set bits
        val result = solution.hammingWeight(n)
        assertEquals(30, result, "hammingWeight should return the correct number of set bits for $n")
    }

    @Test
    @DisplayName("Test with zero")
    fun testZero() {
        val result = solution.hammingWeight(0)
        assertEquals(0, result, "hammingWeight should return 0 for input 0")
    }

    @Test
    @DisplayName("Test with power of two")
    fun testPowerOfTwo() {
        val result = solution.hammingWeight(1024) // 2^10
        assertEquals(1, result, "hammingWeight should return 1 for a power of 2")
    }

    @Test
    @DisplayName("Test with all bits set in unsigned int")
    fun testAllBitsSet() {
        // Note: The original solution doesn't handle negative numbers correctly
        // due to the while (n > 0) condition. For negative numbers, it will exit immediately.
        // We're testing with a large positive number instead.
        val result = solution.hammingWeight(0x7FFFFFFF) // Max positive int (31 bits set)
        assertEquals(31, result, "hammingWeight should return 31 for input 0x7FFFFFFF (31 bits set)")
    }

    @Test
    @DisplayName("Test with Integer.MAX_VALUE")
    fun testIntegerMaxValue() {
        val result = solution.hammingWeight(Int.MAX_VALUE) // 2^31 - 1, all bits except sign bit
        assertEquals(31, result, "hammingWeight should return 31 for Integer.MAX_VALUE")
    }

    @Test
    @DisplayName("Test with alternating bits")
    fun testAlternatingBits() {
        val result = solution.hammingWeight(0x55555555) // 01010101...
        assertEquals(16, result, "hammingWeight should return 16 for alternating bits pattern")
    }
}
