

import acm.program.*;
import java.util.*;

public class final2 extends ConsoleProgram {

	public void run() {
		
		Map<String, List<String>> friendships = new HashMap<String, List<String>>();
		Map<String, Map<String, Double>> grades = new HashMap<String, Map<String, Double>>();
		
		
		println("Lucky one is " + luckyStudent(friendships, grades));
		
	}
	
	
	String luckyStudent(Map<String, List<String>> friendships, Map<String, Map<String, Double>> grades) {
		

		ArrayList<String> badSubjects = findBadSubjects(grades);
		
		for(String maybeLuckyOne : friendships.keySet()) {
			if(!hasAFriendWithBadSubject(friendships.get(maybeLuckyOne), grades, badSubjects)) return maybeLuckyOne;
		}
		
		return "";
	}
	
	private boolean hasAFriendWithBadSubject(List<String> friends, Map<String, Map<String, Double>> grades, ArrayList<String> badSubjects) {
		
		for(String currentFriend : friends) {
			Set<String> subjects =  grades.get(currentFriend).keySet();
			for(String currentSubject : subjects) {
				if(badSubjects.contains(currentSubject)) return true;
			}
		}
		
		return false;
	}
	
	private ArrayList<String> findBadSubjects(Map<String, Map<String, Double>> grades) {
		
		ArrayList<String> result  = new ArrayList<String>();
		
		Map<String, Double> subjectAverages = findSubjectAverages(grades);
		
		double allCourseAverageGrade = averageOfAllCourses(subjectAverages);
		
		for(String subj : subjectAverages.keySet()) {
			if(	subjectAverages.get(subj) <= allCourseAverageGrade ) result.add(subj);

		}
		
		return result;
	}
	
	private HashMap<String, Double> findSubjectAverages(Map<String, Map<String, Double>> grades) {
		HashMap<String, Double> result =  new HashMap<String, Double>();
		HashMap<String, Integer> registeredOnSubject = new HashMap<String, Integer>();
		
		for(String student : grades.keySet()) {
			Map<String, Double> currentStudentsSubjects = grades.get(student);
			for(String subject : currentStudentsSubjects.keySet()) {
				
				if(result.containsKey(subject)) {
					double tempSum = result.get(subject) + currentStudentsSubjects.get(subject);
					result.put(subject, tempSum);
					
					registeredOnSubject.put(subject, registeredOnSubject.get(subject) + 1);
				} else {
					result.put(subject, currentStudentsSubjects.get(subject));
					registeredOnSubject.put(subject, 1);
				}
				
			}
		}
		
		
		for(String subject : result.keySet()) {
			double subjectAverage = result.get(subject) / registeredOnSubject.get(subject);
			result.put(subject, subjectAverage);
		}
		
		return result;
	}
	
	private double averageOfAllCourses(Map<String, Double> subjectAverages) {
		int totalSubjects = subjectAverages.keySet().size();
		double sum = 0;
		
		for(String current : subjectAverages.keySet()) {
			sum = sum + subjectAverages.get(current);
		}
		
		return sum/totalSubjects;
	}
}
