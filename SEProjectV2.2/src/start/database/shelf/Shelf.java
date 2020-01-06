package start.database.shelf;

import java.util.ArrayList;

import start.database.singleProduct.Product;

public class Shelf extends ShelfTests{

	private ArrayList<Product> shelfContent = new ArrayList<Product>();
	
	public Shelf() {	
	}
	
	public boolean addProductType(Product newProduct) {	
		int newLoad = newProduct.getAmount()*newProduct.getWeight();
		//can't overload the shelf
		if (testWeight(newLoad)) {
			shelfContent.add(newProduct);
			addLoad(newLoad);
			return true;
		}	else {System.out.println("Das Regal wäre mit dieser eingabe überlastet"); return false;}
	}
	
	public boolean changeProduct(Product oldVersion, Product newVersion) {
		remove(oldVersion);
		if (addProductType(newVersion)) {return true;}
		else {addProductType(oldVersion); return false;}
			
	
	}
	
	public void remove(Product toRemove) {
		shelfContent.remove(toRemove);
		this.workload -= toRemove.getAmount()*toRemove.getWeight();
		
	}
	
}
