package food;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *  
 * @author Kristen Mounas - moukn001
 *
 */
public class MealsPopMenu {

	// toggle buttons for each menu option
	public ToggleButton option1, option2, option3, option4, option5;
	public ToggleGroup toggleGroup; // group to hold all options above

	// class variables that allow changing of configuration of
	// position in which stage will be launched into
	public double popX = 0;
	public double popY = 24;

	public Button backButt; // back or exit button
	public Button okNext; // OK or next button

	public Scene scene; // new scene
	public static Stage stage; // new stage

	public static StackPane layout; // holds border & flow pane
	public BorderPane mpane; // sets content to positions
	public FlowPane background; // background within pop
	public VBox vmenu; // holds option buttons
	public Label heading, content, space; // labels for pop up content
	public TextFlow textFlow; // holds the above labels

	// used for loading images
	Image add = new Image(getClass().getResourceAsStream("/plusCircle.png"));
	Image favourite = new Image(getClass().getResourceAsStream("/fav.png"));
	Image addClicked = new Image(getClass().getResourceAsStream("/addClicked.png"));
	Image favClicked = new Image(getClass().getResourceAsStream("/favB.png"));
	Image backButton = new Image(getClass().getResourceAsStream("/backk.png"));
	
	// used for painting images loaded
	ImageView add1 = new ImageView(add);
	ImageView add2 = new ImageView(add);
	ImageView add3 = new ImageView(add);
	ImageView add4 = new ImageView(add);
	ImageView add5 = new ImageView(favourite);
	ImageView fav = new ImageView(favClicked);
	ImageView exit = new ImageView(backButton);

	// getters for stage and scene
	public Stage getStage() {
		return MealsPopMenu.stage;
	}

	public Scene getScene() {
		return this.scene;
	}

	// method to show stage
	public void showStage() {
		stage.show();
	}

	// method to close stage
	public static void closeStage() {
		stage.close();
	}

