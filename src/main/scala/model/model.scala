/*
Model Class
  The main model itself
  Where the data, loader, and ai controller are encapsulated
*/

package model

import model.playing_cards._
import model.players._

class Model {
    val deck = new Deck
    val players = new Players
}