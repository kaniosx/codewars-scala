object MemoizedFibonacci {

  private def memoize[K, V](f: K => V): K => V = {
    val cache = scala.collection.mutable.Map.empty[K, V]
    k => cache.getOrElseUpdate(k, f(k))
  }

  private val fibM: Int => BigInt = memoize {
    case 0 => 0
    case 1 => 1
    case n => fibM(n - 2) + fibM(n - 1)
  }

  def fib(n: Int): BigInt = {
    fibM(n)
  }

}
