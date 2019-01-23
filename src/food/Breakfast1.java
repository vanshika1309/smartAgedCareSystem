package food;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;

/**
 * @author Kristen Mounas - moukn001
 *
 */
public class Breakfast1 extends MealsPopMenu {

	// variable to store user selection for this class
	public static String breakfastSelection1;

	/**
	 * Constructor that instantiates a new stage with the structure from menuStructure
	 * @param maxX max screen size for stage, uses 600
	 * @param maxY max screen size for stage, uses 900
	 */
	public Breakfast1(double maxX, double maxY) {
		// shows stage
		super.showStage();
		
		//sets the text and user data for all buttons in the pop menu
		super.option1.setText("Nutella");
		super.option1.setUserData("Nutella");
		super.option2.setText("Honey");
		super.option2.setUserData("Honey");
		super.option3.setText("Jam");
		super.option3.setUserData("Jam");
		super.option4.setText("Vegemite");
		super.option4.setUserData("Vegemite");
		
		// sets the below elements to be visible
		super.option5.setVisible(true);
		super.okNext.setVisible(true);
		super.backButt.setVisible(true);
		super.textFlow.setVisible(true);
		
		// sets heading content with new text
		super.heading.setText("TOAST");
		super.content.setText("Would you like to add any condiments to your choice? \n"
				+ "Click on the + symbol to add to your selection. \n*Butter is included.");

		// Event handler to progress to next pop over window
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
					// calls next pop menu with transition
					new Breakfast2(maxX, maxY).transition();	
				}
			}
		};
		okNext.setOnAction(next); // sets the action to the button
		
		// listens for selected option
		toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldToggle, Toggle newToggle) {
				if (toggleGroup.getSelectedToggle() != null) { // or observable != null
					// sets the user selection to a string
					breakfastSelection1 = (toggleGroup.getSelectedToggle().getUserData().toString());
					// prints the users selection
					System.out.println(breakfastSelection1);
				}
			}
		});
	}
}