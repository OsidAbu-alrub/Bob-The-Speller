package model.logo;

import java.io.InputStream;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Logo extends Label
{
	
	private static final String TITLE = "Bob\nThe Speller";
	private static final String FONT_PATH = "./resources/fonts/AlloyInk-nRlyO.ttf";
	public Logo() 
	{
		init();
	}
	
	private void init() 
	{
		setText(TITLE);
		setTextAlignment(TextAlignment.CENTER);
		setFont();
		initListeners();
	}
	
	private void setFont() 
	{
		try {
			InputStream input = this.getClass().getResourceAsStream(FONT_PATH);
			Font font = Font.loadFont(input,64);
			input.close();
			setFont(font);
			setTextFill(Color.WHITE);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void initListeners() {
		setOnMouseEntered();
		setOnMouseExited();
	}
	
	private void setOnMouseEntered() 
	{
		this.setOnMouseEntered(e->{
			this.setEffect(new DropShadow());
		});
	}
	
	private void setOnMouseExited() {
		this.setOnMouseExited(e->{
			this.setEffect(null);
		});
	}
}
