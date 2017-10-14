/*
Main Object
Hey you found me!
*/

package main

import model._
import controller._

object Main {
  
  def main(args: Array[String]): Unit = {
    val model = new Model
    val ctrl = new Controller(model)
    
    println("hi there!")

    /***********************************************
    * Test controller functions here               *
    ***********************************************/
    
    /*
    ctrl.initializeGame
    //println(ctrl.showStrategies)
    //println(ctrl.showGameArea)
    //println(ctrl.showStrategies)
    ctrl.set(0, 2)
    ctrl.doGame(true)
    println(ctrl.checkForWinner)
    */
    
    /***********************************************
    *          How to use                          *
    ************************************************
    * open a command promt/terminal in root folder *
    *                                              *
    * Method 1: (output to screen)                 *
    *   type "sbt" then "run" or "test"            *
    *                                              *
    * Method 2: (output to file)                   *
    *   "sbt run > output.txt" or                  *
    *   "sbr test > output.txt"                    *
    ***********************************************/
  }
}