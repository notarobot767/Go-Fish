/*
AI controller
  manages the AI functions
  maps an AI to a player
*/

package model.strategy

import model.data._
import model.loader._

import scala.collection.mutable.Map

class AI(data: Stencil, loader: Loader) {
  private val deck = data.deck
  private val players = data.players

  val strat_playerMap = Map[Player, Strat]()
  val strat_idMap = Map[Int, Strat]()

  private var i = 1
  private val default_strat = 1
  private var console_flag = false
  private val random = scala.util.Random

  //return random player (other current player up)
  private def returnRndPlayer(): Player =
    return players.tail(random.nextInt(players.length-1))

  //return random card id from player (that you have)
  private def returnRndCardId(p: Player): Int = {
    val lst = p.get_hand.keys.toList
    if(lst.nonEmpty) lst(random.nextInt(lst.length))
    else -1
  }

  def doMove_oldMan(p: Player): Boolean = {
    while(true) {
      //empty hand
      if(p.get_hand.isEmpty) {loader.load_emptyHand(p, console_flag); return true}
      //random valid move
      if(loader.load(p, this.returnRndPlayer, this.returnRndCardId(p), this.console_flag))
        return true
    }
    false
  }; strat_idMap += i -> Strat("Old Man", doMove_oldMan); i += 1

  def doMove_god(p: Player): Boolean = {
    println("doing move with AI god!")
    true
  }; strat_idMap += i -> Strat("God", doMove_god); i += 1

  def doMove_jamesBond(p: Player): Boolean = {
    println("doing move with AI James Bond!")
    true
  }; strat_idMap += i -> Strat("James Bond", doMove_jamesBond); i += 1

  def doMove_averageJeff(p: Player): Boolean = {
    println("doing move with AI Average Jeff!")
    true
  }; strat_idMap += i -> Strat("Average Jeff", doMove_averageJeff); i += 1


  def initialize = {
    strat_playerMap.clear
    players.foreach(p => strat_playerMap += p -> strat_idMap(default_strat))
  }

  def doMove(console: Boolean = false) = {
    if(console) console_flag = true
    val p = players.head
    strat_playerMap(p).findMoves(p)
    console_flag = false
  }
}