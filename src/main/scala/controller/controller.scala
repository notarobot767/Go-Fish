/*
Controller Class
  Use these functions to manipulate the model
  otherwise, may put game in unintended state.
  This is where error checking for legal moves is done
*/

package controller

import model._

class Controller(model: Model) {
  val deckctl = new Deckctl(model.deck)
  val playerctl = new Playerctl(model.players, deckctl)
  val gamectl = new Gamectl(model, deckctl, playerctl)
}