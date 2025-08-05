# LeetCode Study Project Guidelines

This document provides guidelines and information for developing and maintaining the LeetCode Study project.

## Build and Configuration

### Project Setup

- **Kotlin Version**: 2.1.21
- **JVM Toolchain**: Java 21
- **Build System**: Gradle (Kotlin DSL)

### Building the Project

```bash
# Build the project
./gradlew build

# Clean and rebuild
./gradlew clean build
```

### Dependencies

The project uses the following key dependencies:

- JUnit 5 (5.10.0) for testing
- Kotlin Test with JUnit 5 integration
- ktlint (13.0.0) for code style enforcement

## Testing

### Running Tests

```bash
# Run all tests
./gradlew test

# Run a specific test class
./gradlew test --tests "leetcode.editor.en.ValidPalindromeTest"

# Run tests with a specific pattern
./gradlew test --tests "*Palindrome*"
```

### Test Structure

Tests follow a consistent structure:

1. Test classes are named after the problem with a "Test" suffix (e.g., `ValidPalindromeTest`)
2. Test classes are placed in the same package structure as the implementation but in the test source set
3. Each test class creates an instance of the Solution class from the corresponding problem object

### Test Methods

The project uses individual test methods:

```kotlin
@Test
@DisplayName("Test with empty string")
fun testEmptyString() {
    val result = solution.isPalindrome("")
    assertEquals(true, result, "Empty string should be considered a palindrome")
}

@Test
@DisplayName("Test with standard case")
fun testStandardCase() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    val result = solution.twoSum(nums, target)
    val expected = intArrayOf(0, 1)
    assertTrue(
        result.contentEquals(expected),
        "twoSum should correctly find indices of two numbers that add up to $target"
    )
}
```

### Adding New Tests

When adding a new test for a LeetCode problem:

1. Create a test class in the `src/test/kotlin/leetcode/editor/en/` directory with the name `[ProblemName]Test.kt`
2. Create individual test methods for different test cases
3. Include descriptive test names and meaningful assertion messages
4. Run the test to verify it works: `./gradlew test --tests "leetcode.editor.en.[ProblemName]Test"`

### Example: Creating a Test for a New Problem

Here's an example of creating a test for the TwoSum problem:

```kotlin
// File: TwoSumTest.kt

class TwoSumTest {
    private val solution = TwoSum.Solution()

    @Test
    @DisplayName("Test with standard case")
    fun testStandardCase() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val result = solution.twoSum(nums, target)
        val expected = intArrayOf(0, 1)
        assertTrue(
            result.contentEquals(expected),
            "twoSum should correctly find indices of two numbers that add up to $target"
        )
    }

    @Test
    @DisplayName("Test with numbers not in order")
    fun testNumbersNotInOrder() {
        val nums = intArrayOf(3, 2, 4)
        val target = 6
        val result = solution.twoSum(nums, target)
        val expected = intArrayOf(1, 2)
        assertTrue(
            result.contentEquals(expected),
            "twoSum should correctly find indices of two numbers that add up to $target"
        )
    }

    @Test
    @DisplayName("Test with duplicate numbers")
    fun testDuplicateNumbers() {
        val nums = intArrayOf(3, 3)
        val target = 6
        val result = solution.twoSum(nums, target)
        val expected = intArrayOf(0, 1)
        assertTrue(
            result.contentEquals(expected),
            "twoSum should correctly find indices of two numbers that add up to $target"
        )
    }

    @Test
    @DisplayName("Test with negative numbers")
    fun testNegativeNumbers() {
        val nums = intArrayOf(-1, -2, -3, -4, -5)
        val target = -8
        val result = solution.twoSum(nums, target)

        // Expected: indices of 2 and 4 (values -3 and -5)
        val expected = intArrayOf(2, 4)
        assertTrue(
            result.contentEquals(expected),
            "twoSum should work with negative numbers"
        )
    }
}
```

## Code Style and Development Guidelines

### Code Style

The project uses ktlint for code style enforcement. The style is based on
the [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html).

```bash
# Check code style
./gradlew ktlintCheck

# Format code automatically
./gradlew ktlintFormat
```

### LeetCode Problem Structure

Each LeetCode problem follows a consistent structure:

1. The problem is wrapped in an object named after the problem (e.g., `ValidPalindrome`)
2. The actual solution is in a nested `Solution` class
3. The solution code is marked with special comments: `leetcode submit region begin/end`
4. Many problems include a `main` method with simple test cases for manual testing

Example:

```kotlin
object ValidPalindrome {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        // Test cases...
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isPalindrome(s: String): Boolean {
            // Solution implementation...
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
```

### Adding a New LeetCode Problem

When adding a new LeetCode problem:

1. Create a new Kotlin file in `src/main/kotlin/leetcode/editor/en/` with the name of the problem
2. Follow the existing structure (object, Solution class, etc.)
3. Implement the solution within the `Solution` class
4. Add test cases in the `main` method for quick manual testing
5. Create a corresponding test class in the test source set

### Debugging Tips

- Use the `main` method in the problem object for quick manual testing
- Add print statements to debug specific cases
- Run tests with the `--info` or `--debug` flag for more detailed output: `./gradlew test --info`