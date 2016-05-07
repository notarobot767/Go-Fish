package controller

import model._

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

      //VERY unlikely to win after 1 move
      //ctl.doMove(false)
      //ctl.checkForWinner should be(expectedResult)

      //cannot be winner after only one 1 turn
      //ctl.doTurn(false)
      //ctl.checkForWinner should be(expectedResult)

      //should be winner at end of game
      //ctl.doGame(false)
      //ctl.checkForWinner should not be(expectedResult)
    }

    /*
    for doMove, doTurn, & doGame
    eclipse required the parameter even though i made it
      a default. The purpose is a flag for printing console
      tests when troubleshooting
    */    
  }
}