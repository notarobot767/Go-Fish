package controller

import model._
import model.players._
import model.playing_cards._
import scala.collection.mutable.Map

class Playerctl (players: Players, deckctl: Deckctl) {
  
  //
  def init = {
    players.clear
    players ++= players.static_players.map(Player(_))
  }
  
  //advance order of players
  def advance = players.enqueue(players.dequeue)
  
  //who is up next
  def upNext: String = players.tail.head.toString
  
  //list of highest highscores
  def getLeader: List[String] = {
    val leaderboard = Map[Int, List[String]]()
    players.foreach(p =>
      leaderboard += (p.points -> (p.name +: leaderboard.getOrElse(p.points, List[String]())))
    )
    leaderboard.maxBy(_._1)._2
  }
  
  //draw from deck and put card in hand of current player
  //false means no cards to draw
  def draw: Boolean = {
    if(deckctl.isEmpty) false
    else {
      //move card to player hand
      val (card, hand) = (deckctl.draw, players.head.hand)
      hand += (card.id -> (card +: hand.getOrElse(card.id, List[Card]())))
      
      //check for 4
      true
    }
  }
  
  def show: String = players.map(
    p => s"$p: ${p.points} " +
    p.getHandList.mkString(", ")
    ).mkString("\n")
}