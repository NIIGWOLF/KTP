import scala.collection.mutable._
import java.util.TreeMap


object lab4 {

  def main(args: Array[String]): Unit = {
    val score = Map("Apple"->32.9, "Orange"->99.2, "Limon"->43.5)
    //println(score)

    exercise4()
  }

  def exercise1(score: Map[String, Double]): Unit ={
      var newScore=(for((k,v) <-score) yield (k,v*0.9))
      println(newScore)
    }

  def exercise2(): Unit ={
      var map = HashMap[String, Int]()

      val in = new java.util.Scanner(new java.io.File("myfile.txt"))
      while (in.hasNext()) {
        var str = in.next()
        if (map.contains(str))
          map(str)+=1
        else
          map(str)=1
      }
      println(map)
    }

  def exercise3(): Unit = {
    var map = Map[String, Int]()

    val in = new java.util.Scanner(new java.io.File("myfile.txt"))
    while (in.hasNext()) {
      var str = in.next()
      if (map.contains(str))
        map = map + (str -> (map(str) + 1))
      else
        map = map + (str -> 1)
    }
    println(map)
  }

  def exercise4(): Unit = {
    var map = SortedMap[String, Int]()

    val in = new java.util.Scanner(new java.io.File("myfile.txt"))
    while (in.hasNext()) {
      var str = in.next()
      if (map.contains(str))
        map(str)+=1
      else
        map(str)=1
    }
    println(map)
  }

  def exercise5(): Unit = {
    var map = SortedMap[String, Int]()


    val in = new java.util.Scanner(new java.io.File("myfile.txt"))
    while (in.hasNext()) {
      var str = in.next()
      if (map.contains(str))
        map(str)+=1
      else
        map(str)=1
    }
    println(map)
  }
}
