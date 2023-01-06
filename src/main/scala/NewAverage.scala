// 7 kyu
// https://www.codewars.com/kata/569b5cec755dd3534d00000f/train/scala

object NewAverage {
  def newAvg(arr: Array[Double], navg: Double): Option[Int] = {
    if (arr.isEmpty) {
      return Some(navg.toInt)
    }

    val result = (navg * (arr.length + 1) - arr.sum).ceil

    if (result < 0) {
      return None
    }

    Some(result.toInt)
  }
}
