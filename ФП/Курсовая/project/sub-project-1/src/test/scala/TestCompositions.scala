package exercise2
import org.scalatest.FunSuite

class TestCompositions extends FunSuite {


  //test testCompose
  test("testCompose: double -> int -> byte -> string"){
    val A: (Double) => Int = _.toInt
    val B: (Int) => Byte = _.toByte
    val C: (Byte) => String = _.toString
    val p = Compositions.testCompose[Double,Int,Byte,String](A)(B)(C)
    assert(p(257.5) == "1")
  }


  //test testMapFlatMap
  test("testMapFlatMap: double -> int -> byte -> string"){
    val A1: (Double) => Int = _.toInt
    val B1: (Int) => Byte = _.toByte
    val C1: (Byte) => String = _.toString

    val A: (Double) => Option[Int] = Some(_).map(A1)
    val B: (Int) => Option[Byte] = Some(_).map(B1)
    val C: (Byte) => String = _.toString
    val p = Compositions.testMapFlatMap(A)(B)(C)
    assert(p(Some(257.5)).toString == (Some(1).toString))
  }


  //test testForComprehension
  test("testForComprehension: double -> int -> byte -> string"){
    val A1: (Double) => Int = _.toInt
    val B1: (Int) => Byte = _.toByte
    val C1: (Byte) => String = _.toString

    val A: (Double) => Option[Int] = Some(_).map(A1)
    val B: (Int) => Option[Byte] = Some(_).map(B1)
    val C: (Byte) => String = _.toString
    val p = Compositions.testForComprehension(A)(B)(C)
    assert(p(Some(257.5)).toString == (Some(1).toString))
  }
}