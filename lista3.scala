/* Zadanie 3 */
()

def sumProd(list: List[Int]) = list.foldLeft (0,1)((x,b) => (x._1 + b,x._2 * b))

sumProd(List())

/* Zadanie 2 */

def uncurry[A,B,C,D](f: A => B => C => D): (A,B,C) => D = (x1,x2,x3) => f(x1)(x2)(x3)

def curry[A,B,C,D](f: (A,B,C) => D): A => B => C => D = (x1) => (x2) => (x3) => f(x1,x2,x3)

val sum = (x:Int) => (y:Int) => (z:Int) => x+y+z


uncurry(sum)(1,2,3)

val add = (x:Int, y:Int, z:Int) => x+y+z

curry(add)(1)(2)(3)

/* TESTING */


def sum3 = (x: Int) => (y: Int) => (z: Int) => x + y + z

val usum3 = (x: Int, y: Int, z: Int) => x+y+z

def curry[A,B,C,D](f: (A,B,C) => D): A => B => C => D = (x) => (y) => (z) => f(x,y,z)

curry (usum3)(1)(2)(3)

def uncurry[A,B,C,D](f: A => B => C => D): (A,B,C) => D = (x,y,z) => f(x)(y)(z)

uncurry(sum3)(1,2,3)