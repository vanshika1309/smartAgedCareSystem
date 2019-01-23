package main;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContentDisplay;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * 
 * @author Cristina - Pilca002
 *
 */

public class TVMenu extends MenuStructure {

	//Imports required images.
	Image volumeDown = new Image(getClass().getResourceAsStream("/volDown.png"));
	Image volumeUp = new Image(getClass().getResourceAsStream("/volUp.png"));
	Image channelDown = new Image(getClass().getResourceAsStream("/channel-.png"));
	Image channelUp = new Image(getClass().getResourceAsStream("/channel+.png"));
	Image channel9 = new Image(getClass().getResourceAsStream("/tvGuideDisplayV3.png"));
	Image channel10 = new Image(getClass().getResourceAsStream("/tvGuideDisplayCH10.png"));
	Image channel7 = new Image(getClass().getResourceAsStream("/tvGuideDisplayCH7.png"));
	Image channelABC = new Image(getClass().getResourceAsStream("/tvGuideDisplayABC.png"));
	Image channelSBS = new Image(getClass().getResourceAsStream("/tvGuideDisplaySBS.png"));

	//Creates a viewable version of the imported images.
	ImageView volDown = new ImageView(volumeDown);
	ImageView volUp = new ImageView(volumeUp);
	ImageView chDown = new ImageView(channelDown);
	ImageView chUp = new ImageView(channelUp);
	ImageView ch9 = new ImageView(channel9);
	ImageView ch10 = new ImageView(channel10);
	ImageView ch7 = new ImageView(channel7);
	ImageView chABC = new ImageView(channelABC);
	ImageView chSBS = new ImageView(channelSBS);

	//Creates variables that will later be used to cycle through TV channels.
	ImageView image;
	int channel = 1;

	//Constructor that creates, and sets up the functions of the TVMenu class.
	public TVMenu(double maxX, double maxY) {	
		super(maxX, maxY);
		//Shows stage in super class.
		super.showStage();

		//Sets position of TV guide in place of weather details.
		currentWeatherDisplay.setTop(ch9);
		currentWeatherDisplay.setCenter(null);
		currentWeatherDisplay.setBottom(null);

		//Adds and defines elements of the upper left button.
		menuOption1.setFont(Font.font("Raleway", 20));
		menuOption1.setText("\n VOLUME DOWN");
		menuOption1.setContentDisplay(ContentDisplay.TOP);
		menuOption1.setGraphic(volDown);
		volDown.setFitHeight(80);
		volDown.setFitWidth(80);

		//Creates dropshadow effect and sets its colour.
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.MIDNIGHTBLUE);

