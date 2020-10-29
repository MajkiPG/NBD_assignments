import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object Hello extends App{
  def printDays_1a (a:List[String]): Unit ={
    for (day <- a) {
      print(day)
      if (day != a.last)
        print(", ")
    }
  }

  def printDays_1b (a:List[String]): Unit ={
    for (day <- a) {
      if (day.charAt(0) == 's') {
        print(day)
        if (day != a.last)
          print(", ")
      }
    }
  }

  def printDays_1c (a:List[String]): Unit ={
    var i = 0
    while (i != a.length-1)
    {
      print(a(i))
      print(", ")
      i += 1
    }
    print(a.last)
  }

  @tailrec
  def printDays_recursion_2a(a:List[String]): Unit = {
    print(a.head)
    if (a.tail.nonEmpty){
      print(", ")
      printDays_recursion_2a(a.tail)
    }
  }

  def printDays_recursion_2b(a:List[String]): Unit ={
    if (a.tail.nonEmpty)
      printDays_recursion_2b(a.tail)
    print(a.head)
    print(", ")
    //TODO fix last comma
  }

  @tailrec
  def printDays_recursion_3a(a:List[String], str: String): String ={
    var acc = str
    acc += a.head
    if (a.tail.isEmpty){
      acc
    } else {
      acc += ", "
      printDays_recursion_3a(a.tail, acc)
    }
  }

  def printDays_4a(a:List[String]): Unit ={
    print(a.foldLeft("") {(acc, e) =>
      if (acc.count(_ == ',') < a.length-1)
        acc + e + ", "
      else
        acc + e
    })
  }

  def printDays_4b(a:List[String]): Unit ={
    print(a.foldRight("") {(e, acc) =>
      if (acc.count(_ == ',') < a.length-1)
        ", " + e + acc
      else
        e + acc
    })
  }

  def printDays_4c(a:List[String]): Unit ={
    print(a.foldLeft("") {(acc, e) =>
      if (e .charAt(0) == 's') {
        if (acc.count(_ == ',') < a.length-1) {
          acc + e + ", "
        } else
          acc + e
      }
      else
        acc
    })
  }

  def increasedIntList_6(list: List[Int]): List[Int] ={
    list map (n => n+1)
  }

  def numbersInRange_7(list: List[Double]):List[Double] ={
    list filter (x => x >= -5 && x <= 12)
  }

  def printTuple3_8(x: (Any, Any, Any)): Unit ={
    println(x)
  }

  @tailrec
  def recursion_9(list: List[Int], newList: ListBuffer[Int]): List[Int] ={
    if (list.head != 0) {
      newList.append(list.head)
    }
    if (list.tail.isEmpty)
     newList.toList
    else
      recursion_9(list.tail, newList)
  }

  val days = List("monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday")
  val products = Map("cpu" -> 1200.0, "mobo" -> 700.0, "psu" -> 400.0, "ram" -> 500.0, "gpu" -> 2000.0, "ssd" -> 600.0, "case" -> 250.0)
  val integers = List(0, 10, 34, 321, 854, 4, 42, 987, 0, 65, 34, 53463, 365, 547654, 3, 6, 5445, 324, 0)
  val realNumbers = List(-20.5, 40.0, 0.75, 77, 8, -100, -2, -5.7, -0.5)
  val tuple3 = new Tuple3[Int, String, Double](1, "Hello", 0.5)

  printDays_1a(days)
  println("")
  printDays_1b(days)
  println("")
  printDays_1c(days)
  println("")
  printDays_recursion_2a(days)
  println("")
  printDays_recursion_2b(days)
  println("")
  print(printDays_recursion_3a(days, ""))
  println("")
  printDays_4a(days)
  println("")
  printDays_4b(days)
  println("")
  printDays_4c(days)
  println("")

  println(products)
  println(products.map{case (k, v) => (k, v*0.9)})

  val integersPlusOne = increasedIntList_6(integers)
  println(integers)
  println(integersPlusOne)

  val realNumbersInRange = numbersInRange_7(realNumbers)
  println(realNumbers)
  println(realNumbersInRange)

  printTuple3_8(tuple3)

  val integersWithoutZeros = recursion_9(integers, ListBuffer.empty)
  println(integers)
  println(integersWithoutZeros)


}
