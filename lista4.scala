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

def teste[A](bt: BT[A]) = {
  def helper[A](list: List[A], list2: List[A]): List[Any] = {
    list match {
      case Nil => list2 match {
                    case Nil => Nil
                    case _ => helper(list2.reverse, List())
                  }
      case Empty :: tail => helper(tail, list2)
      case Node(v, l, r) :: tail => v :: helper(tail, r :: l :: list2)
    }
  }
  helper(List(bt), List())
}

breadth(newbt)

val newbt = Node(5,Node(4,Node(2,Empty,Empty),Node(8,Node(3,Empty,Empty),Empty)),Node(1,Node(7,Node(6,Empty,Node(9,Empty,Empty)),Empty), Node(0,Empty,Empty)))

teste(newbt)


sealed trait Graphs[A]
case class Graph[A](succ: A=>List[A]) extends Graphs[A]

val g = Graph((i: Int) => i match {
  case 0 => List(3)
  case 1 => List(0,2,4)
  case 2 => List(1)
  case 3 => Nil
  case 4 => List(0,2)
  case n => throw new Exception("Graph g: node " + n + " doesn't exist")
})

def deepSearch[A] (g: Graph[A]) (startNode: A): List[A] = {
  def search(visited: List[A])(toVisit: List[A]): List[A] = toVisit match {
    case Nil => Nil
    case h::t =>
                if (visited contains h) search(visited)(t)
                else h::search(h::visited)(t ++ (g succ h))
    }
  search (Nil) (List(startNode))
}
breadthSearch (g)(4)

def deepS[A] (g: Graph[A]) (startNode: A): List[A] = {
  def search(visited: List[A])(toVisit: List[A]): List[A] = toVisit match {
    case Nil => Nil
    case h::t =>
                if (visited contains h) search(visited)(t)
                else h::search(h::visited)((g succ h) ++ t)
    }
  search (Nil) (List(startNode))
}

deepS(g)(4)