class Time(x: Int) {
  hour = x
  
  private[this] var h: Int = _
  def hour: Int = h
  def hour_=(x: Int){
    if(x < 0) h = 0
    else h = x
  }
}

object Time {	
  def apply(hour: Int) = new Time(hour)
}

val test = new Time(-20)
val test2 = Time(-2)
test.hour
test.hour = 20
test2.hour

test.hour = 22
test.hour




// 2

class Time(x: Int, y: Int){
  require(0<=x && x<24 && 0<=y && y<60)
  private var h: Int = x
  private var m: Int = y
  
  def hour: Int = h
  def min: Int = m
  
  def hour_=(x: Int){
    require(0 <= x && 24 > x)
    h = x
  }
  
  def min_=(x: Int){
    require(0 <= x && 60 > x)
    m = x
  }
  
  def before(t: Time): Boolean = {
    t.hour > this.hour || (t.hour == this.hour && t.min > this.min)
  }
}

val time1 = new Time(5, 30)
time1.hour
val time2 = new Time(23, 30)
println(time1.before(time2))

class Time2(h: Int, m: Int){
  require(0<=h && h<24 && 0<=m && m<60)
  private var value: Int = h*60+m
  def hour: Int = value/60
  def hour_=(x: Int) {
    require(0<=x && x<24)
    value = value%60 + x*60
  }
  def min: Int = value%60
  def min_=(x: Int) {
    require(0<=x && x<60)
    value -= value%60
    value += x
  }
  def before(other: Time2): Boolean = {
    value < other.value
  }
}

val time1 = new Time2(12,30)
val time2 = new Time2(11,30)
time2.before(time1)


//3


