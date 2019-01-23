package Staff;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.PopOver;

public class PatientRecord extends PopOver {

	Image allergy = new Image(getClass().getResourceAsStream("/patient.png"));
	ImageView acon = new ImageView(allergy);

	public PatientRecord() {
		super();
		
		super.layout.getChildren().remove(flowPane);
		super.layout.getChildren().remove(bpane);
		super.title.setVisible(false);
		super.okDone.setVisible(true);

		acon.setFitHeight(200);
		acon.setFitWidth(400);
		acon.setTranslateY(-20);
		super.layout.getChildren().addAll(bpane, acon);
	}

}