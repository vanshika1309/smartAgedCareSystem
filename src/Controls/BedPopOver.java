package Controls;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Matt - bycmj001
 *
 */
public class BedPopOver extends AirCondPopOver{
	
	//two images used to add to graphic of buttons
	ImageView increaseRecline = new ImageView(new Image(getClass().getResourceAsStream("/plus.png")));
	ImageView decreaseRecline = new ImageView(new Image(getClass().getResourceAsStream("/minus.png")));
	
	/**
	 * bedpopover constructor, instantiates stage and extends aircond, 
	 * adds the images relating to bed and changes text
	 */
public BedPopOver(){
	super();
	
	//setting title of popover 
	super.title.setText("BED");
	
	//setting width and height, text of each button in bed popover
	super.button1.setText(" INCREASE RECLINE");
	super.button2.setText(" INCREASE LUMBAR");
	super.button3.setText(" DECREASE RECLINE");
	super.button4.setText(" DECREASE LUMBAR");
	super.button1.setPrefWidth(230);
	super.button2.setPrefWidth(230);
	super.button3.setPrefWidth(230);
	super.button4.setPrefWidth(230);
	
	//setting height and width of images
	increaseRecline.setFitHeight(50);
	increaseRecline.setFitWidth(50);
	decreaseRecline.setFitHeight(4);
	decreaseRecline.setFitWidth(50);
	
	//setting two imageviews to the buttons
	super.button1.setGraphic(increaseRecline);
	super.button3.setGraphic(decreaseRecline);
}
}
