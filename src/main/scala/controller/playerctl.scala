package controller

import model._
import model.players._
import model.playing_cards._
import scala.collection.mutable.Map

class Playerctl (players: Players, deckctl: Deckctl) {
  
  //
  def init = {
    players.clear
    for(p <- players.static_players) players.enqueue(Player(p))
  }
  
  //advance order of players
  def advance = players.enqueue(players.dequeue)
  
  //who is up next
  def upNext: String = players.tail.head.toString
  
  //list of highest highscores
  private getLeader: List[String] = {
    val leaderboard = Map[Int -> List[String]]
    players.foreach(p => lead += p.points +: leaderboard.getOrElse(p.points, List[String]()))
    leaderboard.max._2
  }
 
  //draw from deck and put card in hand of current player
  //false means no cards to draw
  def draw: Boolean = {
    if(deckctl.isEmpty) false
    else {
      val card = deckctl.draw
      val hand = players.head.hand
      hand += (card.id -> card +: hand.getOrElse(card.id, List[Card]))
      //check for 4
      true
    }
  }
  
  def show: String = {
    var ans_str = ""
    for(p <- players) ans_str += p.toString 
    ans_str
  }
}