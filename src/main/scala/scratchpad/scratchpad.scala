package scratchpad

import controller._

class Scratchpad (ctrl: Controller) {
  def testdrive {
    println("hi testdrive!")
    val deckctl = ctrl.deckctl
    deckctl.init
    println(deckctl.count)
    println(deckctl.show)
    //println(deckctl.draw)
    println(deckctl.count)
    println(deckctl.show)
    
    val playerctl = ctrl.playerctl
    
  }
}