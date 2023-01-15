// 6 kyu
// https://www.codewars.com/kata/588a00ad70720f2cd9000005/train/scala

import scala.collection.mutable

class Router {
  private var routes: Map[String, mutable.Map[String, () => String]] = Map()

  def bind(route: String, method: String, call: () => String): Unit = {
    if !routes.contains(method) then
      routes += (method -> mutable.Map())

    routes(method) += (route -> call)
  }

  def runRequest(route: String, method: String): String = {
    if routes.contains(method) && routes(method).contains(route) then
      return routes(method)(route)()

    "Error 404: Not Found"
  }
}
