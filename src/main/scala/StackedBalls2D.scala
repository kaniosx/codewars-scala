// 7 kyu
// https://www.codewars.com/kata/5bb804397274c772b40000ca/train/scala

object StackedBalls2D {

  def stackHeight2d(layers: Double): Double =
    (layers - 1) * math.sqrt(3) / 2 + 1
}
