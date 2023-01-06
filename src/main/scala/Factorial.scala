object Factorial {
  def !(n: Int): BigInt = {
    if (n <= 1) {
      return 1
    }

    var result: BigInt = 1

    for (i <- 2 to n) {
      result *= i
    }

    result
  }
}
