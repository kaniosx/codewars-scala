// 6 kyu
// https://www.codewars.com/kata/581ee0db1bbdd04e010002fd/train/scala

object ApproxInter {
  def interp(f: Double => Double, l: Double, u: Double, n: Int): String =
    (for i <- 0 until n yield (math floor f(l + i * (u - l) / n) * 100) / 100).mkString(", ")
}
