import scala.collection.mutable.ListBuffer

object SumConsecutives {
  def sumConsecutives(xs: List[Int]): List[Int] = {
    var current: Int = 0
    var counter: Int = 0

    val result: ListBuffer[Int] = ListBuffer[Int]()

    for (x <- xs) {
      if (current != x) {
        result += current * counter
        counter = 0
      }
      current = x
      counter += 1
    }

    result.toList
  }
}
