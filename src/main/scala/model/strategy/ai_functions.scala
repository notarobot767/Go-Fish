/*
AI Functions
  the actual behaviors for a player
*/

package model.strategy

import model.data._
import model.loader._

import scala.collection.mutable.Queue

case class AI_Functions(data: Stencil, loader: Loader) extends Queue[Strat] {
  private val deck = data.deck
  private val players = data.players

  //for random functions picking cards or IDs
  private val random = scala.util.Random

  //return random player (other current player up)
  private def returnRndPlayer: Player =
    return players.tail(random.nextInt(players.length-1))

  //return random card id from player (that you have)
  private def returnRndCardId(p: Player): Int = {
    val lst = p.get_hand.keys.toList
    if(lst.nonEmpty) lst(random.nextInt(lst.length))
    else -1
  }

  /*
  Old Man AI
    randomly pick card_id (that you have)
    randomly pick player (other then self)
  */
  def doMove_oldMan(p: Player): Boolean = {
    while(true) {
      //empty hand
      if(p.get_hand.isEmpty) {
        loader.load_emptyHand(p)
        return true
      }

      //random valid move
      if(loader.load(p, this.returnRndPlayer, this.returnRndCardId(p))) return true
    }
    false
  }; this.enqueue(Strat("Old Man", doMove_oldMan))

  /*
  God AI
  */
  def doMove_god(p: Player): Boolean = {
    println("doing move with AI god!")
    true
  }; this.enqueue(Strat("God", doMove_god))

  /*
  James Bond AI
  */
  def doMove_jamesBond(p: Player): Boolean = {
    println("doing move with AI James Bond!")
    true
  }; this.enqueue(Strat("James Bond", doMove_jamesBond))

  /*
  Average Jeff AI
  */
  def doMove_averageJeff(p: Player): Boolean = {
    println("doing move with AI Average Jeff!")
    true
  }; this.enqueue(Strat("Average Jeff", doMove_averageJeff))
}