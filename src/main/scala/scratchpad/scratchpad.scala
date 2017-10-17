package scratchpad

import controller._

class Scratchpad (ctrl: Controller) {
  def testdrive {
    ctrl.gamectl.init
    
    println(ctrl.gamectl.showGameArea)
    println(ctrl.playerctl.getLeader)
    ctrl.playerctl.draw
    println(ctrl.gamectl.showGameArea)
    println(ctrl.playerctl.getLeader)
  }
}