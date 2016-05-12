package strategy

import model._

import scala.collection.mutable.Map

class AI(deck: Deck, players: Players, loader: Loader) {

  val strat_playerMap = Map[Player, Strat]()
  val strat_idMap = Map[Int, Strat]()

  private var i = 1
  private val default_strat = 1
  private var console_flag = false

  def doMove_oldMan(p: Player): Boolean = {
    if(console_flag) println("doing move with AI old man!")
    true
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
    val nxtP = players.head
    strat_playerMap(nxtP).findMoves(nxtP)
    console_flag = false
  }

}