/*
Players class
  holds the players
  keeps track of who's turn it is
*/

package model.data

import model.statics.Statics

import scala.collection.mutable.Queue

class Players extends Queue[Player] {

  //player names separated by comma
  override def toString: String = this.mkString(", ")

  //advance order of players
  def advanceOrder: Boolean = {this.enqueue(this.dequeue); true}

  //array of players; perserves a static order unlike the queue
  var players_arry = Array[Player]()

  //who is up next?
  def upNext: Player = this.tail.head

  //the player currently in the lead with points
  private var leader = Player("place_holder")
  def get_leader: String = this.leader.toString

  //update the leader (who has most points currently)
  def update_leader = players_arry.foreach(p =>
    if(p.get_points > this.leader.get_points) this.leader = p)

  //set up new players from Statics
  def initialize = {
    this.clear
    Statics.players_arry.foreach(p => this.enqueue(Player(p)))
    players_arry = this.toArray
  }

  //show players; used in showGameArea
  def show: String = {
    var gameStr = ""
    this.foreach({p => gameStr += p.show + "\n"*2})
    gameStr
  }
}