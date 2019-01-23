package main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Matt - bycmj001
 *
 */
public class SettingsPopOver extends PopOver{

	/**
	 * constructor instantiates new stage for popover and adds details such as title and graphics
	 */
	public SettingsPopOver(){
		super();
		super.title.setText("SETTINGS");

		//adding images to the  imageviews
		ImageView increaseBrightness = new ImageView(new Image(getClass().getResourceAsStream("/sun.png")));
		ImageView decreaseBrightness = new ImageView(new Image(getClass().getResourceAsStream("/minus.png")));
		ImageView increaseVolume = new ImageView(new Image(getClass().getResourceAsStream("/plus.png")));
		ImageView decreaseVolume = new ImageView(new Image(getClass().getResourceAsStream("/minus.png")));

		//adding text to buttons
		super.button1.setText(" BRIGHTNESS +");
		super.button2.setText(" SOUND +");
		super.button3.setText(" BRIGHTNESS -");
		super.button4.setText(" SOUND -");

		//adding graphics to the buttons
		super.button1.setGraphic(increaseBrightness);
		super.button2.setGraphic(decreaseBrightness);
		super.button3.setGraphic(increaseVolume);
		super.button4.setGraphic(decreaseVolume);
		
		//setting size of the buttons
		button1.setPrefWidth(230);
		button1.setPrefHeight(70);
		button2.setPrefWidth(230);
		button2.setPrefHeight(70);
		button3.setPrefWidth(230);
		button3.setPrefHeight(70);
		button4.setPrefWidth(230);
		button4.setPrefHeight(70);

		//changing the size of the graphics on the buttons
		increaseBrightness.setFitWidth(50);
		increaseBrightness.setFitHeight(50);
		decreaseBrightness.setFitWidth(50);
		decreaseBrightness.setFitHeight(4);
		increaseVolume.setFitWidth(50);
		increaseVolume.setFitHeight(50);
		decreaseVolume.setFitWidth(50);
		decreaseVolume.setFitHeight(4);
	}
}