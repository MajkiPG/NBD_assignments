class BankAccount(var currentBalance: Double = 0.0) {

  def deposit(amount: Double): Boolean = {
    if (amount >= 0) {
      currentBalance += amount
      true
    }
    else false
  }

  def withdraw(amount: Double) : Boolean = {
    if (amount > 0.0 && amount <= currentBalance) {
      currentBalance -= amount
      true
    }
    else false
  }
}

case class Person_3(var firstName: String, var lastName: String)

abstract class Person_5(private var firstName: String, private var lastName: String) {
  def taxToPay: Double
}

trait Student extends Person_5 {
  override def taxToPay: Double = 0.0
}

trait Employee extends Person_5 {
  private var _salary: Double = _
  def salary: Double = _salary
  def salary_(sal: Double): Unit = _salary = sal
  override def taxToPay: Double = 0.2*_salary
}

trait Teacher extends Employee {
  override def taxToPay: Double = 0.1*salary
}

abstract class Person_5(var firstName: String, var lastName: String) {
  var taxToPay: Double
}

val days = List("monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday")

def patternMatching_1(str:String): Unit = str match {
  case "monday" => println("workday")
  case "tuesday" => println("workday")
  case "wednesday" => println("workday")
  case "thursday" => println("workday")
  case "friday" => println("workday")
  case "saturday" => println("weekend")
  case "sunday" => println("weekend")
  case _ => println("no such day")
}

def patternMatching_2(person: Person_3): Unit = person match {
  case Person_3("Tanisha", _) => println("How are you " + person.firstName)
  case Person_3(_, "Hart") => println("This is dr. " + person.firstName + " " + person.lastName)
  case Person_3("Adam", "Divine") => println("Welcome " + person.firstName + " " + person.lastName)
  case Person_3(_, _) => println("Hi " + person.firstName)
}

def square_integer(int: Int): Int = int*int

def integer_4(int: Int, fun: Int => Int): Int ={
  var currInt = int
  currInt = fun(currInt)
  currInt = fun(currInt)
  fun(currInt)
}

for (day <- days){
patternMatching_1(day)}

val bankAccount_cash = new BankAccount(499.99)
val bankAccount_empty = new BankAccount()
println(bankAccount_cash.currentBalance)
println(bankAccount_empty.currentBalance)
bankAccount_empty.deposit(35.5)
println(bankAccount_empty.currentBalance)
bankAccount_empty.withdraw(15.2)
println(bankAccount_empty.currentBalance)


val person1 = Person_3("Saarah ", "Brookes")
val person2 = Person_3("Tanisha", "Horner")
val person3 = Person_3("Yasmin ", "Frazier")
val person4 = Person_3("Miles ", "Hart")
val person5 = Person_3("Adam", "Divine")
val person6 = Person_3("Juno", "Chung")

patternMatching_2(person1)
patternMatching_2(person2)
patternMatching_2(person3)
patternMatching_2(person4)
patternMatching_2(person5)
patternMatching_2(person6)

println(integer_4(2, square_integer))

