// 8 kyu
// https://www.codewars.com/kata/55f9bca8ecaa9eac7100004a/train/scala

object Clock {
  def past(h: Int, m: Int, s: Int): Int = {
    1000 * (s + m * 60 + h * 60 * 60)
  }
}
