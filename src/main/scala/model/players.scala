package model

import scala.collection.mutable.Queue

class Players extends Queue[Player] {

  override def toString: String = this.mkString(", ")

  //advance order of players
  def advanceOrder: Boolean = {this.enqueue(this.dequeue); true}

  //set up new players from Statics
  def initialize = {
    this.clear
    Statics.players_arry.foreach(p => this.enqueue(Player(p)))
  }

  //show players
  def show: String = {
    var gameStr = ""
    this.foreach({p => gameStr += p.show + "\n\n"})
    gameStr
  }
}