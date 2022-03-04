
public class Car {
	// კონსტრუქტრი
	public Car(int gas, int kms){
		hasGas = gas;
		kmTravelled = kms;

	}

	public boolean turnOnAndDrive(int kmsToDrive){
                startUp();
		boolean result = false;
		if(!isBroken){
			if(KILOMETERS_PER_LITER * kmsToDrive <= hasGas){
				hasgas = hasGas - KILOMETERS_PER_LITER * kmsToDrive;
				kmTravelled = kmTravelled + kmsToDrive;
				result = true;
			} else {
				kmTravelled = kmTravelled + hasGas/KILOMETERS_PER_LITER;
				hasGas = 0;
			}
		}
		
		return result;

	}
	
	
	public int getMileage(){
		return kmTravelled;

	} 

	
	public boolean isBrokenDown(){
		return isBroken;

	}

	
	public void repair(){
		isBroken = false;

	}

	
	public void fillGas(double numberOfLiters){
		hasGas = hasGas + numberOfLiters;

	}
	
	private void testCar(){
		car myCar = new car(10, 0);
		while(!mycar.isBrokenDown){
			myCar.turnOnAndDrive(10);
			myCar.fillGas(10);
		}
		return myCar.getMileage();
	}


	private void startUp(){
                if(isBroken == false){
		double chanceOfBreakeing = findChance();
		isBroken = rgen.nextBoolean(chanceOfBreaking);
                }
	}

	private double findChance(){
		
		if(kmTravelled < 10000) return 0.1;
		if(kmTravelled < 20000) return 0.2;
		if(kmTravelled < 30000) return 0.3;
		if(kmTravelled < 40000) return 0.4;
		if(kmTravelled < 50000) return 0.5;
		if(kmTravelled < 60000) return 0.6;
		if(kmTravelled < 70000) return 0.7;
		if(kmTravelled < 80000) return 0.8;
		if(kmTravelled < 90000) return 0.9;
		
	    return 1;
		
		
	} 

	private double hasGas;
	private double kmTravelled;
	private boolean isBroken = false;

	private RandomGenerator rgen = new RandomGenerator();

	private final static double KILOMETERS_PER_LITER = 10;	
	
}






