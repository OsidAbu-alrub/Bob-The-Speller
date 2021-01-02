package model.button;

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
import view.subview.SubView;

// this class is parent to all main menu buttons
public class MenuButton extends Button {
//	"src\\model\\button\\resources\\click_menu_audio.wav";
	private static final String AUDIO = "src\\model\\button\\resources\\confirmation_001.wav";
	private static final String BUTTON_FONT = "./resources/fonts/Kenney Future Narrow.ttf";
	private static final String BUTTON_PRESSED = "model/button/resources/yellow_button_pressed.png"; 
	private static final String BUTTON_RELEASED = "model/button/resources/yellow_button_normal.png";
	private static final String BUTTON_HOVERED = "model/button/resources/yellow_button_hovered.png";
	
	private static final int WIDTH = 350;
	private static final int HEIGHT = 100;
	
	private SubView subView;
	private static SubView currentSubView; // current subview thats showing
	
	public MenuButton(String text,SubView subView) 
	{
		this.subView = subView;
		setText(text);
		setFont();
		setPrefWidth(WIDTH);
		setPrefHeight(HEIGHT);
		setEffectAndPadding(BUTTON_RELEASED,0,0,0,0);
		initListeners();
	}
	
	private void setFont() 
	{
		try {
			InputStream input = this.getClass().getResourceAsStream(BUTTON_FONT);
			Font font = Font.loadFont(input,45);
			input.close();
			setFont(font);
			setTextFill(Color.WHITE);
		} catch (Exception ex) {
			
		}
	}
	
	private void initListeners() 
	{
		setOnMousePressed();
		setOnMouseReleased();
		setOnMouseEntered();
		setOnMouseExited();
		setOnMouseClicked();
	}
	
	private void setOnMousePressed() {
		this.setOnMousePressed(e -> {
			setEffectAndPadding(BUTTON_PRESSED,15,0,0,0);
		});
	}
	
	private void setOnMouseReleased() {
		this.setOnMouseReleased(e -> {
			setEffectAndPadding(BUTTON_HOVERED,0,0,0,0);
		});
	}
	private void setOnMouseEntered() {
		this.setOnMouseEntered(e -> {
			setEffectAndPadding(BUTTON_HOVERED,0,0,0,0);
		});
	}
	private void setOnMouseExited() {
		this.setOnMouseExited(e -> {
			setEffectAndPadding(BUTTON_RELEASED,0,0,0,0);
		});
	}
	
	private void setOnMouseClicked() {
		this.setOnMouseClicked(e ->{
			playSound();
			if(currentSubView != null) 
			{
				if(currentSubView == subView) // if user wants to hide 
				{
					currentSubView = null;
					subView.transition();
				}
				else
				{
					currentSubView.transition(); // hide current
					currentSubView = subView; // assign new current
					currentSubView.transition(); // show current
				}
			}
			else 
			{
				currentSubView = subView;
				currentSubView.transition();
			}
		});
	}
	
	public void playSound() {
		Media media = new Media(new File(AUDIO).toURI().toString());
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
	
}
