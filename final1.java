import java.util.ArrayList;
import java.io.*;
import java.util.*;

import acm.io.*;
import acm.program.*;
import acm.util.*;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class final1 extends ConsoleProgram {

	RandomGenerator rgen = new RandomGenerator();
	private final static int games = 10000;
	private static final double n = 1000;
	
	public void run() {
		println(average());
	
	}
	
	private double average() {
		double sum = 0;
		for(int i=0; i<games ; i++) {
			sum = sum + oneGame();
		}
		return sum/games;
	}
	
	private int oneGame() {
		double money = n;
		int steps = 0;
		
		while(money > 0) {
			double bet = 0;
			if(money >= n)  {
				bet = 1;
			} else {
				bet = (n-money + 1) / 36;
			}
			
			money = money - bet;
			
			int bettingNumber = rgen.nextInt(0, 36);
			int winningNumber = rgen.nextInt(0, 36);
			
			if(bettingNumber == winningNumber) money = money + bet * 36;
			steps++;
		}
		
		return steps;
	}
}
