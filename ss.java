

import acm.program.*;

import java.util.List;
import java.util.*;

public class ss extends ConsoleProgram{
	
	
	public void run() {
		List<Integer> result = new ArrayList<Integer>();
		result.add(1);
		result.add(2);
		result.add(3);
		result.add(1);
		result.add(-1);
		result.add(50);
		result.add(50);
		result.add(-1);
		result.add(50);
		
		println(findDuplicates(result, 2));
	}
	

    public List<Integer> findDuplicates(List<Integer> integers, int numberOfDuplicates) {
        
    	List<Integer> result = new ArrayList<Integer>();
        
        for(int i=0; i < integers.size(); i++){
            int temp = integers.get(i);
            if(!result.contains(temp)  && numberOfInstances(integers, temp) == numberOfDuplicates) result.add(temp);
        }
        
        
        return result;
    }
    
    private int numberOfInstances(List<Integer> integers, int n){
        int count = 0;
        for(int i=0 ; i < integers.size() ; i++){
            int temp = integers.get(i);
            if(temp == n) count++;
        }
        
        return count;
    }


}


