package controller

import model._
import model.playing_cards._

class Deckctl (deck: Deck) {
  
  //return a shuffled deck
  private def shuffle(d: List[Card]): Deck = new Deck ++= util.Random.shuffle(d)
  
  //return a new unshuffled deck
  def getNewDeck(card_ids: List[Int]): List[Card] = {
    if(card_ids.nonEmpty) deck.card_suits.map(
      s => Card(card_ids.head, s)) ++: getNewDeck(card_ids.tail)
    else List[Card]()
  }
  
  private def deal = ???
  
  //initiate a new deck
  def init = {
    deck.clear
    deck ++= shuffle(getNewDeck(deck.card_ids))
    //deck.deal
  }
  
  //count number of cards
  def count: Int = deck.length
  
  //draw a card; does check if deck empty
  def draw: Card = deck.dequeue
  
  //text show of cards
  def isEmpty: Boolean = deck.isEmpty
  def nonEmpty: Boolean = deck.nonEmpty
  
  def show: String = deck.toString
}