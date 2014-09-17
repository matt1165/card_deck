package card_deck;

/**
 * A simple deck class with definitions for common methods
 * 
 * Date Created:			9/15/2014
 * Date Last Modified:		9/16/2014
 * 
 * @author user
 */
class Card {

	private int number;
	private String suit;
	
	/**
	 * No argument constructor
	 */
	Card(){
		this(0,null);
	}
	
	/**
	 * Constructor, takes a number and a suit
	 * @param number	Int card value 
	 * @param suit	String card suit, use null for Jokers
	 */
	Card(int number, String suit){
		this.number = number;
		if(suit!=null)this.suit = suit;
		else this.suit = "Joker";
	}
	
	/**
	 * Get the number value of the card
	 * @return Int card value
	 */
	int getNumber(){
		 return number;
	}
	
	/**
	 * Get the suit of the card
	 * @return	String card suit
	 */
	String getSuit(){
		return suit;		
	}
	
	/**
	 * Get the color of the card based on the suit
	 * @return	String card color
	 */
	String getColor(){
		String color;
		if(suit.equals("Joker")) color = "None";
		else if(suit.equals("Spades")||suit.equals("Clubs")) color = "Black";
		else color = "Red";
		return color;		
	}
	
	/**
	 * Get the string value of the card (e.g. '7' or 'King')
	 * @return	String card value
	 */
	String getValue(){
		String value;
		switch(number){
		case 1: value =  "Ace";break;
		case 11: value =  "Jack";break;
		case 12: value =  "Queen";break;
		case 13: value =  "King";break;
		default: value =  Integer.toString(number);		
		}
		return value;
	}
	
	/**
	 * Get the full name of the card (e.g. 'Ace of Spades')
	 * @return String full card name
	 */
	String getName(){
		return getValue() + " of " + suit;
		
	}
	
	/**
	 * Get an abbreviated card code that describes the card
	 * e.g. "Jack of Hearts" --> "JH"
	 * @return String card code
	 */
	String getCode(){
		String cardCode;
		if(isFaceCard()) cardCode = getValue().substring(0,1); 
		else cardCode = getValue();
		return cardCode + getSuit().substring(0,1);
	}
	
	/**
	 * Determines if a card is a face card (Jack, Queen, King or Ace)
	 * @return boolean value
	 */
	boolean isFaceCard(){
		return (number==1||number>10);
	}
	
	/**
	 * Determines if two cards are equal
	 * @param newCard Card to compare
	 * @return boolean value
	 */
	boolean equals(Card newCard){
		return(getCode().equals(newCard.getCode()));
	}
}
