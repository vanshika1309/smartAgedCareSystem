package Staff;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import main.MenuStructure;

public class FaultReport extends MenuStructure {
		
	TextField itemTA;
	TextField locationTA;
	TextArea descriptionTA;
	Label label1 = new Label("Item Name");
	Label label2 = new Label("Item Location");
	Label label3 = new Label("Fault Description");
	Label label4 = new Label("Please enter the item name");
	Label label5 = new Label("Please enter the items location");
	Label label6 = new Label("Please enter the problem");
	
	//Custom styles which overwrite exisiting ones later in the code
	String textBoxStyle = ("-fx-font-size: 20px;");
	String textBoxStyleError = ("-fx-font-size: 20px; -fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 2px;");
	String textBoxStyleSuccess = ("-fx-font-size: 20px; -fx-border-color: green; -fx-border-width: 2px; -fx-border-radius: 2px;");
	String labels = ("-fx-font-size: 24px;");
	String labelsError = ("-fx-font-size: 16px; -fx-font-color: red;");
	String sendButton = "-fx-background-color: rgb(0, 218, 0); -fx-border-radius: "
			+ "30px; -fx-background-radius: 32px; -fx-border-width: 0px; -fx-border-color: rgba(255, 255, 255);"
			+ "-fx-font-size: 32px;";
	String clearButton = "-fx-background-color: rgb(255,215,0); -fx-border-radius: "
			+ "30px; -fx-background-radius: 32px; -fx-border-width: 0px; -fx-border-color: rgba(255, 255, 255);"
			+ "-fx-font-size: 32px;";
	String regularButton = ("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
			+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251);"
			+ "-fx-font-size: 32px;");
    
	
	@SuppressWarnings("static-access")
	public FaultReport(double maxX, double maxY) {
		super(maxX, maxY);
		super.showStage();
		itemTA = new TextField();
		locationTA = new TextField();
		descriptionTA = new TextArea();
		
		super.scene.setOnKeyPressed(null);
		
		label1 = new Label("Item Name");
		label2 = new Label("Item Location");
		label3 = new Label("Fault Description");
		
		label4.setTextFill(Color.web("#FF0000"));
		label5.setTextFill(Color.web("#FF0000"));
		label6.setTextFill(Color.web("#FF0000"));
		
		label4.setVisible(false);
		label5.setVisible(false);
		label6.setVisible(false);
		
		descriptionTA.setPrefHeight(150);
		descriptionTA.setWrapText(true);

		Image emergency = new Image(getClass().getResourceAsStream("/emergency.png"));
		ImageView emergencyImg = new ImageView(emergency);
		emergencyImg.setFitHeight(100); 
		emergencyImg.setFitWidth(150);
		
		EventHandler<ActionEvent> menu1Load = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent menu1) {
				
				
				boolean readyToSend = true;
				if(itemTA.getText().trim().isEmpty()) {
					itemTA.setStyle(textBoxStyleError);
					readyToSend = false;
					label4.setVisible(true);
				} else {
					itemTA.setStyle(textBoxStyle);
					label4.setVisible(false);
				}
				
				if(locationTA.getText().trim().isEmpty()) {
					locationTA.setStyle(textBoxStyleError);
					readyToSend = false;
					label5.setVisible(true);
				} else {
					locationTA.setStyle(textBoxStyle);
					label5.setVisible(false);
				}
				
				if(descriptionTA.getText().trim().isEmpty()) {
					descriptionTA.setStyle(textBoxStyleError);
					readyToSend = false;
					label6.setVisible(true);
				} else {
					descriptionTA.setStyle(textBoxStyle);
					label6.setVisible(false);
				}
				
				if(readyToSend) {
					itemTA.setText("");
					itemTA.setStyle(textBoxStyleSuccess);
					locationTA.setText("");
					locationTA.setStyle(textBoxStyleSuccess);
					descriptionTA.setText("");
					descriptionTA.setStyle(textBoxStyleSuccess);
				}
			}
		};
		
		super.menuOption1.setOnAction(menu1Load);
		super.menuOption1.setFont(Font.font("Raleway", 20));
		super.menuOption1.setText("SEND");
		super.menuOption1.setStyle(sendButton);
		super.menuOption1.setContentDisplay(ContentDisplay.TOP);
		//super.menuOption1.setGraphic();
		
		EventHandler<ActionEvent> menu2Load = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent menu1) {
				itemTA.setText("");
				locationTA.setText("");
				descriptionTA.setText("");
				
				itemTA.setStyle(textBoxStyle);
				label4.setVisible(false);
				locationTA.setStyle(textBoxStyle);
				label5.setVisible(false);
				descriptionTA.setStyle(textBoxStyle);
				label6.setVisible(false);
			}
		};
		
		super.menuOption2.setOnAction(menu2Load);
		super.menuOption2.setFont(Font.font("Raleway", 20));
		super.menuOption2.setText("CLEAR");
		super.menuOption2.setStyle(clearButton);
		super.menuOption2.setContentDisplay(ContentDisplay.TOP);
		//super.menuOption1.setGraphic(breakfast1);
		
		EventHandler<ActionEvent> menu3Load = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent menu1) {
				locationTA.setText("Room 14A - West Wing");
			}
		};
		
		super.menuOption3.setOnAction(menu3Load);
		super.menuOption3.setFont(Font.font("Raleway", 20));
		super.menuOption3.setText("GET ROOM");
		super.menuOption3.setStyle(regularButton);
		super.menuOption3.setContentDisplay(ContentDisplay.TOP);
		
		EventHandler<ActionEvent> menu4Load = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent menu4) {
				new Emergency();
			}
		};

		super.menuOption4.setOnAction(menu4Load);
		super.menuOption4.setFont(Font.font("Raleway", 20)); 
		super.menuOption4.setText("\n EMERGENCY");
		super.menuOption4.setContentDisplay(ContentDisplay.TOP);
		super.menuOption4.setGraphic(emergencyImg);
		emergencyImg.setFitHeight(100); 
		emergencyImg.setFitWidth(150);
		
		//Setting Styles
		label1.setStyle(labels);
		label2.setStyle(labels);
		label3.setStyle(labels);
		itemTA.setStyle(textBoxStyle);
		locationTA.setStyle(textBoxStyle);
		descriptionTA.setStyle(textBoxStyle);
		
		GridPane grid = new GridPane();
		
		
		grid.add(label1, 0, 1);
		grid.add(itemTA, 0, 2);
		grid.add(label4, 0, 3);
		
		
		grid.add(label2, 0, 4);
		grid.add(locationTA, 0, 5);
		grid.add(label5, 0, 6);
		
		grid.add(label3, 0, 7);
		grid.add(descriptionTA, 0, 8);
		grid.add(label6, 0, 9);

		// adding contents to borderpane (current time, weather and picture)
	    super.currentWeatherDisplay.setTop(null);
	    super.currentWeatherDisplay.setBottom(null);
		super.currentWeatherDisplay.setCenter(grid);
		grid.setTranslateX(400);
		
		//The animation to slide in from the right
		TranslateTransition tt = new TranslateTransition(Duration.millis(2000), grid);
		tt.setByX(-400);
		tt.play();
		
		EventHandler<ActionEvent> backButtonClose = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent close){
				stage.close();
			}
		};
		
		super.backButton.setVisible(true);
		super.backButton.setOnAction(backButtonClose);
		
	}
}






