Programmers: Kushal Gautam, Pratistha Maharjan, Manish Panta.( Collaborative work). 

Information: 

1. Kushal Gautam 
NetId: kgautam2
Lab Sessions: TR 6:15 TO 7:30
TA:Jillian Penfield 
"I collaborated with Manish Panta and Pratishta Maharjan in this project." 

2. Manish Panta

NetId: mpanta
Lab Sessions:TR 11:05 - 12:20




3. Pratishtha Maharjan.
NetID: pmaharja
Lab Sessions: Mon-Wed: 2:00 - 3:00



******************
This is a collaborative group project that incorporates the concepts of OOP and arrays to design a simple Poker Game. First, there is a Card.java class that defines all the properties that a simple playing card has i.e Suit, Numeric Value, and Face. This class does nothing but uses methods like getters, setters and toSting that are useful later in the project. It basically contains all the attributes of a card. 

The second class Deck of Cards declares an object deck to deal with 52 cards. It also has as arrays faces and suits that list all the possible faces and suits a card has as a String data type. There is a void method shuffle that uses a Random object to deal five cards randomly to each person playing. Shuffle method basically deals any random five cards from the entire deck. The class deck of cards also has a constructor that enables an object to have faces( Numbers) and Suits. The basic idea is to assign four different suits for each numbered card, starting from Ace all the way till king using a loop.

Now, in the Play class, the main execution of the Poker game occurs. The Play class randomly distributes five cards to two players, compare the hands and determine winner on the basis of their current hand. There's an object play that uses Shuffle method from previous class to shuffle and distribute the cards. Play object also uses deal method from previous class to deal the hands. The for loop runs 10 times, distributing 5 cards to each players. Now after the cards are distributed randomly, a method sortedCards sorts the cards of each hands and arranges them according to their ranks. Remember, Ace has the lowest rank and King has the highest rank over here. However, that doesn't imply that the hierarchical value of Ace is lower than that of a King. There is another object called poker in the class play  that takes sorted cards and start comparing hands. 

The class has several methods to identify the hands of each of the player. ie. to identify if they have Straight Flush, Flush, One Pair, Two Pair, Three of a Kind, Four of a Kind, Full House, and  a High Card. We set an integer value called priority for every possible hands and compared the priority value of the hands of two players to determine the winner. If the the two players have similar cards, then their priority values would be equal. In that case, our game prints a draw message although a real poker game does't work that way. And, if the priority value of player 1 is greater than that of the player two, player 1 will be the winner, and vice versa. Assigning the hands to a particular priority number occurs in the class classify. As Straight flush is the superior of all the possible hands, it has priority set as no 1. Similarly, Four of a Kind, Full House, Flush, Straight, Three Pairs, Two pairs, One Pair, and High Card are assigned the priority 2,3,4,5,6,7,8,9 respectively. The ideas of determining what particular hand a player has is pretty simple. In most of the cases, we have used loops that compares each of the cards with others and determine if they have same face or same suit. 

Now, as required by the part 4 of the project, our program allows the users to assign the hands manually and compare them. The class Classify handles this part. It asks the user to input the card of their choice from the terminal, and compares the hands of the two players. The program asks 10 characters, each for two players, where the user has to input the face of the card ( only the initial number( A for ace, T for 10, J, Q, K for jack, queen and king respectively, and initial numbers of the rest of the cards) followed by an initial letter of their suits ( H, D, C, S for hearts, diamonds, clubs, and spades respectively), be that in any case. Now, at first the two characters for each card( ie. suit and rank) are considered as a single string input and stored in an array. The program uses substring method to take two consecutive characters for each card and uses a method to convert all the given letters into  upper case. This makes us easier to identify the cards. Now the main work is done in the method MakeCards that assigns cards to their consecutive initials. After the cards have been identified, the similar sorting method as in previous class sorts the cards in an ascending order and the variable priority1 and priority2 (for player 1 and 2 respectively) get their value according to the type of the hand each player has.( As in previous class). Finally, the variables priority1 and priority2 are compared to determine the winner. 

The basic output the class play gives is that it first prints all the shuffled 52 cards, assigns 5 random cards each to two players, sorts the cards based on their rank, compares the hands and give final winning decision based on the hands of the players. And the output that the class Classify gives is that it asks for 10 characters for each players, convert to characters into the respective cards, sort and print the cards, determine the hand and finally give the winner.

In this way, the Poker game is completed. 

In order to play the game, you need to run class Play along with all the classes, that automatically distributes the hands to two players, compare hands and then determine the winner. If you are to play manually, then you need to run the class Classify along with all the classes, enter characters as described above, and the program will determine the winner based on the cards they have entered and the hands they have formed. 

Thank you.!!