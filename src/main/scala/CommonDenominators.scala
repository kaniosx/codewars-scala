// 5 kyu
// https://www.codewars.com/kata/54d7660d2daf68c619000d95/train/scala

import scala.annotation.tailrec

object CommonDenominators {
  @tailrec
  private def gcd(a: Long, b: Long): Long = if (b == 0) a.abs else gcd(b, a % b)

  private def lcm(a: Long, b: Long) = (a * b).abs / gcd(a, b)

  def convertFrac(lst: Array[(Long, Long)]): String = {
    val denominator: Long = lst.map((x, y) => (x / gcd(x, y), y / gcd(x, y))).map((_, d) => d).reduce(lcm)
    lst.map((x, y) => (x * denominator / y, denominator)).mkString("")
  }
}
