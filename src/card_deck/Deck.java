package card_deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards;
	
	//No Args Constructor
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
	
	//Additional Constructor, takes card array
	public Deck(ArrayList<Card> cards){
		this.cards = cards;		
	}
	
	//Cuts the deck from a random position
	public void cut(){
		Random randomGen = new Random();
		this.cut(randomGen.nextInt(cards.size()-1));
	}
	
	//Cuts the deck from a given position
	public void cut(int position){
		ArrayList<Card>first = (ArrayList<Card>) cards.subList(0, position);
		ArrayList<Card>second = (ArrayList<Card>) cards.subList(position, cards.size()-1);
		
		second.addAll(first);
		cards = second;
	}
	
	//Performs a random shuffle
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
	
	//Performs a random shuffle a specified number of times
	public void shuffle(int i){
		for(;i>0;i--){
			this.shuffle();
		}
	}
	
	//Returns the card in position 0
	public Card draw(){
		try{
			return cards.get(0);
		}
		//Check the error code here
		catch(Error e){
			System.out.println("Deck is out of cards!");
			return null;
		}
	}
	
	//Removes the first instance of a given card
	public void removeCard(Card c){
		cards.remove(c);
	}
	
	//Removes all of the face cards from the deck
	public void removeFaceCards(){
		for(Card c: cards){
			if(c.isFaceCard()) cards.remove(c);
		}
	}
	
	//Removes all instances of a given card from the deck
	public void removeAllInstances(Card c){
		while(cards.contains(c)) cards.remove(c);
	}
	
	//Removes all instances of a given suit from the deck
	public void removeAllSuit(String suit){
		for(Card c: cards){
			if(c.getSuit().equals(suit)) cards.remove(c);
		}
	}
	
	//Removes all instances of a given card value from the deck
	public void removeAllValue(int value){
		for(Card c: cards){
			if(c.getNumber()==value) cards.remove(c);
		}
	}
	
	//Removes all instances of a given card name from the deck
	public void removeAllValue(String name){
		for(Card c: cards){
			if(c.getName().equals(name)) cards.remove(c);
		}
	}
	
	//Removes all instances of a given card color from the deck
	public void removeAllColor(String color){
		for(Card c: cards){
			if(c.getName().equals(color)) cards.remove(c);
		}
	}
	
	//Returns the "Running Count" of a deck (used for the Hi-Lo card counting system)
	public int runningCount(){
		int count = 0;
		for(Card c: cards){
			if(c.getNumber()>1 && c.getNumber()<7) count++;		//Cards from 2-6 increase the count
			else if(c.isFaceCard()) count --;					//Facecards decrease the count
		}
		return count;
	}
	
	//Inserts a card at a given position
	public void insertCard(Card c, int position){
		cards.add(position, c);
	}
	
	//Inserts a card in a random position
	public void instertCard(Card c){
		Random randomGen = new Random();
		this.insertCard(c, randomGen.nextInt(cards.size()-1));
	}
	
	//Returns the "True Count" of a deck (used for the Hi-Lo card counting system)
	public float trueCount(int decksInShoe){
		return this.runningCount()/decksInShoe;
	}
	
	//Returns an array of Decks representing "hands" for a game of cards
	public ArrayList<Deck> deal(int players, int cardsPerHand){
				
		Deck[] hands = new Deck[players];
		
		//Loop through, adding cards to each player's hands
		while(!cards.isEmpty()){
			for(;cardsPerHand>0;cardsPerHand--)
				for(Deck playerHand: hands){
					playerHand.insertCard(cards.get(0),0);
			}
		}
		return new ArrayList<Deck>(Arrays.asList(hands));
	}
	
	//Prints the card code of each card in the deck
	public void printDeck(){
		for(Card c: cards) System.out.print(c.getCode()+"|");
	}
}
