import acm.program.*;
import java.awt.event.*;
import javax.swing.*;
import acm.graphics.GImage;
import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class School {

	public School() {}
		
	
	public void addTeacher(String teacher) {
		if(!teachersTeachSubject.containsKey(teacher)) {
			teachersTeachSubject.put(teacher, new ArrayList<String>());
		}
	}
	
	public void addSubject(String teacher, String subject) {
		if(teachersTeachSubject.containsKey(teacher)) {
			teachersTeachSubject.get(teacher).add(subject);
			
			if(subjectIsTaught.get(subject) == null) {
				ArrayList<String> teachers = new ArrayList<String>();
				teachers.add(teacher);
				subjectIsTaught.put(subject, teachers);
			} else {
				subjectIsTaught.get(subject).add(teacher);
			}
		}
	}
	
	public void addPupil(String pupil, String subject) {
		if(pupilsData.get(pupil) == null) {
			ArrayList<String> subjects = new ArrayList<String>();
			subjects.add(subject);
			pupilsData.put(pupil, subjects);
		} else {
			pupilsData.get(pupil).add(subject);
		}
	}
	
	public Iterator<String> getTeachers(String pupil){
		if(pupilsData.containsKey(pupil)) {
			ArrayList<String> toIterate = getTeachersByPupil(pupil);
			Iterator<String> result = toIterate.iterator();
			//return teachersTeachSubject.get(pupilsData.get(pupil).iterator()).iterator();
			return result;
		} else {
			return null;
		}
	}
	
	public Iterator<String> getPupils(String teacher){
		if(teachersTeachSubject.containsKey(teacher)) {
			ArrayList<String> toIterate = getPupilsByTeacher(teacher);
			Iterator<String> result = toIterate.iterator();
			//return pupilsData.get(subjectIsTaught.get(teacher).iterator()).iterator();
			return result;
		} else {
			return null;
		}
	}
	
	public void removeTeacher(String teacher) {
		
	}
	
	
	//private methods------------------------------------------------------------------------------------------------
	
	private ArrayList<String> getTeachersByPupil(String pupil) {
		ArrayList<String> result = new ArrayList<String>();
		for(String subject : pupilsData.get(pupil)) {
			for(String teacher : subjectIsTaught.get(subject)) {
				if(!result.contains(teacher)) result.add(teacher);
			}
		}
		return result;
	}
	
	private ArrayList<String> getPupilsByTeacher(String teacher) {
		ArrayList<String> result = new ArrayList<String>();
		for(String subject : teachersTeachSubject.get(teacher)) {
			for(String pupil : pupilsData.keySet()) {
				if(pupilsData.get(pupil).contains(subject) && !result.contains(pupil)) result.add(pupil);
			}
		}
		return result;
	}

	
	//insatnce varables
	HashMap<String, ArrayList<String>> teachersTeachSubject = new HashMap<String, ArrayList<String>>();
	HashMap<String, ArrayList<String>> subjectIsTaught = new HashMap<String, ArrayList<String>>();
	HashMap<String, ArrayList<String>> pupilsData = new HashMap<String, ArrayList<String>>();
	
}
