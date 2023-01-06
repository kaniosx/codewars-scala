import scala.collection.mutable.ListBuffer

object TripleTrouble {
  def tripleDouble(num1: Long, num2: Long): Int = {
    var current: Int = 0
    var counter: Int = 0

    val triples: ListBuffer[Int] = ListBuffer()
    val doubles: ListBuffer[Int] = ListBuffer()

    for (digit <- num1.toString.split("")) {
      if (digit.toInt == current) {
        counter += 1

        if (counter == 3) {
          triples.addOne(current)
          counter = 0
        }
      } else {
        current = digit.toInt
        counter = 1
      }
    }

    counter = 0

    for (digit <- num2.toString.split("")) {
      if (digit.toInt == current) {
        counter += 1

        if (counter == 2 && triples.contains(current)) {
          doubles.addOne(current)
          counter = 0
        }
      } else {
        current = digit.toInt
        counter = 1
      }
    }

    println(doubles)
    println(triples)

    doubles.length
  }
}
