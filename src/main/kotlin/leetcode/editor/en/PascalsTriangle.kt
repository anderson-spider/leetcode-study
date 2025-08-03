package leetcode.editor.en
// Given an integer numRows, return the first numRows of Pascal's triangle.
//
// In Pascal's triangle, each number is the sum of the two numbers directly
// above it as shown:
//
//
// Example 1:
// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
// Example 2:
// Input: numRows = 1
// Output: [[1]]
//
//
// Constraints:
//
//
// 1 <= numRows <= 30
//
//
// Related Topics Array Dynamic Programming 👍 14278 👎 532

object PascalsTriangle {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        // Test with numRows = 5
        println("Test with numRows = 5:")
        val result1 = solution.generate(5)
        println(result1)

        // Test with numRows = 1
        println("Test with numRows = 1:")
        val result2 = solution.generate(1)
        println(result2)
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun generate(numRows: Int): List<List<Int>> {
            val result = mutableListOf<List<Int>>()

            // Handle the first row
            result.add(listOf(1))

            // Generate the rest of the rows
            for (i in 1 until numRows) {
                val prevRow = result[i - 1]
                val currentRow = mutableListOf<Int>()

                // First element of each row is always 1
                currentRow.add(1)

                // Calculate middle elements based on the previous row
                for (j in 1 until i) {
                    currentRow.add(prevRow[j - 1] + prevRow[j])
                }

                // Last element of each row is always 1
                currentRow.add(1)

                result.add(currentRow)
            }

            return result
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
