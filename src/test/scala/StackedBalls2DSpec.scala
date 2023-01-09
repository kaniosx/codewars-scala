import StackedBalls2DSpec.testing
import org.scalatest.Assertions.assertResult
import org.scalatest.flatspec.AnyFlatSpec

class StackedBalls2DSpec extends AnyFlatSpec {
  it should "pass for 1 layer" in
    testing(1d, 1d)

  it should "pass for 2 layers" in
    testing(1.866d, 2d)
}

object StackedBalls2DSpec {
  private def testing(expected: Double, layers: Double): Unit =
    val actual: Double = (math floor (StackedBalls2D.stackHeight2d(layers) * 1000)) / 1000

    println("Actual rounded: " + actual)
    println("Expect: " + expected)

    assertResult(expected){actual}

    println("-")
}
