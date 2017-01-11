sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem: A, left: BT[A], right: BT[A]) extends BT[A]


def breadth[A](bt: BT[A]) = {
  def helper[A](list: List[A]): List[Any] = {
    list match {
      case Nil => Nil
      case Empty :: tail => helper(tail)
      case Node(v, l, r) :: tail => v :: helper(tail ::: (l :: r :: Nil))
    }
  }
  helper(List(bt))
}


val tt = Node(1,
  Node(2,
    Node(4,
      Empty,
      Empty),
    Empty),
  Node(3,
    Node(5,
      Empty,
      Node(6,
        Empty,
        Empty)),
    Empty))

val newbt = Node(5,Node(4,Node(2,Empty,Empty),Node(8,Node(3,Empty,Empty),Empty)),Node(1,Node(7,Node(6,Empty,Node(9,Empty,Empty)),Empty), Node(0,Empty,Empty)))

breadth(newbt)

