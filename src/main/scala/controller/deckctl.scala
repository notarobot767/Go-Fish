package controller

import model._
import model.playing_cards._

class Deckctl (private val deck: Deck) {
  
  //count number of cards
  def count: Int = deck.length
  
  //shuffle a deck
  def shuffle: Deck = {
    val shuffled_deck = util.Random.shuffle(deck)
    deck.clear
    deck ++= shuffled_deck
    deck
  }
  
  //draw a card
  def draw: Option[Card] = {
    if(deck.nonEmpty) Some(deck.dequeue)
    else None
  }
  
  def show: String = s"*Deck ($count Cards)\n$deck"
}