package main

import model._

object Main{
  
  def main(args: Array[String]): Unit = {
    println("hello")
    val model = new Model


    model.Game.deck.createNew
    println(model.Game.deck)

    model.Game.deck.shuffle
    println("\n")
    println(model.Game.deck)

    println("\n")
    println(model.Game.deck.draw)

    sys.exit(0)
  }
}