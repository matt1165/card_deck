package card_deck;

import java.util.ArrayList;
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
	
	//Additional Constructor, takes prebuilt card array
	public Deck(ArrayList<Card> cards){
		this.cards = cards;		
	}
	
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
	
	public void printDeck(){
		for(Card c: cards) System.out.print(c.getCode()+"|");
	}
	
	
	
}
