// Zad 1

val s = Stream.cons(1, Stream.cons(2, Stream.cons(3, Stream.empty)))
s toList

def lrepeat[A](count: Int, s: Stream[A]): Stream[A] ={
  def repeat(c: Int, s: Stream[A]): Stream[A] =
    (c, s) match {
      case (_, Stream.Empty) => Stream.Empty
      case (n, Stream.cons(x, xf)) => if(n == 0) repeat(count, xf)
                                      else Stream.cons(x, repeat(n-1, Stream.cons(x, xf)))
    }
    repeat(count, s)
}

lrepeat(3, s) toList

// Zad 2

val fibs = {
  def fibs_iter(current: BigInt, next: BigInt): Stream[BigInt] =
    Stream.cons(current, fibs_iter(next, current + next))
  fibs_iter(0,1)
}

fibs.take(10) toList

let fibs = 
	let rec fibs_iter current next =
		LCons(current, fun() -> fibs_iter next (current + next))
	in fibs_iter 0 1



// Zad 3
sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem:A, left:()=>lBT[A], right:()=>lBT[A]) extends lBT[A]

def ltree(n: Int): lBT[Int] = LNode(n, ()=>ltree(2*n+1), ()=>ltree(2*n+2))

def lbreadth[A](lbt: lBT[A]): Stream[A] = {
  def helper(el: List[lBT[A]]): Stream[A] =
    el match {
        case Nil => Stream.Empty
        case LEmpty :: tail => helper(tail)
        case LNode(v, l, r) :: tail => Stream.cons(v, helper( tail ++ ( l() :: r() :: Nil) ))
    }
  helper(List(lbt))
}

lbreadth(ltree(4)).take(20).toList

