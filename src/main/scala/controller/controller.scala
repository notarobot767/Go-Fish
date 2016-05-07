package controller

import model._

class Controller(val model: Model) {
  val mod = model.Game

  //check if players exist
  def isPlayerEmpty: Boolean = mod.players.isEmpty

  //check if deck is empty
  def isDeckEmpty: Boolean = mod.deck.isEmpty

  //show game universe
  def showGameArea: String = mod.players.show + mod.deck.show

  //show order of players
  def showPlayerOrder: String = mod.players.toString

  //advance the order of the players
  def advanceOrder: Boolean = if(isPlayerEmpty) false else mod.players.advanceOrder

  //set conditions for new game
  def initializeGame = {
    def draw5 =
      mod.players.foreach(p => for(x <- 0 until 5) p.addCard(mod.deck.draw))
    mod.players.initialize; mod.deck.createNew; mod.deck.shuffle; draw5
  }

  //check if a player has won the game
  def checkForWinner: String = {
    ???
  }
}