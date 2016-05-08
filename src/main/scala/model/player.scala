package model

import scala.collection.mutable.Map
import scala.collection.mutable.ListBuffer

case class Player(val name: String) {

  override def toString: String = name

  //player points
  private var points = 0
  def getPoints = this.points

  //number of cards in hand; does not include sets
  private var cardCount = 0
  def getCardCount = this.cardCount

  //actual hand mapping
  private val hand = Map[Int, List[Card]]()
  def get_hand: Map[Int, List[Card]] = this.hand

  //if have set of 4, remove from hand and +1 to points
  private def check4(c_id: Int) = {
    if(hand(c_id).length == 4) {
      this.points += 1; this.hand -= c_id; this.cardCount -= 4
    }
    else if(this.hand(c_id).length > 1)
      this.hand += c_id -> this.hand(c_id).sortBy(_.suit)
  }

  //draw a card from deck and add to hand
  def addCard(card: Card) = {
    this.cardCount += 1
    this.hand += card.id -> (card +: hand.getOrElse(card.id, List[Card]()))
    this.check4(card.id)
  }

  def addCards(c_lst: List[Card]) = c_lst.foreach(c => this.addCard(c))

  def remove(c_id: Int) ={
    this.cardCount -= this.get_hand(c_id).length
    this.hand -= c_id
  }

  //show game space of players
  def show: String = {
    def showHand: String = {
      if(this.cardCount == 0) ""
      else {
        val lst = ListBuffer[Card]()
        this.hand.toSeq.sortBy(_._1).foreach(_._2.foreach(lst += _))
        lst.mkString(", ")
      }
    }
    s"$name ($cardCount Cards, $points Points)\n$showHand"
  }
}