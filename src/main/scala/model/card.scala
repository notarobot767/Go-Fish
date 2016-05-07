package model

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