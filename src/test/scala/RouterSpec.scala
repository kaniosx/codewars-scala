import org.scalatest.flatspec.AnyFlatSpec

class RouterSpec extends AnyFlatSpec{
  it should "handle GET routs" in {
    val router = new Router()

    router.bind("/hello", "GET", () => "hello world")
    router.bind("/login", "GET", () => "Please log-in.")

    assert(router.runRequest("/hello", "GET") == "hello world")
    assert(router.runRequest("/login", "GET") == "Please log-in.")
  }

  it should "handle POST routes" in {
    val router = new Router()

    router.bind("/vote", "POST", () => "Voted.")
    router.bind("/comment", "POST", () => "Comment sent.")

    assert(router.runRequest("/vote", "POST") == "Voted.")
    assert(router.runRequest("/comment", "POST") == "Comment sent.")
  }

  it should "handle mixed routes" in {
    val router = new Router()

    router.bind("/login", "GET", () => "Please log-in.")
    router.bind("/login", "POST", () => "Logging-in.")

    assert(router.runRequest("/login", "GET") == "Please log-in.")
    assert(router.runRequest("/login", "POST") == "Logging-in.")
  }

  it should "return 404 for non-existing routes" in {
    val router = new Router()

    assert(router.runRequest("/this-url-does-not-exist", "GET") == "Error 404: Not Found")
  }

  it should "modify existing routes" in {
    val router = new Router()

    router.bind("/page", "GET", () => "First binding.")
    router.bind("/page", "GET", () => "Modified binding.")

    assert(router.runRequest("/page", "GET") == "Modified binding.")
  }
}
