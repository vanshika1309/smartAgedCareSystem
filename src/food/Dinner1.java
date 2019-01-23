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
public class Dinner1 extends MealsPopMenu {

	// variable to store user selection for this class
	public static String dinnerSelection1;

	/**
	 * Constructor that instantiates a new stage with the structure from menuStructure
	 * @param maxX max screen size for stage, uses 600
	 * @param maxY max screen size for stage, uses 900
	 */
	public Dinner1(double maxX, double maxY) {
		// shows stage
		super.showStage();
		
		//sets the text and user data for all buttons in the pop menu
		super.option1.setText("Soup");
		super.option1.setUserData("Soup");
		super.option1.setPrefSize(135, 150);
		super.option2.setText("Sandwich");
		super.option2.setUserData("Sandwich");
		super.option2.setPrefSize(135, 150);
		super.option3.setText("Salad");
		super.option3.setUserData("Salad");
		super.option3.setPrefSize(135, 150);
		// sets the below elements to be visible
		super.option4.setVisible(false);
		super.option5.setVisible(false);
		super.okNext.setVisible(true);
		super.backButt.setVisible(true);
		super.textFlow.setVisible(true);
		// sets heading content with new text
		super.heading.setText("SIDES");
		super.content.setText("Please select your choice for a side \n"
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
					// calls next pop menu with transition
					new Dinner2(maxX, maxY).transition();
				}
			}
		};
		okNext.setOnAction(next); // sets the action to the button

		// listens for selected option
		toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldToggle, Toggle newToggle) {
				if (toggleGroup.getSelectedToggle() != null) { // or observable != null
					// sets the user selection to a string
					dinnerSelection1 = (toggleGroup.getSelectedToggle().getUserData().toString());
					// prints the users selection
					System.out.println(dinnerSelection1);
				}
			}
		});
	}
}