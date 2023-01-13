// 6 kyu
// https://www.codewars.com/kata/554ca54ffa7d91b236000023/train/scala

import scala.collection.immutable.HashMap
import scala.collection.mutable.ListBuffer

object EnoughIsEnough {
  def deleteNth(elements: List[Int], maxOccurrences: Int): List[Int] =
    val result: ListBuffer[Int] = ListBuffer()

    elements.foreach(element => {
      if result.count(_ == element) < maxOccurrences then
        result += element
    })

    result.result()
}
