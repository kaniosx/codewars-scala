// 7 kyu
// https://www.codewars.com/kata/56eb0be52caf798c630013c0/train/scala

import java.time._

class UnluckyDays {
  def unluckyDays(year: Int): Int = {
    val firstDayOfYear: LocalDate = LocalDate.of(year, 1, 1)
    (1 to 365)
      .map(firstDayOfYear.plusDays(_))
      .count(d => DayOfWeek.FRIDAY == d.getDayOfWeek && 13 == d.getDayOfMonth)
  }
}
