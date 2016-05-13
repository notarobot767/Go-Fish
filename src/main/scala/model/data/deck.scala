/*
Deck Class
  the deck of cards
*/

package model.data

import model.statics.Statics

import scala.collection.mutable.Queue

class Deck extends Queue[Card] {
  //ex) [5-C], [9-S], [5-H], [10-S]...
  override def toString: String = this.mkString(", ")

  //count the number of cards in the deck
  def count: Int = this.length

  //create a new unshuffled deck
  def createNew: Deck = {
    this.clear
    Statics.cardIDRange.foreach({c_id => Statics.cardSuits.foreach({c_suit => 
      this.enqueue(Card(c_id, c_suit))})})
    this
  }

  //shuffle a deck
  def shuffle: Deck = {
    val shuffled_deck = util.Random.shuffle(this)
    this.clear; this ++= shuffled_deck; this
  }

  //draw a card
  def draw: Card = this.dequeue

  //used in showGameArea
  def show: String = s"*Deck ($count Cards)\n$this"
}