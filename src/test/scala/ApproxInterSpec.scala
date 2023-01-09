import ApproxInterSpec.testing
import org.scalatest.Assertions.assertResult
import org.scalatest.flatspec.AnyFlatSpec

class ApproxInterSpec extends AnyFlatSpec {
  it should "pass basic tests f: x -> x" in
    testing(x => x, 0, 9.0, 4, "0.0, 2.25, 4.5, 6.75")

  it should "pass basic tests f: x -> sin(x)" in
    testing(
      x => Math.sin(x),
      0,
      18.0,
      12,
      "0.0, 0.99, 0.14, -0.98, -0.28, 0.93, 0.41, -0.88, -0.54, 0.8, 0.65, -0.72"
    )

  it should "pass basic tests f: x -> cos(x)" in
    testing(x => Math.cos(x), 0, 21.0, 7, "1.0, -0.99, 0.96, -0.92, 0.84, -0.76, 0.66")
}

object ApproxInterSpec {
  private def testing(f: Double => Double, l: Double, u: Double, n: Int, expected: String): Unit =
    val actual: String = ApproxInter.interp(f: Double => Double, l: Double, u: Double, n: Int)

    println("Actual: " + actual)
    println("Expect: " + expected)

    assertResult(expected){actual}

    println("-")
}
