package main;

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

public class HelpPage extends MenuStructure {

	Image meals = new Image(getClass().getResourceAsStream("/meals.jpg"));
	Image tv = new Image(getClass().getResourceAsStream("/tv.jpg"));
	Image assistance = new Image(getClass().getResourceAsStream("/assistance.jpg"));
	Image room = new Image(getClass().getResourceAsStream("/room.jpg"));

	ImageView meals1 = new ImageView(meals);
	ImageView tv1 = new ImageView(tv);
	ImageView assistance1 = new ImageView(assistance);
	ImageView room1 = new ImageView(room);

	@SuppressWarnings("static-access")
	public HelpPage(double maxX, double maxY) {
		super(maxX, maxY);
		super.showStage();

		// setting the visibility of the back button to true so user can go back
		super.backButton.setVisible(true);
		
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
		
		Label food = new Label("MEALS");
		food.setAlignment(Pos.CENTER);
		food.setPrefHeight(140);
		food.setPrefWidth(200);
		food.setFont(Font.font("Raleway", FontWeight.BOLD, 35));
		
		
		Label content1 = new Label("You can select your meal" + "\n" + "options for Breakfast, Lunch"
				+ "\n" +  "and Dinner. You can save" + "\n" + "your dishes in favourites.");
		content1.setAlignment(Pos.CENTER);
		content1.setPrefHeight(140);
		content1.setPrefWidth(200);
		content1.setFont(Font.font("Raleway", 16)); 
		
		Label tv = new Label("TV");
		tv.setAlignment(Pos.CENTER);
		tv.setPrefHeight(140);
		tv.setPrefWidth(200);
		tv.setFont(Font.font("Raleway", FontWeight.BOLD, 35));
		
		Label content2 = new Label("You can operate the TV"  + "\n" + 
				"through this panel. You" + "\n" + "can use the inbuild options" + "\n" + 
				"to change the channels" + "\n" + "and the volume.");
		content2.setAlignment(Pos.CENTER);
		content2.setPrefHeight(140);
		content2.setPrefWidth(200);
		content2.setFont(Font.font("Raleway", 16));
		
		Label assistance = new Label("ASSISTANCE");
		assistance.setAlignment(Pos.CENTER);
		assistance.setPrefHeight(140);
		assistance.setPrefWidth(200);
		assistance.setFont(Font.font("Raleway", FontWeight.BOLD, 32));
		
		Label content3 = new Label(" This button will allow you "  + "\n" + 
		" to call a support worker " + "\n" + " whenever you require"  + "\n" + "assistance.");
		content3.setAlignment(Pos.CENTER);
		content3.setPrefHeight(140);
		content3.setPrefWidth(200);
		content3.setFont(Font.font("Raleway", 16));
		
		
		Label room = new Label("    ROOM" + "\n" + "CONTROLS");
		room.setAlignment(Pos.CENTER);
		room.setPrefHeight(140);
		room.setPrefWidth(200);
		room.setFont(Font.font("Raleway", FontWeight.BOLD, 35));
		
		Label content4 = new Label("On this panel you will be  " + "\n" + "able to change the bed's "
				+ "\n" + "position, turn lights on/off," + "\n" + "operate the windows, and" + "\n" + "airconditioner settings.");
		
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
		super.menuOption1.setText("\n MEALS");
		super.menuOption1.setContentDisplay(ContentDisplay.TOP);
		super.menuOption1.setGraphic(meals1);

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
	
		meals1.setFitHeight(100); 
		meals1.setFitWidth(100);


		super.menuOption2.setFont(Font.font("Raleway", 20)); 
		super.menuOption2.setText("\n TV");
		super.menuOption2.setContentDisplay(ContentDisplay.TOP);
		super.menuOption2.setGraphic(tv1);
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
		tv1.setFitHeight(100); 
		tv1.setFitWidth(100);

	
		super.menuOption3.setFont(Font.font("Raleway", 20)); 
		super.menuOption3.setText("\n ASSISTANCE");
		super.menuOption3.setContentDisplay(ContentDisplay.TOP);
		super.menuOption3.setGraphic(assistance1);
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
		assistance1.setFitHeight(100); 
		assistance1.setFitWidth(100);

		
		
		super.menuOption4.setFont(Font.font("Raleway", 20)); 
		super.menuOption4.setText("\n ROOM CONTROLS");
		super.menuOption4.setContentDisplay(ContentDisplay.TOP);
		super.menuOption4.setGraphic(room1);
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
		
		room1.setFitHeight(100); 
		room1.setFitWidth(100);

	}
}