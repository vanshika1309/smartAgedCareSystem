package main;

import javafx.animation.Animation;
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

public class AssistanceMenu extends MenuStructure {

	//Imports required images.
	Image medicalQ = new Image(getClass().getResourceAsStream("/medicalHelp.png"));
	Image foodQ = new Image(getClass().getResourceAsStream("/mealQuestion.png"));
	Image staffQ = new Image(getClass().getResourceAsStream("/staffQuestion.png"));
	Image otherQ = new Image(getClass().getResourceAsStream("/otherQuestion.png"));
	Image placeholderDesc = new Image(getClass().getResourceAsStream("/assistanceDefault.png"));
	Image medicalResponse = new Image(getClass().getResourceAsStream("/medicalAssistance.png"));
	Image defaultResponse = new Image(getClass().getResourceAsStream("/otherQuestions.png"));

	//Creates a viewable version of the imported images.
	ImageView medical = new ImageView(medicalQ);
	ImageView food = new ImageView(foodQ);
	ImageView staff = new ImageView(staffQ);
	ImageView other = new ImageView(otherQ);
	ImageView placeholder = new ImageView(placeholderDesc);
	ImageView medicalMsg = new ImageView(medicalResponse);
	ImageView defaultMsg = new ImageView(defaultResponse);
	
	FadeTransition ft1;
	FadeTransition ft2;
	FadeTransition ft3;
	FadeTransition ft4;

	//Constructor that creates, and sets up the functions of the AssistanceMenu class.
	@SuppressWarnings("static-access")
	public AssistanceMenu(double maxX, double maxY) {
		super(maxX, maxY);
		//Shows stage in super class.
		super.showStage();

		//Sets position of placeholder message in place of weather details.
		currentWeatherDisplay.setTop(placeholder);
		currentWeatherDisplay.setCenter(null);
		currentWeatherDisplay.setBottom(null);

		//Adds and defines elements of the upper left button.
		super.menuOption1.setFont(Font.font("Raleway", 20));
		super.menuOption1.setText("\n MEDICAL ASSISTANCE");
		super.menuOption1.setContentDisplay(ContentDisplay.TOP);
		super.menuOption1.setGraphic(medical);
		medical.setFitHeight(80);
		medical.setFitWidth(80);

		//Creates dropshadow effect and sets its colour.
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.MIDNIGHTBLUE);

