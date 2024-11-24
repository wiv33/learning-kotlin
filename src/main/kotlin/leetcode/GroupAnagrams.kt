package xyz.pubps.leetcode

class GroupAnagrams {
  /**
   * 1. sort each string
   *  각 문자열 정렬
   * 2. use the sorted string as a key
   *  정렬된 문자열을 key로 선언
   * 3. put the original string into the list of the key
   *  key가 존재하지 않으면 새로운 mutable list를, 있으면 기존 list를 반환
   *  반환된 list에 애너그램 추가.
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
