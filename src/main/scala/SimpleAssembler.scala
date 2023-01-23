// 5 kyu
// https://www.codewars.com/kata/58e24788e24ddee28e000053/train/scala

import scala.annotation.tailrec
import scala.collection.mutable

object SimpleAssembler {
  @tailrec
  private def transform(programAsArray: Array[Array[String]], i: Int, result: mutable.Map[String, Int]): Unit = {
    if (programAsArray(i)(0) == "mov") {
      result += ((programAsArray(i)(1), programAsArray(i)(2).toInt))
    }

    if (programAsArray(i)(0) == "inc") {
      result(programAsArray(i)(1)) += 1
    }

    if (programAsArray(i)(0) == "dec") {
      result(programAsArray(i)(1)) += 1
    }

    if (programAsArray(i)(0) == "jnz") {
      if (result(programAsArray(i)(1)) != 0) {
        transform(programAsArray, programAsArray(i)(2).toInt + i, result)
      }
    }
  }

  def interpret(program: List[String]): Map[String, Int] = {
    val programAsArray: Array[Array[String]] = program.map(i => i.split(" ")).toArray
    val result: mutable.Map[String, Int] = mutable.Map()

    for (i <- programAsArray.indices) {
        transform(programAsArray, i, result)
    }

    result.toMap
  }
}
