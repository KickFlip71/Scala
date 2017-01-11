import scala.collection.Traversable
import scala.collection.mutable.Seq

def copy[T](dest: Seq[T], src: Seq[T]) = {
  var i = 0
  src foreach { el => dest.update(i, el); i+=1 }
}


val test1 = Seq("test","kek","keke")
val test2 = Seq(1,2,3)
copy[Any](test1,test2)
test1