package model

//import strategy._

class Model {
  object Game {
    val deck = new Deck
    val players = new Players
    val loader = new Loader(deck, players)
    //val strategy = new Strategy
  }
}