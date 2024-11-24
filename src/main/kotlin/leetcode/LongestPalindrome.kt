package xyz.pubps.leetcode

class LongestPalindrome {
  /**
   * 주어진 문자열에서 가장 긴 팰린드롬 부분 문자열을 찾는 함수
   */
  fun longestPalindrome(s: String): String {
    // 문자열 길이가 2보다 작으면 그대로 반환
    if (s.length < 2) {
      return s
    }
    
    var maxLength = 0 // 가장 긴 팰린드롬의 길이
    var maxLeft = 0 // 팰린드롬의 시작 인덱스
    
    // 문자열의 각 인덱스에 대해 팰린드롬을 검사
    for (i in s.indices - 1) {
      var left = i
      var right = i
      // 홀수 길이의 팰린드롬 검사
      while (left >= 0 && right < s.length && s[left] == s[right]) {
        left--
        right++
      }
      
      // 최대 길이 업데이트
      if (maxLength < right - left - 1) {
        maxLeft = left + 1
        maxLength = right - left - 1
      }
      
      left = i
      right = i + 1
      // 짝수 길이의 팰린드롬 검사
      while (left >= 0 && right < s.length && s[left] == s[right]) {
        left--
        right++
      }
      
      // 최대 길이 업데이트
      if (maxLength < right - left - 1) {
        maxLength = right - left - 1
        maxLeft = left + 1
      }
    }
    
    // 가장 긴 팰린드롬 부분 문자열 반환
    return s.substring(maxLeft, maxLeft + maxLength)
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