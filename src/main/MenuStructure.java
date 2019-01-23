package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Staff.StaffMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author Matt - bycmj001, 
 * @author Kristen Mounas - moukn001
 *
 */
public class MenuStructure {
	DropShadow shadow = new DropShadow();

	//class variables allow changing of configuration from super class
	// position in which stage will be launched into
	public double stageX = 0; 
	// allow for re-decorating
	public double stageY = 24; 

	// clients name to allow for easy editing from administrator settings
	public String clientName = "Jane Doe";
	// hard coded current weather, implementing weather api too complex and out of scope
	public String currentWeather = "24C SUNNY";
	//string of image paths to allow images to be changed from outside of class if needed
	String settingsImage = "/cog.png";
	String infoImage = "/info.png";
	String sunImage = "/sun.png";

	//menu buttons allow renaming of buttons outside of superclass
	public static Button menuOption1;
	public Button menuOption2;
	public Button menuOption3;
	public Button menuOption4;
	public Button backButton;
	//stage and panes class variables to allow for access
	public Stage stage;
	public Scene scene;
	public FlowPane flowMenu;
	public BorderPane currentWeatherDisplay;
	public Button information;


	/**
	 * showstage allows another stage to show the instantiated stage once loaded.
	 */
	public void showStage() {
		this.stage.show();
	}

