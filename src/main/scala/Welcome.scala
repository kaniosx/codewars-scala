// 8 kyu
// https://www.codewars.com/kata/577ff15ad648a14b780000e7/train/scala

import scala.collection.immutable.HashMap

object Welcome {
  def greet(language: String): String =
    db.getOrElse(language, "Welcome")

  private val db: HashMap[String, String] = HashMap[String, String](
    "english" -> "Welcome",
    "czech" -> "Vitejte",
    "danish" -> "Velkomst",
    "dutch" -> "Welkom",
    "estonian" -> "Tere tulemast",
    "finnish" -> "Tervetuloa",
    "flemish" -> "Welgekomen",
    "french" -> "Bienvenue",
    "german" -> "Willkommen",
    "irish" -> "Failte",
    "italian" -> "Benvenuto",
    "latvian" -> "Gaidits",
    "lithuanian" -> "Laukiamas",
    "polish" -> "Witamy",
    "spanish" -> "Bienvenido",
    "swedish" -> "Valkommen",
    "welsh" -> "Croeso"
  )
}
