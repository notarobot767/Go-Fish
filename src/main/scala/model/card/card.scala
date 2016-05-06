package model.card

/** a playing card in the game
  *
  * @constructor create a new card with id, face, and suit
  * @param id the integer id of the card (2-14)
  * @param face the string representation of the id
  * @parm suit the string representation of the card suit
  */
case class Card(val id: Int, val face: String, val suit: String) {

  /** display a card. ex) 2 of Hearts => [2-H] */
  override def toString: String = s"[$face-$suit]"

}