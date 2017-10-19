package controller

import model._
import model.playing_cards._

class Deckctrl (deck: Deck) {
  
  //return a shuffled deck
  private def shuffle(d: List[Card]): Deck = new Deck ++= util.Random.shuffle(d)
  
  //return a new unshuffled deck
  private def getNewDeck(card_ids: List[Int]): List[Card] = {
    if(card_ids.nonEmpty) deck.card_suits.map(
      s => Card(card_ids.head, s)) ++: getNewDeck(card_ids.tail)
    else List[Card]()
  }
  
  //initiate a new deck
  def init = {
    deck.clear
    deck ++= shuffle(getNewDeck(deck.card_ids))
  }
  
  //count number of cards
  def count: Int = deck.length
  
  //draw a card if available
  def draw: Option[Card] = if(isEmpty) None else Some(deck.dequeue)
  
  //does deck have cards?
  def isEmpty: Boolean = deck.isEmpty
  def nonEmpty: Boolean = deck.nonEmpty
  
  //text show of cards
  def show: String = deck.toString
}