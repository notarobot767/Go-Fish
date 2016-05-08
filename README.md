# Go-Fish
object oriented game simulation project using Scala

CS403 AY16-2

By Cadet Noah Ogrydziak,'17 B1

##Description:
Go Fish is a card game usually played by two up to five players using a standard 52 card deck, no Jokers. A player wins by having the most points at the end of the games by laying down sets of four of a kind aquired by either drawing or actions in game.

##Starting a New Game:
Each player gets five cards. A player must immediately lay down a set of four cards he or she aquires at any time during the game. The remaining cards are spread out in a disorderly pile face down on the table, refered to as the "ocean" or "Sea". Players may look at their cards but should keep their values hidden from other players. Players may not, however, hide the amount of cards they have from other players at any time.

##Going:
When it is a player's turn, he or she may ask any one player if he or she has any cards of a particular face value. The player who asks may only inquire about face values that he or she has at least one of. If the player getting asked about a card has any, that player must give all of those cards he or she has to the player who asked. The player will continue to ask any player one at a time for cards until someone the player asks does not have any of the value in question. In that case, they player will draw from the pile of cards on the table. If there are no more cards in the deck or the player does not draw the card he or she asked for, the player's turn is now over. The direction of play will move clockwise.

###example)
#####given:
Bob has [1][1][2] and Mary has [2][3][4]

It is Bob's turn

Bob: "Mary, do you have any 2's?"

Mary: "Yes, I have one 2."

#####update hand:

Bob has [1][1][2][2] and Mary has [3][4]

Bob successfully guessed a card Mary had, so it is still Bob's turn.

Bob: "Mary do you have any 1's"

Mary: "No, go fish!"

Bob draws a card from the deck.

#####updated hand:

Bob has [1][1][2][2][7] and Mary has [3][4]

Bob did not successfully guess a card Mary had and did not draw the card he had asked for, so Bob's turn is over.

###Special Cases:
In the event a player has no card and it is his or her to go, the player draw from the deck and end his or her turn. If the deck is empty, the player will just pass.

##End Game:
The game is over when all pairs of four have been layed on the table. At that point the players will tally up their sets.

##Scoring:
Anytime a player lays down a set of four, those cards are out of play. A set of four is defined as four cards that share the same number or value, meaning there are a total of 13 in any game. At the end of the game, the player with the most number of sets wins. A set will be equivalent to one point.

##Works Cited:
Alexander, Alvin. "11.2. Creating a Mutable List." Scala Cookbook. Safari Books.

"Go Fish." Hoyle. Web. 12 Jan. 2016. http://www.hoylegaming.com/rules/showrule.aspx?RuleID=214.

"Go Fish." Wikipedia. Web. 12 Jan. 2016. https://en.wikipedia.org/wiki/Go_Fish.

"HTML Images." w3schools. http://www.w3schools.com/html/html_images.asp.

Knoll, Bryon. "Playing Cards (Vector & PNG)." OpenGameArt.Org. http://opengameart.org/content/playing-cards-vector-png.

Borden, Mondo Lizzie. http://lizzieandrewborden.com/MondoLizzie.

"Parallel Execution." SBT. Typesafe. http://www.scala-sbt.org/release/docs/Parallel-Execution.html.

"Reading from the terminal." http://otfried.org/scala/reading_terminal.html.

                         ,.
                      ,-'.:\
                   _/'.:'_:'`._    .-._
              _.-''        ```-`.,'.::.`-._
           _.'                    ``-..:.:.`-.
         ,'          ____               `-:.:,'      _..-'|
       ,',.      ),''    ```--...___        `-.__..'':..  |
      / (O )   \  `.  ___....-----..``-...___      \::.   |
     /_' `'  /  )  /,'::::::._:.-'           ````-.-'- .-'|
     ,-`'. ,' ,'  /  ):::._,'             __...--../::.   |
     `.        _,'   `--''     CS403  _.''           `-.._|
       `''-..''_                   _.'.:`.
                ``.  ..--....___.-' `:_.::/
                   \ .:`.              `-.\
                    \:::|
                     \_,