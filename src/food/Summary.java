package food;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Window;
import main.MainMenu;
import food.Breakfast1;
import food.Breakfast2;
import food.Breakfast3;
import food.Breakfast4;
import food.Lunch;

/**
 * @author Kristen Mounas - moukn001
 *
 */

public class Summary extends main.MealsMenu {

	/**
	 * Constructor that instantiates a new stage with the structure from menuStructure
	 * @param maxX max screen size for stage, uses 600
	 * @param maxY max screen size for stage, uses 900
	 */
	public Summary(double maxX, double maxY) {
		// shows stage
		super(maxX, maxY);	
		super.backButton.setDisable(true);
		
		// Label heading for food summary
		Label heading = new Label("MEAL SUMMARY");
		heading.setFont(Font.font("Raleway", 28)); // sets font styling
		heading.setTextAlignment(TextAlignment.CENTER); // aligns text to center
		heading.setAlignment(Pos.CENTER); // aligns label to center
		heading.setTextFill(Color.rgb(38, 153, 251)); // sets font color 
		heading.setPadding(new Insets(10, 0, 0, 0));
		heading.setPrefWidth(450); // sets width of label

		// Label heading for food sub heading summary
		Label subHeading = new Label("Click on the icons to start\nselecting your meal options.");
		subHeading.setFont(Font.font("Raleway Light", 14)); // sets font
		subHeading.setTextFill(Color.rgb(38, 153, 251)); // sets text color
		subHeading.setAlignment(Pos.CENTER); // aligns label to center
		subHeading.setTextAlignment(TextAlignment.CENTER);
		subHeading.setPadding(new Insets(10, 0, 5, 0));
		subHeading.setPrefWidth(450); // sets width of label

		// Breakfast Summary
		TitledPane tp1 = new TitledPane(); // new titled pane
		tp1.setText("Breakfast"); // set titledPane heading
		tp1.setFont(Font.font("Raleway", FontWeight.BOLD, 14)); // sets font styling
		tp1.setCollapsible(false); // remove closing action
		tp1.setPrefHeight(40); // set height
		tp1.setPrefWidth(450); // set width
		
		// An array to store the breakfast selection options
		Label options[] = new Label[] { new Label("TOAST:  "), new Label("CEREAL:  "), new Label("FRUIT:  "),
				new Label("DRINK:  ") };
		
		// GridPane to hold breakfast labels and user selections
		GridPane grid = new GridPane();
		GridPane.setRowIndex(options[0], 0); // column=1
		GridPane.setRowIndex(options[1], 1); // column=1
		GridPane.setRowIndex(options[2], 2); // column=1
		GridPane.setRowIndex(options[3], 3); // column=1
		
		grid.add(new Label(Breakfast1.breakfastSelection1), 2, 0); // column=2 row=0
		grid.add(new Label(Breakfast2.breakfastSelection2), 2, 1); // column=2 row=1
		grid.add(new Label(Breakfast3.breakfastSelection3), 2, 2); // column=2 row=2
		grid.add(new Label(Breakfast4.breakfastSelection4), 2, 3); // column=2 row=3
		grid.setStyle("-fx-background-color: white; ");
		
		// for loop to add all labels to vbox
		for (int i = 0; i < 4; i++) {
			grid.getChildren().addAll(options[i]);
			// font styling
			options[i].setFont(Font.font("Raleway", 13));
		}
		tp1.setContent(grid); // add vbox to titled pane
		tp1.setPadding((new Insets(3, 0, 0, 0))); // set padding for titled pane

		// Lunch Summary
		TitledPane tp2 = new TitledPane();
		tp2.setText("Lunch"); // set titledPane heading
		tp2.setFont(Font.font("Raleway", FontWeight.BOLD, 14)); // sets font styling
		tp2.setCollapsible(false); // remove closing action
		tp2.setPrefHeight(40); // set height
		tp2.setPrefWidth(450); // set width
		
		// A label to store the breakfast selection options
		Label option2 = new Label("LUNCH:  ");
		
		// GridPane to hold breakfast labels and user selections
		GridPane grid2 = new GridPane();
		GridPane.setRowIndex(option2, 0); // column=1
		grid2.add(new Label(Lunch.lunchSelection), 2, 0); // column=2 row=0
		grid2.setStyle("-fx-background-color: white; "); // styling 
		grid2.getChildren().addAll(option2); // add option to grid
		option2.setFont(Font.font("Raleway", 13)); // font styling
		tp2.setContent(grid2); // add vbox to titled pane
		tp2.setPadding((new Insets(3, 0, 0, 0))); // set padding

		// Dinner Summary
		TitledPane tp3 = new TitledPane();
		tp3.setText("Dinner"); // set titledPane heading
		tp3.setFont(Font.font("Raleway", FontWeight.BOLD, 14)); // sets styling
		tp3.setCollapsible(false); // remove closing action
		tp3.setPrefHeight(40); // set height
		tp3.setPrefWidth(450); // set width

		// An array to store the breakfast selection options
		Label options3[] = new Label[] { new Label("SIDE:  "), new Label("MAIN:  "),
				new Label("DESSERT:  "), new Label("DRINK:  ") };

		// GridPane to hold breakfast labels and user selections
		GridPane grid3 = new GridPane();
		GridPane.setRowIndex(options3[0], 0); // column=1
		GridPane.setRowIndex(options3[1], 1); // column=1
		GridPane.setRowIndex(options3[2], 2); // column=1
		GridPane.setRowIndex(options3[3], 3); // column=1
		grid3.add(new Label(Dinner1.dinnerSelection1), 2, 0); // column=2 row=0
		grid3.add(new Label(Dinner2.dinnerSelection2), 2, 1); // column=2 row=1
		grid3.add(new Label(Dinner3.dinnerSelection3), 2, 2); // column=2 row=2
		grid3.add(new Label(Dinner4.dinnerSelection4), 2, 3); // column=2 row=3
		grid3.setStyle("-fx-background-color: white; ");

		// for loop to add all labels to vbox
		for (int i = 0; i < 4; i++) {
			grid3.getChildren().addAll(options3[i]);
			options3[i].setFont(Font.font("Raleway", 13)); // change font and
			// size
		}
		tp3.setContent(grid3); // add vbox to titled pane
		tp3.setPadding((new Insets(3, 0, 0, 0))); // set paddings

		// Snack Summary
		TitledPane tp4 = new TitledPane();
		tp4.setText("Snack"); // set titledPane heading
		tp4.setFont(Font.font("Raleway", FontWeight.BOLD, 14)); // sets font styling
		tp4.setCollapsible(false); // remove closing action
		tp4.setPrefHeight(40); // set height
		tp4.setPrefWidth(450); // set width
		
		// A label to store the breakfast selection options
		Label option4 = new Label("SNACKS:  ");

		// GridPane to hold breakfast labels and user selections
		GridPane grid4 = new GridPane();
		GridPane.setRowIndex(option4, 0); // column=1
		grid4.add(new Label(Snacks.snackSelection), 2, 0);
		// grid2.add(new Label(Lunch.lunchSelection), 2, 0); // column=2 row=0
		grid4.setStyle("-fx-background-color: white; ");
		
		grid4.getChildren().addAll(option4); // adds option to grid
		option4.setFont(Font.font("Raleway", 13)); // change font and
		// size
		tp4.setContent(grid4); // add vbox to titled pane
		tp4.setPadding((new Insets(3, 0, 8, 0))); // set padding for titled
		// pane

		// styling of titled panes
		tp1.setStyle("-fx-color: rgba(38, 153, 251, 0.5); -fx-hover-base: rgba(38, 153, 251, 0.8); -fx-text-fill: white;");
		tp2.setStyle("-fx-color: rgba(38, 153, 251, 0.5); -fx-hover-base: rgba(38, 153, 251, 0.8); -fx-text-fill: white;");
		tp3.setStyle("-fx-color: rgba(38, 153, 251, 0.5); -fx-hover-base: rgba(38, 153, 251, 0.8); -fx-text-fill: white;");
		tp4.setStyle("-fx-color: rgba(38, 153, 251, 0.5); -fx-hover-base: rgba(38, 153, 251, 0.8); -fx-text-fill: white;");

		// button for submitting food order
		Button submit = new Button("SUBMIT MEAL ORDER");
		submit.setMaxWidth(450); // width of button
		submit.setMaxHeight(15); // height of button
		submit.setFont(Font.font("Raleway", FontWeight.SEMI_BOLD, 14)); // sets font styling
		submit.setDisable(true); // disables button

		// if all selections have been made, show submit button
		if ((c1 == true && c2 == true && c3 == true && c4 == true)) {
			// make submit button accessible
			submit.setDisable(false);
			// changes styling once selections have been made
			submit.setStyle("-fx-background-color: rgba(38, 153, 251); -fx-text-fill: rgb(255, 255, 255); ");
		}

		// event handler for submit button
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// if all selections have been made, allow submit
				if ((c1 == true && c2 == true && c3 == true && c4 == true)) {
					// creates confirmation alert
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirmation");
					alert.setHeaderText(null);
					alert.setContentText("Are you sure you want to submit?");
					alert.showAndWait();

					// calls main menu after meal has been submitted
					new MainMenu(maxX, maxY);
					// calls static method to disable meal menu once submitted 
					MainMenu.menuOption1.setDisable(true);
					MainMenu.menuOption1.setText("Meal Submitted");
				}
			}
		});	

		// used for loading images
		Image btick = new Image(getClass().getResourceAsStream("/btick.png"));
		Image ltick = new Image(getClass().getResourceAsStream("/ltick.png"));
		Image dtick = new Image(getClass().getResourceAsStream("/dtick.png"));
		Image stick = new Image(getClass().getResourceAsStream("/stick.png"));

		// used for painting images loaded
		ImageView btickView = new ImageView(btick);
		ImageView ltickView = new ImageView(ltick);
		ImageView dtickView = new ImageView(dtick);
		ImageView stickView = new ImageView(stick);

		// setting width and height for images
		btickView.setFitHeight(200);
		btickView.setFitWidth(225);
		ltickView.setFitHeight(200);
		ltickView.setFitWidth(225);
		dtickView.setFitHeight(200);
		dtickView.setFitWidth(225);
		stickView.setFitHeight(200);
		stickView.setFitWidth(225);
		
		// VBox to hold all elements
		VBox root = new VBox();
		
		// add all elememts to root
		root.getChildren().addAll(heading, subHeading, tp1, tp2, tp3, tp4, submit);	
		root.setMaxHeight(maxX);
		
		// if statements for changing the state of buttons once selections have been made
		// breakfast
		if (c1 == true) {
			menuOption1.setDisable(true);
			menuOption1.setGraphic(btickView); // sets graphic as image
		}
		// lunch
		if (c2 == true) {
			menuOption2.setDisable(true);
			menuOption2.setGraphic(ltickView);
		}
		// dinner
		if (c3 == true) {
			menuOption3.setDisable(true);
			menuOption3.setGraphic(dtickView);
		}
		// snacks
		if (c4 == true) {
			menuOption4.setDisable(true);
			menuOption4.setGraphic(stickView);
		}
		
		if ((c1 == true && c2 == true && c3 == true && c4 == true)) {
			root.getChildren().remove(subHeading);
			heading.setPadding(new Insets(10, 0, 0, 0));
		}

		super.currentWeatherDisplay.setTop(null); // set top of pane to null 
		super.currentWeatherDisplay.setCenter(root); // set content to center of borderPane
		super.currentWeatherDisplay.setBottom(null); // set bottom of pane to null
	}
}