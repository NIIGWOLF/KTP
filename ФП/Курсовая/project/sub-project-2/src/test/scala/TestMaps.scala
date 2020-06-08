package exercise3
import exercise3.Maps.User
import org.scalatest.FunSuite

class TestMaps extends FunSuite{
  //test testGroupUsers
  test("testGroupUsers"){
    val l = Seq(User("Dima",24),User("Sasha",19),User("Dima",20),User("Sasha",41))
    val p = Maps.testGroupUsers(l)
    assert(p == Map(("Sasha",30),("Dima",22)))
  }

  //test testNumberFrodos
  test("testNumberFrodos"){
    val l = Map(("1",User("Dima",24)),("2",User("AdamSasha",19)),("3",User("DAdamima",20)),("4",User("Sasha",41)))
    val p = Maps.testNumberFrodos(l)
    assert(p == 2)
  }

  //test testUnderaged
  test("testUnderaged"){
    val l = Map(("1",User("Dima",24)),("2",User("AdamSasha",38)),("3",User("DAdamima",20)),("4",User("Sasha",41)))
    val p = Maps.testUnderaged(l)
    assert(p == Map("2" -> User("AdamSasha",38), "4" -> User("Sasha",41)))
  }

}

