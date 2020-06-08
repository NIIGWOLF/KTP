package exercise2
import org.scalatest.FunSuite

class TestRecursiveData extends FunSuite {

  //test testListIntEmpty
  test("testListIntEmpty: Nil = true"){
    val p = RecursiveData.testListIntEmpty(Nil());
    assert(p == true)
  }

  test("testListIntEmpty: Cons = false"){
    val p = RecursiveData.testListIntEmpty(Cons(1,Nil()));
    assert(p == false)
  }


  //testListIntHead
  test("testListIntHead: Nil = -1"){
    val p = RecursiveData.testListIntHead(Nil());
    assert(p == -1)
  }

  test("testListIntHead: Cons(1,Nil()) = 1"){
    val p = RecursiveData.testListIntHead(Cons(1,Nil()));
    assert(p == 1)
  }
}