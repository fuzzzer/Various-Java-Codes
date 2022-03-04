import java.util.ArrayList;
import java.io.*;
import java.util.*;

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class afterEx63 extends ConsoleProgram{
	
	HashMap<String, ArrayList<String>> friendShip = new HashMap<String, ArrayList<String>>();
	
	public void run() {
		String line = "Arnolda 12 12";
		int nameLength = line.indexOf(" ");
		println(nameLength);
		String name = line.substring(0, 4);
		println(name);
		String scores = line.substring(nameLength);
		println(scores);
	}
	
	private String maxFriendsFinder(HashMap<String, ArrayList<String>> friends) {
		int maxFriendsNumber = 0;
		String maxPerson ="";
		for(String person : friends.keySet()) {
			if(friends.get(person).size() > maxFriendsNumber) {
				maxFriendsNumber = friends.get(person).size();
				maxPerson = person;
			}
		}
		return maxPerson;
	}
	
	private void printFriendsList() {
		HashMap<String, ArrayList<String>> friends = readData();
		for(String person : friends.keySet()) {
			String line = "";
			for(String friend : friends.get(person)) {
				if(line.equals("")) {
					line = line + friend;
				} else {
					line = line + ", " + friend;
				}
				
			}
			println(person +" " + line);
		}
		println(maxFriendsFinder(friends) + " has max friends");
		ArrayList<String> notRelatedPeople = areNotRelated(friends);
		for(String i : notRelatedPeople) {
			println(i);
		}
	}
	
	private ArrayList<String> areNotRelated(HashMap<String, ArrayList<String>> friends) {
		ArrayList<String> result = new ArrayList<String>();
		for(String personOne : friends.keySet()) {
			for(String personTwo : friends.keySet()) {
				if(!personOne.equals(personTwo)) {
					if(dontHaveCommonFriend(friends.get(personOne), friends.get(personTwo))) {
						String temp = personOne + " " + personTwo;
						if(!result.contains(personTwo + " " + personOne)) result.add(temp);
					}
				}
			}
		}
		return result;
	}
	
	private boolean dontHaveCommonFriend(ArrayList<String> arr1, ArrayList<String> arr2) {
		for(String i : arr1) {
			for(String j : arr2) {
				if(i.equals(j)) return false;
			}
		}
		return true;
	}
	
	
	
	private HashMap<String, ArrayList<String>> readData(){
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		while(true) {
			String line = readLine("Enter friends pair: ");
			
			if(line.equals("")) break;
			
			String[] splitData = line.split(" ");
			String friend = splitData[0];
			String person = splitData[1];
			
			if(map.containsKey(person)) {
				map.get(person).add(friend);
			} else {
				ArrayList<String> friends = new ArrayList<String>();
				friends.add(friend);
				map.put(person, friends);
			}
		}
		return map;
	}
}
