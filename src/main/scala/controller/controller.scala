/*
Controller Class
  Use these functions to manipulate the model
  otherwise, may put game in unintended state.
  This is where error checking for legal moves is done
*/

package controller

import model._

class Controller(model: Model) {
  val deckctl = new Deckctl(model.Game.deck)
  val playerctl = new Playerctl(model.Game.players, deckctl)
  
  //start or restart a game
  def init = {
    deckctl.init
    playerctl.init
  }
  
  def showGameArea: String =
    s"${playerctl.show}\n${deckctl.show}"
  
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
  
  //complete moves until the game is over
  def doGame = ???
}