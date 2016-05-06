package main

import model._

object Main{
  
  def main(args: Array[String]): Unit = {
    
    println("hello")

    val a = new Model
    println(a.Game.p1)
    println(a.Game.p2)

    a.Game.col.enqueue(a.Game.p1)
    a.Game.col.enqueue(a.Game.p2)

    sys.exit(0)
  }
}