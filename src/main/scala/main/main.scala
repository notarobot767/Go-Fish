/*
Main Object
Hey you found me!
*/

package main

import model._
import controller._

object Main {
  
  def main(args: Array[String]): Unit = {
    object Game {
      val mod = new Model
      val ctrl = new Controller(mod)
      val scratchpad = new Scratchpad(ctrl)
    }
    
    Game.ctrl.gamectrl.init
    Game.scratchpad.testdrive
    
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