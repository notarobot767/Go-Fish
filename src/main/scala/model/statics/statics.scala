package model.statics

object Statics {

  //player stuff
  val players_arry = Array("Ender", "Sabriel", "Eragon", "Artemis")

  //deck stuff
  val cardSuits = Array("H", "D", "S", "C")
  val cardIDRange = Range(2,15)
  def getFace(c_id: Int): String = c_id match {
    case x if(x >= 2 && x <= 10) => c_id.toString
    case 11 => "J"
    case 12 => "Q"
    case 13 => "K"
    case 14 => "A"
  }
}