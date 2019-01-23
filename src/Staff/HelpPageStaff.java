package Staff;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.MenuStructure;

/** 
 * 
 * @author Vanshika Kapoor - kapvy001
 *
 */
public class HelpPageStaff extends MenuStructure {

	Image clean = new Image(getClass().getResourceAsStream("/clean.png"));
	Image log = new Image(getClass().getResourceAsStream("/log.png"));
	Image record = new Image(getClass().getResourceAsStream("/health.png"));
	Image emergency = new Image(getClass().getResourceAsStream("/emergency.png"));

	ImageView clean1 = new ImageView(clean);
	ImageView log1 = new ImageView(log);
	ImageView record1 = new ImageView(record);
	ImageView emergency1 = new ImageView(emergency);

	@SuppressWarnings("static-access")
	public HelpPageStaff(double maxX, double maxY) {
		super(maxX, maxY);
		super.showStage();

		super.scene.setOnKeyPressed(null);
		Label help = new Label("HELP");
		help.setAlignment(Pos.CENTER);
		help.setPrefHeight(140);
		help.setPrefWidth(200);
		help.setFont(Font.font("Raleway", FontWeight.BOLD, 35));
		
		
		Label content = new Label("Hover over the buttons to" + "\n" + "   find more about them");
		content.setAlignment(Pos.CENTER);
		content.setPrefHeight(140);
		content.setPrefWidth(200);
		content.setFont(Font.font("Raleway", 16));
		
		Label food = new Label("CLEANING");
		food.setAlignment(Pos.CENTER);
		food.setPrefHeight(140);
		food.setPrefWidth(200);
		food.setFont(Font.font("Raleway", FontWeight.BOLD, 35));
		
		
		Label content1 = new Label("Through this button you " + "\n" + "can turn the cleaning mode" + "\n" + "on/off.");
		content1.setAlignment(Pos.CENTER);
		content1.setPrefHeight(140);
		content1.setPrefWidth(200);
		content1.setFont(Font.font("Raleway", 16)); 
		
		Label tv = new Label("LOGS");
		tv.setAlignment(Pos.CENTER);
		tv.setPrefHeight(140);
		tv.setPrefWidth(200);
		tv.setFont(Font.font("Raleway", FontWeight.BOLD, 35));
		
		Label content2 = new Label("On this panel you will"  + "\n" + 
				"be able to view and edit" + "\n" + "the reported faults.");
		content2.setAlignment(Pos.CENTER);
		content2.setPrefHeight(140);
		content2.setPrefWidth(200);
		content2.setFont(Font.font("Raleway", 16));
		
		Label assistance = new Label("  PATIENT" + "\n" + "  RECORDS");
		assistance.setAlignment(Pos.CENTER);
		assistance.setPrefHeight(140);
		assistance.setPrefWidth(200);
		assistance.setFont(Font.font("Raleway", FontWeight.BOLD, 35));
		
		Label content3 = new Label(" On this panel you will be  "  + "\n" + 
		"able to view the information" + "\n"
				+ "and health record of the"  + "\n" + "resident. You can also"
				 + "\n" + "update and edit.");
		content3.setAlignment(Pos.CENTER);
		content3.setPrefHeight(140);
		content3.setPrefWidth(200);
		content3.setFont(Font.font("Raleway", 16));
		
		
		Label room = new Label("EMERGENCY");
		room.setAlignment(Pos.CENTER);
		room.setPrefHeight(140);
		room.setPrefWidth(200);
		room.setFont(Font.font("Raleway", FontWeight.BOLD, 32));
		
		Label content4 = new Label("This button will allow you" + "\n" + "to alert the ambulance"
				+ "\n" + "immediately if the resident" + "\n" + "requires more professional" + "\n" + "help.");
		content4.setAlignment(Pos.CENTER);
		content4.setPrefHeight(140);
		content4.setPrefWidth(200);
		content4.setFont(Font.font("Raleway", 16));
		
		
		BorderPane.setAlignment(content, Pos.CENTER);
		
		super.currentWeatherDisplay.setTop(null);
		super.currentWeatherDisplay.setCenter(null);
		super.currentWeatherDisplay.setBottom(null);
		super.currentWeatherDisplay.setTop(help);
		BorderPane.setMargin(help, new Insets(100, 10, 10, 10));
		super.currentWeatherDisplay.setLeft(content);
	    BorderPane.setMargin(content, new Insets(10, 10, 250, 10));
		DropShadow shadow = new DropShadow();

		super.menuOption1.setFont(Font.font("Raleway", 20)); 
		super.menuOption1.setText("\n CLEANING");
		super.menuOption1.setContentDisplay(ContentDisplay.TOP);
		super.menuOption1.setGraphic(clean1);

		 super.menuOption1.addEventHandler(MouseEvent.MOUSE_ENTERED,
				 new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			        	  menuOption1.setEffect(shadow);
			        	  currentWeatherDisplay.setTop(food);
			        	  BorderPane.setMargin(food, new Insets(100, 10, 10, 10));
			        	  currentWeatherDisplay.setLeft(content1);
				    	  BorderPane.setMargin(content1, new Insets(10, 10, 100, 10));
			          }
			          });
		 super.menuOption1.addEventHandler(MouseEvent.MOUSE_EXITED,
			        new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			            menuOption1.setEffect(null);
			            currentWeatherDisplay.setTop(help);
			    		BorderPane.setMargin(help, new Insets(100, 10, 10, 10));
			    		currentWeatherDisplay.setLeft(content);
			    	    BorderPane.setMargin(content, new Insets(10, 10, 250, 10));
			          }
			        });
	
		clean1.setFitHeight(100); 
		clean1.setFitWidth(100);


		super.menuOption2.setFont(Font.font("Raleway", 20)); 
		super.menuOption2.setText("\n FAULT REPORT");
		super.menuOption2.setContentDisplay(ContentDisplay.TOP);
		super.menuOption2.setGraphic(log1);
		 super.menuOption2.addEventHandler(MouseEvent.MOUSE_ENTERED,
				 new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			        	  menuOption2.setEffect(shadow);
			        	  currentWeatherDisplay.setTop(tv);
			        	  BorderPane.setMargin(tv, new Insets(100, 10, 10, 10));
			        	  currentWeatherDisplay.setLeft(content2);
				    	  BorderPane.setMargin(content2, new Insets(10, 10, 150, 10));
			          }
			          });
		 super.menuOption2.addEventHandler(MouseEvent.MOUSE_EXITED,
			        new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			            menuOption2.setEffect(null);
			            currentWeatherDisplay.setTop(help);
			    		BorderPane.setMargin(help, new Insets(100, 10, 10, 10));
			    		currentWeatherDisplay.setLeft(content);
			    	    BorderPane.setMargin(content, new Insets(10, 10, 250, 10));
			          }
			        });
		log1.setFitHeight(100); 
		log1.setFitWidth(100);

	
		super.menuOption3.setFont(Font.font("Raleway", 20)); 
		super.menuOption3.setText("\n PATIENT RECORD");
		super.menuOption3.setContentDisplay(ContentDisplay.TOP);
		super.menuOption3.setGraphic(record1);
		super.menuOption3.addEventHandler(MouseEvent.MOUSE_ENTERED,
				 new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			        	  menuOption3.setEffect(shadow);
			        	  currentWeatherDisplay.setTop(assistance);
			        	  BorderPane.setMargin(assistance, new Insets(100, 10, 10, 10));
			        	  currentWeatherDisplay.setLeft(content3);
				    	  BorderPane.setMargin(content3, new Insets(10, 10, 100, 10));
			          }
			          });
		 super.menuOption3.addEventHandler(MouseEvent.MOUSE_EXITED,
			        new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			            menuOption3.setEffect(null);
			            currentWeatherDisplay.setTop(help);
			    		BorderPane.setMargin(help, new Insets(100, 10, 10, 10));
			    		currentWeatherDisplay.setLeft(content);
			    	    BorderPane.setMargin(content, new Insets(10, 10, 250, 10));
			          }
			        });
		record1.setFitHeight(100); 
		record1.setFitWidth(100);

		
		
		super.menuOption4.setFont(Font.font("Raleway", 20)); 
		super.menuOption4.setText("\n EMERGENCY");
		super.menuOption4.setContentDisplay(ContentDisplay.TOP);
		super.menuOption4.setGraphic(emergency1);
		super.menuOption4.addEventHandler(MouseEvent.MOUSE_ENTERED,
				 new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			        	  menuOption4.setEffect(shadow);
			        	  currentWeatherDisplay.setTop(room);
			        	  BorderPane.setMargin(room, new Insets(100, 10, 10, 10));
			        	  currentWeatherDisplay.setLeft(content4);
				    	  BorderPane.setMargin(content4, new Insets(10, 10, 100, 10));
			          }
			          });
		super.menuOption4.addEventHandler(MouseEvent.MOUSE_EXITED,
			        new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			            menuOption4.setEffect(null);
			            currentWeatherDisplay.setTop(help);
			    		BorderPane.setMargin(help, new Insets(100, 10, 10, 10));
			    		currentWeatherDisplay.setLeft(content);
			    	    BorderPane.setMargin(content, new Insets(10, 10, 250, 10));
			          }
			        });
		
		// adding event handler to the back button
		EventHandler<ActionEvent> backButtonClose = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent close) {
				stage.close();
			}
		};
		super.backButton.setOnAction(backButtonClose);
		
		emergency1.setFitHeight(100); 
		emergency1.setFitWidth(150);

	}
}