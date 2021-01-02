package model.button;

import javafx.stage.Stage;
import view.subview.SubView;

public class ExitButton extends MenuButton{

	
	public ExitButton(String text,SubView subView) {
		super(text,subView);
		
		init();
	}
	
	private void init() 
	{
		setOnMouseClicked();
	}
	
	private void setOnMouseClicked() {
		this.setOnMouseClicked(e->{
			((Stage)this.getScene().getWindow()).close();
		});
	}
}
