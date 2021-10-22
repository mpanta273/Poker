
//class Deck of Cards 
//import Random 
import java.util.Random;

public class DeckofCards {
	// create instance of Random class
	Random rand = new Random();
	// constant variable for cards
	private static int Number = 52;
	// Initialize an array for the deck of cards
	Card[] deck = new Card[Number];

	// Current Card
	int current = 0;
	// to deal five hands
	int five = 0;
	// Constructor
	private String[] suits;
	private String[] faces;

	// Constructor for DeckOfCards
	public DeckofCards() {
		// initialize and assign cards the value
		String[] faces = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
		String[] suits = { "Hearts", "Clubs", "Diamonds", "Spades" };
		// The calculation count % 13 always results in a value from 0 to 12
		// the calculation count / 13 always results in a value from 0 to 3
		// create a counter which assigns number to all the suits and it will be used to
		// sort all the cards
		int number = 0;
		// For loop to get the combination of all the cards
		for (int i = 0; i < deck.length; i++) {
			deck[i] = new Card(faces[i / 4], suits[i % 4], number);
			// System.out.println(deck[i]);
			number = number + 1;
		}
	}

	// getters for suits and faces
	public String[] getSuits() {
		return suits;
	}

	public String[] getFaces() {
		return faces;
	}

//To print
	public void printcards() {
		for (int i = 0; i < deck.length; i++) {
			System.out.print(deck[i]);
		}
	}
// For Shuffle
	public void Shuffle() {
		current = 0;
		five = 0;
		// we need to pick random cards from the array
		for (int i = 0; i < deck.length; i++) {
			// pick random number between 0 and 51
			int pick = rand.nextInt(Number);
			// swap the elements
			Card temp = deck[i];
			deck[i] = deck[pick];
			deck[pick] = temp;
		}
	}

	// Deal all the cards
	public Card dealCards() {
		if (current < deck.length) {
			return deck[current++]; // return the current card in the array
		} else {
			return null; // return it null
		}
	}

	// Deal only 10 cards for the 2 players to play poker
	public Card dealfiveCards() {
		if (five < 11) {
			return deck[five++];// return the cards in the array
		} else {
			return null;// return it null
		}
	}

}