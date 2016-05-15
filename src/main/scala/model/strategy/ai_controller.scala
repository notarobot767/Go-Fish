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

  //map each player to default strat ID
  def initialize = {
    var i = 1
    strat_idMap.clear
    AI_Functions(data, loader).foreach({s =>
      strat_idMap += i -> s
      i += 1
    })

    strat_playerMap.clear
    players.foreach(p =>
      strat_playerMap += p -> strat_idMap(Statics.default_strat))
  }

  //do a move based on player up and his strategy
  def doMove = {val p = players.head; strat_playerMap(p).findMoves(p)}
}