package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FirstUniqueCharacterInAStringTest {
    private val solution = FirstUniqueCharacterInAString.Solution()

    @Test
    @DisplayName("Test with standard case - leetcode")
    fun testStandardCase1() {
        val s = "leetcode"
        val result = solution.firstUniqChar(s)

        assertEquals(0, result, "First unique character in 'leetcode' should be at index 0 (character 'l')")
    }

    @Test
    @DisplayName("Test with standard case - loveleetcode")
    fun testStandardCase2() {
        val s = "loveleetcode"
        val result = solution.firstUniqChar(s)

        assertEquals(2, result, "First unique character in 'loveleetcode' should be at index 2 (character 'v')")
    }

    @Test
    @DisplayName("Test with no unique characters - aabb")
    fun testNoUniqueCharacters1() {
        val s = "aabb"
        val result = solution.firstUniqChar(s)

        assertEquals(-1, result, "String 'aabb' has no unique characters, should return -1")
    }

    @Test
    @DisplayName("Test with no unique characters - aa")
    fun testNoUniqueCharacters2() {
        val s = "aa"
        val result = solution.firstUniqChar(s)

        assertEquals(-1, result, "String 'aa' has no unique characters, should return -1")
    }

    @Test
    @DisplayName("Test with unique character in the middle - ccaccc")
    fun testUniqueCharacterInMiddle() {
        val s = "ccaccc"
        val result = solution.firstUniqChar(s)

        assertEquals(2, result, "First unique character in 'ccaccc' should be at index 2 (character 'a')")
    }

    @Test
    @DisplayName("Test with single character")
    fun testSingleCharacter() {
        val s = "z"
        val result = solution.firstUniqChar(s)

        assertEquals(0, result, "Single character string should return index 0")
    }

    @Test
    @DisplayName("Test with unique character at the end")
    fun testUniqueCharacterAtEnd() {
        val s = "aabccd"
        val result = solution.firstUniqChar(s)

        assertEquals(2, result, "First unique character in 'aabccd' should be at index 2 (character 'b')")
    }

    @Test
    @DisplayName("Test with all unique characters")
    fun testAllUniqueCharacters() {
        val s = "abcdefg"
        val result = solution.firstUniqChar(s)

        assertEquals(0, result, "When all characters are unique, should return the first index (0)")
    }

    @Test
    @DisplayName("Test with repeated characters in different positions")
    fun testRepeatedCharactersInDifferentPositions() {
        val s = "abca"
        val result = solution.firstUniqChar(s)

        assertEquals(1, result, "First unique character in 'abca' should be at index 1 (character 'b')")
    }
}
