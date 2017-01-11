def whileLoop(condition: => Boolean)(expression: => Unit): Unit = {
  if (condition) {
    expression
    whileLoop(condition)(expression)
  }
}


