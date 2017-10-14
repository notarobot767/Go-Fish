/*
Deck Class
  the deck of cards
  represented by a Queue
*/

package model.playing_cards

import scala.collection.mutable.Queue

class Deck extends Queue[Card] {
  override def toString: String = this.mkString(", ")
}