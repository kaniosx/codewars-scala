object SmallEnoughBeginner {
  def smallEnough(n: Seq[Int], l: Int): Boolean = {
    for (x <- n) {
      if (l < x) {
        return false
      }
    }

    true
  }
}
