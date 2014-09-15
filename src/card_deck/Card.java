package card_deck;

class Card {

	private int number;
	private String suit;
	
	Card(){
		this(0,null);
	}
	
	Card(int number, String suit){
		this.number = number;
		if(suit!=null)this.suit = suit;
		else this.suit = "Joker";
		
	}
	
	int getNumber(){
		 return number;
	}
	
	String getSuit(){
		return suit;		
	}
	
	String getColor(){
		String color;
		if(suit.equals("Joker")) color = "None";
		else if(suit.equals("Spades")||suit.equals("Clubs")) color = "Black";
		else color = "Red";
		return color;		
	}
	
	String getValue(){
		String value;
		switch(number){
		case 0: value = "Joker";
		case 1: value =  "Ace";
		case 11: value =  "Jack";
		case 12: value =  "Queen";
		case 13: value =  "King";
		default: value =  Integer.toString(number);		
		}
		return value;
	}
	
	String getName(){
		return getValue() + " of " + suit;
		
	}
	
	String getCode(){
		String cardCode;
		if(!isFaceCard()) cardCode = getValue().substring(0,1); 
		else cardCode = getValue();
		return cardCode + getSuit().substring(0,1);
		
	}
	
	boolean isFaceCard(){
		return (number>2 && number<11);
	}
}
