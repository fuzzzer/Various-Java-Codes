import acm.program.*;
import java.awt.event.*;
import javax.swing.*;
import acm.graphics.GImage;
import acm.program.*;


public class afterEx67 extends GraphicsProgram {
	
	public void init() {
		
		textField = new JTextField(10);
		add(textField, SOUTH);
		
		textField.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
		String url = textField.getText();
		textField.setText("");
		
		if(img == null ) {
			img = new GImage(url);
			add(img, (getWidth() - img.getWidth()) / 2, (getHeight() - img.getHeight()) / 2);
		} else {
			img.setImage(url);
		}
	}
	
	//instance varibles
	private JTextField textField;
	private GImage img;
	
}
