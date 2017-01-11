//SCALA:

def ltest (n:Int): Stream[Int] = {
  def helper(x:Int):Stream[Int]={
    if(x>0) Stream.cons(x, helper(-x))
    else Stream.cons(x, helper(-x+1))
  }
  helper(n)
}

ltest(5).take(10) toList
