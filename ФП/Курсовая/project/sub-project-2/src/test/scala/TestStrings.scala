package exercise3
import org.scalatest.FunSuite

class TestStrings extends FunSuite {


  //test testUppercase
  test("testUppercase") {
    val p = Strings.testUppercase("dima")
    assert(p == "DIMA")
  }


  //test testInterpolations
  test("testInterpolations") {
    val p = Strings.testInterpolations("Dima", 24)
    assert(p == "Hi my name is Dima and I am 24 years old.")
  }


  //test testComputation
  test("testComputation") {
    val p = Strings.testComputation(5, 7)
    assert(p == "Hi,\nnow follows a quite hard calculation. We try to add:\n\ta := 5\n\tb := 7\n\n\tresult is 12")
  }


  //test testTakeTwo
  test("testTakeTwo: 2") {
    val p = Strings.testTakeTwo("qu")
    assert(p == "qu")
  }
  test("testTakeTwo: 5") {
    val p = Strings.testTakeTwo("quite")
    assert(p == "qu")
  }
}
