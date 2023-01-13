import org.scalatest.flatspec.AnyFlatSpec

class EnoughIsEnoughSpec extends AnyFlatSpec {
  it should "pass fixed tests" in {
    val fixedTests = List(
      (List(20, 37, 20, 21), 1, List(20, 37, 21)),
      (List(1, 1, 3, 3, 7, 2, 2, 2, 2), 3, List(1, 1, 3, 3, 7, 2, 2, 2)),
      (List(1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1), 3, List(1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5)),
      (List(1, 1, 1, 1, 1), 5, List(1, 1, 1, 1, 1)),
      (List(), 5, List())
    )

    fixedTests.foreach {
      case (elements, maxOccurrences, expected) =>
        val clue = s"\nInput:\n  elements = $elements\n  maxOccurrences = $maxOccurrences"
        assertResult(expected, clue) {EnoughIsEnough.deleteNth(elements, maxOccurrences)}
    }
  }
}
