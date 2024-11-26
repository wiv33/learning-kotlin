package xyz.pubps.leetcode.linear

class TwoSum {
  fun twoSum(nums: IntArray, target: Int): IntArray {
    // key: nums 원소
    // value: nums index
    val map = mutableMapOf<Int, Int>()
    
    for (i in nums.indices) {
      // target - 현재 숫자가 존재하면 종료
      val key = target - nums[i]
      if (map.containsKey(key)) {
        // 이전 Key 값은 항상 존재
        return intArrayOf(map[key]!!, i)
      }
      map[nums[i]] = i
    }
    return intArrayOf()
  }
}

fun main() {
  val twoSum = TwoSum().twoSum(intArrayOf(2, 3, 4), 5)
  
  println(twoSum.joinToString { "$it" })
}