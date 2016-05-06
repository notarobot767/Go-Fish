package model.card

/* class for a playing card
id: Integer from 2 to 14

face: string representation of id
  2-10 map to integer representation
    ex) 2 -> "2", 3 -> "3", 4 -> "4", ..., 10 -> "10"
  11-14 map to playing card face
    ex) 11 -> "J", 12 -> "Q", 13 -> "K", 14 -> "A"

suit: string representation of card suit
  There are 4
  Heart -> "H", Diamond -> "D", Spade -> "S", Club -> "C"
*/
case class Card(val id: Int, val face: String, val suit: String) {
  //string representation: ex) 2 of Hears -> "[2-H]"
  override def toString: String = s"[$face-$suit]"
}