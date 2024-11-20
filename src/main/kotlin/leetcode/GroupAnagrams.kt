package xyz.pubps.leetcode

class GroupAnagrams {
  /**
   * 1. sort each string
   * 2. use the sorted string as a key
   * 3. put the original string into the list of the key
   */
  fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val result = mutableMapOf<String, List<String>>()
    for (str in strs) {
      val key = str.toCharArray().sorted().joinToString("")
      
      result.getOrPut(key) { mutableListOf() }
        .also {
          result[key] = it.plus(str)
        }
    }
    return ArrayList(result.values)
  }
}
