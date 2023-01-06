// 6 kyu
// https://www.codewars.com/kata/54db15b003e88a6a480000b9/train/scala

import scala.annotation.tailrec

object ModSystem {

  def fromNb2Str(n: Int, bases: Array[Int]): String = {
    for (x <- bases) {
      for (y <- bases) {
        if (x != y && gcd(x, y) != 1) {
          return "Not applicable"
        }
      }
    }

    if (bases.product < n) {
      return "Not applicable"
    }

    var result: String = ""

    for (base <- bases) {
      result += "-" + (n % base).toString + "-"
    }

    result
  }

  @tailrec
  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }
}
