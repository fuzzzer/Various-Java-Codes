import java.util.ArrayList;
import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;


public class afterEX56 extends ConsoleProgram {

	ArrayList<Integer> stack = new ArrayList<Integer>();
	ArrayList<Integer> sortedNumbers = new ArrayList<Integer>();
	
	public void run() {
		int[][] categoryCounter = new int[3][5];
		for(int i=0 ; i<3 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				println(categoryCounter[i][j]);
				
			}
		}
	}
	
	/**
	 * Ex:56
	 */
	private void printSorted() {
		int N = readInt("please enter how many numbers will you be entering: ");
		for(int i=0 ; i<N ; i++) {
			int currentNumber = readInt("enter number: ");
			stack.add(currentNumber);
		}		
		sortArray();
		println("The numbers you entered sorted in ascending order are: ");
		println(sortedNumbers);
	}
	
	private void sortArray() {
		for(int i = getMin(stack) ; i < getMax(stack) + 1 ; i++) {
			if(stack.contains(i)) sortedNumbers.add(i);
		}
	}
	
	private int getMin(ArrayList list) {
		int min = (Integer) list.get(0);
		if(list.size() > 1) {
			for(int i=1 ; i<list.size() ; i++) {
				min = Math.min(min, (Integer) list.get(i));
			}
		}
		return min;
	}
	
	private int getMax(ArrayList list) {
		int max = (Integer) list.get(0);
		if(list.size() > 1) {
			for(int i=1 ; i<list.size() ; i++) {
				max = Math.max(max, (Integer) list.get(i));
			}
		}
		return max;
	}
	
	/**
	 * Ex:57
	 */
	private boolean isAnagram(String str1 , String str2) {
		ArrayList<Integer> String1 = new ArrayList<Integer>();
		ArrayList<Integer> String2 = new ArrayList<Integer>();
		String letters = "abcdefghijklmnopqrstuwxyz";
		for(int i=0 ; i<letters.length() ; i++) {
			String1.add(countInstance(str1 , letters.charAt(i)));
			String2.add(countInstance(str2 , letters.charAt(i)));
		}
		if(String1.equals(String2)) {
			return true;
		} else {
			return false;
		}
	}
	
	private int countInstance(String str , char ch) {
		int result = 0;
		for(int i=0 ; i<str.length() ; i++) {
			if(str.charAt(i) == ch)  result++;
		}
		return result;
	}
	
	/**
	 * Ex:58
	 */
	private boolean magicMatrix(int[][] matrix) {
		if(matrix[0].length != matrix.length) return false;
		ArrayList<Integer> storage = new ArrayList<Integer>();
		int N = matrix.length;
		for(int i=0 ; i< N ; i++) {
			for(int j=0 ; j<N ; j++) {
					storage.add(matrix[i][j]);
			}
		}
		for(int i=1 ; i<N * N + 1; i++) {
				if(!storage.contains(i)) return false;
		}
	
		return true;
	}

	/**
	 * Ex 59 done right
	 */
	private int maxSubMatrixOfOnes(int[][] matrix) {
		ArrayList<Integer> subMatrixSizes = new ArrayList<Integer>();
		for(int i=0 ; i< matrix.length ; i++) {
			for(int j=0 ; j< matrix[i].length ; j++) {
				subMatrixSizes.add(allPossibleSubMatrixSizes(matrix, i, j));
			}
		}
		return getMaxFromArray(subMatrixSizes);
	}
	
	private int allPossibleSubMatrixSizes(int[][] arr, int i, int j) {
		ArrayList<Integer> everyCombination = new ArrayList<Integer>();
		int tempI = i;
		int tempJ = j;
		while(tempI < arr.length &&  arr[tempI][tempJ] != 0 ) {
			tempJ++;
			if(tempJ == arr[tempI].length || arr[tempI][tempJ] == 0) {
				if(tempI > i) {
					if(tempJ - j < everyCombination.get(tempI - i - 1) / (tempI - i)) {
						int tempCount = (tempJ - j ) * (tempI - i + 1);
						everyCombination.add(tempCount);
					} else {
						int tempCount = everyCombination.get(tempI - i - 1) +  everyCombination.get(tempI - i - 1) / (tempI - i);
						everyCombination.add(tempCount);
					}
				} else {
					everyCombination.add(tempJ - j);
				}
				tempI++;
				tempJ = j;
			}
			
		}
		return getMaxFromArray(everyCombination);
		
	}
	
	private int getMaxFromArray(ArrayList arr) {
		int result = 0;
		for(int i=0 ; i<arr.size() ; i++) {
			result = Math.max((int) arr.get(i) , result);
		}
		return result;
	}
	
	/**
	 * Ex:60
	 */
	private void reverseOrder() {
		ArrayList<Double> storage = new ArrayList<Double>();
		while(true) {
			double temp = readDouble("enter next number: ");
			if(temp == -1) break;
			storage.add(temp);
		}
		for(int i = storage.size() - 1 ; i >= 0 ; i--) {
			if(storage.get(i) % 1 == 0) {
				double k = storage.get(i);
				int m = (int) k;
				println( m );
			} else {
				println(storage.get(i));
			}
			
		}
	}
	
	/**
	 * Ex:61
	 */
	private void findSum() {
		int m = readInt("Enter M: ");
		int n = readInt("Enter N: ");
		ArrayList<Integer> storage = new ArrayList<Integer>();
		for(int i=0 ; i<n ; i++) {
			storage.add(readInt("Enter next numer: "));
		}
		findSumInArray(m, storage);
	}
	
	private void findSumInArray(int m, ArrayList storage) {
		int combinationCounter = 0;
		for(int i=0 ; i<storage.size(); i++) {
			for(int j=i+1 ; j<storage.size(); j++) {
				if( (int) storage.get(i) + (int) storage.get(j) == m) {
					println(i + "-th number: " + storage.get(i) + " and " + j + "-th number" + storage.get(j) + " gives together: " + m);
					combinationCounter++;
				}
			}
		}
		println("From numbers you enetered " + combinationCounter + " different sums are possible.");
	}
	
	/**
	 * Ex:62
	 */
	private void countNames() {
		ArrayList<String> nameBase = new ArrayList<String>();
		while(true) {
			String temp = readLine();
			if(temp.equals("")) break;
			nameBase.add(temp);
		}
		findSameStringsInArray(nameBase);
	}
	
	private void findSameStringsInArray(ArrayList nameBase){
		ArrayList<String> uniqueNames = new ArrayList<String>();
		ArrayList<Integer> instanceNumbers = new ArrayList<Integer>();
		for(int i=0 ; i<nameBase.size(); i++) {
			String temp = nameBase.get(i).toString();
			int instanceNum = findStringInstance(nameBase, temp);
			if(!uniqueNames.contains(temp)) {
				uniqueNames.add(temp);
				instanceNumbers.add(instanceNum);
			}
			
		}
		for(int i=0 ; i<uniqueNames.size() ; i++) {
			println(uniqueNames.get(i) + " " + instanceNumbers.get(i) + " times.");
		}
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
	
	
	private void isStraight() {
		int[] ascendingOrder = new int[5];
		int saved = 0;
		while(saved < 5) {
			for(int i=1 ; i<=6 ;i++) {
				for(int j=0 ; j<5 ; j++) {
					if(i == dice[j]) {
						ascendingOrder[saved] = i;
						saved++;
					}
				}
			}
		}
		int maxLengthStraight = 1;
		int temp = 1;
		for(int i=0 ; i<5-1 ; i++) {
			int lastDiff = ascendingOrder[i+1] - ascendingOrder[i];
			if(lastDiff == 1) {
				temp++;
			} else {
				maxLengthStraight = Math.max(maxLengthStraight, temp);
				temp = 1;
			}
		}
		println(ascendingOrder);
		
	}
	
	private int[] sortInAscendingOrder(int[] arr) {
		int[] result = new int[5];
		int saved = 0;
		while(saved < 5) {
			for(int i=1 ; i<=getMax(arr) ;i++) {
				for(int j=0 ; j<5 ; j++) {
					if(i == arr[j]) {
						result[saved] = i;
						saved++;
					}
				}
			}
		}
		return result;
	}
	
	private int getMax(int[] list) {
		int max = list[0];
		if(list.length > 1) {
			for(int i=1 ; i<list.length ; i++) {
				max = Math.max(max, list[i]);
			}
		}
		return max;
	}
	
	private void rollDice() {
		for(int i=0 ; i<5 ; i++) {
				dice[i] = i+1;
		}
	}
	
	
	private int[] dice;
	
}

