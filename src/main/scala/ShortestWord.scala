object ShortestWord {
  def findShort(str: String): Int = {
    str.split(" ").minBy(_.length).length
  }
}
