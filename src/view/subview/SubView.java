package view.subview;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.util.Duration;

public class SubView extends SubScene {
	private static final String FONT = "view/subview/resources/fonts/Kenney Future Narrow.ttf";
	private static final String BACKGROUND_IMAGE = "view/subview/resources/yellow_panel.png";
	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;
	
	private boolean isShowing;
	private final int START_X = 1450;
	private final int START_Y = 250;
	private final int SHOW_SUB_VIEW = -920;
	private final int HIDE_SUB_VIEW = 0;
	public SubView() 
	{
		super(new AnchorPane(),WIDTH,HEIGHT);
		init();
	}
	
	private void init() 
	{
		initBackground();
		this.setLayoutX(START_X);
		this.setLayoutY(START_Y);
	}
	
	private void initBackground() {
		BackgroundImage bImage = new BackgroundImage(new 
				Image(BACKGROUND_IMAGE,800,500,false,true),
				    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				      BackgroundSize.DEFAULT);
		((AnchorPane)this.getRoot()).setBackground(new Background(bImage));
	}
	
	public void transition() 
	{
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.8));
		transition.setNode(this);
		if(isShowing) 
		{
			transition.setToX(HIDE_SUB_VIEW); // hide
		}
		else 
		{
			transition.setToX(SHOW_SUB_VIEW); // show
		}
		isShowing = !isShowing;
		transition.play();
	}

	// getters
	public static String getFont() {
		return FONT;
	}
	
	public AnchorPane getPane() {
		return ((AnchorPane)this.getRoot());
	}

}
