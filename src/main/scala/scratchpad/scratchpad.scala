package scratchpad

import controller._

class Scratchpad (ctrl: Controller) {
  def testdrive {
    println("hi testdrive!")
    val deckctl = ctrl.deckctl
    
    val playerctl = ctrl.playerctl
    
    ctrl.init
    println(ctrl.showGameArea)
  }
}