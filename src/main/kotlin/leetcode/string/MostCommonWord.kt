package xyz.pubps.leetcode.string

class MostCommonWord {
  /**
   * 1. Convert the paragraph to lowercase and split it into words
   *   정규식을 사용하여 문자열을 단어로 분리한다.  
   * 2. Filter out the banned words
   *   금지된 단어를 제외한다.
   * 3. Count the frequency of each word
   *   각 단어의 빈도를 계산한다.
   * 4. Return the word with the highest frequency
   *   가장 빈도가 높은 단어를 반환한다.
   */
  fun mostCommonWord(paragraph: String, banned: Array<String>): String {
    val wordCount = HashMap<String, Int>()

    paragraph.lowercase()
    .split("[!?',:;. ]".toRegex())
    .filter { it.isNotEmpty() && it !in banned }
    .forEach { wordCount[it] = (wordCount[it] ?: 0) + 1}

    return wordCount.maxByOrNull { it.value }?.key ?: ""
  }
}