/*
Strat Class
  holds an AI function
*/

package model.strategy

import model.data._

case class Strat(val name: String, findMoves: Player => Boolean) {
  override def toString: String = name
}