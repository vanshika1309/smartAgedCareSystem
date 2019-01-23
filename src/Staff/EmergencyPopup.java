package Staff;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EmergencyPopup {

	public double popX = 0;
	public double popY = 0;


	public Button backButt; // back or exit button
	Button callButton;
	Button change;
	public Scene scene;
	public Stage stage;

	public Label heading;
	public Label title;
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
	Image add = new Image(getClass().getResourceAsStream("/ambulance.png"));
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

	public EmergencyPopup() {
		stage = new Stage();
		stage.setResizable(false);
		stage.initStyle(StageStyle.TRANSPARENT);

		layout = new StackPane();
		mpane = new BorderPane();	
		background = new FlowPane();
		textFlow = new TextFlow();
		
		addTest.setFitHeight(250);
		addTest.setFitWidth(300);
		
		
//		heading = new Label("A SUPPORT WORKER WILL BE THERE\n           SOON TO ASSIST YOU");
		heading = new Label("AMBULANCE IS ON THE WAY");
		heading.setFont(Font.font("Raleway", 25)); 
		heading.setTextFill(Color.rgb(255, 255, 255));
		space = new Label();
		space.setPrefHeight(150);
		space.setPrefWidth(60);
		title = new Label("00:38");
		title.setFont(Font.font("Raleway", 30)); 
		title.setTextFill(Color.rgb(255, 255, 255));
		
		textFlow.getChildren().addAll(addTest, heading);
		textFlow.setTextAlignment(TextAlignment.CENTER); 
		
		exit.setFitHeight(30);
		exit.setFitWidth(40);
		
		callIcon.setFitHeight(60);
		callIcon.setFitWidth(80);

		change = new Button("", callIcon);
		change.setStyle("-fx-background-color: rgb(98, 4, 20);");
		backButt = new Button("", exit);
		backButt.setStyle("-fx-background-color: rgb(98, 4, 20);");
		
		mpane.setRight(change);
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

		EventHandler<ActionEvent> closePop = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				textFlow.getChildren().removeAll(addTest, heading);
			
				callIcon.setFitHeight(140);
				callIcon.setFitWidth(180);
			
				
				exit.setFitHeight(30);
				exit.setFitWidth(40);
				
				endIcon.setFitHeight(40);
				endIcon.setFitWidth(180);

				
				callButton = new Button("", endIcon);
				callButton.setStyle("-fx-background-color: rgb(98, 4, 20);");
				
				mpane.setRight(space);
				
				BorderPane.setAlignment(callIcon, Pos.TOP_CENTER);
				BorderPane.setAlignment(title, Pos.CENTER);
				BorderPane.setAlignment(callButton, Pos.TOP_CENTER);
				

				// adding contents to borderpane (current time, weather and picture)
				mpane.setTop(callIcon);
				mpane.setCenter(title);
				mpane.setBottom(callButton);
				
				
		
				EventHandler<ActionEvent> end = new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						stage.close();
						}
					};
					callButton.setOnAction(end);
					try{
					mpane.setLeft(space);}
					catch (Exception ex){};
				}
		
			};
		change.setOnAction(closePop);
		

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
	
	@SuppressWarnings("unused")
	private Node makeScrollBar(int value)
	{
	    Text text = new Text();
	    text.setFont(new Font("sans-serif", 10));
	    ScrollBar sb = new ScrollBar();
	    sb.setOrientation(Orientation.VERTICAL);
	    sb.setPrefHeight(400);
//	    sb.valueProperty().addListener(
//	        (observable, oldvalue, newvalue) ->
//	        {
//	            int i = newvalue.intValue();
//	            text.setText(Integer.toString(100-i));
//	        }
//	        );
//	    sb.setValue(value);
//	    VBox box = new VBox(10, sb, text);
//	    box.setPadding(new Insets(10));
//	    box.setAlignment(Pos.CENTER);
//	    box.setMinWidth(30);
//	    box.setPrefWidth(40);
//	    box.setMaxWidth(30);
	    return sb;
	}


}