		//Event handler that adds dropshadow to menuOption1, and changes the message on the side, when it is pressed.
		menuOption1.addEventHandler(MouseEvent.MOUSE_PRESSED, 
				new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				menuOption1.setEffect(shadow);
				currentWeatherDisplay.setTop(medicalMsg);
				
				//Removes effects from other menuOption2, if present.
				if (menuOption2.getEffect() == shadow) {
					menuOption2.setEffect(null);
					ft2.stop();
				}

				//Removes effects from other menuOption3, if present.
				else if (menuOption3.getEffect() == shadow) {
					menuOption3.setEffect(null);
					ft3.stop();
				}

				//Removes effects from other menuOption3, if present.
				else if (menuOption4.getEffect() == shadow) {
					menuOption4.setEffect(null);
					ft4.stop();
				}
				
				//Transition that will make the button that was pressed flash.
				ft1 = new FadeTransition(Duration.millis(400), menuOption1);
				ft1.setFromValue(0.6);
				ft1.setToValue(1.0);
				ft1.setCycleCount(Animation.INDEFINITE);
				ft1.setAutoReverse(true);

				//Plays fade transition.
				ft1.play();
			}
		});

		//Adds and defines elements of the upper right button.
		super.menuOption2.setFont(Font.font("Raleway", 20));
		super.menuOption2.setText("\n MEAL ASSISTANCE");
		super.menuOption2.setContentDisplay(ContentDisplay.TOP);
		super.menuOption2.setGraphic(food);
		food.setFitHeight(80);
		food.setFitWidth(80);

		//Event handler that adds dropshadow to menuOption2, and changes the message on the side, when it is pressed.
		menuOption2.addEventHandler(MouseEvent.MOUSE_PRESSED, 
				new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				menuOption2.setEffect(shadow);
				currentWeatherDisplay.setTop(defaultMsg);
				
				//Removes effects from other menuOption1, if present.
				if (menuOption1.getEffect() == shadow) {
					menuOption1.setEffect(null);
					ft1.stop();
				}

				//Removes effects from other menuOption3, if present.
				else if (menuOption3.getEffect() == shadow) {
					menuOption3.setEffect(null);
					ft3.stop();
				}

				//Removes effects from other menuOption4, if present.
				else if (menuOption4.getEffect() == shadow) {
					menuOption4.setEffect(null);
					ft4.stop();
				}
				
				//Transition that will make the button that was pressed flash.
				ft2 = new FadeTransition(Duration.millis(400), menuOption2);
				ft2.setFromValue(0.6);
				ft2.setToValue(1.0);
				ft2.setCycleCount(Animation.INDEFINITE);
				ft2.setAutoReverse(true);

				//Plays fade transition.
				ft2.play();
			}
		});

		//Adds and defines elements of the lower left button.
		super.menuOption3.setFont(Font.font("Raleway", 20));
		super.menuOption3.setText("\n STAFF ASSISTANCE");
		super.menuOption3.setContentDisplay(ContentDisplay.TOP);
		super.menuOption3.setGraphic(staff);
		staff.setFitHeight(80);
		staff.setFitWidth(80);

		//Event handler that adds dropshadow to menuOption3, and changes the message on the side, when it is pressed.
		menuOption3.addEventHandler(MouseEvent.MOUSE_PRESSED, 
				new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				menuOption3.setEffect(shadow);
				currentWeatherDisplay.setTop(defaultMsg);
				
				//Removes effects from other menuOption1, if present.
				if (menuOption1.getEffect() == shadow) {
					menuOption1.setEffect(null);
					ft1.stop();
				}

				//Removes effects from other menuOption2, if present.
				else if (menuOption2.getEffect() == shadow) {
					menuOption2.setEffect(null);
					ft2.stop();
				}

				//Removes effects from other menuOption4, if present.
				else if (menuOption4.getEffect() == shadow) {
					menuOption4.setEffect(null);
					ft4.stop();
				}
				
				//Transition that will make the button that was pressed flash.
				ft3 = new FadeTransition(Duration.millis(400), menuOption3);
				ft3.setFromValue(0.6);
				ft3.setToValue(1.0);
				ft3.setCycleCount(Animation.INDEFINITE);
				ft3.setAutoReverse(true);

				//Plays fade transition.
				ft3.play();
			}
		});

		//Adds and defines elements of the lower right button.
		super.menuOption4.setFont(Font.font("Raleway", 20));
		super.menuOption4.setText("\n OTHER ASSISTANCE");
		super.menuOption4.setContentDisplay(ContentDisplay.TOP);
		super.menuOption4.setGraphic(other);
		other.setFitHeight(80);
		other.setFitWidth(80);

		//Event handler that adds dropshadow to menuOption4, and changes the message on the side, when it is pressed.
		menuOption4.addEventHandler(MouseEvent.MOUSE_PRESSED, 
				new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				menuOption4.setEffect(shadow);
				currentWeatherDisplay.setTop(defaultMsg);

				//Removes effects from other menuOption1, if present.
				if (menuOption1.getEffect() == shadow) {
					menuOption1.setEffect(null);
					ft1.stop();
				}

				//Removes effects from other menuOption2, if present.
				else if (menuOption2.getEffect() == shadow) {
					menuOption2.setEffect(null);
					ft2.stop();
				}

				//Removes effects from other menuOption3, if present.
				else if (menuOption3.getEffect() == shadow) {
					menuOption3.setEffect(null);
					ft3.stop();
				}
				
				//Transition that will make the button that was pressed flash.
				ft4 = new FadeTransition(Duration.millis(400), menuOption4);
				ft4.setFromValue(0.6);
				ft4.setToValue(1.0);
				ft4.setCycleCount(Animation.INDEFINITE);
				ft4.setAutoReverse(true);

				//Plays fade transition.
				ft4.play();
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

