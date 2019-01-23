package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Kristen Mounas - moukn001
 *
 */
public class PopOver {

	public double popX = 0;
	// sets pop menu in correct position after stage.UNDECORATED
	public double popY = 24;

	// buttons for popOver
	protected Button button1;
	protected Button button2;
	protected Button button3;
	protected Button button4;
	protected Button okDone;

	// Creating a Flow Pane for buttons
	protected FlowPane flowPane = new FlowPane();
	protected Label title = new Label("HEADING");
	protected BorderPane bpane;
	protected StackPane layout;
	
	Stage stage = new Stage();

	/**
	 * Constructor for PopOver
	 */
	public PopOver() {
		// sets title of menu
		stage.setTitle("Settings Menu");
		// makes stage non resizable
		stage.setResizable(false);
		// removes styling from stage
		stage.initStyle(StageStyle.TRANSPARENT);

		// create stackpane for menu
		layout = new StackPane();

		// Creating 4 buttons and change font styling
		button1 = new Button("Button1");
		button2 = new Button("Button2");
		button3 = new Button("Button3");
		button4 = new Button("Button4");

		// setting styles of the 4 buttons
		button1.setFont(Font.font("Raleway", 14));
		button1.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
				+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
		button2.setFont(Font.font("Raleway", 14));
		button2.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
				+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
		button3.setFont(Font.font("Raleway", 14));
		button3.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
				+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
		button4.setFont(Font.font("Raleway", 14));
		button4.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
				+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");

		// new button to close the popup
		okDone = new Button("DONE");
		okDone.setFont(Font.font("Raleway", FontWeight.SEMI_BOLD, 16));
		okDone.setStyle("-fx-background-color: rgba(38, 153, 251, 0.8); -fx-text-fill: rgb(255, 255, 255); ");
		okDone.setPrefSize(125, 48);

		// heading for popup included to allow changingfrom super
		title.setFont(Font.font("Raleway", 28)); // sets font type and size
		title.setTextFill(Color.rgb(38, 153, 251));

		// border pane holds done button
		bpane = new BorderPane();
		bpane.setPadding(new Insets(10, 10, 10, 10));
		bpane.setBottom(okDone);
		bpane.setTop(title);
		BorderPane.setAlignment(okDone, Pos.BOTTOM_RIGHT);

		// event handler for submit button
		okDone.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				stage.close();
			}
		});

		// setting the horizontal gap between the buttons
		flowPane.setHgap(15);
		flowPane.setVgap(15);
		// sets flow pane with buttons to center position
		flowPane.setAlignment(Pos.CENTER);

		// adding all the buttons to the flow pane
		flowPane.getChildren().add(button1);
		flowPane.getChildren().add(button2);
		flowPane.getChildren().add(button3);
		flowPane.getChildren().add(button4);
		flowPane.setMaxHeight(500);
		flowPane.setMaxWidth(500);

		// setting title to the Stage
		stage.setTitle("Pop-over Menu");

		// sets new window in top left corner
		stage.setX(popX);
		stage.setY(popY);

		// sets flow pane to white
		bpane.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-background-radius: 10;");
		// sets layout background to blue
		layout.setStyle("-fx-background-color: rgba(38, 153, 251, 0.5); -fx-padding: 150;");
		// adds borderPane and flowPane to the layout
		layout.getChildren().addAll(bpane, flowPane);

		Scene scene = new Scene(layout, 900, 600);
		// sets scene to transparent
		scene.setFill(Color.TRANSPARENT);
		stage.setScene(scene);
		
		//adding event handler to chang ecolour on mouse event
		EventHandler<MouseEvent> changeColor = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				//if the cause of the event was a button, set the style to ablue colour
				if(event.getTarget().getClass()==button1.getClass()){
				((Button)event.getTarget()).setStyle("-fx-background-color: BLUE; -fx-border-radius: "
						+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
				}
			}
		};
		
		//adding event handler to chang ecolour on mouse event
		EventHandler<MouseEvent> defaultColor = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				//if the cause was a button, change back to default colour
				if(event.getTarget().getClass()==button1.getClass()){
				((Button)event.getTarget()).setStyle("-fx-background-color: null; -fx-border-radius: "
						+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
				}	
			}
		};
		
		//setting the events to each button
		button1.setOnMousePressed(changeColor);
		button1.setOnMouseReleased(defaultColor);
		button2.setOnMousePressed(changeColor);
		button2.setOnMouseReleased(defaultColor);
		button3.setOnMousePressed(changeColor);
		button3.setOnMouseReleased(defaultColor);
		button4.setOnMousePressed(changeColor);
		button4.setOnMouseReleased(defaultColor);

		// shows stage
		stage.show();
	}
}