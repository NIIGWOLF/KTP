package exercise4

object Typeclasses {

  def main(args: Array[String]): Unit = {
    println("testReversableString: (Dima Klyushkin) = " + testReversableString("Dima Klyushkin"))
    println("testSmashInt: (5,9) = " + testSmashInt(5,9))
    println("testSmashDouble: (5,9) = " + testSmashDouble(5,9))
    println("testSmashString: (Dima,Klyushkin) = " + testSmashString("Dima","Klyushkin"))
  }

  // a) Определите тайп-класс Reversable, который представляет в обратном порядке значения.
  // b) Реализуйте функцию Reverse для String.

  trait Reversable[T] {
    def reverse(a: T): T
  }

  implicit object ReversableString extends Reversable[String] {
    def reverse(a: String): String = a.reverse
  }

  // примените тайп-класс-решение из пункта (a) здесь
  def testReversableString(str: String): String = ReversableString.reverse(str)

  // c) Определите тайп-класс Smash таким образом чтобы в нем была функция smash, которая выполняет операцию со значениями одного типа.
  // d) Реализуйте  функции Smash для типа Int и Double.
  //    Используйте сложение для типа Int у умножение для типа Double.
  // e) Реализуйте функцию Smash для типа String. Необходимо выполнить конкатенацию строк, которые будут получены в качестве параметра.

  trait Smash[T]{
    def smash(a: T, b: T): T
  }

  implicit object SmashInt extends Smash[Int] {
    def smash(a: Int, b: Int): Int = a + b
  }

  implicit object SmashDouble extends Smash[Double] {
    def smash(a: Double, b: Double): Double = a * b
  }

  implicit object SmashString extends Smash[String] {
    def smash(a: String, b: String): String = a.concat(b)
  }

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashInt(a: Int, b: Int): Int = SmashInt.smash(a,b)

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashDouble(a: Double, b: Double): Double = SmashDouble.smash(a,b)

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashString(a: String, b: String): String = SmashString.smash(a,b)
}