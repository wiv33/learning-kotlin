package xyz.pubps.leetcode.string

class LogsV1 {
  /**
   * 1. Parse the logs into a list of triples (header, content, original log)
   *   세 개의 원소를 가지는 트리플을 만든다. 헤더는 첫 번째 단어, 내용은 두 번째 단어, 원본 로그는 그대로 저장한다.
   * 2. Separate the letter logs and digit logs
   *   문자열의 첫 번째 단어가 숫자인지 아닌지로 구분한다.
   * 3. Sort the letter logs by content and then by header
   *   문자열의 두 번째 단어로 정렬하고, 그래도 같으면 첫 번째 단어인 header로 정렬한다.
   * 4. Merge the sorted letter logs and digit logs
   *   정렬된 문자열과 숫자열을 합친다.
   * 5. Return the merged logs
   *   합쳐진 로그를 반환한다.
   */
  fun reorderLogFiles(logs: Array<String>): Array<String> {
    val parsedLogs = logs.map {
      val pivot = it.indexOf(" ")
      val header = it.substring(0, pivot)
      val content = it.substring(pivot + 1)
      Triple(header, content, it)
    }
    
    val letterLogs = mutableListOf<Triple<String, String, String>>()
    val digitLogs = mutableListOf<String>()
    
    for (log in parsedLogs) {
      if (log.second[0].isDigit()) {
        digitLogs.add(log.third)
      } else {
        letterLogs.add(log)
      }
    }
    
    return (letterLogs.sortedWith(compareBy<Triple<String, String, String>> {
      it.second
    }.thenBy { it.first })
      .map { it.third } + digitLogs)
      .toTypedArray()
  }
  
  /**
   * 1. Partition the logs into letter logs and digit logs
   *   문자열의 첫 번째 단어가 숫자인지 아닌지로 구분한다.
   * 2. Sort the letter logs by content and then by header
   *   문자열의 두 번째 단어로 정렬하고, 그래도 같으면 첫 번째 단어로 정렬한다.
   * 3. Merge the sorted letter logs and digit logs
   *   정렬된 문자열과 숫자열을 합친다.
   * 4. Return the merged logs
   *   합쳐진 로그를 반환한다.
   */
  fun reorderLogFiles2(logs: Array<String>): Array<String> {
    // partition은 바이너리 배열을 반환한다. // 더 많은 그룹이 필요한 경우, groupBy 사용
    return logs.partition { it.substringAfter(' ')[0].isLetter() }
      .let { (letters, digits) ->
        letters.sortedWith(
          // indexOf 대신 substringAfter, substringBefore 사용
          compareBy<String> { it.substringAfter(' ') }
            .thenBy { it.substringBefore(' ') }
        ).plus(digits)
      }.toTypedArray()
  }
}

fun main() {
  val logs = arrayOf(
    "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"
  )
  val result = LogsV1().reorderLogFiles(logs)
  for (log in result) {
    println(log)
  }
  
  println("================================================================")
  
  val res = LogsV1().reorderLogFiles2(logs)
  for (log in res) {
    println(log)
  }
}