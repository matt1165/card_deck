package card_deck;

//A series of tests to demonstrate the functionality of the Deck class
public class Test_Deck {
	public static void main(String[] args){
		
		//Create a new deck
		Deck myDeck = new Deck();
		
		//Print out the entire deck
		myDeck.printDeck();
		
		//Shuffle and print the deck
		myDeck.shuffle();
		myDeck.printDeck();
		
		//Remove all of the face cards
		myDeck.removeFaceCards();
		myDeck.printDeck();
		
		//Remove all of the remaining spades
		myDeck.removeAllSuit("Spades");
		myDeck.printDeck();
		
		
	}
	
	
	
}
