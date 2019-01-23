package main;

import Controls.AirCondPopOver;
import Controls.BedPopOver;
import Controls.DoorsPopOver;
import Controls.LightsPopOver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Matt - bycmj001
 *
 */
public class ControlsMenu extends MenuStructure {

	// instantiating images
	Image lights = new Image(getClass().getResourceAsStream("/light.png"));
	Image doors = new Image(getClass().getResourceAsStream("/door.png"));
	Image aircond = new Image(getClass().getResourceAsStream("/cold.png"));
	Image bed = new Image(getClass().getResourceAsStream("/bed.png"));

	// instantiating imageviews to hold images which will be displayed in
	// buttons
	ImageView lightsview = new ImageView(lights);
	ImageView doorsview = new ImageView(doors);
	ImageView aircondview = new ImageView(aircond);
	ImageView bedview = new ImageView(bed);

	/**
	 * controls menu constructor defines a new stage and shows it to the screen
	 * 
	 * @param maxX
	 *            the size of the window x
	 * @param maxY
	 *            the size of the window y
	 */
	public ControlsMenu(double maxX, double maxY) {
		super(maxX, maxY);
		super.showStage();
		// changing the superclass variable buttons text to reflect controls
		// buttons.
		menuOption1.setText("\n LIGHTS");
		super.menuOption2.setText("\n DOORS AND WINDOWS");
		super.menuOption3.setText("\n AIRCONDITIONER");
		super.menuOption4.setText("\n BED");

		// setting the visibility of the back button to true so user can go back
		super.backButton.setVisible(true);

		// setting the size of the imageviews to fi the butoons
		lightsview.setFitHeight(100);
		lightsview.setFitWidth(75);
		doorsview.setFitHeight(100);
		doorsview.setFitWidth(70);
		aircondview.setFitHeight(90);
		aircondview.setFitWidth(80);
		bedview.setFitHeight(80);
		bedview.setFitWidth(100);

		// setting graphic of buttons to the imageviews
		menuOption1.setGraphic(lightsview);
		super.menuOption2.setGraphic(doorsview);
		super.menuOption3.setGraphic(aircondview);
		super.menuOption4.setGraphic(bedview);

		// adding event handler to the back button
		EventHandler<ActionEvent> backButtonClose = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent close) {
				stage.close();
			}
		};
		super.backButton.setOnAction(backButtonClose);

		// adding events handler to instantiate new lights popover upon click of
		// lights menu button
		EventHandler<ActionEvent> lightsPopOver = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// calls LightsPopOver class
				new LightsPopOver();
			}
		};
		menuOption1.setOnAction(lightsPopOver);

		// adding popover for doors button
		EventHandler<ActionEvent> doorsPopOver = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// calls DoorsPopOver class
				new DoorsPopOver();
			}
		};
		super.menuOption2.setOnAction(doorsPopOver);

		// adding popover for aircond button
		EventHandler<ActionEvent> aircondPopOver = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// calls AircondPopOver class
				new AirCondPopOver();
			}
		};
		super.menuOption3.setOnAction(aircondPopOver);

		// adding popover for bed button
		EventHandler<ActionEvent> bedPopOver = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// calls BedPopOver class
				new BedPopOver();
			}
		};
		super.menuOption4.setOnAction(bedPopOver);
	}
}
