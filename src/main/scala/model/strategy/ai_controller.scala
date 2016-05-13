/*
AI controller
  manages the AI functions
  maps an AI to a player
*/

package model.strategy

import model.data._
import model.loader._

import scala.collection.mutable.Map

class AI_Controller(data: Stencil, loader: Loader) {
  private val deck = data.deck
  private val players = data.players

  //map player to strat
  val strat_playerMap = Map[Player, Strat]()

  //map id to strat
  private val strat_idMap = Map[Int, Strat]()
  def get_strat_idMap: Map[Int, Strat] = this.strat_idMap

  //incrementing couter for each new strategy in strat_idMap
  private var i = 1

  //default strategy each player will be assigned
  private val default_strat = 1

  //whether to print the console info to the screen
  private var console_flag = false

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
        loader.load_emptyHand(p, console_flag)
        return true
      }

      //random valid move
      if(loader.load(p, this.returnRndPlayer, this.returnRndCardId(p),
        this.console_flag)) return true
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

  //map each player to default strat ID
  def initialize = {
    strat_playerMap.clear
    players.foreach(p =>
      strat_playerMap += p -> strat_idMap(default_strat))
  }

  //do a move based on player up and his strategy
  def doMove(console: Boolean = false) = {
    if(console) console_flag = true
    val p = players.head; strat_playerMap(p).findMoves(p)
    console_flag = false
  }
}