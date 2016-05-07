package controller

import model._

class Controller(val model: Model) {
  val mod = model.Game

  //check if players exist
  def isPlayerEmpty: Boolean = mod.players.isEmpty
  def isPlayerNonEmpty: Boolean = !isPlayerEmpty

  //check if deck is empty
  def isDeckEmpty: Boolean = mod.deck.isEmpty
  def isDeckNonEmpty: Boolean = !isDeckEmpty

  //show game universe
  def showGameArea: String = 
    if(isPlayerEmpty) "None" else mod.players.show + mod.deck.show

  //show order of players
  def showPlayerOrder: String = if(isPlayerEmpty) "None" else mod.players.toString

  //advance the order of the players
  def advanceOrder: Boolean = if(isPlayerEmpty) false else mod.players.advanceOrder

  private def draw5 =
      mod.players.foreach(p => for(x <- 0 until 5) p.addCard(mod.deck.draw))

  private def initializeGame_bare = {mod.players.initialize; mod.deck.createNew}

  //set conditions for new game
  def initializeGame = {initializeGame_bare; mod.deck.shuffle; draw5}

  //same as initializeGame but dont shuffle deck
  def initializeGame_unshuffled = {initializeGame_bare; draw5}

  //check if a player has won the game
  def checkForWinner: String = {
    ???
  }
}