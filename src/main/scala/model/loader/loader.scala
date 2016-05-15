/*
Loader class
  logic behind making a move
    moves cards between players and deck
    updates scores
    
  stencil: the game data

*/

package model.loader

import model.data._
import model.statics.Statics

class Loader(data: Stencil) {
  private val deck = data.deck
  private val players = data.players

  def load(you: Player, them: Player, c_id: Int): Boolean = {
    var output = ""
    var didEndTurn = false

    output += s"\n$you: $them, do you have any " +
      Statics.getFace(c_id) + "'s?\n"

    //case they have card asked for
    if(them.get_hand.contains(c_id)) {
      output += s"$them: Yes, I have " + them.get_hand(c_id).length +
        " of those.\n"

      //swap cards and update leader if needed
      you.addCards(them.get_hand(c_id)); them.remove(c_id)
      players.update_leader
    }

    //case they do not have card
    else {
      output += s"$them: No, go fish!\n"

      //case deck is empty
      if(deck.isEmpty) {
        output += s"$you: Well, the deck is empty, so my turn is over.\n"
        didEndTurn = true
      }

      //case deck is not empty
      else {
          val drawn = deck.draw
          you.addCard(drawn)
          output += s"\n***$you drew a $drawn***\n"
          
          //check if drawn card is what asked for
          if(c_id == drawn.id)
            output += s"$you: Nice, I got the card.\n"

          //did not get card from drawing
          else {
            output += s"$you: Nuts, I did not get the card, " +
              "and now my turn is over.\n" +
              players.upNext + ": Yaaa, It's now my turn!\n"
            didEndTurn = true
          }
        players.update_leader
      }
    }

    if(!didEndTurn) output += s"$you: It's still my turn!\n"
    else players.advanceOrder
    output += show_updatedHand
    if(data.console) println(output)
    didEndTurn
  }

  def load_emptyHand(you: Player) = {
    var output = s"$you: Well I am out of cards, "
    if(deck.isEmpty) output += "and the deck is empty!"
    else {
      output += "so I guess I will draw."
      val drawn = deck.draw
      you.addCard(drawn)
      output += s"\n\n***$you drew a $drawn***\n"
      output += show_updatedHand
    }
    players.advanceOrder
    if(data.console) println(output)
  }

  def show_updatedHand: String =
    "\n***Updated Hand***\n" + players.show + deck.show + "\n"*3
}