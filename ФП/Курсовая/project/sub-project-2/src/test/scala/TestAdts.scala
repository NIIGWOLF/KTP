package exercise3
import org.scalatest.FunSuite
import scala.util.{Success}

class TestAdts extends FunSuite {

  //test testGetNth
  test("testGetNth: testGetNth(List(1, 2),1) = 2"){
    val p = Adts.testGetNth(List(1, 2),1)
    assert(p == Some(2))
  }

  //test testDouble
  test("testDouble: 2 = 4"){
    val p = Adts.testDouble(Some(2))
    assert(p == Some(4))
  }

  //test testIsEven
  test("testIsEven: 4 = Right(4)"){
    val p = Adts.testIsEven(4)
    assert(p == Right(4))
  }
  test("testIsEven: 3 = Left(Negativ)"){
    val p = Adts.testIsEven(3)
    assert(p == Left("Нечетное число."))
  }

  //test testSafeDivide
  test("testSafeDivide: 3/3 = Right(1)"){
    val p = Adts.testSafeDivide(3,3)
    assert(p == Right(1))
  }
  test("testSafeDivide: 3/0 = Left(Error)"){
    val p = Adts.testSafeDivide(3,0)
    assert(p == Left("Вы не можете делить на ноль."))
  }

  //test testGoodOldJava
  test("testGoodOldJava: 123 = Success(123)"){
    val A: (String) => Int = Integer.parseInt(_)
    val p = Adts.testGoodOldJava(A,"123")
    assert(p == Success(123))
  }
  test("testGoodOldJava: 123 = Success(123!)"){
    val A: (String) => Int = Integer.parseInt(_)
    val p = Adts.testGoodOldJava(A,"123!")
    assert(p == Success(0))
  }

}