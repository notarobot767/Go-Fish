package main

import controller._

class Scratchpad (ctrl: Controller) {
  def testdrive {
    
    /*
    ctrl.gamectl.init
    println(ctrl.gamectl.showGameArea)
    println(ctrl.playerctl.getLeader)
    ctrl.playerctl.draw
    println(ctrl.gamectl.showGameArea)
    println(ctrl.playerctl.getLeader)
    */
    
    //println(ctrl.deckctl.getNewDeck2())
    ctrl.gamectl.init
    println(ctrl.gamectl.showGameArea)
  }
}