package model.cursor;

import custom.JFXCustomCursor;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class CustomCursor {	
	
	private static final String PATH = "./resources/cursor_pointer3D.png";
	private static final int WIDTH = 40;
	private static final int HEIGHT = 40;
	private Scene scene;
	private Pane root;
	
	public CustomCursor(Scene scene,Pane root)
	{
		this.scene = scene;
		this.root = root;
		init();
	}
	
	private void init() 
	{
		// loading image for cusor
		ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(PATH)));
		imageView.setFitWidth(WIDTH);
		imageView.setFitHeight(HEIGHT);
		
		// setting image in pane
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(imageView);
		
		// replacing regular cursor
		new JFXCustomCursor(scene, root, borderPane, 1, 1);
		scene.setCursor(Cursor.NONE);
	}

}
