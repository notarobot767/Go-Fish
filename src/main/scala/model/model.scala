/*
Model Class
  The main model itself
  Where the data, loader, and ai controller are encapsulated
*/

package model

import model.playing_cards._

class Model {
  object Game {
    val deck = new Deck
  }
}