		//Event handler that adds dropshadow to menuOption1 when it is pressed.
		menuOption1.addEventHandler(MouseEvent.MOUSE_PRESSED, 
				new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				menuOption1.setEffect(shadow);
			}
		});

		//Event handler that removes dropshadow from menuOption1 when it is released.
		menuOption1.addEventHandler(MouseEvent.MOUSE_RELEASED, 
				new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				menuOption1.setEffect(null);
			}
		});

		//Adds and defines elements of the upper right button.
		super.menuOption2.setFont(Font.font("Raleway", 20));
		super.menuOption2.setText("\n VOLUME UP");
		super.menuOption2.setContentDisplay(ContentDisplay.TOP);
		super.menuOption2.setGraphic(volUp);
		volUp.setFitHeight(80);
		volUp.setFitWidth(80);

		//Event handler that adds dropshadow to menuOption2 when it is pressed.
		menuOption2.addEventHandler(MouseEvent.MOUSE_PRESSED, 
				new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				menuOption2.setEffect(shadow);
			}
		});

		//Event handler that removes dropshadow from menuOption2 when it is released.
		menuOption2.addEventHandler(MouseEvent.MOUSE_RELEASED, 
				new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				menuOption2.setEffect(null);
			}
		});

		//Adds and defines elements of the lower left button.
		super.menuOption3.setFont(Font.font("Raleway", 20));
		super.menuOption3.setText("\n CHANNEL DOWN");
		super.menuOption3.setContentDisplay(ContentDisplay.TOP);
		super.menuOption3.setGraphic(chDown);
		chDown.setFitHeight(80);
		chDown.setFitWidth(80);

		//Event handler that adds dropshadow to menuOption3 when it is pressed.
		menuOption3.addEventHandler(MouseEvent.MOUSE_PRESSED, 
				new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				menuOption3.setEffect(shadow);

				//Changes allocated channel number down each time button is pressed.
				channel -= 1;

				//Resets nonexistent 0 to 5, which is Channel 10, and sets the image accordingly.
				//Will only run if channel variable is 0. 
				if (channel == 0) {
					image = ch10;
					channel = 5;
				}

				//Sets image to ABC if channel variable is 1.
				else if (channel == 1) {
					image = chABC;
				}

				//Sets image to SBS if channel variable is 2.
				else if (channel == 2) {
					image = chSBS;
				}

				//Sets image to Channel 7 if channel variable is 3.
				else if (channel == 3) {
					image = ch7;
				}

				//Sets image to Channel 9 if channel variable is 4.
				else if (channel == 4) {
					image = ch9;
				}

				//Sets the weatherDisplay to show the image determined by the prior code.
				currentWeatherDisplay.setTop(image);

				//Transition that will fade in the next image when the button is pressed.
				FadeTransition ft = new FadeTransition(Duration.millis(400), image);
				ft.setFromValue(0.6);
				ft.setToValue(1.0);
				ft.setCycleCount(1);
				ft.setAutoReverse(true);

				//Plays fade transition.
				ft.play();
			}
		});

		//Event handler that removes dropshadow from menuOption2 when it is released.
		menuOption3.addEventHandler(MouseEvent.MOUSE_RELEASED, 
				new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				menuOption3.setEffect(null);
			}
		});

		//Adds and defines elements of the lower right button.
		super.menuOption4.setFont(Font.font("Raleway", 20));
		super.menuOption4.setText("\n CHANNEL UP");
		super.menuOption4.setContentDisplay(ContentDisplay.TOP);
		super.menuOption4.setGraphic(chUp);
		chUp.setFitHeight(80);
		chUp.setFitWidth(80);

		//Event handler that adds dropshadow to menuOption4 when it is pressed.
		menuOption4.addEventHandler(MouseEvent.MOUSE_PRESSED, 
				new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				menuOption4.setEffect(shadow);
				//Changes allocated channel number up each time button is pressed.
				channel += 1;

				//Sets image to SBS if channel variable is 2.
				if (channel == 2) {
					image = chSBS;
				}

				//Sets image to Channel 7 if channel variable is 3.
				else if (channel == 3) {
					image = ch7;
				}

				//Sets image to Channel 9 if channel variable is 4.
				else if (channel == 4) {
					image = ch9;
				}

				//Sets image to Channel 10 if channel variable is 5.
				else if (channel == 5) {
					image = ch10;

				}

				//Resets nonexistent 6 to 1, which is ABC, and sets image accordingly.
				//Will only run if channel variable is 6.
				else if (channel == 6) {
					image = chABC;
					channel = 1;
				}

				//Sets the weatherDisplay to show the image determined by the prior code.
				currentWeatherDisplay.setTop(image);

				//Transition that will fade in the next image when the button is pressed.
				FadeTransition ft = new FadeTransition(Duration.millis(400), image);
				ft.setFromValue(0.6);
				ft.setToValue(1.0);
				ft.setCycleCount(1);
				ft.setAutoReverse(true);

				//Plays fade transition.
				ft.play();
			}
		});

		//Event handler that removes dropshadow from menuOption4 when it is released.
		menuOption4.addEventHandler(MouseEvent.MOUSE_RELEASED, 
				new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				menuOption4.setEffect(null);
			}
		});

		//Sets the back button to be visible.
		super.backButton.setVisible(true);

		//Event handler that closes the current stage when it is pressed.
		EventHandler<ActionEvent> backButtonClose = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent close) {
				stage.close();
				// close menu here

			}
		};

		//Activates prior event handler when back button is pressed.
		super.backButton.setOnAction(backButtonClose);
	}
}