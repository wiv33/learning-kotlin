package xyz.pubps.leetcode.string

class LongestPalindrome {
  var left = 0
  var maxLen = 0
  fun longestPalindrome(s: String): String {
    val strLen = s.length
    if (strLen < 2) return s
    
    for (i in s.indices) {
      extendPalindrome(s, i, i + 1)
      extendPalindrome(s, i, i + 2)
    }
    
    return s.substring(left, left + maxLen)
  }
  
  fun extendPalindrome(str: String, j: Int, k: Int) {
    var l = j
    var r = k
    
    while (l >= 0 && r < str.length && str[l] == str[r]) {
      l--
      r++
    }
    
    if (maxLen < r - l - 1) {
      left = l + 1
      maxLen = r - l - 1
    }
  }
}

fun main() {
  val longestPalindrome = LongestPalindrome()
  // "xyzyx"의 가장 긴 팰린드롬 찾기
  val s = longestPalindrome.longestPalindrome("xyzyx")
  println("s = $s")
  
  // "cdbbbbdd"의 가장 긴 팰린드롬 찾기
  val s2 = longestPalindrome.longestPalindrome("cdbbbbdd")
  println("input length = ${"cdbbbbdd".length}, s2 = $s2")
}