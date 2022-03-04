import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.*;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import java.awt.*;

public class final3 extends GraphicsProgram implements ComponentListener {

	private static final int MARGIN_X = 20;
	private static final int MARGIN_Y = 10;
	
	
	JTextField nameField;
	JTextField phoneField;
	HashMap<String, GLabel> labels = new HashMap<String, GLabel>();
	ArrayList<String> names = new ArrayList<String>();
	RandomGenerator rgen = new RandomGenerator();
	
	public void run() {
		this.setSize(1000, 600);
		addButtonsAndListeners();
		addComponentListener(this);
		
	}
	
	private void addButtonsAndListeners() {
		
		JLabel nameLabel = new JLabel("name");
		add(nameLabel, SOUTH);
	
		nameField = new JTextField(8);
		add(nameField, SOUTH);
		
		JLabel numberLabel = new JLabel("phone");
		add(numberLabel, SOUTH);
		
		phoneField = new JTextField(8);
		add(phoneField, SOUTH);
		
		JButton addButton = new JButton("add");
		add(addButton, SOUTH);
		
		addActionListeners();
		nameField.addActionListener(this);
		phoneField.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		String nameText = nameField.getText();
		String phoneText = phoneField.getText();
		 
		if(cmd.equals("add") || e.getSource() == nameField || e.getSource() == phoneField) {
			addLabel(nameText, phoneText);
		}
	}
	
	private void addLabel(String name, String phone) {
		 GLabel label = new GLabel(name + " " + phone);
		 double x;
		 double y;
		 
		 if(labels.containsKey(name)) {
			 x = labels.get(name).getX();
			 y = labels.get(name).getY();
		 } else {
			 x = MARGIN_X;
			 y = (labels.keySet().size() + 1) * (MARGIN_Y + label.getAscent());
			 names.add(name);
		 }
		 
		 labels.put(name, label);
		 
		 add(label, x, y);
	}
	
	private void reDrawRandomly() {
		this.removeAll();
		
		for(int i=0; i < names.size(); i++) {
			int newIndex = rgen.nextInt(i, names.size() - 1);
			
			String oldValue = names.get(newIndex);
			names.set(newIndex, names.get(i));
			names.set(i,  oldValue);
		}
		
		for(int i=0; i<names.size(); i++) {
			String current = names.get(i);
			GLabel label = labels.get(current);
			add(label, MARGIN_X, (i+1) * (MARGIN_Y + label.getAscent()));
		}
		
		
	}
	
	
	


	public void componentResized(ComponentEvent e) {
		reDrawRandomly();

	}

	public void componentMoved(ComponentEvent e) {
		
	}

	public void componentShown(ComponentEvent e) {
		
	}

	public void componentHidden(ComponentEvent e) {
			
	}
	
	
}
