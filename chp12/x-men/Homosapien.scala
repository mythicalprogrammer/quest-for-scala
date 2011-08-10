import scala.collection.mutable.HashMap

object Sex extends Enumeration {
  type Sex = Value
  val male = Value("male")
  val female = Value("female")
  val other = Value("other")
}

object Power {
  val powers = new HashMap[String, String] // power -> description
  val secondaryPowers = new HashMap[String, String]  // [usage] Power.secondaryPowers += "regeneration" -> "heal faster than normal"
}

import Sex._
import Power._

class Power(power: String) {
  private var powers: List[String] = List()
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
  val power: List[Power] = List() //power name and description
}

trait secondaryPower extends Homosapien {
  val secondaryPower: List[Power] = List() //power name and description
}

class HomosapienSuperior(
  val name:HashMap[String, String],
  val sex:Sex
) extends Homosapien with power with secondaryPower

class HomosapienSuperiorSuperior(
  val name:HashMap[String, String],
  val sex:Sex
) extends Homosapien with power
