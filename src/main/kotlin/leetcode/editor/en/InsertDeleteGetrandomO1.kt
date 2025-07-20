package leetcode.editor.en

import java.lang.Math.pow
import kotlin.math.pow

//Implement the RandomizedSet class:
//
// 
// RandomizedSet() Initializes the RandomizedSet object. 
// bool insert(int val) Inserts an item val into the set if not present. 
//Returns true if the item was not present, false otherwise. 
// bool remove(int val) Removes an item val from the set if present. Returns 
//true if the item was present, false otherwise. 
// int getRandom() Returns a random element from the current set of elements (
//it's guaranteed that at least one element exists when this method is called). 
//Each element must have the same probability of being returned. 
// 
//
// You must implement the functions of the class such that each function works 
//in average O(1) time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", 
//"insert", "getRandom"]
//[[], [1], [2], [2], [], [1], [2], []]
//Output
//[null, true, false, true, 2, true, false, 2]
//
//Explanation
//RandomizedSet randomizedSet = new RandomizedSet();
//randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was 
//inserted successfully.
//randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
//randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now 
//contains [1,2].
//randomizedSet.getRandom(); // getRandom() should return either 1 or 2 
//randomly.
//randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now 
//contains [2].
//randomizedSet.insert(2); // 2 was already in the set, so return false.
//randomizedSet.getRandom(); // Since 2 is the only number in the set, 
//getRandom() will always return 2.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// At most 2 * 10⁵ calls will be made to insert, remove, and getRandom. 
// There will be at least one element in the data structure when getRandom is 
//called. 
// 
//
// Related Topics Array Hash Table Math Design Randomized 👍 9683 👎 677

object InsertDeleteGetrandomO1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val randomizedSet = RandomizedSet()
        assert(randomizedSet.insert(1)) { "Insert 1 should return true" }
        assert(!randomizedSet.remove(2)) { "Remove 2 should return false" }
        assert(randomizedSet.insert(2)) { "Insert 2 should return true" }
        val random1 = randomizedSet.getRandom()
        assert(random1 == 1 || random1 == 2) { "getRandom should return 1 or 2" }
        assert(randomizedSet.remove(1)) { "Remove 1 should return true" }
        assert(!randomizedSet.insert(2)) { "Insert 2 should return false" }
        assert(randomizedSet.getRandom() == 2) { "getRandom should return 2" }
        println("All test cases passed!")
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet() {
        val random = java.util.Random()
        val hashMap = mutableMapOf<Int, Int>()
        val array = IntArray(2 * 10.0.pow(5).toInt()) // at most 2 * 10^5 calls
        var size = 0

        fun insert(`val`: Int): Boolean {
            if (hashMap.contains(`val`)) {
                return false
            }
            hashMap.put(`val`, size)
            array[size++] = `val`
            return true
        }

        fun remove(`val`: Int): Boolean {
            val index = hashMap.remove(`val`)
                ?: return false

            val lastIndex = size - 1

            if (index != lastIndex) {
                val lastValue = array[lastIndex]
                hashMap[lastValue] = index
                array[index] = lastValue
            }

            size--

            return true
        }

        fun getRandom(): Int {
            return array[random.nextInt(size)]
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


}