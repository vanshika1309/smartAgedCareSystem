package main;

import food.Dinner1;
import food.Lunch;
import food.Snacks;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/**
 * @author Kristen Mounas - moukn001
 *
 */

public class MealsMenu extends MenuStructure {
	
	// static boolean variables for menu selection buttons
	public static boolean c1, c2, c3, c4 = false;

	// used for loading images
	Image breakfast = new Image(getClass().getResourceAsStream("/breakfast.jpg"));
	Image lunch = new Image(getClass().getResourceAsStream("/lunch.jpg"));
	Image dinner = new Image(getClass().getResourceAsStream("/dinner.jpg"));
	Image snack = new Image(getClass().getResourceAsStream("/snack.jpg"));
	
	// used for painting images loaded
	ImageView breakfast1 = new ImageView(breakfast);
	ImageView lunch1 = new ImageView(lunch);
	ImageView dinner1 = new ImageView(dinner);
	ImageView snack1 = new ImageView(snack);
	
	// method for transitioning between menus etc. 
	public void transition() {
		FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5));
		fadeOut.setFromValue(1.0);
		fadeOut.setToValue(0.0);
		fadeOut.play(); // plays transition
	}

	/**
	 * Constructor for MealsMenu, instantiates a new stage with the structure from menuStructure
	 * changes text on labels for buttons to be used on different menus.
	 * @param maxX max screen size for stage, uses 600
	 * @param maxY max screen size for stage, uses 900
	 */
	@SuppressWarnings("static-access")
	public MealsMenu(double maxX, double maxY) {
		super(maxX, maxY);
		super.showStage();

		// breakfast - settings for menu option button 1
		super.menuOption1.setFont(Font.font("Raleway", 20)); // sets font styling
		super.menuOption1.setText("\n BREAKFAST"); // sets text within button
		super.menuOption1.setContentDisplay(ContentDisplay.TOP); // sets graphic to top of text
		super.menuOption1.setGraphic(breakfast1); // sets graphic as image
		breakfast1.setFitHeight(80); // sets height of graphic
		breakfast1.setFitWidth(80); // sets width of graphic

		// Event Handler for menu option
		menuOption1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				new food.Breakfast1(maxX, maxY).transition(); // calls breakfast pop over menu
				c1 = true;
			}
		});

		// lunch - settings for menu option button 2
		super.menuOption2.setFont(Font.font("Raleway", 20)); // sets font styling
		super.menuOption2.setText("\n LUNCH"); // sets text within button
		super.menuOption2.setContentDisplay(ContentDisplay.TOP); // sets graphic to top of text
		super.menuOption2.setGraphic(lunch1); // sets graphic as image
		lunch1.setFitHeight(80); // sets height of graphic
		lunch1.setFitWidth(80); // sets width of graphic

		// Event Handler for menu option
		menuOption2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				new Lunch(maxX, maxY).transition(); // calls lunch pop over menu
				c2 = true;
			}
		});

		// dinner - settings for menu option button 3
		super.menuOption3.setFont(Font.font("Raleway", 20)); // sets font styling
		super.menuOption3.setText("\n DINNER"); // sets text within button
		super.menuOption3.setContentDisplay(ContentDisplay.TOP); // sets graphic to top of text
		super.menuOption3.setGraphic(dinner1); // sets graphic as image
		dinner1.setFitHeight(80); // sets height of graphic
		dinner1.setFitWidth(80); // sets width of graphic

		// Event Handler for menu option
		menuOption3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				new Dinner1(maxX, maxY).transition(); // calls lunch pop over menu
				c3 = true;
			}
		});		

		// snacks - settings for menu option button 4
		super.menuOption4.setFont(Font.font("Raleway", 20)); // sets font styling
		super.menuOption4.setText("\n SNACK"); // sets text within button
		super.menuOption4.setContentDisplay(ContentDisplay.TOP);  // sets graphic to top of text
		super.menuOption4.setGraphic(snack1); // sets graphic as image
		snack1.setFitHeight(80); // sets height of graphic
		snack1.setFitWidth(80); // sets width of graphic

		// Event Handler for menu option
		menuOption4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				new Snacks(maxX, maxY).transition(); // calls lunch pop over menu
				c4 = true;
			}
		});	

		// Event Handler for the back button
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close(); // close menu here
			}
		});

		// New vbox to hold below elements
		VBox root = new VBox();
		root.setStyle("-fx-text-fill: rgb(38, 153, 251); "); // sets text color 
		root.setAlignment(Pos.CENTER); // aligns vbox to center

		// Heading
		Label heading = new Label("MEALS"); // label for meals heading 
		heading.setFont(Font.font("Raleway", 32)); // sets font type and size
		heading.setTextFill(Color.rgb(38, 153, 251)); // sets font colour

		// Spacing label
		Label space = new Label("\n");

		// Content
		Label content = new Label("Click on the icons to start \nselecting your meal options.");
		content.setTextAlignment(TextAlignment.CENTER); // sets text to center
		content.setFont(Font.font("Raleway Light", 16)); // sets font styling
		content.setTextFill(Color.rgb(38, 153, 251)); // sets text color

		// adds heading, space and content to vbox root
		root.getChildren().addAll(heading, space, content);

		super.backButton.setVisible(true); // makes back button visible
		super.currentWeatherDisplay.setTop(null); // hides top border pane elements
		super.currentWeatherDisplay.setCenter(root); // sets center border pane as root
		super.currentWeatherDisplay.setBottom(null); // hides bottom border pane elements
	}
}