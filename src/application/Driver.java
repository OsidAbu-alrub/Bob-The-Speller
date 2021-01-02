package application;

import javafx.application.Application;
import javafx.stage.Stage;
import view.MainView;

public class Driver extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new MainView();
	}
}
