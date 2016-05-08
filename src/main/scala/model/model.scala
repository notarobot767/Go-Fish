package model

//import strategy._

class Model {
  object Game {
    val deck = new Deck
    val players = new Players
    //val strategy = new Strategy
    var console = true

    def loader(you: Player, them: Player, card: Card): Boolean = {
      var output = ""
      var didEndTurn = false

      output += s"\n$you: $them, do you have any " + card.getFace + "'s?\n"

      //case they have card asked for
      if(them.get_hand.contains(card.id)) {
        output += s"$them: Yes, I have " + them.get_hand(card.id).length +
          " of those.\n"

        you.addCards(them.get_hand(card.id))
        them.remove(card.id)
      }

      //case they do not have card
      else {
        output += s"$them: No, go fish!\n"

        //case deck is empty
        if(deck.isEmpty) {
          output += s"$them: Well, the deck is empty, so my turn is over.\n"
          didEndTurn = true
        }

        //case deck is not empty
        else {
            val drawn = deck.draw
            you.addCard(drawn)
            output += s"\n***$you drew a $drawn***\n"
            
            //check if drawn card is what asked for
            if(card.id == drawn.id) {
              output += s"$you: Nice, I got the card.\n"
            }

            //did not get card from drawing
            else {
              output += s"$you: Nuts, I did not get the card, " +
                "and now my turn is over.\n" +
                players.nextUp + ": Yaaa, It's now my turn!\n"
              didEndTurn = true
            }
        }
      }

      if(!didEndTurn) output += s"$you: It's still my turn!\n"
      else players.advanceOrder
      output += "\n***Updated Hand***\n" + players.show + deck.show + "\n"*3
      if(console) println(output)
      didEndTurn
    }

  }
}