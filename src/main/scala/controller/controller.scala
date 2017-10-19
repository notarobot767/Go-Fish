/*
Controller Class
  Use these functions to manipulate the model
  otherwise, may put game in unintended state.
  This is where error checking for legal moves is done
*/

package controller

import model._

class Controller(model: Model) {
  val deckctrl = new Deckctrl(model.deck)
  val playerctrl = new Playerctrl(model.players)
  val gamectrl = new Gamectrl(deckctrl, playerctrl)
}