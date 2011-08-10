import scala.collection.mutable.HashMap

object Sex extends Enumeration {
  type Sex = Value
  val male = Value("male")
  val female = Value("female")
  val other = Value("other")
}

object Power {
  var powers = new HashMap[String, String] // power -> description
  var secondaryPowers = new HashMap[String, String] // [usage] Power.secondaryPowers += "regeneration" -> "heal faster than normal"
}

import Sex._
import Power._

class Power(power: String) {
  private var powers: List[String] = List(power)
  
  def getPowers(): Unit = {
    for(power <- this.powers) { 
      println(power)
    }
  }
  def addPower(power: String): Unit = {
      this.powers = List(power) ++ this.powers
  }
  def addPowers(power: String): List[String] = {
    if (Power.powers.get(power) == None)
      List()
    else {
      List(power) ++ this.powers
    }
  }
}

abstract class Homosapien {
  def name:HashMap[String, String]
  def sex: Sex
}

trait power extends Homosapien {
  var power: List[Power] = List() //power name and description
}

trait secondaryPower extends Homosapien {
  var secondaryPower: List[Power] = List() //power name and description
}

class HomosapienSuperior(
  var name:HashMap[String, String],
  var sex:Sex
) extends Homosapien with power with secondaryPower

class HomosapienSuperiorSuperior(
  var name:HashMap[String, String],
  var sex:Sex
) extends Homosapien with power

val rogueName = HashMap("First Name" -> "Rogue")
val rogue = new HomosapienSuperior(rogueName,female)
val superStrength = new Power("Super Strength")
rogue.power = List(superStrength)
rogue.power(0).getPowers