package leetcode.editor.en

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
// ', determine if the input string is valid.
//
// An input string is valid if:
//
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
//
//
//
// Example 1:
//
//
// Input: s = "()"
//
//
// Output: true
//
// Example 2:
//
//
// Input: s = "()[]{}"
//
//
// Output: true
//
// Example 3:
//
//
// Input: s = "(]"
//
//
// Output: false
//
// Example 4:
//
//
// Input: s = "([])"
//
//
// Output: true
//
//
// Constraints:
//
//
// 1 <= s.length <= 10⁴
// s consists of parentheses only '()[]{}'.
//
//
// Related Topics String Stack 👍 26091 👎 1905

object ValidParentheses {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        check(solution.isValid("()")) { "Test case 1 failed" }
        check(solution.isValid("()[]{}")) { "Test case 2 failed" }
        check(!solution.isValid("(]")) { "Test case 3 failed" }
        check(solution.isValid("([])")) { "Test case 4 failed" }
        check(!solution.isValid("([)]")) { "Test case 5 failed" }
        check(!solution.isValid("]")) { "Test case 6 failed" }
        check(solution.isValid("")) { "Test case 7 failed" }
        println("All test cases passed!")
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isValid(s: String): Boolean {
            val stack = ArrayDeque<Char>()

            for (c in s) {
                when (c) {
                    '(', '[', '{' -> stack.addLast(c)
                    ')' -> if (stack.isEmpty() || stack.removeLast() != '(') return false
                    ']' -> if (stack.isEmpty() || stack.removeLast() != '[') return false
                    '}' -> if (stack.isEmpty() || stack.removeLast() != '{') return false
                }
            }

            return stack.isEmpty()
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
