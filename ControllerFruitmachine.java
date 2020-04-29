// 2200528b, Tereza Buckova

/* Controller implements action listener and is responsible for actions
 *  tied to the button clicking */ 

import java.awt.event.*;

public class ControllerFruitmachine implements ActionListener {
	private ViewFruitmachine viewObject;
	private ModelFruitmachine modelObject;
	
	// only the model is passed in constructor
	public ControllerFruitmachine(ModelFruitmachine model) {
		modelObject = model;
	}
	
	// method that allows us to pass it a view, this is used in Main
	public void setView(ViewFruitmachine view) {
		viewObject = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewObject.newgameButton) {
			/*
			 * This is the controller - listens to two buttons of the game
			 * and performs actions.  
			 * When "new game" button is clicked game needs to reset balance in model,
			 * and update the balance in view, update message in view and delete
			 * the winning message
			*/
				modelObject.resetBalance();
				viewObject.updateBalance();
				viewObject.resetCards();
				viewObject.resetMessage();
				viewObject.enabledisableButton();
				viewObject.resetendMessage();
				
		} else if (e.getSource() == viewObject.spinButton) {
				modelObject.Spin();
				viewObject.updateBalance();
				viewObject.updateCards();
				viewObject.updateMessage();
				viewObject.enabledisableButton();
				viewObject.updateendMessage();
				}

	}
}
