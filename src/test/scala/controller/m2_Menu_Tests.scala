package controller

import model._

import org.scalatest.FunSpec
import org.scalatest.Matchers

class m2_Menu_Test extends FunSpec with Matchers {
   describe("(commands to see the game universe)") {

    //******* SHOW GAME AREA *******
    it("showGameArea"){ val ctl = Fixture.instance.controller
      val expectedResultNone = "None"
      val expectedResult =
        "Ender (1 Cards, 1 Points)\n" +
        "[3-H]\n\n" +
        "Sabriel (5 Cards, 0 Points)\n" +
        "[3-C], [3-D], [3-S], [4-D], [4-H]\n\n" +
        "Eragon (5 Cards, 0 Points)\n" +
        "[4-C], [4-S], [5-D], [5-H], [5-S]\n\n" +
        "Artemis (1 Cards, 1 Points)\n" +
        "[5-C]\n\n" +
        "*Deck (32 Cards)\n" +
        "[7-H], [7-D], [7-S], [7-C], [8-H], [8-D], [8-S], [8-C], " +
        "[9-H], [9-D], [9-S], [9-C], [10-H], [10-D], [10-S], [10-C], " +
        "[J-H], [J-D], [J-S], [J-C], [Q-H], [Q-D], [Q-S], [Q-C], " +
        "[K-H], [K-D], [K-S], [K-C], [A-H], [A-D], [A-S], [A-C]"

      //case players not yet initialized
      ctl.showGameArea should be(expectedResultNone)

      //how game should look at start with static deck
      ctl.initializeGame_unshuffled
      ctl.showGameArea should be(expectedResult)
      /*This is my default static order at the start of game. May be
        different if implement players inputing name.*/
    }
    
    //******* SHOW PLAYER ORDER *******
    it("showPlayerOrder"){ val ctl = Fixture.instance.controller
      val expectedResultNone = "None"
      val expectedResult = "Ender, Sabriel, Eragon, Artemis"
      
      //case game has no players
      ctl.showPlayerOrder should be(expectedResultNone)

      //player order at start of game
      ctl.initializeGame_unshuffled
      ctl.showPlayerOrder should be(expectedResult)
    }

    //******* ADVANCE ORDER *******
    it("advanceOrder"){ val ctl = Fixture.instance.controller

      val expectedResult_0_advances = "Ender, Sabriel, Eragon, Artemis"
      val expectedResult_1_advances = "Sabriel, Eragon, Artemis, Ender"
      val expectedResult_2_advances = "Eragon, Artemis, Ender, Sabriel"
      val expectedResult_3_advances = "Artemis, Ender, Sabriel, Eragon"

      //nothing to advance
      ctl.advanceOrder should be(false)

      ctl.initializeGame_unshuffled
      
      //0 advance
      ctl.showPlayerOrder should be(expectedResult_0_advances)

      //1 advance
      ctl.advanceOrder should be(true)
      ctl.showPlayerOrder should be(expectedResult_1_advances)
      
      //2 advances
      ctl.advanceOrder should be(true)
      ctl.showPlayerOrder should be(expectedResult_2_advances)
      
      //3 advances
      ctl.advanceOrder should be(true)
      ctl.showPlayerOrder should be(expectedResult_3_advances)

      //4 advances (full circle)
      ctl.advanceOrder should be(true)
      ctl.showPlayerOrder should be(expectedResult_0_advances)
    }
  }
}