import acm.program.*;
import java.awt.event.*;
import javax.swing.*;
import acm.graphics.GImage;
import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;



/*
68. თქვენი ამოცანაა გრაფიკული პროგრამის საშუალებით გააკეთოთ ჩატი. ფანჯარაზე, SOUTH 
რეგიონზე უნდა გქონდეთ ერთი ტექსტფილდი და ერთი ღილაკი ტექტით Enter. 
ტექსტფილდში ტექსტის შეყვანის მერე Enter ჭილაკზე დაჭერით ტექსტი უნდა
იწერებოდეს(იხატებოდეს) კანვასზე ხოლო ტექსტფილდში კი ტექსტი იშლებოდეს. ხელახლა
ტექსტის შეყვანისას ახალი ტექსტი წინა ტექსტის ქვემოთ უნდა გამოცნდეს(როგორც ჩატში
ხდება ხოლმე. თუკი ტექსტი ჩაცდება ეკრანს არაუშავს.
69. 68 ამოცანის გაგრძელება. დაამატეთ სქროლი. თუკი ტექსტი ჩაცდება ეკრანს მაშინ ახალი
ტექსტი მაინც უნდა გამოჩნდეს ეკრანის ბოლოში, შესაბამისად სულ პირველად შეყვანილი
ტექსტი გაქრება ეკრანიდან
 */
public class afterEx68 extends GraphicsProgram {

	public void init() {
		
		input = new JTextField(20);
		add(input, SOUTH);
		
		
		JButton enter = new JButton ("Enter");
		add(enter, SOUTH);
		
		addActionListeners();
		input.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String text = input.getText();
		String cmd = e.getActionCommand();
		if(e.getSource() == input || cmd.equals("Enter") ){
			addOnCanvas(text);
		}
		input.setText("");
	}
	
	private void addOnCanvas(String text) {
		GLabel print = new GLabel(text);
		int N = labels.size();
		labels.put(N, print);
		double height = print.getAscent();
		if(N*height > getHeight() - height) {
			for(Integer K : labels.keySet()) {
				double y = labels.get(K).getY();
				labels.get(K).setLocation(0, y - height);
			}
			add(print, 0 , labels.get(N-1).getY() + height);
		} else {
			add(print, 0 , N * height + height);
		}
	}
	
	
	//instance varibles
	JTextField input;
	HashMap<Integer, GLabel> labels =  new HashMap<Integer, GLabel>();
}
