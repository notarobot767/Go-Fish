package controller

import org.scalatest.FunSpec
import org.scalatest.Matchers

class m4_Menu_Test extends FunSpec with Matchers {
  describe("(strategy related commands)") {

    //******* SHOW STRATEGIES *******
    it("showStrategies") { val ctl = Fixture.instance.controller

      val expectedResult =
        "Ender\t-> Old Man\n" +
        "Sabriel\t-> Old Man\n" +
        "Eragon\t-> Old Man\n" +
        "Artemis\t-> Old Man"

      val expectedResultNone = "None"

      //state before game is initalized
      ctl.showStrategies should be(expectedResultNone)

      //default AI at start of game
      ctl.initializeGame
      ctl.showStrategies should be(expectedResult)
    }

    //******* SET *******
    it("set") { val ctl = Fixture.instance.controller

      /*
      player_id (0-3)
        0 => Ender, 1 => Sabriel, 2 => Eragon, 3 => Artemis
      strategy_id (1-3)
        1 => oldman, 2 => god, 3 => james_bond
      */

      val expectedResult0 =
      "Ender\t-> Old Man\n" +
      "Sabriel\t-> Old Man\n" +
      "Eragon\t-> Old Man\n" +
      "Artemis\t-> Old Man"

      val expectedResult1 =
      "Ender\t-> Old Man\n" +
      "Sabriel\t-> God\n" +
      "Eragon\t-> Old Man\n" +
      "Artemis\t-> Old Man"

      val expectedResult2 =
      "Ender\t-> Old Man\n" +
      "Sabriel\t-> God\n" +
      "Eragon\t-> Old Man\n" +
      "Artemis\t-> James Bond"

      //no players to set
      ctl.set(1,1) should be(false)

      //default AI at start of game
      ctl.initializeGame
      ctl.showStrategies should be(expectedResult0)

      //set player 1 (Sabriel) to strategy 2 ("God")
      ctl.set(1,2) should be(true)
      ctl.showStrategies should be(expectedResult1)

      //set player 3 (Eragon) to strategy 3 ("James Bond")
      ctl.set(3,3) should be(true)
      ctl.showStrategies should be(expectedResult2)

      //try to set an invalid player
      ctl.set(-1,1) should be(false)

      //try to set an invalid strategy
      ctl.set(0,-4) should be(false)

      //try to set an invalid player and strategy
      ctl.set(-1,-1) should be(false)
    }

    //******* DO MOVE *******
    it("doMove") { val ctl = Fixture.instance.controller
      
      //tests not yet built
      true should be(false)
    }
  }
}