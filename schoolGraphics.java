import acm.program.*;
import java.awt.event.*;
import javax.swing.*;
import acm.graphics.GImage;
import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class schoolGraphics extends GraphicsProgram {
	
	public void init() {
		this.setSize(1200, 800);
		school = new School();
		addFirstLine();
		addInteractors();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		String teacherText = teacher.getText();
		String subjText = subj.getText();
		String pupilText = pupil.getText();
		clearTextFields();
		
		if(cmd.equals("Add Teach")) {
			school.addTeacher(teacherText);
		}
		
		if(cmd.equals("Add Subj")) {
			school.addSubject(teacherText, subjText);
		}
		
		if(cmd.equals("Add Pupils")) {
			school.addPupil(pupilText, subjText);
		}
		
		if(cmd.equals("Display Pupils")) {
			printPupils(teacherText);
		}
		
		if(cmd.equals("Display Teachers")) {
			printTeachers(pupilText);
		}
	
	}
	
	private void printPupils(String teacher) {
		removeAll();
		addFirstLine();
		Iterator<String> pupils = school.getPupils(teacher);
		int counter = 2;
		if(pupils != null) {
			while(pupils.hasNext()) {
				String nextLine = pupils.next();
				GLabel line = new GLabel(nextLine);
				add(line, xCoordinate, counter * (line.getAscent() + yDifference));
				counter++;
			}
		}
	}
	
	private void printTeachers(String pupil) {
		removeAll();
		addFirstLine();
		Iterator<String> teachers = school.getTeachers(pupil);
		int counter = 2;
		if(teachers != null) {
			while(teachers.hasNext()) {
				String nextLine = teachers.next();
				GLabel line = new GLabel(nextLine);
				add(line, xCoordinate, counter * (line.getAscent() + yDifference));
				counter++;
			}
		}
		
	}
	
	private void clearTextFields() {
		teacher.setText("");
		subj.setText("");
		pupil.setText("");
	}
	
	
	private void addFirstLine() {
		String starter = "result: ";
		GLabel firstLine = new GLabel(starter);
		add(firstLine, xCoordinate, firstLine.getAscent() + yDifference);
		
	}
	
	private void addInteractors() {
		add(new JLabel("Teacher:"), SOUTH);
		teacher = new JTextField(10);
		add(teacher, SOUTH);
		
		add(new JLabel("Subj:"), SOUTH);
		subj = new JTextField(10);
		add(subj, SOUTH);
		
		add(new JLabel("Pupil:"), SOUTH);
		pupil = new JTextField(10);
		add(pupil, SOUTH);
		
		JButton addTeach = new JButton("Add Teach");
		add(addTeach, SOUTH);
		
		JButton addSubj = new JButton("Add Subj");
		add(addSubj, SOUTH);
		
		JButton addPupil = new JButton("Add Pupils");
		add(addPupil, SOUTH);
		
		JButton displayPupils = new JButton("Display Pupils");
		add(displayPupils, SOUTH);
		
		JButton displayTeachers = new JButton("Display Teachers");
		add(displayTeachers, SOUTH);
		
		addActionListeners();
		
		/*
		teacher.addActionListener(this);
		subj.addActionListener(this);
		pupil.addActionListener(this);
		*/
	}
	
	
	
	
	
	
	//instances:
	private JTextField teacher;
	private JTextField subj;
	private JTextField pupil;
	private School school;
	
	
	private static final int xCoordinate = 10;
	private static final int yDifference = 7;
}
