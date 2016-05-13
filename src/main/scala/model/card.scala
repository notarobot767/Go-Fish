package model

import model.statics.Statics

case class Card(val id: Int, val suit: String) {
  //map id to string face value
  def getFace: String = Statics.getFace(this.id)

  //string representation: ex) 2 of Hears -> "[2-H]"
  override def toString: String = "[" + this.getFace + s"-$suit]"
}