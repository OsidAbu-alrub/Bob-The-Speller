package model.audio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;

public class AudioPlayer extends StackPane {
	private static final String TRACK_ONE = "src\\model\\audio\\resources\\track_one.wav";
	private static final String TRACK_TWO = "src\\model\\audio\\resources\\track_two.wav";
	private static final String TRACK_THREE = "src\\model\\audio\\resources\\track_three.wav";
	private static final String MUTE = "src\\model\\audio\\resources\\mute.png";
	private static final String PLAY = "src\\model\\audio\\resources\\play.png";
	private static final int WIDTH = 60;
	private static final int HEIGHT = 60;
	
	private boolean isOn;
	private MediaPlayer player;
	private ArrayList<String> playlist;
	private int currentSong;

	public AudioPlayer() {
		isOn = true;
		this.getChildren().add(new Rectangle());
		init();
	}

	private void init() {
		this.setLayoutX(25);
		this.setLayoutY(25);
		play();
		setOnMouseClicked();
		initPlaylist();
		initAudio();
		setOnEndOfMedia();
	}
	
	private void initPlaylist() {
		playlist = new ArrayList<String>();
		playlist.add(TRACK_TWO);
		playlist.add(TRACK_THREE);
		playlist.add(TRACK_ONE);
	}
	
	// when song ends
	private void setOnEndOfMedia() {
		player.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				currentSong++;
				if(currentSong == playlist.size()) 
					currentSong = 0;
				initAudio();
//				player.seek(Duration.ZERO);
			}
		});
	}

	private void initAudio() {
		Media media = new Media(new File(playlist.get(currentSong)).toURI().toString());
		player = new MediaPlayer(media);
		player.play();
	}
	
	private void play() {
		addImage(PLAY);
	}

	private void mute() {
		addImage(MUTE);
	}

	private void setOnMouseClicked() {
		this.setOnMouseClicked(e -> 
		{
			if (isOn) {
				mute();
				player.setMute(true);
			} else {
				play();
				player.setMute(false);
			}
			isOn = !isOn;
		});
	}
	
	private void addImage(String path) 
	{
		try {
			ImageView image = new ImageView(new Image(new File(path).toURI().toURL().toExternalForm()));
			image.setFitWidth(WIDTH);
			image.setFitWidth(HEIGHT);
			this.getChildren().set(0, image);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
