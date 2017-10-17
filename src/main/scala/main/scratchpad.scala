package main

import controller._

class Scratchpad (ctrl: Controller) {
  def testdrive {
    ctrl.gamectl.init
    
    println(ctrl.gamectl.showGameArea)
    ctrl.playerctl.draw
    println(ctrl.gamectl.showGameArea)
  }
}