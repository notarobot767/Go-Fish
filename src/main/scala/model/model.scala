/*
Model Class
  The main model itself
  Where the data, loader, and ai controller are encapsulated
*/

package model

import model.data._
import model.strategy._
import model.loader._

class Model {
  object Game {
    val data = Stencil(new Deck, new Players)
    val loader = new Loader(data)
    val ai = new AI(data, loader)
  }
}