// 2200528b, Tereza Buckova

/* This class creates the cards used in the game and creates an array of the cards used
 * in the game in order to avoid repeating of the code in Model class. 
 */

import java.util.Random;

public class CardFruitmachine {
	static CardFruitmachine joker;
	static CardFruitmachine ace;
	static CardFruitmachine king;
	static CardFruitmachine queen; 
	static CardFruitmachine jack;
	public String type;

// introduces card defined with the type of the card
public CardFruitmachine (String type) {
	this.type = type;
}

// returns type of the card
public String toString() {
	return type;
}

//introduces cards, makes an array of them, picks a random card from the array and returns it
public static CardFruitmachine randomCard() {
	CardFruitmachine joker = new CardFruitmachine ("Joker");
	CardFruitmachine ace = new CardFruitmachine ("Ace");
	CardFruitmachine king = new CardFruitmachine ("King");
	CardFruitmachine queen = new CardFruitmachine ("Queen");
	CardFruitmachine jack = new CardFruitmachine ("Jack");
	CardFruitmachine [] ArrayofCards = {joker, ace, king, queen, jack};
	Random rand = new Random();
	CardFruitmachine randomCard = ArrayofCards[rand.nextInt(4)];
	return randomCard;
}

}
