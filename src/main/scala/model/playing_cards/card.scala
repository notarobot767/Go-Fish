/*
Card Class
*/

package model.playing_cards

case class Card(val id: Int, val suit: Char) {
  //id 1-14
  //suit H, D, C, S
  
  //map id to string face value; see Statics
  def getFace(c_id: Int): Option[String] = c_id match {
    case x if(x >= 2 && x <= 10) => Some(c_id.toString)
    case 11 => Some("J")
    case 12 => Some("Q")
    case 13 => Some("K")
    case 14 => Some("A")
    case _ => None
  }

  //string representation: ex) 2 of Hearts -> "[2-H]"
  override def toString: String = "[" + this.getFace(this.id) + s"-$suit]"
}