package main;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AssistancePopup {

	public double popX = 0;
	public double popY = 0;


	public Button backButt; // back or exit button
	public Scene scene;
	public Stage stage;

	public Label heading;
	public Label space;
	public StackPane layout;
	public BorderPane mpane;
	public FlowPane background;
	public TextFlow textFlow;
	


	public ToggleGroup toggleGroup;

	Image backButton = new Image(getClass().getResourceAsStream("/backk.png"));
	ImageView exit = new ImageView(backButton);
	Image call = new Image (getClass().getResourceAsStream("/call.png"));
	ImageView callIcon = new ImageView(call);
	Image add = new Image(getClass().getResourceAsStream("/help.png"));
	ImageView addTest = new ImageView(add);
	Image endCall = new Image (getClass().getResourceAsStream("/endcall.png"));
	ImageView endIcon = new ImageView(endCall);

	public Stage getStage() {
		return this.stage;
	}

	public Scene getScene() {
		return this.scene;
	}

	public void showStage() {
		this.stage.show();
	}

	public AssistancePopup() {
		stage = new Stage();
		stage.setResizable(false);
		stage.initStyle(StageStyle.TRANSPARENT);

		layout = new StackPane();
		mpane = new BorderPane();	
		background = new FlowPane();
		textFlow = new TextFlow();
		
		addTest.setFitHeight(250);
		addTest.setFitWidth(300);
		
		
		heading = new Label("A SUPPORT WORKER WILL BE THERE\n           SOON TO ASSIST YOU");
		heading.setFont(Font.font("Raleway", 25)); 
		heading.setTextFill(Color.rgb(255, 255, 255));
		space = new Label();
		space.setPrefHeight(150);
		space.setPrefWidth(60);
		
		
		textFlow.getChildren().addAll(addTest, heading);
		textFlow.setTextAlignment(TextAlignment.CENTER); 
		
		exit.setFitHeight(30);
		exit.setFitWidth(40);
		
		callIcon.setFitHeight(60);
		callIcon.setFitWidth(80);

		
		backButt = new Button("", exit);
		backButt.setStyle("-fx-background-color: rgb(98, 4, 20);");
	
		mpane.setLeft(backButt);
//		mpane.setRight(makeScrollBar(78));	
		BorderPane.setAlignment(textFlow, Pos.CENTER);
		mpane.setCenter(textFlow);
		EventHandler<ActionEvent> back1 = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				stage.close();
				}
			};
			backButt.setOnAction(back1);

		

		stage.setTitle("Pop-over Menu");

		stage.setX(popX); 
		stage.setY(popY);
		background.setStyle("-fx-background-color: rgb(98, 4, 20); -fx-background-radius: 0;");
		layout.setStyle("-fx-background-color: rgba(38, 153, 251, 0.5); -fx-padding: 150;");
		layout.getChildren().addAll(background, mpane);

		scene = new Scene(layout, 900, 624);
		scene.setFill(Color.TRANSPARENT);
		stage.setScene(scene);

		// shows stage
		stage.show();
	}
	



}
