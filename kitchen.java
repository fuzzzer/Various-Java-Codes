
private ArrayList<String> kitchen(Map<String, ArrayList<String>> receipts, ArrayList<String> ingredients) {
	int totalFoods = receipts.keySet().size();
	int checkedFoods = 0;
	
	ArrayList<String> result = new ArrayList<String>();
	
	while(checkedFoods < TotalFoods){
		
		HashMap<String,ArrayList<String>> primitiveFoods = findPrimitiveFoodsThatCanBeMade(receipts, ingredients);
		
		for(String currPrimitiveFood : primitiveFoods.keySet()){
			if(canBeMadeWithIngredientsWeHave(primitiveFoods.get(currPrimitiveFood), ingredients)){
				
				result.add(currPrimitiveFood);
				ingredients.add(currPrimitiveFood);
				
			
		    }
			
			receipts.remove(currPrimitiveFood);
			checkedFoods++;
			
		}
	}
	
	
	
	return result;
}

private HashMap<String,ArrayList<String>> findPrimitiveFoodsThatCanBeMade(findPrimitiveFoods(Map<String, ArrayList<String>> receipts, ArrayList<String> ingredients)){
	ArrayList<String> primitiveIngredients = new ArrayList<String>();
	HashMap<String,ArrayList<String>> result = new HashMap<String,ArrayList<String>>();
	
	for(String currFood : receipts.keySet()){
		for(String currIngredient : receipts.get(currFood)){
			Set<String> allFoods = receipts.keySet();
			if(!allFoods.contains(currIngredient) && !primitiveIngredients.contains(currIngredient)) primitiveIngredients.add(currIngredient);
		}
	}
	
	for(String currFood : receipts.keySet()){
		if(canBeMadeWithPrimitiveIngredients(receipts.get(currFood), primitiveIngredients)){
			result.put(currFood, receipts.get(currFood);
		}
	}
	
	return result;
	
}

private boolean canBeMadeWithPrimitiveIngredients(ArrayList<String> ingredientsNeeded, ArrayList<String> primitiveIngredients)){
	for(String ingr : ingredientsNeeded){
		if(!primitiveIngredients.contains(ingr)) return false;
	}
	return true;
}

private boolean canBeMadeWithIngredientsWeHave(ArrayList<String> ingredientsNeeded, primitiveIngredients)){
	for(String ingr : ingredientsNeeded){
		if(!primitiveIngredients.contains(ingr)) return false;
	}
	return true;
}
