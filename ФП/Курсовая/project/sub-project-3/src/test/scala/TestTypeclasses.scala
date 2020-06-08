package exercise4
import org.scalatest.FunSuite

class TestTypeclasses extends FunSuite {


  //test testReversableString
  test("testReversableString"){
    val p = Typeclasses.testReversableString("Dima")
    assert(p == "amiD")
  }
  //test testSmashInt
  test("testSmashInt"){
    val p = Typeclasses.testSmashInt(7,3)
    assert(p == 10)
  }
  //test testSmashDouble
  test("testSmashDouble"){
    val p = Typeclasses.testSmashDouble(7.0,3.0)
    assert(p == 21.0)
  }
  //test testSmashString
  test("testSmashString"){
    val p = Typeclasses.testSmashString("Di", "ma")
    assert(p == "Dima")
  }
}
