package exercise2
import org.scalatest.FunSuite

class TestRecursiveFunctions extends FunSuite {

  var a:List[Int]=Cons(4,Cons(2,Cons(1,Cons(5,Nil()))))
  var b:List[Int]=Cons(8,Cons(9,Cons(7,Cons(6,Nil()))))
  var c:List[List[Int]]=Cons(Cons(1,Cons(2,Nil())), Cons(Cons(3,Cons(4,Nil())),Nil()))
  val InDo: (Int) => Double = _*2
  val InDoB: List[Int] => List[Int] = _ match{
    case Cons(head, tail) => Cons(head,tail)
    case Nil() => Nil()
  }


  //test testReverse
  test("testReverse: 4 2 1 5 -> 5 1 2 4"){
    val p = RecursiveFunctions.testReverse(a);
    assert(p == Cons(5,Cons(1,Cons(2,Cons(4,Nil())))))
  }

  //test testMap
  test("testMap: 4 2 1 5 -> 8 4 2 10"){
    val p = RecursiveFunctions.testMap(a,InDo);
    assert(p == Cons(8,Cons(4,Cons(2,Cons(10,Nil())))))
  }

  //test testAppend
  test("testAppend: 4 2 1 5 append 8 9 7 6 -> 4 2 1 5 8 9 7 6"){
    val p = RecursiveFunctions.testAppend(a,b);
    assert(p == Cons(4,Cons(2,Cons(1,Cons(5,Cons(8,Cons(9,Cons(7,Cons(6,Nil())))))))))
  }

  //test testFlatMap
  test("testFlatMap: [[1,2],[3,4]] -> 1 2 3 4"){
    val p = RecursiveFunctions.testFlatMap(c,InDoB)
    assert(p == Cons(1,Cons(2,Cons(3,Cons(4,Nil())))))
  }


}