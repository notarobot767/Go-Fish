package model

class Loader(deck: Deck, players: Players) {
  //wasnot sure how to reuse from card class
  private def getFace(c_id: Int): String = c_id match {
    case x if(x >= 2 && x <= 10) => c_id.toString
    case 11 => "J"
    case 12 => "Q"
    case 13 => "K"
    case 14 => "A"
  }

  def load(you: Player, them: Player, c_id: Int, console: Boolean = false): Boolean = {
    var output = ""
    var didEndTurn = false

    output += s"\n$you: $them, do you have any " + getFace(c_id) + "'s?\n"

    //case they have card asked for
    if(them.get_hand.contains(c_id)) {
      output += s"$them: Yes, I have " + them.get_hand(c_id).length +
        " of those.\n"

      you.addCards(them.get_hand(c_id))
      them.remove(c_id)
      players.update_leader
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
          if(c_id == drawn.id) {
            output += s"$you: Nice, I got the card.\n"
          }

          //did not get card from drawing
          else {
            output += s"$you: Nuts, I did not get the card, " +
              "and now my turn is over.\n" +
              players.tail.head + ": Yaaa, It's now my turn!\n"
            didEndTurn = true
          }
        players.update_leader
      }
    }

    if(!didEndTurn) output += s"$you: It's still my turn!\n"
    else players.advanceOrder
    output += "\n***Updated Hand***\n" + players.show + deck.show + "\n"*3
    if(console) println(output)
    didEndTurn
  }
}