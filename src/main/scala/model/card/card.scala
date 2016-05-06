package model.card

//####Card Class####
case class Card(val id: Int, val face: String, val suit: String) {

  override def toString: String = "[" + face + "-" + suit + "]"

}