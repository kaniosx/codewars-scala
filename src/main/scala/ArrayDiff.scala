import scala.collection.mutable.ListBuffer

object ArrayDiff {
  def arrayDiff(a: Seq[Int], b: Seq[Int]): Seq[Int] = {
    val result: ListBuffer[Int] = new ListBuffer[Int]()

    for (elem <- a) {
      if (!b.contains(elem)) {
        result.addOne(elem)
      }
    }

    result.toList
  }
}
