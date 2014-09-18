package card_deck;

import java.util.ArrayList;

/**
 * A series of tests to demonstrate the functionality of the Deck class
 * 
 * Date Created:			9/15/2014
 * Date Last Modified:		9/17/2014
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
		myDeck.removeAllNumber(6);
		myDeck.printDeck();
		*/
		
		/*
		//Remove all of the face cards and Jokers
		Deck myDeck = new Deck();
		myDeck.removeFaceCards();
		myDeck.removeAllSuit("Joker");
		myDeck.printDeck();
		*/
		
		/*
		//Remove all of the Spades and all other red cards (leaving only Clubs and Jokers)
		Deck myDeck = new Deck();
		myDeck.removeAllSuit("Spades");
		myDeck.removeAllColor("Red");
		myDeck.printDeck();
		*/
		
		/*
		//Remove the 5 of diamonds, insert back in random position, print the position
		Deck myDeck = new Deck();
		Card card = new Card(5,"Diamonds");
		myDeck.removeCard(card);
		myDeck.instertCard(card);
		System.out.println("Position: " + myDeck.getPosition(card));
		*/
		
		/*
		//Deal and print 5 hands of 2 cards for a game of Blackjack
		//After the cards are delt find the Running Count and the True Count of the
		//remaining cards in the deck
		int decksInShoe = 2;
		Deck myDeck = new Deck();
		myDeck.removeAllSuit("Joker");
		myDeck.shuffle();
		ArrayList<Deck> handsArray = myDeck.deal(5,2);
		for(Deck hand: handsArray){
			hand.printDeckLong();
		}
		
		System.out.println("Running Count: " + myDeck.runningCount());
		System.out.println("True Count: " + myDeck.trueCount(decksInShoe));
		*/
	}
}
