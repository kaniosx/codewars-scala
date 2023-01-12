// 6 kyu
// https://www.codewars.com/kata/582c5382f000e535100001a7/train/scala

object ListParser {
  def parse(nodes: String): Node =
    var result: Node = null

    for x <- nodes.split(" -> ").dropRight(1).reverse do
      if result == null then
        result = Node(x.toInt)
      else
        result = Node(x.toInt, result)

    result
}

case class Node(data: Int, next: Node = null)
