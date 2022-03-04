import acm.program.*;
import java.awt.event.*;
import javax.swing.*;
import acm.graphics.GImage;
import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;


public class afterEx70 extends GraphicsProgram implements ComponentListener{

	
	public void run() {
		addComponentListener(this);
	}
	
	public void update() {
		removeAll();
		addVerticalLines();
		addHorizontalLines();
	}
	
	private void addVerticalLines() {
		for(int i=0; i<boardSize ;  i++) {
			add(new GLine(i * (getWidth() / boardSize), 0 , i * (getWidth() / boardSize) , getHeight()));
		}
	}
	
	private void addHorizontalLines() {
		for(int i=0; i<boardSize ;  i++) {
			add(new GLine(0 , i * (getHeight() / boardSize), getWidth(), i * (getHeight() / boardSize)));
		}
	}
	
	
	
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	
	private static final int boardSize = 8;
}
