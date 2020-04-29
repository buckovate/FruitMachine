// 2200528b, Tereza Buckova

// main class that calls and connects the model, controller and view		
public class FruitMachine {



	public static void main(String[] args) {

		// main creates model
		ModelFruitmachine model = new ModelFruitmachine();
		
		// main creates controller passing it the model, controller not yet tied to view
		ControllerFruitmachine controller = new ControllerFruitmachine(model);
		
		// main creates vies passing it the model and controller
		ViewFruitmachine view = new ViewFruitmachine(model, controller);
		
		// controller has method which allows us to connect it to the view
		controller.setView(view);
		view.setVisible(true);
	}

}
