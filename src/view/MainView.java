package view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.audio.AudioPlayer;
import model.button.CreditsButton;
import model.button.ExitButton;
import model.button.HelpButton;
import model.button.PlayButton;
import model.cursor.CustomCursor;
import model.logo.Logo;
import view.subview.ExitSubView;
import view.subview.PlaySubView;
import view.subview.SubView;

public class MainView {
	
	
	private static final int WIDTH = 1400;
	private static final int HEIGHT = 800;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	private VBox buttonPane;
	
	private SubView creditsSubView;
	private SubView exitSubView;
	private SubView howToPlaySubView;
	private SubView playSubView;
	public MainView() 
	{
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
		mainStage = new Stage();
		
		init();
	}
	
	private void init() 
	{
		initAudioPlayer();
		initCreditsSubView();
		initExitSubView();
		initHowToPlaySubView();
		initPlaySubView();
		initCursor();
		initButtonPane();
		initPlayButton();
		initHowToPlayButton();
		initCreditsButton();
		initExitButton();
		initLogo();
		

		mainPane.setStyle("-fx-background-color: #40bad5");
		mainStage.setTitle("Bob The Speller");
		mainStage.setResizable(false);
		mainStage.setScene(mainScene);
		mainStage.show();
	}
	

	private void initButtonPane() {
		buttonPane = new VBox(30);
		AnchorPane.setLeftAnchor(buttonPane, 100.0);
		AnchorPane.setTopAnchor(buttonPane, 150.0);
		mainPane.getChildren().add(buttonPane);
	}

	public Stage getMainStage() {
		return mainStage;
	}
	
	private void initPlayButton() 
	{
		PlayButton BTN = new PlayButton("PLAY",playSubView);
		buttonPane.getChildren().add(BTN);
	}
	
	private void initHowToPlayButton() 
	{
		HelpButton BTN = new HelpButton("HELP",howToPlaySubView);
		buttonPane.getChildren().add(BTN);
	}
	
	private void initCreditsButton() 
	{
		CreditsButton BTN = new CreditsButton("CREDITS",creditsSubView);
		buttonPane.getChildren().add(BTN);
	}
	
	private void initExitButton() 
	{
		ExitButton BTN = new ExitButton("EXIT",exitSubView);
		buttonPane.getChildren().add(BTN);
	}
	
	private void initLogo() {
		Logo logo = new Logo();
		mainPane.getChildren().add(logo);
		AnchorPane.setRightAnchor(logo, 270.0);
		AnchorPane.setTopAnchor(logo, 50.0);
	}
	
	private void initCursor() 
	{
		new CustomCursor(mainScene,mainPane);
	}
	
	private void initCreditsSubView() {
		creditsSubView = new SubView();
		mainPane.getChildren().add(creditsSubView);
	}
	
	private void initExitSubView() {
		exitSubView = new ExitSubView();
		mainPane.getChildren().add(exitSubView);
	}
	
	private void initHowToPlaySubView() {
		howToPlaySubView = new SubView();
		mainPane.getChildren().add(howToPlaySubView);
	}
	
	private void initPlaySubView() {
		playSubView = new PlaySubView();
		mainPane.getChildren().add(playSubView);
	}
	
	private void initAudioPlayer() 
	{
		AudioPlayer player = new AudioPlayer();
		mainPane.getChildren().add(player);
	}
}
