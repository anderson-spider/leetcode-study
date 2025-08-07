package leetcode.editor.en
// Given an m x n grid of characters board and a string word, return true if
// word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cells,
// where adjacent cells are horizontally or vertically neighboring. The same letter
// cell may not be used more than once.
//
//
// Example 1:
//
//
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
// Output: true
//
//
// Example 2:
//
//
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
// Output: true
//
//
// Example 3:
//
//
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
// Output: false
//
//
//
// Constraints:
//
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.
//
//
//
// Follow up: Could you use search pruning to make your solution faster with a
// larger board?
//
// Related Topics Array String Backtracking Depth-First Search Matrix 👍 16931 ?
// ? 719

object WordSearch {
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun exist(
            board: Array<CharArray>,
            word: String,
        ): Boolean {
            val charFreq = mutableMapOf<Char, Int>()
            for (row in board) {
                for (col in row) {
                    charFreq[col] = charFreq.getOrDefault(col, 0) + 1
                }
            }

            for (ch in word) {
                if (word.count { it == ch } > charFreq.getOrDefault(ch, 0)) {
                    return false
                }
            }

            for (row in board.indices) {
                for (col in board[0].indices) {
                    if (backtrack(board, word, row, col, 0)) {
                        return true
                    }
                }
            }

            return false
        }

        fun backtrack(
            board: Array<CharArray>,
            word: String,
            rowIdx: Int,
            colIdx: Int,
            wordIdx: Int,
        ): Boolean {
            if (wordIdx == word.length) return true

            if (rowIdx !in board.indices || colIdx !in board[0].indices || board[rowIdx][colIdx] != word[wordIdx]) return false

            val originalValue = board[rowIdx][colIdx]
            board[rowIdx][colIdx] = '#'

            val found =
                backtrack(board, word, rowIdx, colIdx - 1, wordIdx + 1) ||
                    // up
                    backtrack(board, word, rowIdx, colIdx + 1, wordIdx + 1) ||
                    // down
                    backtrack(board, word, rowIdx - 1, colIdx, wordIdx + 1) ||
                    // left
                    backtrack(board, word, rowIdx + 1, colIdx, wordIdx + 1) // right

            board[rowIdx][colIdx] = originalValue

            return found
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
