class Time private (var h: Int, var m: Int){
  require(0<=h && h<24 && 0<=m && m<60)
  def hour: Int = h
  def hour_=(x: Int) {
    require(0<=x && x<24)
    h = x
  }
  def min: Int = m
  def min_=(x: Int) {
    require(0<=x && x<60)
    m = x
  }
  def before(other: Time): Boolean = {
    (h == other.hour && m < other.min) || h < other.hour
  }
}
val test = new Time(21,37)
val test2 = new Time(9,11)

test2.before(test)
//test.min=213

class Time2(h: Int, m: Int){
  hour = h
  min = m
  private var value: Int = h*60+m
  def hour: Int = value/60
  def hour_=(x: Int) {
    require(0<=x && x<24)
    value = value%60
    value += x*60
  }
  def min: Int = value%60
  def min_=(x: Int) {
    require(0<=x && x<60)
    value -= value%60
    value += x
  }
  def before(other: Time2): Boolean = {
    value < other.hour*60+other.min
  }
}

val test3 = new Time2(21,37)
val test4 = new Time2(9,11)

test2.before(test)