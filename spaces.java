
private String asteroidsDestroyed (String text, int[] spaces) {
	for(int i=0 ; i<spaces.length ; i++){
		int currentCoefficient = spaces[i];
		text = addSpace(String text, currentCoefficient);
		for(int j=i+1 ; j<spaces.length ; j++){
			spaces[j] = spaces[j] + 1;
		}
	}
	return text;
}

private String addSpace(String text,int coefficient) {
	String result = "";
	String firstPart = text.subString(0, coefficient);
	String secondPart = "";
	if(text.length > coefficient) secondPart = text.subString(coefficient);
	
	result = firstPart + " " + secondPart;
}