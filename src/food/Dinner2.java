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
public class Dinner2 extends MealsPopMenu {

	// variable to store user selection for this class
	public static String dinnerSelection2;

	/**
	 * Constructor that instantiates a new stage with the structure from menuStructure
	 * @param maxX max screen size for stage, uses 600
	 * @param maxY max screen size for stage, uses 900
	 */
	public Dinner2(double maxX, double maxY) {
		// shows stage
		super.showStage();
		
		//sets the text and user data for all buttons in the pop menu
		super.option1.setText("Chicken");
		super.option1.setUserData("Chicken");
		super.option1.setPrefSize(135, 150);
		super.option2.setText("Beef");
		super.option2.setUserData("Beef");
		super.option2.setPrefSize(135, 150);
		super.option3.setText("Vegetarian");
		super.option3.setUserData("Vegetarian");
		super.option3.setPrefSize(135, 150);
		// sets the below elements to be visible
		super.option4.setVisible(false);
		super.option5.setVisible(false);
		super.okNext.setVisible(true);
		super.backButt.setVisible(true);
		super.textFlow.setVisible(true);
		// sets heading content with new text
		super.heading.setText("MAIN");
		super.content.setText("Please select your choice for a main meal \n"
				+ "Click on the + symbol to add to your selection.");

		// removes background colour to avoid overlapping of colours
		layout.setStyle("-fx-background-color: transparent; -fx-padding: 140;");
		
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
					// calls next pop menu with transition
					new Dinner3(maxX, maxY).transition();
				}
			}
		};
		okNext.setOnAction(next); // sets the action to the button

		// listens for selected option
		toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldToggle, Toggle newToggle) {
				if (toggleGroup.getSelectedToggle() != null) { //or observable != null
					// sets the user selection to a string	
					dinnerSelection2 = (toggleGroup.getSelectedToggle().getUserData().toString());
					// prints the users selection
					System.out.println(dinnerSelection2);
				}
			}
		});
	}
}