	/**
	 * MenuStructure constructor to create a stage for menus to be based off of.
	 * @param maxX value for screen x
	 * @param maxY value for screen y
	 */
	public MenuStructure(double maxX, double maxY) {
		// dateformat and date to get the date
		DateFormat dateFormat = new SimpleDateFormat("h:mm a");
		Date date = new Date();

		// flowPane allows flexibility of positioning and size of components
		flowMenu = new FlowPane();

		// fixing the preffered height and width to keep aspect ratio of whole screen
		flowMenu.setPrefHeight(maxX);
		flowMenu.setPrefWidth(maxY);
		flowMenu.setStyle("-fx-background-color: rgb(255, 255, 255)");

		// Label for displaying clients name
		Label clientNameDisplay = new Label(clientName);
		clientNameDisplay.setPrefHeight(40);
		clientNameDisplay.setPrefWidth(100);
		clientNameDisplay.setFont(Font.font("Raleway", 18));

		//new button to allow user to go back to the previous screen
		backButton = new Button();

		ImageView backView = new ImageView(new Image(getClass().getResourceAsStream("/backkk.png")));

		backView.setFitWidth(40);
		backView.setFitHeight(30);
		backButton.setGraphic(backView);
		backButton.setStyle("-fx-background-color: transparent;");
		backButton.setPrefHeight(35);
		backButton.setPrefWidth(50);

		// blank space to make the flowpane spaced out
		Label blankspace = new Label();
		blankspace.setPrefHeight(40);
		blankspace.setPrefWidth(250);

		// currrent time label displays the time
		Label currentTime = new Label(dateFormat.format(date));
		currentTime.setPrefHeight(40);
		currentTime.setPrefWidth(350);
		currentTime.setFont(Font.font("Raleway", 20));

		// settings button image set to cog
		Image cog = new Image(getClass().getResourceAsStream(settingsImage));
		ImageView icog = new ImageView(cog);
		icog.setFitHeight(40);
		icog.setFitWidth(40);

		//button for settings added and settings graphic added
		Button settings = new Button();
		settings.setPrefHeight(28);
		settings.setPrefWidth(28);
		settings.setGraphic(icog); 
		settings.setStyle("-fx-background-color:null;");

		//settings popover action instantiating a new settings popup
		EventHandler<ActionEvent> settingsPopOver = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// calls PopOver class
				new SettingsPopOver();
			}
		};
		settings.setOnAction(settingsPopOver);

		// information button image added to the button
		Image info = new Image(getClass().getResourceAsStream(infoImage));
		ImageView iinfo = new ImageView(info);
		iinfo.setFitHeight(40);
		iinfo.setFitWidth(40);

		EventHandler<ActionEvent> help = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// calls help menu
				new HelpPage(maxX, maxY);
			}
		};
				
		information = new Button("");
		information.setGraphic(iinfo);
		information.setPrefHeight(25);
		information.setPrefWidth(40);
		information.setOnAction(help);
		information.setStyle("-fx-background-color:null");

		
		// details bar is a bar along top of app that will display clientsname, time and different buttons
		ToolBar detailsBar = new ToolBar(backButton, clientNameDisplay, blankspace, currentTime, settings, information);
		detailsBar.setPrefHeight(70);
		detailsBar.setPrefWidth(maxX);
		detailsBar.setStyle("-fx-background-color: rgb(38, 153, 251)");

		// adding a new image to be loaded into image view
		Image weatherPicture = new Image("sun.png");

		// adding image to imageview (a place to show the image) keeps the ratio good
		ImageView currentTempImage = new ImageView();
		currentTempImage.setImage(weatherPicture);
		currentTempImage.setFitWidth(160);
		currentTempImage.setFitHeight(135);
		currentTempImage.setPreserveRatio(true);
				
		Label note = new Label("**Note: Press enter to emulate fingerprint\n scanner loading staff menu.");
		note.setAlignment(Pos.CENTER);
		note.setTextAlignment(TextAlignment.CENTER);
		note.setFont(Font.font("Raleway", 12));

		// label shows date and is positioned in the centre of the element
		// used for weather section of main menu
		Label dateTime = new Label(dateFormat.format(date));
		dateTime.setAlignment(Pos.CENTER);
		dateTime.setPrefHeight(40);
		dateTime.setPrefWidth(200);
		dateTime.setFont(Font.font("Raleway", 16));
		
		GridPane grid = new GridPane();
		GridPane.setRowIndex(dateTime, 0); // column=1
		GridPane.setRowIndex(note, 1); // column=1
		grid.getChildren().addAll(dateTime, note);
		grid.setTranslateX(60);

		// temperature variable label uesd in weather section.
		Label temperature = new Label(currentWeather);
		temperature.setAlignment(Pos.CENTER);
		temperature.setPrefHeight(140);
		temperature.setPrefWidth(200);
		temperature.setContentDisplay(ContentDisplay.RIGHT);
		temperature.setFont(Font.font("Raleway", FontWeight.SEMI_BOLD, 16));

		
		// borderpane is a layout that holds the weatherdisplay
		currentWeatherDisplay = new BorderPane();
		currentWeatherDisplay.setPrefHeight(570);
		currentWeatherDisplay.setPrefWidth(310);

		// setting alignment of borderpane
		BorderPane.setAlignment(grid, Pos.CENTER);
		BorderPane.setAlignment(currentTempImage, Pos.CENTER);
		BorderPane.setAlignment(temperature, Pos.TOP_CENTER);

		// adding contents to borderpane (current time, weather and picture)
		currentWeatherDisplay.setTop(grid);
		currentWeatherDisplay.setCenter(currentTempImage);
		currentWeatherDisplay.setBottom(temperature);

		// creating 4 blank buttonholders which are borderpane layouts. they
		// will hold togglebuttons
		BorderPane buttonHolder1 = new BorderPane();
		BorderPane buttonHolder2 = new BorderPane();
		BorderPane buttonHolder3 = new BorderPane();
		BorderPane buttonHolder4 = new BorderPane();
		
		

		// 4 togglebuttons added to buttonholders and styled similarly,
		menuOption1 = new Button();
		buttonHolder1.setCenter(menuOption1);
		menuOption1.setFont(Font.font("Raleway", 20)); 
		menuOption1.setContentDisplay(ContentDisplay.TOP);
		menuOption1.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
				+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251);");
		menuOption1.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						menuOption1.setEffect(shadow);

					}
				});
		menuOption1.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						menuOption1.setEffect(null);
					}
				});

		menuOption1.setPrefHeight(250);
		menuOption1.setPrefWidth(275);

		menuOption2 = new Button();
		buttonHolder2.setCenter(menuOption2);
		menuOption2.setFont(Font.font("Raleway", 20)); 
		menuOption2.setContentDisplay(ContentDisplay.TOP);
		menuOption2.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
				+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251);");
		menuOption2.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						menuOption2.setEffect(shadow);

					}
				});
		menuOption2.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						menuOption2.setEffect(null);
					}
				});
		menuOption2.setPrefHeight(250);
		menuOption2.setPrefWidth(275);

		menuOption3 = new Button();
		buttonHolder3.setCenter(menuOption3);
		menuOption3.setFont(Font.font("Raleway", 20)); 
		menuOption3.setContentDisplay(ContentDisplay.TOP);
		menuOption3.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
				+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251);");
		menuOption3.setPrefHeight(250);
		menuOption3.setPrefWidth(275);
		
		menuOption3.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						menuOption3.setEffect(shadow);

					}
				});
		menuOption3.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						menuOption3.setEffect(null);
					}
				});

		menuOption4 = new Button();
		buttonHolder4.setCenter(menuOption4);
		menuOption4.setFont(Font.font("Raleway", 20)); 
		menuOption4.setContentDisplay(ContentDisplay.TOP);
		menuOption4.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-border-radius: "
				+ "30px; -fx-background-radius: 32px; -fx-border-width: 2px; -fx-border-color: rgba(38, 153, 251);");
		menuOption4.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						menuOption4.setEffect(shadow);

					}
				});
		menuOption4.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						menuOption4.setEffect(null);
					}
				});
		menuOption4.setPrefHeight(250);
		menuOption4.setPrefWidth(275);

		// gridpane is a grid that holds our buttons, setting padding etc
		GridPane buttonArea = new GridPane();
		buttonArea.setPrefHeight(540);
		buttonArea.setPrefWidth(580);
		buttonArea.setStyle("-fx-background-color: rgb(255, 255, 255)");
		buttonArea.setPadding(new Insets(10, 0, 0, 10));
		buttonArea.setHgap(10);
		buttonArea.setVgap(10);

		// adding buttonholders which contain our buttons to the buttonarea, in grid positions
		buttonArea.add(buttonHolder1, 0, 0);
		buttonArea.add(buttonHolder2, 1, 0);
		buttonArea.add(buttonHolder3, 0, 1);
		buttonArea.add(buttonHolder4, 1, 1);

		// buttonArea gridpane is a grid, easy to show or hide lines for
		// adding layouts to flowpane main layout
		flowMenu.getChildren().add(detailsBar);
		flowMenu.getChildren().add(buttonArea);
		flowMenu.getChildren().add(currentWeatherDisplay);

		// setting a new scene, with the layout to display and how big to display it
		scene = new Scene(flowMenu, maxX, maxY);

		// new stage to hold scene, setting height width, not allowing resizing.
		stage = new Stage();
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scene);
		stage.setMaxHeight(maxY);
		stage.setMaxWidth(maxX);
		stage.setResizable(false);
		stage.setX(stageX);
		stage.setY(stageY);

		EventHandler<KeyEvent> staffmenu = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent menu4) {
				// new instance of menu structure, staff menu.
				new StaffMenu(maxX, maxY);
			}
		};
		
		scene.setOnKeyPressed(staffmenu);
		// stageX and stageY are position variables that determine where the
		// window will open upon launching.
	}
}