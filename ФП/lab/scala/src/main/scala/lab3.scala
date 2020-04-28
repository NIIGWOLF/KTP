import math._
import scala.collection.mutable.ArrayBuffer
import java.awt.datatransfer._

object lab3 {
  def main(args: Array[String]): Unit = {

    var a = ArrayBuffer[Int]()
    enterNumberMas(a,5);
    println(a)
    println(switchNumberMasYield(a))
  }

  def enterNumberMas(a: ArrayBuffer[Int],n:Int): Unit ={
    a ++= 0 until n
  }

  def switchNumberMas(a: ArrayBuffer[Int]): ArrayBuffer[Int] ={
    for (i <-1 until a.length if i%2==1){
      val b=a(i-1)
      a(i-1)=a(i)
      a(i)=b
    }
    a
  }

  def switchNumberMasYield(a: ArrayBuffer[Int]) ={
    var b = ArrayBuffer[Int]()
    b++=(for (i <-0 until a.length)yield{
      if (i==a.length-1){
        if(i%2==1){
          a(i-1)
        }
        else{
          a(i)
        }
      }
      else{
        if(i%2==0){
          a(i+1)
        }
        else
          a(i-1)
      }
    })
    b
  }

  def sortZero(a: ArrayBuffer[Int]): ArrayBuffer[Int] ={
    var b = ArrayBuffer[Int]()
    b = for (elem <- a if elem > 0) yield elem
    b++=(for (elem <- a if elem <= 0) yield elem)
  }

  def averageMas(a: ArrayBuffer[Int]): Double ={
    a.sum.toDouble/a.size
  }

  def reverseSortMas(a: ArrayBuffer[Int]): ArrayBuffer[Int] ={
    a.sortWith(_ > _)
  }

  def distinctMas(a: ArrayBuffer[Int]): ArrayBuffer[Int] ={
    a.distinct
  }

  def delNegativNumberMas(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    var b = ArrayBuffer[Int]()
    b.++=(for (i <-0 until a.length if a(i)<0) yield i).trimStart(1)
    b=b.reverse
    var c = ArrayBuffer[Int]()
    c++=(for (i <- 0 until a.length if !b.contains(i))yield a(i))
  }

  def timeZoneAmerica(): ArrayBuffer[String] ={
    var a = java.util.TimeZone.getAvailableIDs()
    var b =ArrayBuffer[String]()
    b++=(for (elem <- a if elem.contains("America/"))yield elem.drop(8)).sorted
  }

  def flavor(): Unit ={
    val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
    var a=flavors.getNativesForFlavor(DataFlavor.imageFlavor)
    print(a)
  }
}


