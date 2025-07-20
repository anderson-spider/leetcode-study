# Kotlin Array Rotation Algorithm - LeetCode Solution

## Overview

This Kotlin code implements an efficient solution for the **Array Rotation** problem from LeetCode. The algorithm uses the **triple reversal technique** to rotate an array `k` positions to the right with O(n) time complexity and O(1) space complexity.

## Algorithm Breakdown

### Main Function `rotate`

```kotlin
fun rotate(nums: IntArray, k: Int): Unit {
    val n = nums.size
    val rotations = k % n  // Optimization for k > n
    
    // Step 1: Reverse the entire array
    reverse(nums = nums, start = 0, end = n - 1)
    
    // Step 2: Reverse the first k elements
    reverse(nums = nums, start = 0, end = rotations - 1)
    
    // Step 3: Reverse the remaining elements
    reverse(nums = nums, start = rotations, end = n - 1)
}
```


**Key optimization**: `k % n` ensures the algorithm works correctly even when `k` is greater than the array size (since rotating `n` positions returns to the original state).

### Helper Function `reverse`

```kotlin
fun reverse(nums: IntArray, start: Int, end: Int) {
    var left = start
    var right = end
    while (left < right) {
        val temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp
        left++
        right--
    }
}
```


This function reverses the elements in the array between positions `start` and `end` (inclusive).

## Step-by-Step Example

Let's rotate `[1,2,3,4,5,6,7]` by `k = 3` positions:

**Initial state**: `[1,2,3,4,5,6,7]`

1. **Reverse entire array**: `[7,6,5,4,3,2,1]`
2. **Reverse first 3 elements**: `[5,6,7,4,3,2,1]`
3. **Reverse remaining elements**: `[5,6,7,1,2,3,4]`

**Final result**: `[5,6,7,1,2,3,4]` ✅

## Algorithm Advantages

- **Efficiency**: O(n) time complexity, O(1) space complexity
- **In-place**: Modifies the original array without using additional space
- **Elegant**: Uses a clever mathematical trick with reversals
- **Robust**: Works for any value of `k`

## How It Works

The triple reversal technique works because:
1. When you reverse the entire array, elements that should end up at the beginning are moved to the front
2. The first reversal of `k` elements puts them in the correct order
3. The second reversal of the remaining elements also puts them in the correct order

This approach transforms the problem of rotation into three simple reversal operations, making it both efficient and easy to understand.

## Complexity Analysis

- **Time Complexity**: O(n) - We visit each element a constant number of times
- **Space Complexity**: O(1) - Only using a few variables for the reversal process

This is one of the most efficient solutions for the array rotation problem!