//Class card 
public class Card {
	// Define the suits and faces
	private String face;
	private String suit;
	private int numericValue;

//	// Define constructors
	public Card(String face, String suit, int numericValue) {
		this.face = face;
		this.setSuit(suit);
		this.numericValue = numericValue;
	}

	// constructor overload
	public Card(String face, String suit) {
		this.face = face;
		this.setSuit(suit);
	}

	// Define getters and setters for all the methods
	public int getNumericValue() {
		return numericValue;
	}

	public void setNumericValue(int numericValue) {
		this.numericValue = numericValue;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	// To String method to return it
	public String toString() {
		return face + " of " + getSuit();
	}

}
