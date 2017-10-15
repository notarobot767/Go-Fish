/*
Player Class
*/

package model.players

import scala.collection.mutable.Map
import model.playing_cards.Card

case class Player(val name: String) {
  
  //points - per pair of 2 like cards
  var points: Int = 0
  
  //cards in hand
  val hand = Map[Int, List[Card]]()
  
  override def toString: String = name
}
