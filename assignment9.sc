class Container[A](private val value:A) {

  def getContent:A = value

  def applyFunction[R](f: A => R):R = f(value)
}

trait Maybe[A] {

  def applyFunction[R](f: A => R)

  def getOrElse[B>:A](value: B):B
}

class No extends Maybe[Nothing] {

  def applyFunction[R](f: Nothing => R) = { new No() }

  def getOrElse[B](value: B) = value
}

class Yes[A](val storedVal:A) extends Maybe[A] {

  def applyFunction[R](f: A => R) = { new Yes[R](f(storedVal)) }

  def getOrElse[B>:A](value: B) = storedVal
}

val no = new No()
val yes  = new Yes[Int](1)
no.isInstanceOf[Maybe[_]]
yes.isInstanceOf[Maybe[_]]