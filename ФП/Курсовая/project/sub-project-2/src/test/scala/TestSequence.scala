package exercise3
import org.scalatest.FunSuite

class TestSequence extends FunSuite{
  //test testLastElement
  test("testLastElement"){
    val p = Sequence.testLastElement(Seq(1,2,3,4))
    assert(p == Some(4))
  }

  //test testZip
  test("testZip"){
    val p = Sequence.testZip(Seq(1, 2),Seq(3, 4))
    assert(p == Seq((1,3), (2,4)))
  }

  //test testForAll
  test("testForAll: false"){
    val A = (i: Int)=> i>2
    val p = Sequence.testForAll(Seq(1,2,3,4))(A)
    assert(p == false)
  }

  test("testForAll: true"){
    val A = (i: Int)=> i>2
    val p = Sequence.testForAll(Seq(3,5,3,4))(A)
    assert(p == true)
  }

  //test testPalindrom
  test("testPalindrom: false"){
    val p = Sequence.testPalindrom(Seq(3,5,3,4))
    assert(p == false)
  }

  test("testPalindrom: true"){
    val p = Sequence.testPalindrom(Seq(3,5,5,3))
    assert(p == true)
  }

  //test testFlatMap
  test("testFlatMap: true"){
    val A = (i: Seq[Int])=> i
    val p = Sequence.testFlatMap(Seq(Seq(1,2),Seq(3,4)))(A)
    assert(p == Seq(1,2,3,4))
  }

}