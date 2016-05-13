/*
Main Object
  Hey you found me!
  test the controller functions here
  
  open cmd in root folder -> type "sbt" -> then "run" or "test"

  or if you want an output file if much data

  while in root type "sbt run > output.txt"
*/

package main

import model._
import model.statics.Welcome
import controller._

object Main {
  
  def main(args: Array[String]): Unit = {
    val model = new Model
    val ctrl = new Controller(model)
    val mod = model.Game
    Welcome.print

    /**********************************
    * Test controller functions below *
    *********************************/

    ctrl.initializeGame
    println(ctrl.showGameArea)
    //println(ctrl.checkForWinner)
    //println(ctrl.showStrategies)
    //println(ctrl.showStrategies)
    ctrl.doGame(true)
  }
}