import java.util.ArrayList;
import java.io.*;
import java.util.*;

import acm.io.*;
import acm.program.*;
import acm.util.*;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;



public class Final extends ConsoleProgram {

	public void run() {
		String str = readLine("enter: ");
		str = rearrange(str);
		println(str);
	}
	
	private String rearrange(String str) {
		StringTokenizer tokenizer = new StringTokenizer(str);
		ArrayList<String> words = new ArrayList<String>();
		
		while(tokenizer.hasMoreTokens()) {
			String current = tokenizer.nextToken();
			words.add(current);
		}
		
		String result = reArrange(words);
		
		
		
		return result;
	}
	
	private String reArrange(ArrayList<String> list) {
		String result =  findAndRemoveSmallest(list);
		int size = list.size();
		
		while(list.size() != 0) {
			result = result + " " + findAndRemoveSmallest(list);
		}
		
		return result;
	}
	
	
	private String findAndRemoveSmallest(ArrayList<String> list) {
		String result;
		int coefficient = -1;
		
		int smallestLength = Integer.MAX_VALUE;
		for(int i=0 ; i<list.size(); i++) {
			if( list.get(i).length() < smallestLength ) {
				smallestLength = list.get(i).length();
				coefficient = i;
			}
		}
		
		result = list.get(coefficient);
		list.remove(coefficient);
		
		return result;
		
	}
}
