package exercise1
import exercise1.PatternMatching._
import org.scalatest.FunSuite

class TestPatterns extends FunSuite {


  //test testIntToString
  test("testIntToString: 1 = \"it is one\""){
    val p = PatternMatching.testIntToString(1)
    assert(p == "it is one")
  }
  test("testIntToString: 2 = \"it is two\""){
    val p = PatternMatching.testIntToString(2)
    assert(p == "it is two")
  }
  test("testIntToString: 3 = \"it is three\""){
    val p = PatternMatching.testIntToString(3)
    assert(p == "it is three")
  }
  test("testIntToString: 4 = \"what's that\""){
    val p = PatternMatching.testIntToString(4)
    assert(p == "what's that")
  }


  //test testIsMaxAndMoritz
  test("testIsMaxAndMoritz: max = true"){
    val p = PatternMatching.testIsMaxAndMoritz("max")
    assert(p == true)
  }
  test("testIsMaxAndMoritz: Max = true"){
    val p = PatternMatching.testIsMaxAndMoritz("Max")
    assert(p == true)
  }
  test("testIsMaxAndMoritz: moritz = true"){
    val p = PatternMatching.testIsMaxAndMoritz("moritz")
    assert(p == true)
  }
  test("testIsMaxAndMoritz: Moritz = true"){
    val p = PatternMatching.testIsMaxAndMoritz("Moritz")
    assert(p == true)
  }
  test("testIsMaxAndMoritz: MAX = false"){
    val p = PatternMatching.testIsMaxAndMoritz("MAX")
    assert(p != true)
  }


  //test testIsEven
  test("testIsEven: 5 = false"){
    val p = PatternMatching.testIsEven(5)
    assert(p == false)
  }
  test("testIsEven: 6 = true"){
    val p = PatternMatching.testIsEven(6)
    assert(p == true)
  }


  //test testWinsA
  test("testWinsA: Rock Rock = Draw"){
    val p = PatternMatching.testWinsA(PatternMatching.Rock,PatternMatching.Rock)
    assert(p == PatternMatching.Draw)
  }
  test("testWinsA: Rock Paper = Lose"){
    val p = PatternMatching.testWinsA(PatternMatching.Rock,PatternMatching.Paper)
    assert(p == PatternMatching.Lose)
  }
  test("testWinsA: Rock Scissor = Win"){
    val p = PatternMatching.testWinsA(PatternMatching.Rock,PatternMatching.Scissor)
    assert(p == PatternMatching.Win)
  }
  test("testWinsA: Paper Rock = Win"){
    val p = PatternMatching.testWinsA(PatternMatching.Paper,PatternMatching.Rock)
    assert(p == PatternMatching.Win)
  }
  test("testWinsA: Paper Paper = Draw"){
    val p = PatternMatching.testWinsA(PatternMatching.Paper,PatternMatching.Paper)
    assert(p == PatternMatching.Draw)
  }
  test("testWinsA: Paper Scissor = Lose"){
    val p = PatternMatching.testWinsA(PatternMatching.Paper,PatternMatching.Scissor)
    assert(p == PatternMatching.Lose)
  }
  test("testWinsA: Scissor Rock = Lose"){
    val p = PatternMatching.testWinsA(PatternMatching.Scissor,PatternMatching.Rock)
    assert(p == PatternMatching.Lose)
  }
  test("testWinsA: Scissor Paper = Win"){
    val p = PatternMatching.testWinsA(PatternMatching.Scissor,PatternMatching.Paper)
    assert(p == PatternMatching.Win)
  }
  test("testWinsA: Scissor Scissor = Draw"){
    val p = PatternMatching.testWinsA(PatternMatching.Scissor,PatternMatching.Scissor)
    assert(p == PatternMatching.Draw)
  }


  //test testExtractMammalWeight
  test("testExtractMammalWeight: Mammal(90) = 90"){
    val p = PatternMatching.testExtractMammalWeight(Mammal("Bear",Meat,90))
    assert(p == 90)
  }
  test("testExtractMammalWeight: Fish = -1"){
    val p = PatternMatching.testExtractMammalWeight(Fish("Gold",Meat))
    assert(p == -1)
  }


  //test testUpdateFood
  test("testUpdateFood: Mammal(Meat) = Mammal(Meat)"){
    val p = PatternMatching.testUpdateFood(Mammal("Bear",Meat,90))
    assert(p.food == Meat)
  }
  test("testUpdateFood: Fish(Meat) = Fish(Plants)"){
    val p = PatternMatching.testUpdateFood(Fish("Gold",Meat))
    assert(p.food == Plants)
  }
  test("testUpdateFood: Bird(Meat) = Bird(Plants)"){
    val p = PatternMatching.testUpdateFood(Bird("Parrot",Meat))
    assert(p.food == Plants)
  }
}