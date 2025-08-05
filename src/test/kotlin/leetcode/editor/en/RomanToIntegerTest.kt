package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RomanToIntegerTest {
    private val solution = RomanToInteger.Solution()

    @Test
    @DisplayName("Test with simple Roman numeral")
    fun testSimpleRomanNumeral() {
        val input = "III"
        val result = solution.romanToInt(input)
        assertEquals(3, result, "romanToInt should correctly convert '$input' to 3")
    }

    @Test
    @DisplayName("Test with Roman numeral containing addition")
    fun testRomanNumeralWithAddition() {
        val input = "LVIII"
        val result = solution.romanToInt(input)
        assertEquals(58, result, "romanToInt should correctly convert '$input' to 58")
    }

    @Test
    @DisplayName("Test with Roman numeral containing subtraction")
    fun testRomanNumeralWithSubtraction() {
        val input = "MCMXCIV"
        val result = solution.romanToInt(input)
        assertEquals(1994, result, "romanToInt should correctly convert '$input' to 1994")
    }

    @Test
    @DisplayName("Test with single character Roman numeral")
    fun testSingleCharacterRomanNumeral() {
        val input = "V"
        val result = solution.romanToInt(input)
        assertEquals(5, result, "romanToInt should correctly convert '$input' to 5")
    }

    @Test
    @DisplayName("Test with all subtraction cases")
    fun testAllSubtractionCases() {
        // Test all six subtraction cases: IV(4), IX(9), XL(40), XC(90), CD(400), CM(900)
        val input = "IVIXXLXCCDCM"
        val result = solution.romanToInt(input)
        assertEquals(1443, result, "romanToInt should correctly handle all subtraction cases")
    }

    @Test
    @DisplayName("Test with maximum Roman numeral value")
    fun testMaximumRomanNumeralValue() {
        val input = "MMMCMXCIX" // 3999
        val result = solution.romanToInt(input)
        assertEquals(3999, result, "romanToInt should correctly convert the maximum value '$input' to 3999")
    }

    @Test
    @DisplayName("Test with consecutive subtraction patterns")
    fun testConsecutiveSubtractionPatterns() {
        val input = "CMXC" // 900 + 90 = 990
        val result = solution.romanToInt(input)
        assertEquals(990, result, "romanToInt should correctly handle consecutive subtraction patterns")
    }

    @Test
    @DisplayName("Test with repeated characters")
    fun testRepeatedCharacters() {
        val input = "XXX" // 10 + 10 + 10 = 30
        val result = solution.romanToInt(input)
        assertEquals(30, result, "romanToInt should correctly handle repeated characters")
    }

    @Test
    @DisplayName("Test with mixed addition and subtraction")
    fun testMixedAdditionAndSubtraction() {
        val input = "XLII" // 40 + 2 = 42
        val result = solution.romanToInt(input)
        assertEquals(42, result, "romanToInt should correctly handle mixed addition and subtraction")
    }
}