	// method for transition between menus etc. 
	public void transition() {
		FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), layout);
		fadeOut.setFromValue(0.0);
		fadeOut.setToValue(1.0);
		fadeOut.play(); // plays transition
	}
	
	public void selectionAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Warning Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Please make a selection..");
		alert.showAndWait();
	}
	
	/**
	 * MealsPopMenu Constructor
	 */
	public MealsPopMenu() {
		// create stackPane for menu
		layout = new StackPane();
		// Creating a Flow Pane for buttons
		mpane = new BorderPane();
		// Creating a Flow Pane for buttons
		background = new FlowPane();
		// creates vertical menu for options
		vmenu = new VBox();
		// setting the position of the text
		textFlow = new TextFlow();
		// creates new group to hold options
		toggleGroup = new ToggleGroup();

		heading = new Label("HEADING"); // creates new label
		heading.setFont(Font.font("Raleway", 32)); // sets font type and size
		heading.setTextFill(Color.rgb(38, 153, 251)); // sets font colour

		space = new Label("\n"); // creates new label

		content = new Label("Content"); // creates new label
		content.setFont(Font.font("Raleway Light", 14)); // sets font type and
															// size
		content.setTextFill(Color.rgb(38, 153, 251)); // sets font colour

		// adds heading and content to center of borderpane
		textFlow.getChildren().addAll(heading, space, content);
		textFlow.setTextAlignment(TextAlignment.LEFT); // aligns text to left
		textFlow.setPadding(new Insets(110, 10, 10, 10)); // sets padding

		backButt = new Button("", exit); // creates new button with graphic
		backButt.setStyle("-fx-background-color: rgb(255, 255, 255);"); // sets
																		// styling

		okNext = new Button("NEXT"); // creates next button
		okNext.setFont(Font.font("Raleway", FontWeight.SEMI_BOLD, 16)); // set
																		// font
																		// styling
		okNext.setStyle("-fx-background-color: rgba(38, 153, 251, 0.8); -fx-text-fill: rgb(255, 255, 255); ");
		okNext.setPrefSize(135, 48); // sets preferred size of button

		// setting elements to border pane
		mpane.setLeft(backButt); // adds the back button to the left
		mpane.setRight(vmenu); // sets choice menu to right
		mpane.setBottom(okNext); // sets OK button to bottom
		mpane.setCenter(textFlow); // sets to center

		mpane.setPadding(new Insets(10, 10, 10, 10)); // adds 10px padding to
														// mpane
		vmenu.setSpacing(3); // sets spacing between buttons

		// aligns elements in border pane
		// okDone to bottom right
		BorderPane.setAlignment(okNext, Pos.BOTTOM_RIGHT); 
		// textFlow to center
		BorderPane.setAlignment(textFlow, Pos.CENTER);

		// sets sizes of icon images
		add1.setFitHeight(20);
		add1.setFitWidth(20);
		add2.setFitHeight(20);
		add2.setFitWidth(20);
		add3.setFitHeight(20);
		add3.setFitWidth(20);
		add4.setFitHeight(20);
		add4.setFitWidth(20);
		add5.setFitHeight(20);
		add5.setFitWidth(20);
		exit.setFitHeight(30);
		exit.setFitWidth(40);

		// creating 6 buttons
		option1 = new ToggleButton("OPTION 1 ");
		// adds image to right hand side
		option1.setContentDisplay(ContentDisplay.RIGHT);
		// sets colour and fill of button
		option1.setStyle("-fx-background-color: rgba(241, 249, 255); -fx-text-fill: rgb(38, 153, 251); ");
		// sets size of button
		option1.setPrefSize(135, 47);
		// sets font type, weight and size
		option1.setFont(Font.font("Raleway", FontWeight.SEMI_BOLD, 14));
		// adds option to group
		option1.setToggleGroup(toggleGroup);
		// sets the user data
		option1.setUserData("Option 1");
		// sets graphic option button
		option1.setGraphic(add1);

		option2 = new ToggleButton("OPTION 2 ", add2);
		option2.setContentDisplay(ContentDisplay.RIGHT);
		option2.setStyle("-fx-background-color: rgba(241, 249, 255); -fx-text-fill: rgb(38, 153, 251); ");
		option2.setPrefSize(135, 47);
		option2.setFont(Font.font("Raleway", FontWeight.SEMI_BOLD, 14));
		option2.setToggleGroup(toggleGroup);
		option2.setUserData("Option 2");

		option3 = new ToggleButton("OPTION 3 ", add3);
		option3.setContentDisplay(ContentDisplay.RIGHT);
		option3.setStyle("-fx-background-color: rgba(241, 249, 255); -fx-text-fill: rgb(38, 153, 251); ");
		option3.setPrefSize(135, 47);
		option3.setFont(Font.font("Raleway", FontWeight.SEMI_BOLD, 14));
		option3.setToggleGroup(toggleGroup);
		option3.setUserData("Option 3");

		option4 = new ToggleButton("OPTION 4 ", add4);
		option4.setContentDisplay(ContentDisplay.RIGHT);
		option4.setStyle("-fx-background-color: rgba(241, 249, 255); -fx-text-fill: rgb(38, 153, 251); ");
		option4.setPrefSize(135, 47);
		option4.setFont(Font.font("Raleway", FontWeight.SEMI_BOLD, 14));
		option4.setToggleGroup(toggleGroup);
		option4.setUserData("Option 4");

		option5 = new ToggleButton("Favourite ", add5);
		option5.setContentDisplay(ContentDisplay.RIGHT);
		option5.setStyle("-fx-background-color: rgba(241, 249, 255); -fx-text-fill: rgb(38, 153, 251); ");
		option5.setPrefSize(135, 47);
		option5.setFont(Font.font("Raleway", FontWeight.SEMI_BOLD, 14));
		option5.setToggleGroup(toggleGroup);
		option5.setUserData("Favourite");

		// Event handler to close pop over window
		backButt.setOnAction(event -> stage.close());
		
		// Event Handler when item is clicked
		option1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// If option 1 is selected
				if (option1.isSelected() == true) {
					// disable remaining buttons
					option2.setDisable(true);
					option3.setDisable(true);
					option4.setDisable(true);
					option5.setDisable(true);
					add1.setImage(addClicked);
					option1.setStyle("-fx-background-color: rgbargb(38, 153, 251, 0.6);");

				}
				// Option un-clicked returns button to original state
				else {
					option1.setStyle("-fx-background-color: rgba(241, 249, 255); -fx-text-fill: rgb(38, 153, 251); ");
					add1.setImage(add);
					option2.setDisable(false);
					option3.setDisable(false);
					option4.setDisable(false);
					option5.setDisable(false);
				}
			}
		});

		// Event Handler when item is clicked
		option2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// If option 2 is selected
				if (option2.isSelected() == true) {
					// disable remaining buttons
					option1.setDisable(true);
					option3.setDisable(true);
					option4.setDisable(true);
					option5.setDisable(true);
					add2.setImage(addClicked);
					option2.setStyle("-fx-background-color: rgbargb(38, 153, 251, 0.6);");
				}
				// Option un-clicked returns button to original state
				else {
					option2.setStyle("-fx-background-color: rgba(241, 249, 255); -fx-text-fill: rgb(38, 153, 251); ");
					add2.setImage(add);
					option1.setDisable(false);
					option3.setDisable(false);
					option4.setDisable(false);
					option5.setDisable(false);
				}
			}
		});

		// Event Handler when item is clicked
		option3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// If option 3 is selected
				if (option3.isSelected() == true) {
					// disable remaining buttons
					option1.setDisable(true);
					option2.setDisable(true);
					option4.setDisable(true);
					option5.setDisable(true);
					add3.setImage(addClicked);
					option3.setStyle("-fx-background-color: rgbargb(38, 153, 251, 0.6);");
				}
				// Option un-clicked returns button to original state
				else {
					option3.setStyle("-fx-background-color: rgba(241, 249, 255); -fx-text-fill: rgb(38, 153, 251); ");
					add3.setImage(add);
					option1.setDisable(false);
					option2.setDisable(false);
					option4.setDisable(false);
					option5.setDisable(false);
				}
			}
		});

		// Event Handler when item is clicked
		option4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// If option 4 is selected
				if (option4.isSelected() == true) {
					// disable remaining buttons
					option1.setDisable(true);
					option3.setDisable(true);
					option2.setDisable(true);
					option5.setDisable(true);
					add4.setImage(addClicked);
					option4.setStyle("-fx-background-color: rgbargb(38, 153, 251, 0.6);");
				}
				// Option un-clicked returns button to original state
				else {
					option4.setStyle("-fx-background-color: rgba(241, 249, 255); -fx-text-fill: rgb(38, 153, 251); ");
					add4.setImage(add);
					option1.setDisable(false);
					option3.setDisable(false);
					option2.setDisable(false);
					option5.setDisable(false);
				}
			}
		});

		// Event Handler when item is clicked
		option5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// If option 5 is selected
				if (option5.isSelected() == true) {
					// disable remaining buttons
					option1.setDisable(true);
					option3.setDisable(true);
					option4.setDisable(true);
					option2.setDisable(true);
					add5.setImage(favClicked);
					option5.setStyle("-fx-background-color: rgbargb(38, 153, 251, 0.6);");
				}
				// Option un-clicked returns button to original state
				else {
					option5.setStyle("-fx-background-color: rgba(241, 249, 255); -fx-text-fill: rgb(38, 153, 251); ");
					add5.setImage(favourite);
					option1.setDisable(false);
					option3.setDisable(false);
					option4.setDisable(false);
					option2.setDisable(false);
				}
			}
		});
		// adds all options to vbox menu
		vmenu.getChildren().addAll(option1, option2, option3, option4, option5);

		stage = new Stage(); // new stage to hold scene
		stage.setResizable(false); // makes stage not resizeable
		stage.initStyle(StageStyle.TRANSPARENT); // removes default styling
		stage.setTitle("Pop-over Menu"); // Setting title to the Stage

		// sets new window in top left corner
		stage.setX(popX);
		stage.setY(popY);

		// sets flowpane to white
		background.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-background-radius: 0;");
		// sets layout background to blue and sets opacity to 0.5
		layout.setStyle("-fx-background-color: rgba(38, 153, 251, 0.5); -fx-padding: 140;");
		// adds background flowPane and borderPane to stackPane
		layout.getChildren().addAll(background, mpane);

		scene = new Scene(layout, 900, 600); // new stage with layout and size
		scene.setFill(Color.TRANSPARENT); // sets scene background to
											// transparent
		stage.setScene(scene); // sets scene to stage

		// shows stage
		stage.show();
	}
}