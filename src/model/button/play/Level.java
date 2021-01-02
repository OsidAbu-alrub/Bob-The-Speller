package model.button.play;

import java.io.File;
import java.io.InputStream;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public abstract class Level extends Button{
	
	private static final String AUDIO = "src\\model\\button\\play\\resources\\start_level_audio.wav";
	private static final String BUTTON_PRESSED = "model/button/play/resources/blue_button_pressed.png";
	private static final String BUTTON_RELEASED = "model/button/play/resources/blue_button_released.png";
	private static final String FONT = "./resources/fonts/Kenney Future Narrow.ttf";
	private static final int WIDTH = 150;
	private static final int HEIGHT = 150;
	
	public Level(String text) 
	{
		this.setPrefSize(WIDTH, HEIGHT);
		this.setText(text);
		setEffectAndPadding(BUTTON_RELEASED,0,0,0,0);
		init();
	}
	
	private void init() 
	{
		setFont();
		setOnMousePressed();
		setOnMouseReleased();
		setOnMouseEntered();
		setOnMouseExited();
		setOnMouseClicked();
	}
	
	private void setFont() 
	{
		try {
			InputStream input = this.getClass().getResourceAsStream(FONT);
			Font font = Font.loadFont(input,50);
			input.close();
			setFont(font);
			setTextFill(Color.WHITE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void setOnMousePressed() {
		this.setOnMousePressed(e -> {
			setEffectAndPadding(BUTTON_PRESSED,15,0,0,0);
		});
	}
	
	private void setOnMouseReleased() {
		this.setOnMouseReleased(e -> {
			setEffectAndPadding(BUTTON_RELEASED,0,0,0,0);
		});
	}
	private void setOnMouseEntered() {
		this.setOnMouseEntered(e -> {
			setEffectAndPadding(BUTTON_RELEASED,0,0,0,0);
		});
	}
	private void setOnMouseExited() {
		this.setOnMouseExited(e -> {
			setEffectAndPadding(BUTTON_RELEASED,0,0,0,0);
		});
	}
	
	public final void setOnMouseClicked() {
		this.setOnMouseClicked(e->{
			try {
				playAudio();
				runLevel();
			}
			catch(Exception ex) {
				
			}
		});
	}
	
	public void playAudio() {
		Media media = new Media(new File(getAudio()).toURI().toString());
		MediaPlayer player = new MediaPlayer(media);
		player.play();
	}
	
	private void setEffectAndPadding(String effect,int topPadding,int rightPadding,int bottomPadding,int leftPadding)
	{
		BackgroundImage bImage = new BackgroundImage(new 
				Image(effect,WIDTH,HEIGHT,false,true),
				    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				      BackgroundSize.DEFAULT);
		this.setBackground(new Background(bImage));
		this.setPadding(new Insets(topPadding,rightPadding,bottomPadding,leftPadding));
	}
	
	
	// abstract methods
	public abstract void runLevel();
	
	// getters
	public String getAudio() {
		return AUDIO;
	}
	
}
