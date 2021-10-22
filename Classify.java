import java.util.Scanner;
import java.util.Arrays;

public class Classify {
	static Classify hand = new Classify();

	public static void main(String[] args) {
		// Define Scanner and objects
		Scanner scan = new Scanner(System.in);
		Play poker = new Play();

		// prompt the user to enter the 10 characters
		System.out.print("Enter 10 characers for Player1: ");
		String character1 = scan.nextLine();
		System.out.print("Enter 10 characers for Player2: ");
		String character2 = scan.nextLine();

		// Define arrays for the players
		String[] player1 = new String[5];
		String[] player2 = new String[5];
		int counter = 0;
		// Get 2 characters from the 10 characters and store it in an array
		for (int i = 0; i < 9; i = i + 2) {
			player1[counter] = character1.substring(i, i + 2).toUpperCase();// change the letters to uppercase
			player2[counter] = character2.substring(i, i + 2).toUpperCase();// Change to uppercase
			counter = counter + 1;
		}
		// Call to sort cards

		// Define a new card array
		Card[] newplayer1 = makeCards(player1);
		Card[] newplayer2 = makeCards(player2);
		// Print all the sorted cards
		System.out.println(Arrays.deepToString(hand.sort(newplayer1)));
		System.out.println(Arrays.deepToString(hand.sort(newplayer2)));

		System.out.println("\n");
		int priority1 = 0;
		int priority2 = 0;
		// Compare the hands. Similar to play.java
		System.out.println("The Player 1 has ");
		if (poker.straight(newplayer1) && poker.flush(newplayer1)) {
			System.out.println("Straight Flush");
			priority1 = 1;
		} else if (poker.straight(newplayer1)) {
			System.out.println("Straight");
			priority1 = 5;
		} else if (poker.flush(newplayer1)) {
			System.out.println("Flush");
			priority1 = 4;
		} else if (poker.fourofakind(newplayer1)) {
			System.out.println("Four of a Kind");
			priority1 = 2;
		} else if (poker.fullhouse(newplayer1)) {
			System.out.println("Full House!");
			priority1 = 3;
		} else if (poker.threepairs(newplayer1)) {
			System.out.println("Three Pairs");
			priority1 = 6;
		} else if (poker.twopairs(newplayer1)) {
			System.out.println("Two Pairs");
			priority1 = 7;
		} else if (poker.onePair(newplayer1)) {
			System.out.println("One Pair");
			priority1 = 8;
		} else {
			poker.highcard(newplayer1);
			System.out.println("High Card");
			priority1 = 9;
		}

		// CHECK THE HANDS FOR player2 Cards
		System.out.println("\n");
		System.out.println("The Player 2 has ");
		if (poker.straight(newplayer2) && poker.flush(newplayer2)) {
			System.out.println("Straight Flush");
			priority2 = 1;
		} else if (poker.straight(newplayer2)) {
			System.out.println("Staight");
			priority2 = 5;
		} else if (poker.flush(newplayer2)) {
			System.out.println("Flush");
			priority2 = 4;
		} else if (poker.fourofakind(newplayer2)) {
			System.out.println("Four of a Kind");
			priority2 = 2;
		} else if (poker.fullhouse(newplayer2)) {
			System.out.println("Full House!");
			priority2 = 3;
		} else if (poker.threepairs(newplayer2)) {
			System.out.println("Three Pairs");
			priority2 = 6;
		} else if (poker.twopairs(newplayer2)) {
			System.out.println("Two Pairs");
			priority2 = 7;
		} else if (poker.onePair(newplayer2)) {
			System.out.println("One Pair");
			priority2 = 8;
		} else {
			poker.highcard(newplayer2);
			System.out.println("High Card");
			priority2 = 9;
		}
		// The hand with the top priority wins the Game!
		if (priority1 < priority2) {
			System.out.println("Player 1 wins the game");
		} else if (priority2 < priority1) {
			System.out.println("Player 2 wins the game");
		}
		// Check if the hand is one pair
		else if ((priority1 == priority2) && (priority1 == 8)) {
			poker.checkOnepair(newplayer1, newplayer2);// Get the highest card from the one pairs of different hand
		}
		// Check which high card won
		else if ((priority1 == priority2) && (priority1 == 9)) {
			if ((poker.highcard(newplayer2)) > (poker.highcard(newplayer1))) {// player with the highest card wins
				System.out.println("\n");
				System.out.println("Player 1 wins the game");
			} else {
				System.out.println("\n");
				System.out.println("Player 2 wins the game");
			}
		} else {
			System.out.println("\n");
			System.out.println(" It is Draw!!!");// if all the condition fails then it must be draw
		}

	}

	// ========================================================================================================================
	public int checkrank(Card cards) {
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

	// FUNCTION to sort the cards in the order
	public Card[] sort(Card[] h) {
		for (int i = 0; i < h.length; i++) {
			for (int j = i + 1; j < h.length; j++) {
				if (this.checkrank(h[i]) > this.checkrank(h[j])) {
					Card temp = h[i];
					h[i] = h[j];
					h[j] = temp;
				}
			}
		}
		return h;
	}

	// FUNCTION to make the string[] cards array to a Card[]
	public static Card[] makeCards(String[] cards) {
		// initialize the card array
		Card[] nCardArray = new Card[5];
		int counter = 0;
		// loop thorough the string array and check which face it has
		for (String pc : cards) {
			String face = "";
			String suit = "";
			// check for the character of Ace, Ten, Jack, Queen and King
			if (pc.charAt(0) == 'T') {
				face = "10";
			} else if (pc.charAt(0) == 'J') {
				face = "Jack";
			} else if (pc.charAt(0) == 'Q') {
				face = "Queen";
			} else if (pc.charAt(0) == 'K') {
				face = "King";
			} else if (pc.charAt(0) == 'A') {
				// System.out.print("I am here");
				face = "Ace";
			} else {
				face = pc.charAt(0) + "";
			}

			if (pc.charAt(1) == 'H') {
				suit = "Hearts";
			} else if (pc.charAt(1) == 'D') {
				suit = "Diamonds";
			} else if (pc.charAt(1) == 'S') {
				suit = "Spades";
			} else if (pc.charAt(1) == 'C') {
				suit = "Clubs";
			}
			Card another = new Card(face, suit);
			// System.out.println("That hand is " +hand.checkrank(another));
			nCardArray[counter] = another;
			counter++;
		}
		return nCardArray;
	}
}
