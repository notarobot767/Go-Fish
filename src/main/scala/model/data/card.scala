/*
Card Class
  This is what makes up the deck
  id: Integer 2-14 representing 2-Ace
  suit: this is the Char representation of the suit
    Hearts -> 'H', Diamonds -> 'D', Spades -> 'S', Clubs -> 'C'
*/

package model.data

import model.statics.Statics

case class Card(val id: Int, val suit: Char) {
  //map id to string face value; see Statics
  def getFace: String = Statics.getFace(this.id)

  //string representation: ex) 2 of Hearts -> "[2-H]"
  override def toString: String = "[" + this.getFace + s"-$suit]"
}