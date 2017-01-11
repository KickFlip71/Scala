/* Zadanie 3 */

def sumProd(list: List[Int]) = list.foldLeft (0,1)((x,b) => (x._1 + b,x._2 * b))

/* Zadanie 2 */

def uncurry[A,B,C,D](f: A => B => C => D): (A,B,C) => D = (x1,x2,x3) => f(x1)(x2)(x3)

def curry[A,B,C,D](f: (A,B,C) => D): A => B => C => D = (x1) => (x2) => (x3) => f(x1,x2,x3)

val sum = (x:Int) => (y:Int) => (z:Int) => x+y+z

val add = (x:Int, y:Int, z:Int) => x+y+z
