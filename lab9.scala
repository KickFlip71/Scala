class MyException(msg: String) extends Exception(msg){
  
}

class Date(x: Int, y: Int){
  private var m: Int = _
  private var d: Int = _
  
  if(x > 30) d = 30
  else if(x <= 0) d = 1
  else d = x
  
  if(y > 12) m = 12
  else if(y <= 0) m = 1
  else m = y
  
  
  def month: Int = m
  def day: Int = d
  
  def month_=(x: Int){
    if(x > 12 || x <= 0) throw new MyException("Zły miesiąc")
    m = x
  }
  
  def day_=(x: Int){
    if(x > 30 || x <= 0) throw new MyException("Zły dzien")
    d = x 
  }

  def przesun(x: Int){
    val temp = d+x
    if(temp > 30){
      d = temp%30
      if(d == 0) d = 30
      m = (m + ((temp-1)/30))%12
      if(m==0) m=12
    }
    else d = temp
  }
}

object Date {	
  def apply(d: Int, m: Int) = new Date(d, m)
}

class Date2(private var d: Int, private var m: Int){  
  if(d > 30) d = 30
  else if(d < 1) d = 1
  
  if(m > 12) m = 12
  else if(m < 1) m = 1
  
  private var value: Int = ((m-1)*30)+(d-1)
  
  def month: Int = {
    (value/30)+1
  }
  def month_=(x: Int) {
    if(0>=x && x>12) throw new Exception("Zły miesiąc")
    value = value%30 + (x-1)*30
  }
  def day: Int = {
    (value%30)+1
  }
  def day_=(x: Int) {
    if(0>=x && x>30) throw new Exception("Zły dzien")
    value = (month-1)*30+(x-1)
  }
  
  def przesun(x: Int){
    value = (value+x)%360
  }
  
}

val d2 = new Date2(16,11)
d2.przesun(16) 
d2.month 
d2.day 

class Student(val index: Int, val imie: String, var nazwisko: String, var miasto: String = "", var dochody: Int = 0){
  
  def this(index: Int, im: String, nazw: String, doch: Int){
    this(index, im, nazw, dochody = doch)
  }
  
  override def toString(): String={
    index +" "+imie+" "+nazwisko+" "+miasto+" "+dochody
  }
}
