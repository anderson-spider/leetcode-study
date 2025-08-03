package leetcode.editor.en

object PascalsTriangle {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        println("Test with numRows = 5:")
        val result1 = solution.generate(5)
        println(result1)

        println("Test with numRows = 1:")
        val result2 = solution.generate(1)
        println(result2)
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun generate(numRows: Int): List<List<Int>> {
            val triangle = mutableListOf<List<Int>>()
            triangle.add(listOf(1))
            for (rowIndex in 1 until numRows) {
                val previousRow = triangle[rowIndex - 1]
                val newRow = mutableListOf<Int>()
                newRow.add(1)
                for (colIndex in 1 until rowIndex) {
                    newRow.add(previousRow[colIndex - 1] + previousRow[colIndex])
                }
                newRow.add(1)
                triangle.add(newRow)
            }

            return triangle
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
