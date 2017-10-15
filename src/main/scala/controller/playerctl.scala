package controller

import model._
import model.players._
import scala.collection.mutable.map

class Playerctl (players: Players){
  
  //advance order of players
  def advance: Players = players.enqueue(players.dequeue)
  
  //who is up next
  def upNext: Player = players.tail.head
  
  /*
  private def getLeaderboard: Map[Int -> List[Player]] = {
    
  }
  */
  
  //who is in the lead
  def leader: Player = {
    //get leaderbard then parse
    players.head
  }
  
  //show to player queue
  def show: String = players.toString
  
}