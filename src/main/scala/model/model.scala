package model

import model.strategy._
import model.loader._

class Model {
  object Game {
    val data = Stencil(new Deck, new Players)
    val loader = new Loader(data)
    val ai = new AI(data, loader)
  }
}