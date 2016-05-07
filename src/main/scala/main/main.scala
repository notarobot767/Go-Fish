package main

import model._
import controller._

object Main {
  
  def main(args: Array[String]): Unit = {
    val model = new Model
    val ctrl = new Controller(model)
    val mod = model.Game

    
    ctrl.initializeGame
    println(ctrl.showGameArea)
    println(ctrl.checkForWinner)
    sys.exit(0)
    
  }
}