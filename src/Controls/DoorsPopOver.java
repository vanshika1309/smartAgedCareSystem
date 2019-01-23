package Controls;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


/**
 * 
 * @author Matt - bycmj001
 *
 */
public class DoorsPopOver extends LightsPopOver {
	
	//class variables for images and imageviews
	Image doors = new Image(getClass().getResourceAsStream("/door.png"));
	Image doors2 = new Image(getClass().getResourceAsStream("/door.png"));
	ImageView door1 = new ImageView(doors);
	ImageView door2 = new ImageView(doors2);
	
	ImageView doorsOpenstage1 = new ImageView(new Image(getClass().getResourceAsStream("/doorOpen1.png")));
	ImageView doorsOpenstage2 = new ImageView(new Image(getClass().getResourceAsStream("/doorOpen2.png")));
	ImageView doorsOpenMain = new ImageView(new Image(getClass().getResourceAsStream("/mainDoorOpen3.png")));
	ImageView doorsOpenToilet = new ImageView(new Image(getClass().getResourceAsStream("/toiletDoorOpen3.png")));
	
	ImageView door1Open = new ImageView();
	ImageView door2Open = new ImageView();
	boolean toggled=false;
	boolean toiletToggled=false;
	
	/**
	 * doorspopover constructor instantiates new stage and 
	 * adds content relating to doors popover
	 */
public DoorsPopOver(){
	super();
	
	//setting the size of imageviews
	doorsOpenstage1.setFitHeight(100);
	doorsOpenstage1.setFitWidth(70);
	doorsOpenstage2.setFitHeight(100);
	doorsOpenstage2.setFitWidth(70);
	doorsOpenMain.setFitHeight(100);
	doorsOpenMain.setFitWidth(70);
	doorsOpenToilet.setFitHeight(100);
	doorsOpenToilet.setFitWidth(70);
	
	door1.setFitHeight(100);
	door1.setFitWidth(70);
	door2.setFitHeight(100);
	door2.setFitWidth(70);
	
	button1.setPrefWidth(140);
	button2.setPrefWidth(140);

	//setting the text and images of the main buttons
	super.title.setText("DOORS");
	super.button1.setText("\n MAIN");
	super.button1.setGraphic(door1);
	
	super.button2.setText("\n TOILET");
	super.button2.setGraphic(door2);
	super.flowPane.getChildren().remove(button3);
	super.flowPane.getChildren().remove(button4);
	
	//settomh unused buttons not visible
	super.button3.setVisible(false);
	super.button3.setMaxSize(0, 0);
	super.button4.setMaxSize(0, 0);
	
	//adding event handler to the main door 
	EventHandler<ActionEvent> mainDoor = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			
			//timeline to open door animation
			Timeline mainTimeline = new Timeline();
			KeyFrame stage1 = new KeyFrame(Duration.ZERO, p -> button1.setGraphic(doorsOpenstage1));
			KeyFrame stage2 = new KeyFrame(Duration.millis(500), p -> button1.setGraphic(doorsOpenstage2));
			KeyFrame stage3 = new KeyFrame(Duration.millis(1000), p -> button1.setGraphic(doorsOpenMain));
			
			//adding stages to the animation timeline
			mainTimeline.getKeyFrames().addAll(stage1, stage2, stage3);
			mainTimeline.setCycleCount(1);
			
			//plays timeline if the mouse has been toggled
			if(!toggled){
				
				mainTimeline.play();
				button1.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
						+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
			toggled=true;
			}
			
			//sets default position if not clicked
			else{
				button1.setGraphic(door1);
				button1.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
						+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
				toggled=false;
			}
		}
	};
	super.button1.setOnMouseReleased(null);
	super.button1.setOnAction(mainDoor);
	
	
	EventHandler<ActionEvent> toiletDoor = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {

			//timeline to open door animation
			Timeline toiletTimeline = new Timeline();
			KeyFrame stage1 = new KeyFrame(Duration.ZERO, p -> button2.setGraphic(doorsOpenstage1));
			KeyFrame stage2 = new KeyFrame(Duration.millis(500), p -> button2.setGraphic(doorsOpenstage2));
			KeyFrame stage3 = new KeyFrame(Duration.millis(1000), p -> button2.setGraphic(doorsOpenToilet));

			//adding stages to the animation timeline
			toiletTimeline.getKeyFrames().addAll(stage1, stage2, stage3);
			toiletTimeline.setCycleCount(1);
			
			//plays timeline if the mouse has been toggled
			if(!toiletToggled){
				toiletTimeline.play();
				button2.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
						+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
			toiletToggled=true;
			}
			//sets default position if not clicked
			else{
				button2.setGraphic(door2);
				button2.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
						+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251); -fx-text-fill: rgb(38, 153, 251);");
				toiletToggled=false;
			}
		}
	};
	super.button2.setOnMouseReleased(null);
	super.button2.setOnAction(toiletDoor);
}
}
