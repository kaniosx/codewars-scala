import CommonDenominatorsSpec.testing
import org.scalatest.*
import org.scalatest.Assertions.*
import org.scalatest.flatspec.AnyFlatSpec


class CommonDenominatorsSpec extends AnyFlatSpec {
  it should "pass basic tests" in {
    var lst: Array[(Long, Long)]  = Array((1L, 2L), (1L, 3L), (1L, 4L))
    testing(lst, "(6,12)(4,12)(3,12)")

    lst = Array((69L, 130L), (87L, 1310L), (30L, 40L))
    testing(lst, "(18078,34060)(2262,34060)(25545,34060)")

    lst = Array((77L, 130L), (84L, 131L), (3L, 4L))
    testing(lst, "(20174,34060)(21840,34060)(25545,34060)")
  }
}

object CommonDenominatorsSpec {
  private def ArrayTupleToString(res: Array[(Long, Long)]): String = {
    var s: String = "["
    val l: Int = res.length

    for (i <- 0 until l) {
      val a = res(i)
      s += "(" + a._1 + ", " + a._2
      if (i < l - 1) s += "), " else s += ")"
    }

    s += "]"

    s
  }

  private def testing(lst: Array[(Long, Long)], expect: String): Unit = {
    println("Testing: " + ArrayTupleToString(lst))
    val actual: String = CommonDenominators.convertFrac(lst)
    println("Actual: " + actual)
    println("Expect: " + expect)
    println("-")
    assertResult(expect){actual}
  }
}
