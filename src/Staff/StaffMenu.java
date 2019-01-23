package Staff;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.util.Duration;
import main.MenuStructure;

public class StaffMenu  extends MenuStructure {
	
	boolean screenLocked = false;

	Image clean = new Image(getClass().getResourceAsStream("/clean.png"));
	Image fault = new Image(getClass().getResourceAsStream("/log.png"));
	Image patient = new Image(getClass().getResourceAsStream("/health.png"));
	Image emergency = new Image(getClass().getResourceAsStream("/emergency.png"));
	
	//Styles which change the layout looks
	String normalButton = "-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
			+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251);";
	String lockedButton = "-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
			+ "30px; -fx-background-radius: 32px; -fx-border-width: 4px; -fx-border-color: 	rgba(169,169,169);";
	
	ImageView cleanImg = new ImageView(clean);
	ImageView faultImg = new ImageView(fault);
	ImageView patientImg = new ImageView(patient);
	ImageView emergencyImg = new ImageView(emergency);
	
	

	@SuppressWarnings("static-access")
	public StaffMenu(double maxX, double maxY) {
		super(maxX, maxY);
		super.showStage();
		
		super.scene.setOnKeyPressed(null);
		EventHandler<ActionEvent> helpPage = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				new HelpPageStaff(maxX, maxY);
			}
		};
		super.information.setOnAction(null);
		super.information.setOnAction(helpPage);

		EventHandler<ActionEvent> timerFinished = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent timerFinished) {
				menuOption1.setStyle(normalButton);
				menuOption2.setStyle(normalButton);
				menuOption3.setStyle(normalButton);
				menuOption4.setStyle(normalButton);
				//detailsBar.setStyle("-fx-background-color: rgb(38, 153, 251)");
				screenLocked = false;
			}
		};
		
		// adding event handler for main menu button 1
		EventHandler<ActionEvent> menu1Load = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent menu1) {
				
				if(!screenLocked) {
					menuOption1.setStyle(lockedButton);
					menuOption2.setStyle(lockedButton);
					menuOption3.setStyle(lockedButton);
					menuOption4.setStyle(lockedButton);
					screenLocked = true;
					
					//This is the timer which disables everything - 3 seconds for testing
					PauseTransition wait = new PauseTransition(Duration.seconds(3));
					wait.setOnFinished(timerFinished);
					wait.play();
				}
				
			}
		};

		
		
		super.menuOption1.setOnAction(menu1Load);
		super.menuOption1.setFont(Font.font("Raleway", 20)); 
		super.menuOption1.setText("\n CLEANING");
		super.menuOption1.setContentDisplay(ContentDisplay.TOP);
		super.menuOption1.setGraphic(cleanImg);
		cleanImg.setFitHeight(100); 
		cleanImg.setFitWidth(100);

		// adding event handler for main menu button 2
		EventHandler<ActionEvent> menu2Load = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent menu2) {
				if(!screenLocked)
					new FaultReport(900, 600);
			}
		};

		super.menuOption2.setOnAction(menu2Load);
		super.menuOption2.setFont(Font.font("Raleway", 20)); 
		super.menuOption2.setText("\n FAULT REPORT");
		super.menuOption2.setContentDisplay(ContentDisplay.TOP);
		super.menuOption2.setGraphic(faultImg);
		faultImg.setFitHeight(100); 
		faultImg.setFitWidth(100);

		// adding event handler for main menu button 3
		// MATT! Vanshikas stuff links through this button
		EventHandler<ActionEvent> menu3Load = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent menu3) {
				if(!screenLocked)
					new PatientRecord();
			}
		};
		super.menuOption3.setOnAction(menu3Load);
		super.menuOption3.setFont(Font.font("Raleway", 20)); 
		super.menuOption3.setText("\n PATIENT RECORD");
		super.menuOption3.setContentDisplay(ContentDisplay.TOP);
		super.menuOption3.setGraphic(patientImg);
		patientImg.setFitHeight(150); 
		patientImg.setFitWidth(150);

		// adding event handler for main menu button 4
		EventHandler<ActionEvent> menu4Load = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent menu4) {

				if(!screenLocked) {
					new Emergency();
				}
			}
		};

		super.menuOption4.setOnAction(menu4Load);
		super.menuOption4.setFont(Font.font("Raleway", 20)); 
		super.menuOption4.setText("\n EMERGENCY");
		super.menuOption4.setContentDisplay(ContentDisplay.TOP);
		super.menuOption4.setGraphic(emergencyImg);
		emergencyImg.setFitHeight(100); 
		emergencyImg.setFitWidth(150);
		
		

		EventHandler<ActionEvent> backButtonClose = new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent close){
				if(!screenLocked)
					stage.close();
			}
		};
		
		super.backButton.setVisible(true);
		super.backButton.setOnAction(backButtonClose);
	}
}
