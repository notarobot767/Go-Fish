package model.deck

import model.card._
import scala.collection.mutable.Queue

class deck extends Queue[Card] {

  override def toString: String = this.mkString(", ")

}