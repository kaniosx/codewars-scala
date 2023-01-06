// 7 kyu
// https://www.codewars.com/kata/55f2b110f61eb01779000053/train/scala

object Sum {
  def getSum(a: Int, b: Int): Int = {
    var result = 0

    if (a <= b) {
      for (i <- a to b) {
        result += i
      }
    } else {
      for (i <- b to a) {
        result += i
      }
    }

    result
  }
}
