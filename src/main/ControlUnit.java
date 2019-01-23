package main;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * @author Matt - bycmj001,
 *
 */
public class ControlUnit extends Application {
	MainMenu display;
	Stage window;
	double maxX = 900;
	double maxY = 600;
	
	/**
	 * start method to initialize the application
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		// displays the Main menu with size defined in class variable
		display = new MainMenu(maxX, maxY);
	}

	public static void main(String[] args) {
		launch(args);
	}
}