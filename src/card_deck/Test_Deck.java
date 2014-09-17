package card_deck;

/**
 * A series of tests to demonstrate the functionality of the Deck class
 * 
 * Date Created:			9/15/2014
 * Date Last Modified:		9/16/2014
 * 
 * @author Matthew T. Farrington
 */

public class Test_Deck {
	public static void main(String[] args){
		
		/*
		//Create a new deck
		Deck myDeck = new Deck();
		myDeck.printDeck();
		*/
		
		/*
		//Cut a new deck in a random position
		Deck myDeck = new Deck();
		myDeck.cut();
		myDeck.printDeck();
		*/
		
		/*
		//Cut a new deck from a given position
		Deck myDeck = new Deck();
		int position = 5;
		myDeck.cut(position);
		myDeck.printDeck();
		*/
		
		/*
		//Shuffle and print the deck once
		Deck myDeck = new Deck();
		myDeck.shuffle();
		myDeck.printDeck();
		*/
		 
		/*
		//Shuffle and print the deck a given number of times
		Deck myDeck = new Deck();
		int numberOfShuffles = 10;
		myDeck.shuffle(numberOfShuffles);
		myDeck.printDeck();
		*/
		
		/*
		//Draw the first card from the deck
		Deck myDeck = new Deck();
		try{
			myDeck.draw();
			myDeck.printDeck();
		}
		catch(IndexOutOfBoundsException e){
			System.out.println(e);
		}
		*/
		
		/*
		//Remove the first 10 of clubs
		Deck myDeck = new Deck();
		myDeck.removeCard(new Card(10, "Clubs"));
		myDeck.printDeck();
		*/
		
		/*
		//Insert 3 King of Spades at positions 10, 15, and 20, and then remove them all
		Deck myDeck = new Deck();
		
		Card kingOfSpades = new Card(13,"Spades");
		myDeck.insertCard(kingOfSpades, 10);
		myDeck.insertCard(kingOfSpades, 15);
		myDeck.insertCard(kingOfSpades, 20);
		myDeck.printDeck();
		
		System.out.println("\n");
		
		myDeck.removeAllInstances(kingOfSpades);
		myDeck.printDeck();
		*/
		
		/*
		//Remove all 6's from the deck
		Deck myDeck = new Deck();
		myDeck.removeAllValue(6);
		myDeck.printDeck();
		*/
		
		//Remove all of the face cards and Jokers
		Deck myDeck = new Deck();
		myDeck.removeFaceCards();
		//myDeck.removeAllInstances(new Card(0,"Joker"));
		myDeck.printDeck();
		
		/*
		//Remove all of the remaining spades
		myDeck.removeAllSuit("Spades");
		myDeck.printDeck();
		
		*
		*/
		
	}
	
	
	
}
