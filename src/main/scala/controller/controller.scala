/*
Controller Class
  Use these functions to manipulate the model
  otherwise, may put game in unintended state.
  This is where error checking for legal moves is done
*/

package controller

import model._

class Controller(val model: Model) {
  val deckctl = new Deckctl(model.Game.deck)
}