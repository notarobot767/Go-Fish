/*
Fixture Object
  used to create a new fixture or instance of the game
  main purpose is to run many tests concurrently
*/

package controller

import model._

object Fixture {
  def instance = new {
    val model = new Model
    val controller = new Controller(model)
  }
}