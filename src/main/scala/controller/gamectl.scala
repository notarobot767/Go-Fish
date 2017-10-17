package controller

import model._

class Gamectl(mod: Model, deckctl: Deckctl, playerctl: Playerctl) {
  //start or restart a game
  def init = {
    deckctl.init
    playerctl.init
  }
  
  //show game universe
  def showGameArea: String = s"${playerctl.show}\n\n${deckctl.show}"
  
  //is the game in an end state
  def isGameOver: Boolean = ???
  
  //is the game over is there a winner
  def isWinner: Boolean = ???
  
  //are there at least two people with the highest score
  def isTie: Boolean = ???
  
  //complete one move for a player
  def doMove = ???
  
  //complete one move for each player
  def doTurn = for(m <- 1 to mod.players.length) doMove
  
  //complete moves until the game is over
  def doGame = while(!this.isGameOver) doMove
}