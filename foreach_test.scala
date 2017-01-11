import scala.collection.Traversable
import scala.collection.mutable.Seq

def copy[T](dest: Seq[T], src: Seq[T]) = {
  var i = 0
  src foreach { el => dest.update(i, el); i+=1 }
}
