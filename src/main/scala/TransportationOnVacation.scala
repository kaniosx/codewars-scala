object TransportationOnVacation {
  def cost(days: Int): Int = {
    var result: Int = days * 40

    if (days >= 7) {
      result -= 50
    } else if (days >= 3) {
      result -= 20
    }

    result
  }
}
