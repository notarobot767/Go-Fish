package controller

import model._
import model.players._
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
  
  //who is in the lead
  def leader: String = {
    //get leaderbard then parse
    ???
  }
  
  //draw from deck and put card in hand of current player
  def draw = ???
  
  def show: String = {
    var ans_str = ""
    for(p <- players) ans_str += p.toString 
    ans_str
  }
}