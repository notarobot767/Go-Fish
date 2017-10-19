/*
Player Class
*/

package model.players

import scala.collection.mutable.Map
import model.playing_cards.Card

case class Player(val name: String) {
  
  override def toString: String = name
  
  //points - per pair of 2 like cards
  var points: Int = 0
  
  //cards in hand
  val hand = Map[Int, List[Card]]()
  
  //sorts by card_id
  //assumes cards with list in map are already sorted
  //see playerctrl draw for cards of same id sorting
  def getHandList: Seq[Card] = hand.toSeq.sortBy(_._1).flatMap(i => i._2)
}