package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WordSearchTest {
    private val solution = WordSearch.Solution()

    @Test
    @DisplayName("Test with word that exists in the grid")
    fun testWordExists() {
        val board =
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E'),
            )
        val word = "ABCCED"
        val result = solution.exist(board, word)
        assertTrue(result, "Should correctly identify that the word exists in the grid")
    }

    @Test
    @DisplayName("Test with another word that exists in the grid")
    fun testAnotherWordExists() {
        val board =
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E'),
            )
        val word = "SEE"
        val result = solution.exist(board, word)
        assertTrue(result, "Should correctly identify that the word exists in the grid")
    }

    @Test
    @DisplayName("Test with word that doesn't exist in the grid")
    fun testWordDoesNotExist() {
        val board =
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E'),
            )
        val word = "ABCB"
        val result = solution.exist(board, word)
        assertFalse(result, "Should correctly identify that the word doesn't exist in the grid")
    }

    @Test
    @DisplayName("Test with single cell grid")
    fun testSingleCellGrid() {
        val board =
            arrayOf(
                charArrayOf('A'),
            )
        val word = "A"
        val result = solution.exist(board, word)
        assertTrue(result, "Should correctly identify that the word exists in a single cell grid")
    }

    @Test
    @DisplayName("Test with word longer than grid capacity")
    fun testWordLongerThanGridCapacity() {
        val board =
            arrayOf(
                charArrayOf('A', 'B'),
                charArrayOf('C', 'D'),
            )
        val word = "ABCDE"
        val result = solution.exist(board, word)
        assertFalse(result, "Should correctly identify that the word is too long to exist in the grid")
    }

    @Test
    @DisplayName("Test with word that requires reusing cells")
    fun testWordRequiresReusingCells() {
        val board =
            arrayOf(
                charArrayOf('A', 'B', 'C'),
                charArrayOf('D', 'E', 'F'),
                charArrayOf('G', 'H', 'I'),
            )
        val word = "ABEHEBA" // This would require reusing 'E'
        val result = solution.exist(board, word)
        assertFalse(result, "Should correctly identify that the word can't be formed without reusing cells")
    }

    @Test
    @DisplayName("Test with empty word")
    fun testEmptyWord() {
        val board =
            arrayOf(
                charArrayOf('A', 'B'),
                charArrayOf('C', 'D'),
            )
        val word = ""
        val result = solution.exist(board, word)
        assertTrue(result, "Should handle empty word correctly")
    }
}
