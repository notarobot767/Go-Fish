package scratchpad

import controller._

class Scratchpad (ctrl: Controller) {
  def testdrive {
    println(ctrl.deckctl.count)
  }
}