package strategy

import model._

case class Strat(val name: String, findMoves: Player => Boolean) {
  override def toString: String = name
}