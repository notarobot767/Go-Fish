/*
Player Order Class
*/

package model.players

import scala.collection.mutable.Queue

class Players extends Queue[Player] {
  
  //player names separated by comma
  override def toString: String = this.mkString(", ")
  
  //4 static players
  val static_players = List (
    "Ender",
    "Sabriel",
    "Eragon",
    "Artemis"
  )
}