package controller

import model._
import model.players._
import model.playing_cards._
import scala.collection.mutable.Map

class Playerctrl (players: Players) {
  
  //
  def init = {
    players.clear
    players ++= players.static_players.map(Player(_))
  }
  
  //get the number of players
  def getNumPlayers: Int = players.length
  
  //advance order of players
  def advance = players.enqueue(players.dequeue)
  
  //who is up?
  def upNext: String = players.tail.head.toString
  def upNow: String = players.head.toString
  
  //list of highest highscores
  def getLeader: List[String] = {
    val leaderboard = Map[Int, List[String]]()
    players.foreach(p =>
      leaderboard += (p.points -> 
      (p.name +: leaderboard.getOrElse(p.points, List[String]()))))
    leaderboard.maxBy(_._1)._2
  }
  
  //take card and put in hand
  //false means no cards to draw or did not get a set of 4
  def draw(card: Option[Card]): Boolean = card match {
    case c: Some[Card] => {
      //move card to player hand
      val (card, hand) = (c.get, players.head.hand)
      //sort the list with each addition
      players.head.hand += (card.id ->
        (card +: hand.getOrElse(card.id, List[Card]())))
      check4(card.id)
    }
    case None => false
  }
  
  //does current player have 4 of a kind of this card id?
  def check4(card_id: Int): Boolean = {
    val complete_set = 4
    players.head.hand.get(card_id) match {
      case h: Some[List[Card]] => if(h.get.length == complete_set) true else false
      case None => false
    }
  }
  
  //check4 for current player
  //if found 4, prune and add points
  def pruneSet(card_id: Int): Boolean = {
    if(check4(card_id)) {
      val set_points = 4
      players.head.hand -= card_id
      players.head.points += set_points
      true
    }
    else false
  }
  
  def show: String = players.map(
    p => s"$p: ${p.points} " +
    p.getHandList.mkString(", ")
    ).mkString("\n")
}