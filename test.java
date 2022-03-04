import java.util.ArrayList;
import java.io.*;
import java.util.*;

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class test extends ConsoleProgram {

	public void run() {
		first();
		for(int i=0; i<testArr.length; i++) {
			println(testArr[i][i]);
		}
		
	}
	
	public void first() {
		second();
		testArr[0][0] = testArr[0][0]/2;
	}
	
	public void second() {
		testArr = new double[1][1];
		testArr[0][0] = 5;
	}
	
	
	double[][] testArr;
}
