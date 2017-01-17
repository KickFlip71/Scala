import java.awt.Color

class Queue[+A] (private val l1: List[A], private val l2: List[A]) {
  class EmptyException(message: String) extends Exception(message)

  def this() = this(Nil, Nil)

  def enqueue[B >: A](elem: B) = {
    (l1, l2) match {
      case (Nil, Nil) => new Queue(List(elem), Nil)
      case (lt1, lt2) => new Queue(l1, elem :: l2)
    }
  }

  def dequeue() = {
    (l1, l2) match {
      case (Nil, Nil) => this
      case (List(_), l) => new Queue(l.reverse, Nil)
      case (_ :: t, l) => new Queue(t, l)
    }
  }

  def first() = {
    (l1, l2) match {
      case (Nil, Nil) => throw new EmptyException("Kolejka jest pusta!")
      case (h :: _, _) => h
      case _ => throw new EmptyException("Błąd implementacji!")
    }
  }
  def isEmpty = l1 == Nil
}

class Point(var x:Double = 0.0, var y:Double = 0.0) {
  override def toString = "[" + x + ", " + y + "]"
}

class Pixel(xp:Double=0.0, yp:Double=0.0, var color:Color = Color.BLACK) extends Point(xp, yp) {
  override def toString = super.toString + " " + color
}

// Tests 
var queue = new Queue[Point]
val point = new Point()
val pixel = new Pixel()

val queue = u.enqueue(point).enqueue(pixel)
queue.first
queue.dequeue.first

// Test 2
var queueOfPoints = new Queue[Point].enqueue(point)
queueOfPoints.first
var queueOfPixels = new Queue[Pixel].enqueue(pixel)
queueOfPixels.first

queueOfPoints = queueOfPixels
queueOfPoints.first