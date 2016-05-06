package model.card

/* class for a playing card
id: Integer from 2 to 14

suit: string representation of card suit
  There are 4
  Heart -> "H", Diamond -> "D", Spade -> "S", Club -> "C"
  see statics
*/
case class Card(val id: Int, val suit: String) {
  //map id to string face value
  def getFace: String = this.id match {
      case x if(x >= 2 && x <= 10) => this.id.toString
      case 11 => "J"
      case 12 => "Q"
      case 13 => "K"
      case 14 => "A"
  }

  //string representation: ex) 2 of Hears -> "[2-H]"
  override def toString: String = "[" + this.getFace + s"-$suit]"
}