package exercise3

import scala.util.{Failure, Success, Try}
/*
sealed trait List[A]
case class Cons[A](head: A, tail: List[A]) extends List[A]
case class Nil[A]() extends List[A]*/

/** Реализуйте следующие функции.
  * 
  * List(1, 2) match {
  *   case head :: tail => ???
  *   case Nil          => ???
  *   case l            => ???
  * }
  * 
  * Option(1) match {
  *   case Some(a) => ???
  *   case None    => ???
  * }
  * 
  * Either.cond(true, 1, "right") match {
  *   case Left(i)  => ???
  *   case Right(s) => ???
  * }
  * 
  * Try(impureExpression()) match {
  *   case Success(a)     => ???
  *   case Failure(error) => ???
  * }
  * 
  * Try(impureExpression()).toEither
  * 
  */
object Adts {

    // a) Дан List[Int], верните элемент с индексом n
  def a(list: List[Int], n: Int): Option[Int] ={
    Option(list(n))
  }

  // примените функцию из пункта (a) здесь, не изменяйте сигнатуру 
  def testGetNth(list: List[Int], n: Int): Option[Int] = a(list,n)

  // b) Напишите функцию, увеличивающую число в два раза.

  def b(n: Option[Int]): Option[Int] = {
    n match {
      case Some(a) => Option(a * 2)
      case None => n
    }
  }

  // примените функцию из пункта (b) здесь, не изменяйте сигнатуру
  def testDouble(n: Option[Int]): Option[Int] = b(n)

  // c) Напишите функцию, проверяющую является ли число типа Int четным. Если так, верните Right. В противном случае, верните Left("Нечетное число.").

  def c(n: Int): Either[String, Int] = {
    Either.cond(n%2==0, n, "Нечетное число.") match {
      case Left(i) => Left(i)
      case Right(s) => Right(s)
    }
  }

  // примените функцию из пункта (c) здесь, не изменяйте сигнатуру
  def testIsEven(n: Int): Either[String, Int] = c(n)

  // d) Напишите функцию, реализующую безопасное деление целых чисел. Верните Right с результатом или Left("Вы не можете делить на ноль.").

  def d(a: Int, b: Int): Either[String, Int] = {
    Try(a/b) match {
      case Success(a)     => Right(a)
      case Failure(error) => Left("Вы не можете делить на ноль.")
    }
  }

  // примените функцию из пункта (d) здесь, не изменяйте сигнатуру
  def testSafeDivide(a: Int, b: Int): Either[String, Int] = d(a,b)

  // e) Обработайте исключения функции с побочным эффектом вернув 0.

  def e (impure: String => Int, str: String): Try[Int] = {
    Try(impure(str)).toEither match {
      case Left(i) => Success(0)
      case Right(s) => Success(s)
    }
  }

  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testGoodOldJava(impure: String => Int, str: String): Try[Int] = e(impure,str)

}
