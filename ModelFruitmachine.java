// 2200528b, Tereza Buckova

/* Model is responsible for the actual mechanism of the game, it assigns random values to
 * cards, spins and is able to update balance and return balance, as well as knows when
 * the game should end. */ 

public class ModelFruitmachine {
public CardFruitmachine field1; 
public CardFruitmachine field2;
public CardFruitmachine field3;
public String message, endingMessage;
public int balance;

public ModelFruitmachine() {	
resetBalance();

}

//Assigns random values through the method in Card class
public void assignValue() {
	field1 = CardFruitmachine.randomCard();
	field2 = CardFruitmachine.randomCard();
	field3 = CardFruitmachine.randomCard();
}

//resets the fields 
public void resetFields() {
field1.type = "King";
field2.type = "Queen";
field3.type = "Jack";
}


// Method that assigns random values to cards and reaches conclusion how to update balance and what message should be generated
public void Spin() {
	assignValue();
	String message = "";
	if ( (field1.type).equals("Joker") || (field2.type).equals("Joker") || (field2.type).equals("Joker")) {
		int n = 0;
		if ( (field1.type).equals("Joker") )
			{balance -= 25;
			n++;}
		if ( (field2.type).equals("Joker") )
			{balance -= 25;
			n++;}
		if ( (field3.type).equals("Joker") )
			{balance -= 25;
			n++;}
		message = n + " jokers, you lose " + n*25 + " points" ;
	}

	else if (field1.type == field2.type && field2.type == field3.type)
	{balance += 50;
	message = "Three of a kind, you win 50 points"; }
	else if (field1.type == field2.type || field1.type == field3.type || field2.type == field3.type)
			{balance += 20; 
			message =  "Two of a kind, you win 20 points";
			}
	else {message = "Balance unchanged";
	}
	
	this.message = message;
}

public int getBalance() {
 return balance;	
}

//boolean method that return false if the game should end (it checks if balance reaches the limits of game ending)
public boolean endGame() {
	endingMessage = " ";
	if (balance < 0 ) {
	endingMessage = "You lost!" ;
	return false;
	}
	else if (balance > 150) {
		endingMessage = "You won!";	
		return false;
	}
	else {
		return true;
		
	}
}

public String getMessage( ) {
	return message;
}

public String getField1() {
	return field1.toString();
}

public String getField2() {
	return field2.toString();
}

public String getField3() {
	return field3.toString();
}


public void setBalance(int newBalance) {
balance = newBalance;
}

public void resetBalance() {
	balance = 0;
}
}
