/*
Card Class
*/

package model.playing_cards

case class Card(val id: Int, val suit: Char) {
  //id 1-14
  //suit H, D, C, S
  
  //map id to string face value; see Statics
  def getFace: String = id match {
    case x if(x >= 2 && x <= 10) => id.toString
    case 11 => "J"
    case 12 => "Q"
    case 13 => "K"
    case 14 => "A"
  }

  //string representation: ex) 2 of Hearts -> "[2-H]"
  override def toString: String = "[" + getFace + s"-$suit]"
}