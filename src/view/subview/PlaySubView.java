package view.subview;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import model.button.play.Level;
import model.button.play.LevelOne;
import model.button.play.LevelThree;
import model.button.play.LevelTwo;

public class PlaySubView extends SubView{
	
	private AnchorPane root;
	private TilePane mainPane;
	
	private Level levelOne; 
	private Level levelTwo; 
	private Level levelThree; 
//	private Level levelFour; 
//	private Level levelFive; 
//	private Level levelSix; 
	public PlaySubView() {
		this.root = this.getPane();
		init();
	}
	
	private void init() 
	{
		initMainPane();
		initLevelOne();
		initLevelTwo();
		initLevelThree();
//		initLevelFour();
//		initLevelFive();
//		initLevelSix();
	}
	
	private void initMainPane() 
	{
		this.mainPane = new TilePane();
		this.mainPane.setHgap(50);
		this.mainPane.setVgap(50);
		this.mainPane.setPrefColumns(3);
		this.mainPane.setLayoutX(125);
		this.mainPane.setLayoutY(150);
		root.getChildren().add(mainPane);
		
	}
	
	private void initLevelOne() {
		levelOne = new LevelOne("1");
		mainPane.getChildren().add(levelOne);
	}
	
	private void initLevelTwo() {
		levelTwo = new LevelTwo("2");
		mainPane.getChildren().add(levelTwo);
	}
	
	private void initLevelThree() {
		levelThree = new LevelThree("3");
		mainPane .getChildren().add(levelThree);
	}
	
//	private void initLevelFour() {
//		levelFour = new LevelOne("4");
//		mainPane.getChildren().add(levelFour);
//	}
//	
//	private void initLevelFive() {
//		levelFive = new LevelOne("5");
//		mainPane.getChildren().add(levelFive);
//	}
//	
//	private void initLevelSix() {
//		levelSix = new LevelOne("6");
//		mainPane.getChildren().add(levelSix);
//	}

}
