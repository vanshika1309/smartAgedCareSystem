package Controls;

import javafx.event.EventHandler;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.PopOver;

/**
 * 
 * @author Matt - bycmj001
 *
 */
public class LightsPopOver extends PopOver{
	
	//class variables for imageviews
	Image lights = new Image(getClass().getResourceAsStream("/light.png"));
	ImageView lightsviewMain = new ImageView(lights);
	ImageView lightsviewToilet = new ImageView(lights);
	ImageView lightsviewBed = new ImageView(lights);
	
	//boolean terms to allow the button to be clicked and actions to be different
	boolean toggled=false;
	boolean toiletToggled=false;
	boolean bedToggled=false;
	
	/**
	 * constructor for lights popoover that adds images and tetx to buttons
	 */
	public LightsPopOver(){
		super();
		
		//setting imageview sizes
		lightsviewMain.setFitHeight(100);
		lightsviewMain.setFitWidth(80);
		lightsviewToilet.setFitHeight(100);
		lightsviewToilet.setFitWidth(80);
		lightsviewBed.setFitHeight(100);
		lightsviewBed.setFitWidth(80);
		
		//setting width of the buttons
		button1.setPrefWidth(140);
		button2.setPrefWidth(140);
		button3.setPrefWidth(140);
		
		//setting text and button graphics for each button
		super.title.setText("LIGHTS");
		super.button1.setGraphic(lightsviewMain);
		super.button1.setContentDisplay(ContentDisplay.TOP);
		super.button1.setText("\n MAIN LIGHTS");
		
		super.button2.setGraphic(lightsviewToilet);
		super.button2.setContentDisplay(ContentDisplay.TOP);
		super.button2.setText("\n TOILET LIGHTS");
		
		super.button3.setGraphic(lightsviewBed);
		super.button3.setContentDisplay(ContentDisplay.TOP);
		super.button3.setText("\n BED LIGHTS");
		
		//removing the fourth button
		super.button4.setVisible(false);
		super.flowPane.getChildren().remove(button4);
		
		//new event handler o change colour of light when the button is clicked
		//shows the state of the light
		EventHandler<? super MouseEvent> mainLight = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if(!toggled){
					button1.setStyle("-fx-background-color: rgb(255, 255, 0); -fx-border-radius: "
							+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
				toggled=true;
				}
				
				else{
					button1.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
							+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
					toggled=false;
				}
			}
		};
		super.button1.setOnMouseReleased(mainLight);
		//super.button1.setOnAction(mainLight);
		
		//new event handler o change colour of light when the button is clicked
		//shows the state of the light
		EventHandler<? super MouseEvent> bedLight = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if(!bedToggled){
					button2.setStyle("-fx-background-color: rgb(255, 255, 0); -fx-border-radius: "
							+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
				bedToggled=true;
				}
				
				else{
					button2.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
							+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
					bedToggled=false;
				}
			}
		};
		super.button2.setOnMouseReleased(bedLight);
		//super.button2.setOnAction(bedLight);
		
		//new event handler o change colour of light when the button is clicked
		//shows the state of the light
		EventHandler<?super MouseEvent> toiletLight = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if(!toiletToggled){
					button3.setStyle("-fx-background-color: rgb(255, 255, 0); -fx-border-radius: "
							+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
				toiletToggled=true;
				}
				
				else{
					button3.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
							+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
					toiletToggled=false;
				};
			}
		};
		super.button3.setOnMouseReleased(toiletLight);
	}
}
