package controller

import org.scalatest.FunSpec
import org.scalatest.Matchers

class m3_Menu_Test extends FunSpec with Matchers {
  describe("(basic commands to run the game)") {
      
    //******* INITIALIZE GAME *******
    it("initializeGame") { val ctl = Fixture.instance.controller

      /*
      at start of new game, each player is dealt 5 cards
      from a deck of 52
      if there are 4 players, total player cards should be 20
      */

      val expectedResult_deckCards = 32
      val expectedResult_playerCards = 20

      /*
      one edge case to check is if one or more players get a set
      of 4 on the initial draw. Since cardCount decrements by 4 each set,
      actual card count per player is cards in hand + points * 4
      */
      
      //state of game when not initialized
      ctl.getDeck_count should be(0)
      ctl.getTotalPlayer_cardCount should be(0)

      //start new game
      ctl.initializeGame

      //number of cards in deck
      ctl.getDeck_count should be(expectedResult_deckCards)
      ctl.getTotalPlayer_cardCount should be(expectedResult_playerCards)
    }

    //******* CHECK FOR WINNER *******
    it("checkForWinner") { val ctl = Fixture.instance.controller
      val expectedResult = "None"

      //no winner if no players
      ctl.checkForWinner should be (expectedResult)

      //can be no winner at start of game
      ctl.initializeGame
      ctl.checkForWinner should be(expectedResult)

      //should be winner at end of game
      ctl.doGame(false)
      ctl.checkForWinner should not be(expectedResult)
    }

    //******* DO MOVE *******
    it("doMove") { val ctl = Fixture.instance.controller
      val StringResult0 = "Ender, Sabriel, Eragon, Artemis"
      val StringResult1 = "Sabriel, Eragon, Artemis, Ender"

      //******* initial check *******
      ctl.initializeGame
      ctl.get_deck.length should be(32)
        //at start of game, each player should have 52 cards
      ctl.showPlayerOrder should be(StringResult0)
        //order at the start of a new game
      
      //******* first pass *******
      ctl.doMove()
      ctl.showPlayerOrder should be (StringResult1)
        //next player should now be up

      ctl.get_deck.length should be < (32)
        //player Ender should have drew 1 or more cards
          //in his turn before passing off to Sabriel
        //we can assume there are always cards in the deck
          //at the start of a game
    }

  }
}