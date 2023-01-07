// 6 kyu
// https://www.codewars.com/kata/52b305bec65ea40fe90007a7/train/scala

object GrabScrab {
  def grabscrab(word: String, possibleWords: Seq[String]): Seq[String] =
    possibleWords.filter(_.sorted.equals(word.sorted))
}
