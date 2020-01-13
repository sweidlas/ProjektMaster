package database.allProducts;

import java.util.ArrayList;

public class AllProductsInList extends AllProducts{ // Class for List Output
	
	public ArrayList<String> databaseAsString = new ArrayList<String>();
	
	public AllProductsInList(){
		super();
		createStringArray();
	}

	public void search(String toFind) {
		createStringArray();
		int foundObjectIndex = databaseAsString.indexOf(toFind);
		while (foundObjectIndex > -1) {
				this.shelfs.remove(foundObjectIndex);
				this.databaseAsString.remove(foundObjectIndex);
				foundObjectIndex = databaseAsString.indexOf(toFind);
		}
	}
	
	public void reload() {
		createStringArray();
		
	}
	
	private void createStringArray() {
		databaseAsString.clear();
		for (int ii = 0; ii < 999 ; ii++) {
			databaseAsString.addAll(shelfs.get(ii).getStringOfShelf());
		}
		System.out.println(databaseAsString);
	}
}
