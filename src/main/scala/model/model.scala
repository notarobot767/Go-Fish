package model

class Model {
  object Game {
    val deck = new Deck
    val players = new Players
    val strategy = new Strategy
    
    def doMove(me: Player, you: Player, strat: Strat): Boolean = {
        ???
    }
  }
}