package model

import model.statics.Statics

import scala.collection.mutable.Queue

class Players extends Queue[Player] {

  override def toString: String = this.mkString(", ")

  //advance order of players
  def advanceOrder: Boolean = {this.enqueue(this.dequeue); true}

  var players_arry = Array[Player]()

  private var leader = Player("place_holder")
  def get_leader: String = this.leader.toString 

  //update the leader (how has most points currently)
  def update_leader = players_arry.foreach(p =>
      if(p.getPoints > this.leader.getPoints) this.leader = p)

  //set up new players from Statics
  def initialize = {
    this.clear
    Statics.players_arry.foreach(p => this.enqueue(Player(p)))
    players_arry = this.toArray
  }

  //show players
  def show: String = {
    var gameStr = ""
    this.foreach({p => gameStr += p.show + "\n\n"})
    gameStr
  }
}