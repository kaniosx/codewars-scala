// 4 kyu
// https://www.codewars.com/kata/5886e082a836a691340000c3/train/scala

object RectangleRotation {
  def rectangleRotation(a: Int, b: Int): Int =
    val EPSILON: Double = 0.001

    val coordinates: List[(Int, Int)] = List(
      (-a / 2, b / 2),
      (a / 2, b / 2),
      (a / 2, -b / 2),
      (-a / 2, -b / 2)
    )

    val rotatedCoordinates: List[(Double, Double)] = coordinates.map(
      (x: Int, y: Int) => (
        x * (1 / math.sqrt(2)) - y * (1 / math.sqrt(2)),
        x * (1 / math.sqrt(2)) + y * (1 / math.sqrt(2))
      )
    )

    val edgesLengths: List[Double] = List(
      math.sqrt(
        math.pow(rotatedCoordinates.head._1 - rotatedCoordinates(1)._1, 2) +
          math.pow(rotatedCoordinates.head._2 - rotatedCoordinates(1)._2, 2)
      ),
      math.sqrt(
        math.pow(rotatedCoordinates(1)._1 - rotatedCoordinates(2)._1, 2) +
          math.pow(rotatedCoordinates(1)._2 - rotatedCoordinates(2)._2, 2)
      ),
      math.sqrt(
        math.pow(rotatedCoordinates(2)._1 - rotatedCoordinates(3)._1, 2) +
          math.pow(rotatedCoordinates(2)._2 - rotatedCoordinates(3)._2, 2)
      ),
      math.sqrt(
        math.pow(rotatedCoordinates(3)._1 - rotatedCoordinates.head._1, 2) +
          math.pow(rotatedCoordinates(3)._2 - rotatedCoordinates.head._2, 2)
      )
    )

    var counter: Int = 0

    for i <- -a to a do {
      for j <- -b to b do {
        val lineSegmentsLengths: List[Double] = List(
          math.sqrt(math.pow(rotatedCoordinates.head._1 - i, 2) + math.pow(rotatedCoordinates.head._2 - j, 2)),
          math.sqrt(math.pow(rotatedCoordinates(1)._1 - i, 2) + math.pow(rotatedCoordinates(1)._2 - j, 2)),
          math.sqrt(math.pow(rotatedCoordinates(2)._1 - i, 2) + math.pow(rotatedCoordinates(2)._2 - j, 2)),
          math.sqrt(math.pow(rotatedCoordinates(3)._1 - i, 2) + math.pow(rotatedCoordinates(3)._2 - j, 2)),
        )

        val semiPerimetersLengths: List[Double] = List(
          (edgesLengths.head + lineSegmentsLengths.head + lineSegmentsLengths(1)) / 2,
          (edgesLengths(1) + lineSegmentsLengths(1) + lineSegmentsLengths(2)) / 2,
          (edgesLengths(2) + lineSegmentsLengths(2) + lineSegmentsLengths(3)) / 2,
          (edgesLengths(3) + lineSegmentsLengths(3) + lineSegmentsLengths.head) / 2
        )

        val areas: List[Double] = List(
          math.sqrt(
            semiPerimetersLengths.head
              * (semiPerimetersLengths.head - edgesLengths.head)
              * (semiPerimetersLengths.head - lineSegmentsLengths.head)
              * (semiPerimetersLengths.head - lineSegmentsLengths(1))
          ),
          math.sqrt(
            semiPerimetersLengths(1)
              * (semiPerimetersLengths(1) - edgesLengths(1))
              * (semiPerimetersLengths(1) - lineSegmentsLengths(1))
              * (semiPerimetersLengths(1) - lineSegmentsLengths(2))
          ),
          math.sqrt(
            semiPerimetersLengths(2)
              * (semiPerimetersLengths(2) - edgesLengths(2))
              * (semiPerimetersLengths(2) - lineSegmentsLengths(2))
              * (semiPerimetersLengths(2) - lineSegmentsLengths(3))
          ),
          math.sqrt(
            semiPerimetersLengths(3)
              * (semiPerimetersLengths(3) - edgesLengths(3))
              * (semiPerimetersLengths(3) - lineSegmentsLengths(3))
              * (semiPerimetersLengths(3) - lineSegmentsLengths.head)
          )
        )

        if math.abs(areas.sum - a * b) < EPSILON then counter += 1
      }
    }

    counter
}
