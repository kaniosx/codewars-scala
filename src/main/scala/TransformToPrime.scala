import scala.util.control.Breaks.{break, breakable}

object TransformToPrime {
  def minimumNumber(numbers: Seq[Int]): Int =
    Iterator
      .from(0)
      .find(i => BigInt(numbers.sum + i).isProbablePrime(4))
      .get
}
