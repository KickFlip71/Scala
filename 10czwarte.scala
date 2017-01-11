import scala.collection.Traversable
import scala.collection.mutable.Seq
class CopySeq[T] {
  def copy[A <: T](dest: Seq[T], src: Seq[A]) = {
    var i = 0
    src foreach {
      el =>
        dest.update(i, el)
        i += 1
    }
  }
}

val test1 = Seq(2,"test",3,4,5)
val test2 = Seq("asd","lololo")
val tester = new CopySeq[Any]
tester.copy(test1,test2)
test1