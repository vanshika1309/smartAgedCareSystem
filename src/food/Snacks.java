package food;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;
import main.MealsMenu;

/**
 * @author Kristen Mounas - moukn001
 *
 */
public class Snacks extends MealsPopMenu {
	
	// variable to store user selection for this class
	public static String snackSelection;

	/**
	 * Constructor that instantiates a new stage with the structure from menuStructure
	 * @param maxX max screen size for stage, uses 600
	 * @param maxY max screen size for stage, uses 900
	 */
	public Snacks(double maxX, double maxY) {
		// shows stage
		super.showStage();
		
		//sets the text and user data for all buttons in the pop menu
		super.option1.setText("Nuts");
		super.option1.setUserData("Nuts");
		super.option2.setText("Fruit Salad");
		super.option2.setUserData("Fruit Salad");
		super.option3.setText("Cheese");
		super.option3.setUserData("Cheese");
		super.option4.setText("Biscuits");
		super.option4.setUserData("Biscuits");
		super.okNext.setText("DONE");
		// sets the below elements to be visible
		super.option5.setVisible(true);
		super.okNext.setVisible(true);
		super.backButt.setVisible(true);
		super.textFlow.setVisible(true);
		// sets heading content with new text
		super.heading.setText("SNACK");
		super.content.setText("Please select your choice for a snack. \n"
				+ "Click on the + symbol to add to your selection.");

		// Event handler to close pop over window
		EventHandler<ActionEvent> next = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// if no selection is made an alert will be called
				if ((option1.isSelected() == false) && (option2.isSelected() == false)
						&& (option3.isSelected() == false) && (option4.isSelected() == false)
						&& (option5.isSelected() == false)) {
					// calls selection alert
					selectionAlert();
				} else {
					// close stage
					stage.close();
					// sets boolean value to true
					MealsMenu.c4 = true;
					// calls summary menu with transition
					new Summary(maxX, maxY).transition();
				}
			}
		};
		okNext.setOnAction(next); // sets the action to the button

		// listens for selected option
		toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldToggle, Toggle newToggle) {
				if (toggleGroup.getSelectedToggle() != null) { //or observable != null
					// sets the user selection to a string
					snackSelection = (toggleGroup.getSelectedToggle().getUserData().toString());
					// prints the users selection
					System.out.println(snackSelection);
				}
			}
		});
	}	
}