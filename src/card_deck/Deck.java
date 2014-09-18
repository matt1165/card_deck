package card_deck;

/**
 * A simple Deck class with definitions for commonly used functions
 * 
 * Date Created:		9/15/2014
 * Date Last Modified:	9/17/2014
 * 
 * @author Matthew T. Farrington
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards;
	
	/**
	 * No argument Constructor
	 */
	public Deck(){
		
		cards = new ArrayList<Card>();
		
		for(int i=1; i<14; i++){
			cards.add(new Card(i,"Spades"));
			cards.add(new Card(i,"Clubs"));
			cards.add(new Card(i,"Hearts"));
			cards.add(new Card(i,"Diamonds"));
		}
		cards.add(new Card());
		cards.add(new Card());
	}
	
	/**
	 * Additional Constructor, takes card array
	 * @param cards	Initial ArrayList of cards to establish a deck
	 */
	public Deck(ArrayList<Card> cards){
		this.cards = cards;		
	}
	
	/**
	 * Cuts the deck from a random position
	 */
	public void cut(){
		Random randomGen = new Random();
		this.cut(randomGen.nextInt(cards.size()-1));
	}
	
	/**
	 * Cuts the deck from a given position
	 * @param position	Position to split the deck
	 */
	public void cut(int position){
		ArrayList<Card>first = new ArrayList<Card>(cards.subList(0, position));
		ArrayList<Card>second = new ArrayList<Card>(cards.subList(position, cards.size()));
		
		second.addAll(first);
		cards = second;
	}
	
	/**
	 * Performs a pseudo-random shuffle
	 */
	public void shuffle(){
		ArrayList<Card> shuffledCards = new ArrayList<>();
		Random randomGen = new Random();
		
		//Remove a random card from "cards" and place it in a random position in "shufledCards"
		while(!cards.isEmpty()){
			int removePosition = randomGen.nextInt(cards.size());
			shuffledCards.add(cards.get(removePosition));
			cards.remove(removePosition);
		}
		cards = shuffledCards;
	}
	
	/**
	 * Performs a pseudo-random shuffle a specified number of times
	 * @param i	Number of times to shuffle the cards
	 */
	public void shuffle(int i){
		for(;i>0;i--){
			this.shuffle();
		}
	}
	
	/**
	 * Draws the first card from the deck
	 * @return	Card in position 0
	 * @throws	IndexOutOfBoundsException
	 */
	public Card draw() throws IndexOutOfBoundsException {
		try{
			Card drawnCard = cards.get(0);
			removeCard(drawnCard);
			return drawnCard;
		}
		catch(IndexOutOfBoundsException e){
			throw e;
		}
	}
	
	/**
	 * Removes the first instance of a given card
	 * @param card Card to remove
	 */
	public void removeCard(Card card){
		Iterator<Card> cardItr = cards.iterator();
		while(cardItr.hasNext()){
			if(cardItr.next().equals(card)){
				cardItr.remove();
				return;
			}
		}
	}
	
	/**
	 * Removes all instances of a given card from the deck
	 * @param card Card to remove from deck
	 */
	public void removeAllInstances(Card card){
		while(contains(card)) removeCard(card);
	}
	
	/**
	 * Removes all instances of a given card number value from the deck
	 * @param numValue int value of card to remove (e.g 7 or 13)
	 */
	public void removeAllNumber(int numValue){
		Iterator<Card> cardItr = cards.iterator();
		while(cardItr.hasNext()){
			if(cardItr.next().getNumber() == numValue) cardItr.remove();
		}
	}
	
	/**
	 * Removes all of the face cards from the deck
	 */
	public void removeFaceCards(){
		Iterator<Card> cardItr = cards.iterator();
		while(cardItr.hasNext()){
			if(cardItr.next().isFaceCard()) cardItr.remove();
		}
	}
	
	/**
	 * Removes all instances of a given suit from the deck
	 * @param suit Suit to remove from deck
	 */
	public void removeAllSuit(String suit){
		Iterator<Card> cardItr = cards.iterator();
		while(cardItr.hasNext()){
			if(cardItr.next().getSuit() == suit) cardItr.remove();
		}
	}
	
	/**
	 * Removes all instances of a given card value from the deck
	 * @param value Value of card type to remove (e.g '7' or 'Queen')
	 */
	public void removeAllValue(String value){
		Iterator<Card> cardItr = cards.iterator();
		while(cardItr.hasNext()){
			if(cardItr.next().getValue() == value) cardItr.remove();
		}
	}
	
	/**
	 * Removes all instances of a given card color from the deck
	 * @param color Color to remove from deck
	 */
	public void removeAllColor(String color){
		Iterator<Card> cardItr = cards.iterator();
		while(cardItr.hasNext()){
			if(cardItr.next().getColor() == color) cardItr.remove();
		}
	}
	
	/**
	 * Finds the "Running Count" of a deck (used for the Hi-Lo card counting system)
	 * @return Running Count of the remaining cards
	 */
	public int runningCount(){
		int count = 0;
		for(Card card: cards){
			if(card.getNumber()>1 && card.getNumber()<7) count++;		//Cards from 2-6 increase the count
			else if(card.isFaceCard()) count --;					//Facecards decrease the count
		}
		return count;
	}
	
	/**
	 * Returns the "True Count" of a deck (used for the Hi-Lo card counting system)
	 * @param decksInShoe
	 * @return
	 */
	public float trueCount(int decksInShoe){
		return (float)runningCount()/decksInShoe;
	}
	
	/**
	 * Inserts a card at a given position
	 * @param c	Card to insert into the deck
	 * @param position Position to insert the card
	 */
	public void insertCard(Card card, int position){
		cards.add(position, card);
	}
	
	/**
	 * Inserts a card in a random position
	 * @param c Card to insert into the deck
	 */
	public void instertCard(Card card){
		Random randomGen = new Random();
		this.insertCard(card, randomGen.nextInt(cards.size()-1));
	}
	
	/**
	 * Generates an array of Decks representing "hands" for a game of cards
	 * @param players	Number of players being dealt cards
	 * @param cardsPerHand	Number of cards to be dealt to each player
	 * @return	ArrayList<Deck> representing "hands" for a game of cards
	 */
	public ArrayList<Deck> deal(int numPlayers, int cardsPerHand){
		
		ArrayList<Deck> hands = new ArrayList<Deck>();
		
		//Add the first card to each players hand
		if(numPlayers>0){
			for(int i=numPlayers; i>0 && !cards.isEmpty(); i--){
				ArrayList<Card> newCards = new ArrayList<Card>();
				newCards.add(draw());	
				hands.add(new Deck(newCards));
				}
			}
		
		//Add additional cards to the hand
		if(numPlayers>1){
			for(Deck hand: hands){
				for(int i=cardsPerHand-1; i>0 && !cards.isEmpty(); i--){
					hand.insertCard(draw(),0);
				}
			}
		}
		return hands;
	}
	
	/**
	 * Determines if a deck contains a given card
	 * @param card Card to find in the deck
	 * @return boolean value
	 */
	public boolean contains(Card card){
		for(Card nextCard: cards){
			if(card.equals(nextCard))return true;
		}
		return false;
	}
	/**
	 * Gets the first position of a given card, returns -1 if not found
	 * @param card	Card to find in the deck
	 * @return int	First position of card (or -1 if not found)
	 */
	public int getPosition(Card card){
		int position = 0;
		if(contains(card)){
			for(Card nextCard: cards){
				if(card.equals(nextCard))return position;
				else position ++;
			}
		}
		return -1;
	}
	
	/**
	 * Prints the card code of each card in the deck
	 */
	public void printDeck(){
		for(Card card: cards){
			System.out.print(card.getCode()+"|");
		}
		System.out.println("\n");
	}
	/**
	 * Prints the full name (value and suit) of each card in the deck
	 */
	public void printDeckLong(){
		for(Card card: cards){
			System.out.println(card.getName());
		}
		System.out.print("\n");
	}
}
