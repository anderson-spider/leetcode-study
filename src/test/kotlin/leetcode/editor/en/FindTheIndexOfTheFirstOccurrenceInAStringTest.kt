package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindTheIndexOfTheFirstOccurrenceInAStringTest {
    private val solution = FindTheIndexOfTheFirstOccurrenceInAString.Solution()

    @Test
    @DisplayName("Test with match at beginning")
    fun testMatchAtBeginning() {
        val haystack = "sadbutsad"
        val needle = "sad"
        val result = solution.strStr(haystack, needle)

        assertEquals(0, result, "First occurrence of 'sad' in 'sadbutsad' should be at index 0")
    }

    @Test
    @DisplayName("Test with no match")
    fun testNoMatch() {
        val haystack = "leetcode"
        val needle = "leeto"
        val result = solution.strStr(haystack, needle)

        assertEquals(-1, result, "'leeto' does not occur in 'leetcode', should return -1")
    }

    @Test
    @DisplayName("Test with match at end")
    fun testMatchAtEnd() {
        val haystack = "hello"
        val needle = "lo"
        val result = solution.strStr(haystack, needle)

        assertEquals(3, result, "First occurrence of 'lo' in 'hello' should be at index 3")
    }

    @Test
    @DisplayName("Test with single character match")
    fun testSingleCharacterMatch() {
        val haystack = "aaaaa"
        val needle = "a"
        val result = solution.strStr(haystack, needle)

        assertEquals(0, result, "First occurrence of 'a' in 'aaaaa' should be at index 0")
    }

    @Test
    @DisplayName("Test with needle longer than haystack")
    fun testNeedleLongerThanHaystack() {
        val haystack = "abc"
        val needle = "abcd"
        val result = solution.strStr(haystack, needle)

        assertEquals(-1, result, "Needle 'abcd' is longer than haystack 'abc', should return -1")
    }

    @Test
    @DisplayName("Test with multiple occurrences")
    fun testMultipleOccurrences() {
        val haystack = "mississippi"
        val needle = "issi"
        val result = solution.strStr(haystack, needle)

        assertEquals(1, result, "First occurrence of 'issi' in 'mississippi' should be at index 1")
    }

    @Test
    @DisplayName("Test with match in the middle")
    fun testMatchInMiddle() {
        val haystack = "abcdefghi"
        val needle = "def"
        val result = solution.strStr(haystack, needle)

        assertEquals(3, result, "First occurrence of 'def' in 'abcdefghi' should be at index 3")
    }

    @Test
    @DisplayName("Test with empty needle")
    fun testEmptyNeedle() {
        val haystack = "hello"
        val needle = ""
        val result = solution.strStr(haystack, needle)

        assertEquals(0, result, "Empty needle should return 0")
    }

    @Test
    @DisplayName("Test with identical haystack and needle")
    fun testIdenticalHaystackAndNeedle() {
        val haystack = "hello"
        val needle = "hello"
        val result = solution.strStr(haystack, needle)

        assertEquals(0, result, "When haystack and needle are identical, should return 0")
    }

    @Test
    @DisplayName("Test with partial match followed by full match")
    fun testPartialMatchFollowedByFullMatch() {
        val haystack = "aabaaabaaac"
        val needle = "aabaaac"
        val result = solution.strStr(haystack, needle)

        assertEquals(4, result, "First occurrence of 'aabaaac' in 'aabaaabaaac' should be at index 4")
    }
}
