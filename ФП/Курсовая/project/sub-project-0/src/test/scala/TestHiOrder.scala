package exercise1
import org.scalatest.FunSuite

class TestHiOrder extends FunSuite {


  //test testNTimes
  val plus: (Int, Int) => Int = _ + _
  test("testNTimes: 2*(3+7)=20"){
    val p = HigherOrder.testNTimes(plus,3,7,2)
    assert(p == 20)
  }

  //test testAnonymousNTimes
  test("testAnonymousNTimes: 2*(if (3 > 7) 3 else 7)=14"){
    val p = HigherOrder.testAnonymousNTimes(3,7,2)
    assert(p == 14)
  }
}