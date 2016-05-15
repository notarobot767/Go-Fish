/*
Stencil class
  a stencil for the game data
  encapsulation to be passed into Loader and AI
*/

package model.data

case class Stencil(deck: Deck, players: Players) {
  var console = false
}