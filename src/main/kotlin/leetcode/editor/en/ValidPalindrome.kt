package leetcode.editor.en
//A phrase is a palindrome if, after converting all uppercase letters into 
//lowercase letters and removing all non-alphanumeric characters, it reads the same 
//forward and backward. Alphanumeric characters include letters and numbers. 
//
// Given a string s, return true if it is a palindrome, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric 
//characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s consists only of printable ASCII characters. 
// 
//
// Related Topics Two Pointers String 👍 10549 👎 8565

object ValidPalindrome {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()

        // Test case 1: Valid palindrome with special characters
        val test1 = "A man, a plan, a canal: Panama"
        println("Test case 1: ${solution.isPalindrome(test1)} (Expected: true)")

        // Test case 2: Invalid palindrome
        val test2 = "race a car"
        println("Test case 2: ${solution.isPalindrome(test2)} (Expected: false)")

        // Test case 3: Empty string with spaces
        val test3 = " "
        println("Test case 3: ${solution.isPalindrome(test3)} (Expected: true)")

        // Test case 4: Alphanumeric palindrome
        val test4 = "A1b2c2b1a"
        println("Test case 4: ${solution.isPalindrome(test4)} (Expected: true)")
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isPalindrome(s: String): Boolean {
            if (s.isEmpty()) return true

            val filtered = s.lowercase().filter { it.isLetterOrDigit() }
            var left = 0
            var right = filtered.length - 1

            while (left < right) {
                if (filtered[left] != filtered[right]) {
                    return false
                }
                left++
                right--
            }

            return true
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}