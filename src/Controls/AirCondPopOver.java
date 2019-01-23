package Controls;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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
public class AirCondPopOver extends PopOver{
	
	//class variables for imageviews
	ImageView increaseTemp = new ImageView(new Image(getClass().getResourceAsStream("/sun.png")));
	ImageView decreaseTemp = new ImageView(new Image(getClass().getResourceAsStream("/cold.png")));
	ImageView increaseFan = new ImageView(new Image(getClass().getResourceAsStream("/plus.png")));
	ImageView decreaseFan = new ImageView(new Image(getClass().getResourceAsStream("/minus.png")));
	
	/**
	 * constructor sets class specific display relating to options
	 */
	public AirCondPopOver(){
		super();
		
		//setting popup text 
		super.title.setText("AIRCONDITIONER");
		super.button4.setVisible(true);
		
		//setting button text
		super.button1.setText(" INCREASE TEMP");
		super.button2.setText(" INCREASE FANSPEED");
		super.button3.setText(" DECREASE TEMP");
		super.button4.setText(" DECREASE FANSPEED");
		
		//setting imageview sizes
		increaseTemp.setFitHeight(50);
		increaseTemp.setFitWidth(50);
		decreaseTemp.setFitHeight(50);
		decreaseTemp.setFitWidth(50);
		increaseFan.setFitHeight(50);
		increaseFan.setFitWidth(50);
		decreaseFan.setFitHeight(4);
		decreaseFan.setFitWidth(50);
		
		//setting content position of buttons
		super.button1.setContentDisplay(ContentDisplay.LEFT);
		super.button2.setContentDisplay(ContentDisplay.LEFT);
		super.button3.setContentDisplay(ContentDisplay.LEFT);
		super.button4.setContentDisplay(ContentDisplay.LEFT);
		
		//setting graphics of buttons
		super.button1.setGraphic(increaseTemp);
		super.button2.setGraphic(increaseFan);
		super.button3.setGraphic(decreaseTemp);
		super.button4.setGraphic(decreaseFan);
		
		button1.setPrefWidth(230);
		button1.setPrefHeight(70);
		button2.setPrefWidth(230);
		button2.setPrefHeight(70);
		button3.setPrefWidth(230);
		button3.setPrefHeight(70);
		button4.setPrefWidth(230);
		button4.setPrefHeight(70);
		
		//adding event handler to chang ecolour on mouse event
		EventHandler<MouseEvent> changeColor = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				//if the cause of the event was a button, set the style to ablue colour
				if(event.getTarget().getClass()==button1.getClass()){
				((Button)event.getTarget()).setStyle("-fx-background-color: BLUE; -fx-border-radius: "
						+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
				}
			}
		};
		
		//adding event handler to chang ecolour on mouse event
		EventHandler<MouseEvent> defaultColor = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				//if the cause was a button, change back to default colour
				if(event.getTarget().getClass()==button1.getClass()){
				((Button)event.getTarget()).setStyle("-fx-background-color: null; -fx-border-radius: "
						+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
				}	
			}
		};
		
		//setting the events to each button
		super.button1.setOnMousePressed(changeColor);
		super.button1.setOnMouseReleased(defaultColor);
		super.button2.setOnMousePressed(changeColor);
		super.button2.setOnMouseReleased(defaultColor);
		super.button3.setOnMousePressed(changeColor);
		super.button3.setOnMouseReleased(defaultColor);
		super.button4.setOnMousePressed(changeColor);
		super.button4.setOnMouseReleased(defaultColor);
	}
}
