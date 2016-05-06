package model.deck

import model.card._
import scala.collection.mutable.Queue

/** a playing card in the game
  *
  * @constructor create a new card with id, face, and suit
  * @param id the integer id of the card (2-14)
  * @param face the string representation of the id
  * @parm suit the string representation of the card suit
  */
class deck extends Queue[Card] {

  override def toString: String = this.mkString(", ")

}