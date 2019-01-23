package main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Matt - bycmj001
 * @author Kristen Mounas - moukn001
 *
 */
public class MainMenu extends MenuStructure {
	//class variables to allow images within buttons to be changed in other classes.
	Image meals = new Image(getClass().getResourceAsStream("/meals.jpg"));
	Image tv = new Image(getClass().getResourceAsStream("/tv.jpg"));
	Image assistance = new Image(getClass().getResourceAsStream("/assistance.jpg"));
	Image room = new Image(getClass().getResourceAsStream("/room.jpg"));
	
	//Image views hold the images to be displayed in buttons.
	ImageView mealsView = new ImageView(meals);
	ImageView tvView = new ImageView(tv);
	ImageView assistanceView = new ImageView(assistance);
	ImageView roomView = new ImageView(room);

	Image exit = new Image(getClass().getResourceAsStream("/exit.png"));
	ImageView exitView = new ImageView(exit);
	
	/**
	 * Constructor for Main Menu, instantiates a new stage with the structure from menuStructure
	 * changes text on labels for buttons to be used on different menus.
	 * @param maxX max screen size for stage, uses 600
	 * @param maxY max screen size for stage, uses 900
	 */
	public MainMenu(double maxX, double maxY) {
		super(maxX, maxY);
		//shows the stage in the super class
		super.showStage();
		
		exitView.setFitWidth(30);
		exitView.setFitHeight(30);
		super.backButton.setGraphic(exitView);
		
		// Event handler to close down entire application
		backButton.setOnAction(event -> System.exit(0));
		
		// adding event handler to launch new stage for meals menu upon button clicking.
		EventHandler<ActionEvent> menu1Load = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent menu1) {
				// here to add class of new mealsmenu
				new MealsMenu(maxX, maxY);
			}
		};
		menuOption1.setOnAction(menu1Load);
		
		//changing text, grapic and size of menu 1 button
		menuOption1.setText("\n MEALS");
		menuOption1.setGraphic(mealsView);
		mealsView.setFitHeight(120); 
		mealsView.setFitWidth(120);

		// adding event handler to launch new stage for tv menu upon button clicking.
		EventHandler<ActionEvent> menu2Load = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent menu2) {
				new TVMenu(maxX, maxY);// here to add class of new menu
			}
		};
		super.menuOption2.setOnAction(menu2Load);
		
		//changing text, grapic and size of menu 2 button
		super.menuOption2.setText("\n TV");
		super.menuOption2.setGraphic(tvView);
		tvView.setFitHeight(120); 
		tvView.setFitWidth(120);

		// adding event handler to launch new stage for assistance button menu upon button clicking.
		//assistance menu action
		EventHandler<ActionEvent> assistance = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				new AssistanceMenu(maxX, maxY);
				//new Assistance();
			}
		};	
		super.menuOption3.setOnAction(assistance);
		
		//changing text, grapic and size of menu 3 button
		super.menuOption3.setText("\n ASSISTANCE");
		super.menuOption3.setGraphic(assistanceView);
		assistanceView.setFitHeight(120); 
		assistanceView.setFitWidth(120);

		// adding event handler to launch new stage for Controls menu upon button clicking.
		EventHandler<ActionEvent> menu4Load = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent menu4) {
				// new instance of menu structure, Controls menu.
				new ControlsMenu(maxX, maxY);
			}
		};
		super.menuOption4.setOnAction(menu4Load);

		//changing text, grapic and size of menu 4 button
		super.menuOption4.setText("\n ROOM CONTROLS");
		super.menuOption4.setGraphic(roomView);
		roomView.setFitHeight(120); 
		roomView.setFitWidth(120);
		

	}
}