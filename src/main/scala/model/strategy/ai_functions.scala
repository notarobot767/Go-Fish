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

  private def convientLoad(p: Player): Boolean =
    loader.load(p, players.tail.head, p.get_hand.head._1)

  /*
  Old Man AI
    randomly pick card_id (that you have)
    randomly pick player (other then self)
  */
  def doMove_oldMan(p: Player): Boolean = {
    while(true) {
      //empty hand
      if(p.get_hand.isEmpty) return loader.load_emptyHand(p)

      //random valid move
      if(loader.load(p, this.returnRndPlayer, this.returnRndCardId(p))) return true
    }
    false
  }; this.enqueue(Strat("Old Man", doMove_oldMan))

  /*
  God AI
  */
  def doMove_god(p: Player): Boolean = {
    while(true) {
      //empty hand
      if(p.get_hand.isEmpty) return loader.load_emptyHand(p)

      //set of my card ids
      val mySet = p.get_hand.keys.toSet
          
      //generate list of all guesses that will be true
      val selection = Queue.empty[(Player, Int)]
      players.tail.foreach({p =>
        mySet.intersect(p.get_hand.keys.toSet).foreach({
        i => selection.enqueue((p, i))})})

      //do all known matches
      while(selection.nonEmpty){
        val guess = selection.dequeue
        loader.load(p, guess._1, guess._2)
      }

      //check for empty hand again
      if(p.get_hand.isEmpty) return loader.load_emptyHand(p)

      //otherwise, see if top of deck is something you can use
      if(deck.nonEmpty) {
        val topOfDeck = deck.head.id

        //next card in deck is something you have
        if(p.get_hand.contains(topOfDeck))
          loader.load(p, players.tail.head, topOfDeck)

        else return convientLoad(p)
          //expended all known moves
          //next move will end turn no matter what
          //ask next player about first card pulled up in your map
      }
      else return true
    }
    false
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