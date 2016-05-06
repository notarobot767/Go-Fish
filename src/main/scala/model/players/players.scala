package model.players

import model.player._
import scala.collection.mutable.Queue

class Players extends Queue[Player] {

  override def toString: String = this.mkString(", ")

}