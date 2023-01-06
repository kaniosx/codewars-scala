import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.{break, breakable}

object Cubes {
  def isSumOfCubes(s: String): String = {
    val numbers = s.replaceAll("\\D", " ").split("\\s+")
    var result: ListBuffer[String] = ListBuffer[String]()

    for (number <- numbers) {
      breakable {
        if (number.isEmpty || result.contains(number)) {
          break
        }

        var sum: Int = 0

        for (num <- number.split("(?<=\\G...)")) {
          for (digit <- num) {
            val x = digit.toInt - 48
            sum += x * x * x
          }
        }

        if (sum == number.toInt) {
          result += number
        }
      }
    }

    if (result.nonEmpty) {
      return result.mkString(" ") + " Lucky"
    }

    "Unlucky"
  }
}
