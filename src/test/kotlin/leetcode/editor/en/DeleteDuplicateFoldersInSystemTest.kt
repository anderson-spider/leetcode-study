package leetcode.editor.en

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DeleteDuplicateFoldersInSystemTest {
    private val solution = DeleteDuplicateFoldersInSystem.Solution()

    @Test
    @DisplayName("Test with duplicate empty folders")
    fun testDuplicateEmptyFolders() {
        val paths =
            listOf(
                listOf("a"),
                listOf("c"),
                listOf("d"),
                listOf("a", "b"),
                listOf("c", "b"),
                listOf("d", "a"),
            )

        val result = solution.deleteDuplicateFolder(paths)

        val expected =
            listOf(
                listOf("d"),
                listOf("d", "a"),
            )

        assertPathsEqual(expected, result, "Should delete folders /a and /c with identical empty subfolder b")
    }

    @Test
    @DisplayName("Test with duplicate subfolders but unique parent folders")
    fun testDuplicateSubfolders() {
        val paths =
            listOf(
                listOf("a"),
                listOf("c"),
                listOf("a", "b"),
                listOf("c", "b"),
                listOf("a", "b", "x"),
                listOf("a", "b", "x", "y"),
                listOf("w"),
                listOf("w", "y"),
            )

        val result = solution.deleteDuplicateFolder(paths)

        val expected =
            listOf(
                listOf("c"),
                listOf("c", "b"),
                listOf("a"),
                listOf("a", "b"),
            )

        assertPathsEqual(expected, result, "Should delete folders /a/b/x and /w with identical empty subfolder y")
    }

    @Test
    @DisplayName("Test with all unique folders")
    fun testAllUniqueFolders() {
        val paths =
            listOf(
                listOf("a", "b"),
                listOf("c", "d"),
                listOf("c"),
                listOf("a"),
            )

        val result = solution.deleteDuplicateFolder(paths)

        val expected =
            listOf(
                listOf("c"),
                listOf("c", "d"),
                listOf("a"),
                listOf("a", "b"),
            )

        assertPathsEqual(expected, result, "Should not delete any folders as all are unique")
    }

    @Test
    @DisplayName("Test with nested duplicate structures")
    fun testNestedDuplicateStructures() {
        val paths =
            listOf(
                listOf("a"),
                listOf("a", "x"),
                listOf("a", "x", "y"),
                listOf("a", "z"),
                listOf("b"),
                listOf("b", "x"),
                listOf("b", "x", "y"),
                listOf("b", "z"),
            )

        val result = solution.deleteDuplicateFolder(paths)

        // Both /a and /b should be deleted as they have identical structures
        val expected = emptyList<List<String>>()

        assertPathsEqual(expected, result, "Should delete all folders as /a and /b have identical structures")
    }

    @Test
    @DisplayName("Test with single path")
    fun testSinglePath() {
        val paths =
            listOf(
                listOf("a", "b", "c"),
            )

        val result = solution.deleteDuplicateFolder(paths)

        val expected =
            listOf(
                listOf("a"),
                listOf("a", "b"),
                listOf("a", "b", "c"),
            )

        assertPathsEqual(expected, result, "Single path should return all folders in the path")
    }

    @Test
    @DisplayName("Test with multiple identical structures")
    fun testMultipleIdenticalStructures() {
        val paths =
            listOf(
                listOf("a"),
                listOf("a", "x"),
                listOf("b"),
                listOf("b", "x"),
                listOf("c"),
                listOf("c", "x"),
            )

        val result = solution.deleteDuplicateFolder(paths)

        // All folders should be deleted as they have identical structures
        val expected = emptyList<List<String>>()

        assertPathsEqual(expected, result, "Should delete all folders as all have identical structures")
    }

    /**
     * Helper function to assert that two lists of paths are equal, regardless of order
     */
    private fun assertPathsEqual(
        expected: List<List<String>>,
        actual: List<List<String>>,
        message: String,
    ) {
        assertEquals(expected.size, actual.size, "$message - Expected ${expected.size} paths but got ${actual.size}")

        // Convert to sets for order-independent comparison
        val expectedSet = expected.map { it.toList() }.toSet()
        val actualSet = actual.map { it.toList() }.toSet()

        assertTrue(expectedSet == actualSet, "$message - Path sets don't match. Expected: $expectedSet, Actual: $actualSet")
    }
}
