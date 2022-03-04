
private void badsort(int[] arr) {
	RandomGenerator rgen = new RandomGenerator();
	
	while(massiveIsNotSorted(arr)){
		swapElements(arr, rgen.nextInt(0, arr.length-1), rgen.nextInt(0, arr.length-1);
	}
	
}

private boolean massiveIsNotSorted(int[] arr) {
	for(int i=0 ; i<arr.length-1 ; i++){
	    if(arr[i] > arr[i+1]) return true;
	}
	
	return false;
}

private void swapElements(int[] arr, int M, int N){
	
	
	int right = math.max(M, N);
	int left = math.min(M, N);
	
	int saveRight = arr[right];
	int saveLeft = arr[left];

	if(saveLeft > saveRight){
		arr[left] = saveRight;
		arr[right] = saveLeft;
	}
}