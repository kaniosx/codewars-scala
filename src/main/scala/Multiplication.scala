// 6 kyu
// https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec/train/scala

object Multiplication {
  def persistence(n: Int): Int = {
    var counter: Int = 0
    var single: Int = 1
    var base: Int = n

    while (base >= 10) {
      for (strDigit <- base.toString.split("")) {
        single *= strDigit.toInt
      }

      base = single
      single = 1
      counter += 1
    }

    counter
  }
}
