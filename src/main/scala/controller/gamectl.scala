package controller

class Gamectrl(deckctrl: Deckctrl, playerctrl: Playerctrl) {
  //initially deal each player n cards
  private def deal(n: Int) = {
    for(i <- 1 to n) for(p <- 1 to playerctrl.getNumPlayers) {
      val card = deckctrl.draw
      if(playerctrl.draw(card)) playerctrl.pruneSet(card.get.id)
      //println(s"dealing ${playerctrl.upNow} card $card")
      playerctrl.advance
    }
  }
  
  //start or restart a game
  def init = {
    deckctrl.init
    playerctrl.init
    val starting_cards = 5
    deal(starting_cards)
  }
  
  //show game universe
  def showGameArea: String = s"${playerctrl.show}\n\n${deckctrl.show}"
  
  //is the game in an end state
  def isGameOver: Boolean = ???
  
  //is the game over is there a winner
  def isWinner: Boolean = ???
  
  //are there at least two people with the highest score
  def isTie: Boolean = ???
  
  //complete one move for a player
  def doMove = ???
  
  //complete one move for each player
  def doTurn = ???
  //for(m <- 1 to mod.players.length) doMove
  
  //complete moves until the game is over
  def doGame = while(!this.isGameOver) doMove
}