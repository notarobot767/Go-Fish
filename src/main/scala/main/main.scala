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
      //protect the model
      private val model = new Model
      val ctrl = new Controller(model)
      val scratchpad = new Scratchpad(ctrl)
      //val view = new View(ctrl)
      
      //ensure the game is in a ready state
      ctrl.gamectrl.init
    }
    //let's take a testdrive
    Game.scratchpad.testdrive
  }
    
    /***********************************************
    *          How to use                          *
    ************************************************
    * open a command promt/terminal in root folder *
    *                                              *
    * Method 1: (output to screen)                 *
    *   type "sbt" then                            *
    *     "compile" - compile the code             *
    *     "run" - run the code                     *
    *     "test" - run the test cases              *
    *                                              *
    * Method 2: (output to file)                   *
    *   "sbt run > output.txt"                     *
    *   "sbt test > output.txt"                    *
    ***********************************************/
}