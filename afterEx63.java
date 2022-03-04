import java.util.ArrayList;
import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;
import java.util.StringTokenizer;


public class afterEx63 extends ConsoleProgram {
	
	public void run() {
		int[] k = {10, 13, 27};
		int[] j = {2, 3, 7};
		k = j;
		for(int i=0 ; i<k.length ; i++) {
			println(k[i]);
		}
	}
	
	/**
	 * Ex:63
	 */
	private void countFriends() {
		ArrayList<String> friends = new ArrayList<String>();
		ArrayList<String> persons = new ArrayList<String>();
		while(true) {
			String temp = readLine();
			if(temp.equals("")) break;
			StringTokenizer st = new StringTokenizer(temp);
			friends.add(st.nextToken());
			persons.add(st.nextToken());
		}
		doThings(friends, persons);
	}
	
	private void doThings(ArrayList friends, ArrayList persons){
		ArrayList<String> uniqueNames = new ArrayList<String>();
		ArrayList<Integer> instanceNumbers = new ArrayList<Integer>();
		for(int i=0 ; i<persons.size(); i++) {
			String temp = persons.get(i).toString();
			int instanceNum = findStringInstance(persons, temp);
			if(!checkPreviuosInstance(persons, temp, i)) {
				instanceNumbers.add(instanceNum);
				uniqueNames.add(temp + " has " + instanceNum + " friends: " + allFriends(friends, persons, temp));
				
			}
			
		}
		for(int i=0 ; i<uniqueNames.size() ; i++) {
			println(uniqueNames.get(i));
		}
		printMaxFriendsNumber(uniqueNames, instanceNumbers);
		printMostWantedFriend(friends);
		findTwoWithoutCommonFriend(friends, persons);
	}
	
	private void printMostWantedFriend(ArrayList friends) {
		ArrayList<Integer> instanceNumbers = new ArrayList<Integer>();
		for(int i=0 ; i<friends.size(); i++) {
			String temp = friends.get(i).toString();
			int instanceNum = findStringInstance(friends, temp);
			instanceNumbers.add(instanceNum);
		}
		int location = locationOfMaxNumber(instanceNumbers);
		println(friends.get(location) + " is most wanted person. " + instanceNumbers.get(location) + " people thinks of him as a frinend.");
	}
	
	private void printMaxFriendsNumber(ArrayList uniqueNames, ArrayList instanceNumbers) {
		int N = locationOfMaxNumber(instanceNumbers);
		String mostSociable = uniqueNames.get(N).toString();
		StringTokenizer st = new StringTokenizer(mostSociable);
		String mostSociableName = st.nextToken();
		println(mostSociableName + " has the most friends, totally: " + instanceNumbers.get(N));
	}
	
	private int locationOfMaxNumber( ArrayList arr) {
		int max = 0;
		for(int i=0 ; i<arr.size(); i++) {
			max = Math.max(max, (int) arr.get(i));
		}
		int result = arr.indexOf(max);
		return result;
	}
	
	private String allFriends(ArrayList friends, ArrayList persons, String temp) {
		String result = "";
		for(int i=0 ; i<persons.size() ; i++ ) {
			if(temp.equals(persons.get(i).toString()) && !result.equals("")) result = result + ", "  + friends.get(i).toString();
			if(temp.equals(persons.get(i).toString()) && result.equals("")) result = result  + friends.get(i).toString();
		}
		return result;
		
	}
	
	private int findStringInstance(ArrayList nameBase, String temp) {
		int result = 0;
		for(int i=0 ; i<nameBase.size() ; i++) {
			String current = nameBase.get(i).toString();
			if(current.equals(temp)) result++;
		}
		return result;
	}
	
	private boolean checkPreviuosInstance(ArrayList nameBase, String temp, int n) {
		for(int i=0 ; i<n ; i++) {
			String current = nameBase.get(i).toString();
			if(current.equals(temp)) return true;
		}
		return false;
	}
	
	
	/**
	 * Ex:66
	 */
	private void findTwoWithoutCommonFriend(ArrayList friends, ArrayList persons) {
		ArrayList<String> uniquePersonsList = createUniqueList(persons);
		int totalPersons = uniquePersonsList.size();
		for(int i=0 ; i<totalPersons ; i++ ) {
			for(int j = i + 1 ; j<totalPersons ; j++ ) {
				String personI = uniquePersonsList.get(i).toString();
				String personJ = uniquePersonsList.get(j).toString();
				ArrayList<String> friendsOfI = createFriendsList(friends, persons, personI);
				ArrayList<String> friendsOfJ = createFriendsList(friends, persons, personJ);
				if(!haveSameElement(friendsOfI, friendsOfJ)) println( personI + " and " + personJ + " do not have a common friend.");
				
			}
		}
		
	}
	
	private ArrayList<String> createUniqueList(ArrayList arr) {
		ArrayList<String> uniqueList = new ArrayList<String>();
		for(int i=0 ; i<arr.size(); i++) {
			String temp = arr.get(i).toString();
			if( !uniqueList.contains(temp)) uniqueList.add(temp);
		}
		return uniqueList;
	}
	
	private ArrayList<String> createFriendsList(ArrayList friends, ArrayList persons, String name) {
		int size = persons.size();
		ArrayList<String> friendsList = new ArrayList<String>();
		for(int i=0 ; i<size ; i++) {
			String tempPerson = persons.get(i).toString();
			String tempFriend = friends.get(i).toString();
			if(name.equals(tempPerson)) friendsList.add(tempFriend);
		}
		return friendsList;
	}
	
	private boolean haveSameElement(ArrayList arr1, ArrayList arr2) {
		for(int i=0 ; i<arr1.size() ; i++) {
			for(int j=0 ; j<arr2.size() ; j++) {
				if(arr1.get(i).equals(arr2.get(j))) return true;
			}
		}
		return false;
	}
	
	
	
	
	
}
