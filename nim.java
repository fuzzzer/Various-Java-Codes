
import acm.graphics.*;
import java.awt.*;
import java.util.*;
import acm.program.*;
import java.awt.event.*;


public class nim extends GraphicsProgram{
	private static final int N_COINS = 11; 		// ქვების რაოდენობა
	private static final int COIN_SIZE = 25; 	// ქვის ზომა
	private static final int COIN_STEP = 10; 	// ქვებს შორის მანძილი

	HashMap<GOval, Integer> ovals = new HashMap<GOval, Integer>();
	int turns = 0; // player 1 wins on evens, player 2 wins on odds
	
	public void run() {
		setup();
		addMouseListeners();
		
	}
	
	private void setup() {
		for(int i=0 ; i<N_COINS ; i++){
			GOval oval = new GOval(COIN_SIZE, COIN_SIZE);
			oval.setFilled(true);
			oval.setColor(Color.BLACK);
			oval.setFillColor(Color.GRAY);
			double X = (getWidth() - N_COINS * COIN_SIZE - (N_COINS - 1) * COIN_STEP) / 2 + i * (COIN_SIZE + COIN_STEP);
			double Y = (getHeight() - COIN_SIZE) / 2;
			add(oval, X, Y);
			ovals.put(oval, i);
		}
				
	}
	
	public void mouseClicked(MouseEvent e){
		double x = e.getX();
		double y = e.getY();
		
		GObject clicked = getElementAt(x, y);
		
		if(clicked !=null) {
			int coefficient = ovals.get(clicked);
			System.out.print("\n" + "-->coefficient-->" + coefficient);
			int size = ovals.keySet().size();
			if(coefficient >= size - 3){
				System.out.print("\n" + "-->ovals.keySet().size()-->" + size);
				for(int i = coefficient ; i<size ; i++){
					System.out.print("\n" + "-->i-->" + i);
					GOval toRemove = null;
					
					for(GOval curr : ovals.keySet()){
						System.out.print("\n" + "-->oval-->" + ovals.get(curr));
						if(ovals.get(curr) == i) toRemove = curr;
					}
					
					if(toRemove != null && ovals.containsKey(toRemove)) {
						ovals.remove(toRemove);
					}
					
				}
				
				this.removeAll();
				redrawOvals();
				turns++;
			}
		}
		
		if(ovals.keySet().size() == 0) {
			if(turns % 2 == 0) {
				println("player 1 wins");
			} else {
				println("player 2 wins");
			}
		}
		
	}
	
	private void redrawOvals(){
		for(GOval curr : ovals.keySet()){
			
			double X = (getWidth() - N_COINS * COIN_SIZE - (N_COINS - 1) * COIN_STEP) / 2 + ovals.get(curr) * (COIN_SIZE + COIN_STEP);
			double Y = (getHeight() - COIN_SIZE) / 2;
			
			add(curr, X, Y);
		}
	}
	
}


