class Pojazd(val producer: String, val model: String, val prodYear: Int, var regNum: String){
  
  def this(prod: String, mod: String){
    this(prod, mod, -1, "")
  }
  
  def this(prod: String, mod: String, reg: String){
    this(prod, mod, -1, reg)
  }
  
  def this(prod: String, mod: String, year: Int){
    this(prod, mod, year, "")
  }
  
}

//class Pojazd(prod: String, model: String, val productionYear: Int = -1) extends Superclass(prod, model)
class Pojazd(val producer: String, val model: String, val productionYear: Int = -1, var registrationNumber: String = "")

var a = new Pojazd("bw", "bw", "2220")
a.regNum
var b = new Pojazd("bw", "bw", 2220, "DW1231")
var c = new Pojazd(regNum = "DW", prodYear = 2001, producer = "kek", model = "ok")

//
//var a = new Pojazd("bmw")
//a.model
//var b = new Pojazd("vw", "golf", 1998)
//var c = new Pojazd("fiat", "panda", 2001, "TEST1")
//var d = new Pojazd("renault", "megane", registrationNumber = "TEST2")
//
//a.productionYear
//b.productionYear
//d.registrationNumber
//c.registrationNumber