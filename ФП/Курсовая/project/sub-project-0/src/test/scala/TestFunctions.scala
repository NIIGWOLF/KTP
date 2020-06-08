package exercise1
import org.scalatest.FunSuite

class TestFunctions extends FunSuite {


  //test testCircle
  test("testCircle: 4*Pi"){
    val p = Functions.testCircle(2);
    assert(p == 4*Math.PI)
  }

  //test testRectangleCurried
  test("testRectangleCurried: a=2 b=3 S=6"){
    val p = Functions.testRectangleCurried(2,3)
    assert(p == 6)
  }

  //test testRectangleCurried
  test("testRectangleUc: a=2 b=3 S=6"){
    val p = Functions.testRectangleUc(2,3)
    assert(p == 6)
  }
}