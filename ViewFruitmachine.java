// 2200528b, Tereza Buckova

import javax.swing.*;
	import java.awt.*;
	  import java.awt.BorderLayout;
	  import java.awt.Color;
	  import javax.swing.BorderFactory;
	  import javax.swing.JPanel;

/* This class sets up the swing window, it takes main panel and puts 4 panels in a grid
 * and then follows the design which we want in each of the panels.
 * Helper methods help to connect the controller and model to the view so that it updates
 * and we see what we are supposed to see.
 */
	  
public class ViewFruitmachine extends JFrame {  

	public JButton newgameButton, spinButton;
	public JLabel balanceLabel;
	private ControllerFruitmachine controllerObject;
	private ModelFruitmachine modelObject;
	private JLabel balance, field1, field2, field3, message, endMessage;
	public JPanel main, Panel1, Panel2, Panel3, Panel4;
	
// setting the JPanel and calls the methods for setting panels
    public ViewFruitmachine(ModelFruitmachine model, ControllerFruitmachine controller) {
    controllerObject = controller;
	modelObject = model;
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(600,400);
	setLocation(100,100);
	setTitle("Fruitmachine GUI");
	setLayout(new BorderLayout());
	setMainpanel();
	setPanel1();
	setPanel2();
	setPanel3();
	setPanel4();
    }
    
    
 // sets up main Panel with border
    public void setMainpanel() {

	JPanel main = new JPanel();
	// on this grid 4 other panels will be added
	main.setLayout(new GridLayout(2,2));
	main.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	this.add(main, BorderLayout.CENTER);
	
	this.main = main;
    }
    
//sets up Panel1 (top left)
	public void setPanel1() {
	JPanel Panel1 = new JPanel();
	main.add(Panel1);
	Panel1.setLayout(new BorderLayout());
	balance = new JLabel("Balance is 0");
	message = new JLabel("Welcome!");
	endMessage = new JLabel(" ");
	Panel1.add(balance,BorderLayout.NORTH);
	Panel1.add(message, BorderLayout.CENTER);
	Panel1.add(endMessage, BorderLayout.SOUTH);
	}
	
	public void setPanel2() {
		JPanel Panel2 = new JPanel();
		main.add(Panel2);
	}
//sets Panel3 (bottom left)
	public void setPanel3() {
	JPanel Panel3 = new JPanel();
	main.add(Panel3);
	Panel3.setLayout( new GridLayout(0,3));
	
	//creating borders for the three cards
	JPanel Panel3field1 = new JPanel();
	Panel3field1.setLayout(new BorderLayout());
	Panel3field1.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
	JPanel Panel3field2 = new JPanel();
	Panel3field2.setLayout(new BorderLayout(10,10));
	Panel3field2.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
	JPanel Panel3field3 = new JPanel();
	Panel3field3.setLayout(new BorderLayout(10,10));
	Panel3field3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
	
	Panel3.add(Panel3field1);
	Panel3.add(Panel3field2);
	Panel3.add(Panel3field3);
	
	//setting up the three cards
	JPanel InnerPanel3field1 = new JPanel();
	JPanel InnerPanel3field2 = new JPanel();
	JPanel InnerPanel3field3 = new JPanel();
	//adding color
	InnerPanel3field1.setBackground(Color.yellow); 
	InnerPanel3field2.setBackground(Color.yellow); 
	InnerPanel3field3.setBackground(Color.yellow); 
	
	InnerPanel3field1.setLayout(new BorderLayout());
	InnerPanel3field2.setLayout(new BorderLayout());
	InnerPanel3field3.setLayout(new BorderLayout());
	
	Panel3field1.add(InnerPanel3field1);
	Panel3field2.add(InnerPanel3field2);
	Panel3field3.add(InnerPanel3field3);
	
	// putting up labels updated with controller using helper methods
	field1 = new JLabel("King", JLabel.CENTER);
	field2 = new JLabel("Queen", JLabel.CENTER);
	field3 = new JLabel("Jack", JLabel.CENTER);

	InnerPanel3field1.add(field1, BorderLayout.CENTER);
	InnerPanel3field2.add(field2, BorderLayout.CENTER);
	InnerPanel3field3.add(field3, BorderLayout.CENTER);
	
	}
//setting up Panel4
	public void setPanel4() {
	JPanel Panel4 = new JPanel();
	main.add(Panel4);
	JPanel InnerPanel4 = new JPanel();
	Panel4.setLayout(new BorderLayout(10,10));
	Panel4.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
	Panel4.add(InnerPanel4, BorderLayout.CENTER);
	InnerPanel4.setLayout(new BorderLayout());
		
	//create buttons on InnerPanel4
	newgameButton = new JButton("New game");
	newgameButton.addActionListener(controllerObject);
	spinButton = new JButton("Spin");
	spinButton.addActionListener(controllerObject);
	
	//add the buttons on InnerPanel4
	InnerPanel4.add(newgameButton, BorderLayout.NORTH);
	InnerPanel4.add(spinButton, BorderLayout.SOUTH);
	}
    
    
 //helper methods that update labels and are used by the controller
	
	// updates balance based on the model
    public void updateBalance() {
	balance.setText("Balance is " + modelObject.getBalance());
    }
    
    // resets the labels into starting values
    public void resetCards() {
    field1.setText("King");
    field2.setText("Queen");
    field3.setText("Jack");
    }
    // updates the visible labels on cards to the values of the cards from model
    public void updateCards() {
    field1.setText(modelObject.getField1());
    field2.setText(modelObject.getField2());
    field3.setText(modelObject.getField3());
    }
    // updates message about change of balance based on the message generated in model
    public void updateMessage() {
    message.setText(modelObject.message);	
    }
    // resets the message into starting state
    public void resetMessage() {
    message.setText("Welcome!");
    }
    // updates end message based on the message generated in model
    public void updateendMessage() {
    endMessage.setText(modelObject.endingMessage);	
    }
    // resets the end message
    public void resetendMessage() {
    endMessage.setText(" ");	
    }
    // the endGame method returns true when the spin button should be clickable, false (disabled) when game ends
    public void enabledisableButton() {
    spinButton.setEnabled(modelObject.endGame());
    }
    

    }


