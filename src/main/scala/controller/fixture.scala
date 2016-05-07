package controller

import model._

object Fixture {
  def instance = new {
    val model = new Model
    val controller = new Controller(model)
  }
}