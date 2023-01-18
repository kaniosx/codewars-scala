// 7 kyu
// https://www.codewars.com/kata/57eba158e8ca2c8aba0002a0/train/scala

object SortByLastChar {
  def last(s: String): Array[String] =
    s.split(" ").sortBy(x => x.reverse(0))
}
