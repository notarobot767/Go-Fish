package main

import model._
import controller._

object Main {
  
  def main(args: Array[String]): Unit = {
    val model = new Model
    val ctrl = new Controller(model)
    val mod = model.Game

    /*
    ctrl.initializeGame_unshuffled
    println(ctrl.showGameArea)
    println(ctrl.checkForWinner)

    mod.loader(mod.players(0), mod.players(1), Card(14, "Z"))
    sys.exit(0)
    */
    
  }
}