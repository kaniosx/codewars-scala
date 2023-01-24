// 6 kyu
// https://www.codewars.com/kata/5873b2010565844b9100026d/train/scala

import scala.collection.mutable.ListBuffer

object EasyChallenge {
  def oneTwoThree(n: Int): List[String] =
    val result: ListBuffer[String] = new ListBuffer[String]()

    if n <= 9 then result += n.toString
    else {
      var copy: Int = n
      val firstElement: StringBuffer = new StringBuffer()

      while (copy > 9) {
        firstElement.append("9")
        copy -= 9

        if (copy <= 9 && copy > 0) {
          firstElement.append(copy.toString)
        }
      }

      result += firstElement.toString
    }

    if n == 0 then result += "0"
    else result += "1" * n

    result.result()
}
