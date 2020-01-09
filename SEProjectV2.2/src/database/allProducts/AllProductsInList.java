package database.allProducts;

import start.Main;
import java.util.ArrayList;

public class AllProductsInList extends AllProducts{ // Class for List Output
	
	private ArrayList<String> databaseAsString = new ArrayList<String>();
	
	public AllProductsInList(){
		super();
		createStringArray();
	}

	public void search(String toFind) {
		resetList();
		int foundObjectIndex = databaseAsString.indexOf(toFind);
		while (foundObjectIndex > -1) {
				this.shelfs.remove(foundObjectIndex);
				this.databaseAsString.remove(foundObjectIndex);
				foundObjectIndex = databaseAsString.indexOf(toFind);
		}
	}
	
	private void resetList() {
		this.shelfs = Main.Datenbank.shelfs; 
		createStringArray();
	}
	
	private void createStringArray() {
		databaseAsString.clear();
		for (int ii = 0; ii < 999 ; ii++) {
			databaseAsString.addAll(shelfs.get(ii).getStringOfShelf());
		}
	}
}
