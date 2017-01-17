class TestThread(var sleep: Int = 2000) extends Thread
{
  override def run: Unit = {
    Thread.sleep(sleep)
    print("Hello")
  }
  def printFast: Unit = {
    Thread.sleep(300)
    print("Sleepy")
  }
}

val t1: TestThread = new TestThread;
val t2: TestThread = new TestThread(300);
t1.run
t2.run


s