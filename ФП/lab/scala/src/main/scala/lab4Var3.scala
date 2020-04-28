import scala.collection.mutable.ArrayBuffer

object lab4Var3 {
  def main(args: Array[String]): Unit = {
    zad1()
    zad2()
  }

  def zad1(): Unit ={
    var b = 102
    print(b+": ")
    var a: String = delit(b).toString
    print(a + ": ")
    var sum: Int=0
    for (i<- a)
      sum+=Integer.parseInt(i.toString)
    println(sum)
  }

  def delit(num: Int): Int ={
    var del: Int= 0
    for (i <- 2 to num/2){
      if (num%i==0) del=i
    }
    del
  }

  def zad2(): Unit ={
    var b = ArrayBuffer[Int]()

    b ++= (1 to 5)
    b++=b++b
    println(b)
  }

}
