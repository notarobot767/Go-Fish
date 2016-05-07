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
  def getDeck_count: Int = mod.deck.getCount

  def getTotalPlayer_cardCount: Int = {
    var c = 0
    if(isPlayerNonEmpty) mod.players.foreach(p => c += p.getCardCount + p.getPoints*4)
    c
  }

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

  private var leader = Player("place_holder") 

  //is there a winner? Also updates the leaderboard
  def isWinner: Boolean = {
    if(isPlayerNonEmpty && isDeckEmpty) {
      var flag = true
      mod.players.foreach({p =>
        if(p.getPoints > this.leader.getPoints) this.leader = p 
        if(p.getCardCount != 0) flag = false
      })
      flag
    }
    else false
  }

  //check if a player has won the game
  def checkForWinner: String = if(isWinner) leader.toString else "None"

  def doMove(console: Boolean = false) = {
    ???
  }

  def doTurn(console: Boolean = false) = {
    ???
  }

  def doGame(console: Boolean = false) = {
    ???
  }

  def set(s: Int): Boolean = {
    ???
  }

  def showStrategies: String = {
    ???
  }
}