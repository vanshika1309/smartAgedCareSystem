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
public class Breakfast4 extends MealsPopMenu {
	
	// variable to store user selection for this class
	public static String breakfastSelection4;

	/**
	 * Constructor that instantiates a new stage with the structure from menuStructure
	 * @param maxX max screen size for stage, uses 600
	 * @param maxY max screen size for stage, uses 900
	 */
	public Breakfast4(double maxX, double maxY) {
		// shows stage
		super.showStage();
		
		//sets the text and user data for all buttons in the pop menu
		super.option1.setText("Coffee");
		super.option1.setUserData("Coffee");
		super.option2.setText("Tea");
		super.option2.setUserData("Tea");
		super.option3.setText("Herbal Tea");
		super.option3.setUserData("Herbal Tea");
		super.option4.setText("Juice");
		super.option4.setUserData("Juice");
		super.okNext.setText("DONE");
		// sets the below elements to be visible
		super.option5.setVisible(true);
		super.okNext.setVisible(true);
		super.backButt.setVisible(true);
		super.textFlow.setVisible(true);
		// sets heading content with new text
		super.heading.setText("DRINKS");
		super.content.setText("Choose your choice of drink. \n" + "Click on the + symbol to add to your selection.");

		// removes background colour to avoid overlapping of colours
		layout.setStyle("-fx-background-color: transparent; -fx-padding: 140;");

		// Event handler to close pop over window
		EventHandler<ActionEvent> done = new EventHandler<ActionEvent>() {
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
					MealsMenu.c1 = true;
					// calls summary menu with transition
					new Summary(maxX, maxY).transition();
				}
			}
		};
		okNext.setOnAction(done); // sets the action to the button

		// listens for selected option
		toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldToggle, Toggle newToggle) {
				if (toggleGroup.getSelectedToggle() != null) { // or observable != null
					// sets the user selection to a string						
					breakfastSelection4 = (toggleGroup.getSelectedToggle().getUserData().toString());
					// prints the users selection
					System.out.println(breakfastSelection4);
				}
			}
		});
	}
}