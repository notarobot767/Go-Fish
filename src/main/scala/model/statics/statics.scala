/*
Statics Object
  Stuff in model that is static (hardcoded)
*/

package model.statics

object Statics {

  //static players
  val players_arry = Array("Ender", "Sabriel", "Eragon", "Artemis")

  //static card suits
  val cardSuits = Array('H', 'D', 'S', 'C')

  //range of card IDs
  val cardIDRange = Range(2,15)

  //cardID to face
  def getFace(c_id: Int): String = c_id match {
    case x if(x >= 2 && x <= 10) => c_id.toString
    case 11 => "J"
    case 12 => "Q"
    case 13 => "K"
    case 14 => "A"
  }

  //default strategy each player will be assigned
  val default_strat = 1
}