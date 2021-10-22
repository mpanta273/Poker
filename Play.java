import java.util.Arrays;
//class Play
public class Play {
	// main method
	public static void main(String[] args) {

		// Create an object for deck of Cards
		DeckofCards play = new DeckofCards();
		play.Shuffle();// place it in random numbers

		// print all the cards
		for (int i = 1; i <= 52; i++) {
			// deal and display a Card
			// print the cards in a format
			System.out.printf("%-20s", play.dealCards());
			if (i % 5 == 0) { // output a newline after every fourth card
				System.out.println();
			}

		}
		System.out.println("\n");
		// Deal five cards for each player to play
		System.out.println("Player 1: ");
		// Create an array for player1 and player 2 cards
		Card[] player1cards = new Card[5];
		Card[] player2cards = new Card[5];
		// use a for loop to deal the cards and keep everything in array
		for (int i = 0; i < 10; i++) {
			if (i < 5) {
				// keep everything in array
				player1cards[i] = play.dealfiveCards();
				// print all the cards for player1
				System.out.printf("%-19s", player1cards[i]);

			} else {
				// break point at 5 for player 2
				if (i == 5)
					System.out.println("\nPlayer 2");
				player2cards[i - 5] = play.dealfiveCards();// keep the cards in the array for player 2
				System.out.printf("%-19s", player2cards[i - 5]);// print everything in a format

			}
		}

		// CREATE A NEW OBJECT FOR PLAY
		Play poker = new Play();

		System.out.println();
		// Call to sort cards
		poker.sortedCards(player1cards);
		poker.sortedCards(player2cards);
		// Print all the array after sorting
		System.out.println();
		System.out.println(Arrays.deepToString(player1cards));
		System.out.println(Arrays.deepToString(player2cards));

		// CHECK THE HANDS FOR player Cards and assign priorities
		System.out.println("\n");
		int priority1 = 0;
		int priority2 = 0;
		System.out.println("The Player 1 has ");
		if (poker.straightFlush(player1cards)) {
			System.out.println("Straight Flush");
			priority1 = 1;
		} else if (poker.straight(player1cards)) {
			System.out.println("Staight");
			priority1 = 5;
		} else if (poker.flush(player1cards)) {
			System.out.println("Flush");
			priority1 = 4;
		} else if (poker.fourofakind(player1cards)) {
			System.out.println("Four of a Kind");
			priority1 = 2;
		} else if (poker.fullhouse(player1cards)) {
			System.out.println("Full House!");
			priority1 = 3;
		} else if (poker.threepairs(player1cards)) {
			System.out.println("Three Pairs");
			priority1 = 6;
		} else if (poker.twopairs(player1cards)) {
			System.out.println("Two Pairs");
			priority2 = 7;
		} else if (poker.onePair(player1cards)) {
			System.out.println("One Pair");
			priority1 = 8;
		} else {
			System.out.println("High Card");
			poker.highcard(player1cards);
			priority1 = 9;
		}

		// CHECK THE HANDS FOR player2 Cards and assign priorities
		System.out.println("\n");
		System.out.println("The Player 2 has ");
		if (poker.straight(player2cards) && poker.flush(player2cards)) {
			System.out.println("Straight Flush");
			priority2 = 1;
		} else if (poker.straight(player2cards)) {
			System.out.println("Staight");
			priority2 = 5;
		} else if (poker.flush(player2cards)) {
			System.out.println("Flush");
			priority2 = 4;
		} else if (poker.fourofakind(player2cards)) {
			System.out.println("Four of a Kind");
			priority2 = 2;
		} else if (poker.fullhouse(player2cards)) {
			System.out.println("Full House!");
			priority2 = 3;
		} else if (poker.threepairs(player2cards)) {
			System.out.println("Three Pairs");
			priority2 = 6;
		} else if (poker.twopairs(player2cards)) {
			System.out.println("Two Pairs");
			priority2 = 7;
		} else if (poker.onePair(player2cards)) {
			System.out.println("One Pair");
			priority2 = 8;
		} else {
			System.out.println("High Card");
			poker.highcard(player2cards);
			priority2 = 9;
		}

		// The hand with the top priority wins the Game!
		if (priority1 < priority2) {
			System.out.println("\n");
			System.out.println("Player 1 wins the game");
		} else if (priority2 < priority1) {
			System.out.println("\n");
			System.out.println("Player 2 wins the game");
		}

		// Check if the hand is one pair
		else if ((priority1 == priority2) && (priority1 == 8)) {
			poker.checkOnepair(player1cards, player2cards);// Get the highest card from the one pairs of different hand
		}
		// Check which high card won the game
		else if ((priority1 == priority2) && (priority1 == 9)) {
			if ((poker.highcard(player2cards)) > (poker.highcard(player1cards))) {// player with the highest card wins
				System.out.println("\n");
				System.out.println("Player 1 wins the game");
			} else if ((poker.highcard(player2cards)) < (poker.highcard(player1cards))) {
				System.out.println("\n");
				System.out.println("Player 2 wins the game");
			} else {
				System.out.println("It is Draw!!"); // if all the condition fails then it must be draw
			}
		} else {
			System.out.println("It is Draw!!"); // if all the condition fails then it must be draw
		}

	}

// ALL THE FUNCTIONS BELOW
// ==========================================================================================
//Function to SortCards 
	public Card[] sortedCards(Card[] cards) {
//Used bubble sort to sort the cards 
		for (int i = 0; i < cards.length; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getNumericValue() > cards[j].getNumericValue()) {// numeric value represents the number
					// that was assigned in cards
					Card temp = cards[i];
					cards[i] = cards[j];
					cards[j] = temp;
				}
			}
		}

		return cards;
	}

	// Check For flush using boolean
	public Boolean flush(Card[] cards) {
		boolean flush = true;
		for (int i = 0; i < cards.length - 1; i++) {
			// This is to check if it is a flush
			if (!cards[i].getSuit().equals(cards[i + 1].getSuit())) {
				// if this is not a flush then return false
				flush = false;
			}
		}
		return flush;
	}

	// Assign ranks to all the cards
	// FUNCTION FOR RANK
	public int rank(Card cards) {
		int rank = 0;
		if (cards.getFace().equals("King")) {
			rank = 13;
			// System.out.println("I am the rank" + rank);
		} else if (cards.getFace().equals("Queen")) {
			rank = 12;
			// System.out.println("I am the rank" + rank);
		} else if (cards.getFace().equals("Jack")) {
			rank = 11;
			// System.out.println("I am the rank" + rank);
		} else if (cards.getFace().equals("2")) {
			rank = 2;
			// System.out.println("I am the rank" + rank);
		} else if (cards.getFace().equals("Ace")) {
			rank = 1;
			// System.out.println("I am the rank" + rank);
		} else if (cards.getFace().equals("3")) {
			rank = 3;
			// System.out.println("I am the rank" + rank);
		} else if (cards.getFace().equals("4")) {
			rank = 4;
			// System.out.println("I am the rank" + rank);
		} else if (cards.getFace().equals("5")) {
			rank = 5;
			// System.out.println("I am the rank" + rank);
		} else if (cards.getFace().equals("6")) {
			rank = 6;
			// System.out.println("I am the rank" + rank);
		} else if (cards.getFace().equals("7")) {
			rank = 7;
			// System.out.println("I am the rank" + rank);
		} else if (cards.getFace().equals("8")) {
			rank = 8;
			// System.out.println("I am the rank" + rank);
		} else if (cards.getFace().equals("9")) {
			rank = 9;
			// System.out.println("I am the rank" + rank);
		} else if (cards.getFace().equals("10")) {
			rank = 10;
			// System.out.println("I am the rank" + rank);
		}
		return rank;

	}

	// BOOLEAN FUNCTION to check if the card is Straight
	public boolean straight(Card[] h) {
		// check if the card is Ace
		// If the first card is 1 and second card is 2
		if (this.rank(h[0]) == 1 && this.rank(h[1]) == 2) {
			// check the rest of the card with run
			for (int i = 2; i < h.length; i++) {
				int current = this.rank(h[i]);
				int previous = this.rank(h[i - 1]);
				// if the current card is not one rank greater than previous card return false
				if (current != previous + 1) {
					return false;
				}
			}
			// If the first card is 1 and second card is 10
		} else if (this.rank(h[0]) == 1 && this.rank(h[1]) == 10) {
			// check the rest of the card with run
			for (int i = 2; i < h.length; i++) {
				int current = this.rank(h[i]);
				int previous = this.rank(h[i - 1]);
				// if the current card is not one rank greater than previous card return false
				if (current != previous + 1) {
					return false;
				}
			}

		} else {
			// same logic check for the rest of the cards
			for (int i = 1; i < h.length; i++) {
				int currentRank = this.rank(h[i]);
				int previousRank = this.rank(h[i - 1]);
				if (currentRank != previousRank + 1) {
					return false;
				}
			}
		}
		return true;
	}

	// Check if the card is flush or not
	public boolean straightFlush(Card[] h) {
		// if the card is straight and flush then it is straightFlush
		return this.straight(h) && this.flush(h);
	}

	// BOOLEAN FUNCTION to check if the card is onePair
	public boolean onePair(Card[] h) {
		boolean onePair = false;
		// for loop to check if there is a pair that is equal or not
		for (int i = 0; i < h.length - 1; i++) {
			int current = this.rank(h[i]);// stores the current card
			int next = this.rank(h[i + 1]);// stores the next card
			// if they are equal then the card is two pair
			if (current == next) {
				onePair = true;
			}
		}
		return onePair;
	}

	// BOOLEAN FUNCTION to check which onePair won
	public int checkOnepair(Card[] a, Card[] b) {
		boolean check = false;
		int high = 0;
		// loop through again to find the one pairs in both the arrays
		for (int i = 0; i < a.length - 1; i++) {
			int current = this.rank(a[i]);
			int next = this.rank(a[i + 1]);
			int current2 = this.rank(b[i]);
			int next2 = this.rank(b[i + 1]);

			// if ((current == next) || (current2 == next2)) { // check if the pair is Ace.
			// then Ace Wins the game
			if (current == 1) {
				System.out.println("Player 1 wins the game.");
				break;
			} else if (current2 == next) {
				System.out.println("It is draw");

				break;
			} else if (current2 == 1) {
				System.out.println("Player 2 wins the game.");
				break;
			} else if (current > current2) { // check for other cards
				high = current;
				System.out.println("Player 1 wins the game.");
				break;
			} else if (current < current2) {
				high = current2;
				System.out.println("Player 2 wins the game.");
				break;
			}

		}
		return high;
	}

	// BOOLEAN FUNCTION to check if the card is three pairs
	public boolean threepairs(Card[] h) {

		boolean threeofakind = false;
		// for loop to check if there is a pair that is equal or not
		for (int i = 0; i < h.length - 2; i++) {
			int current = this.rank(h[i]);// stores the current card
			int next = this.rank(h[i + 1]);// stores the next card
			// if they are equal then the card is two pair
			if (((current == this.rank(h[i + 1])) && ((this.rank(h[i + 1]) == this.rank(h[i + 2]))))) {
				threeofakind = true;
			}
		}
		return threeofakind;
	}

	// BOOLEAN FUNCTION to check if the card is two pairs
	public boolean twopairs(Card[] h) {
		boolean twoPairFound = false;
		int twoPairCount = 0;
		// assign startcheck as the initial value of the hand
		int startCheck = this.rank(h[0]);
		// loop from the second element of the hand to check if it has one pair
		for (int k = 1; k < h.length; k++) {

			if ((this.rank(h[k]) - startCheck) == 0) {
				twoPairCount++;// increment of onepair cointer by one
			}
			startCheck = this.rank(h[k]);// increment of the elements in hand
		}

		if (twoPairCount == 2) {
			twoPairFound = true;// if two one pair is found then return two pair is true
		} else if (twoPairCount != 2) {
			twoPairFound = false;
		}

		return twoPairFound;
	}

	// BOOLEAN FUNCTION to check if the card is four of a kind
	public boolean fourofakind(Card[] h) {

		boolean fourofakind = false;
		// for loop to check if there is a pair that is equal or not
		for (int i = 0; i < h.length - 3; i++) {
			int current = this.rank(h[i]);// stores the current card
			int next = this.rank(h[i + 1]);// stores the next card
			// if they are equal then the card is two pair
			if (((current == this.rank(h[i + 1])) && ((this.rank(h[i + 1]) == this.rank(h[i + 2]))))
					&& ((this.rank(h[i + 2]) == this.rank(h[i + 3])))) {
				fourofakind = true;
			}
		}
		return fourofakind;
	}

	// BOOLEAN FUNCTION to check if the card is full house
	public boolean fullhouse(Card[] h) {
		boolean fullhouse = false;
		if ((this.rank(h[0]) == (this.rank(h[1]))) && (this.rank(h[1]) == (this.rank(h[2])))
				&& ((this.rank(h[3]) == (this.rank(h[4])))))
			return true;
		else if ((this.rank(h[2]) == (this.rank(h[3]))) && (this.rank(h[3]) == (this.rank(h[4])))
				&& ((this.rank(h[0]) == (this.rank(h[1])))))
			return true;
		return fullhouse;
	}

	// FUNCTION to check which is the high card

	public int highcard(Card[] h) {
		int high = 0;
		for (int k = 0; k < h.length; k++) {
			// Check if the first card is 1
			if (this.rank(h[0]) == 1) { // if the first card is 1 then the high card is 1
				return high = 1;

			} else {
				// Else the high card will be at the very hand since our array is sorted

				if ((this.rank(h[4]) == 13)) { // check if the high card is king
					// System.out.println("The high card is King of " + h[4].getSuit());
					return high = 2;

				} else if ((this.rank(h[4]) == 12)) { // check of the high card is Queen
					// System.out.println("The high card is Queen of " + h[4].getSuit());
					return high = 3;

				} else if ((this.rank(h[4]) == 11)) {// check if the high card is Jack
					// System.out.println("The high card is Jack of " + h[4].getSuit());
					return high = 4;
				} else {
					// parse integer into String to get the other high card value
					return high = (this.rank(h[k])) + 11;

				}

			}
		}
		return high;

	}

}