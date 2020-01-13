package database.shelf;

import java.util.ArrayList;

import database.singleProduct.Product;

import java.lang.Exception;

public class Shelf { //Class for the Single S

	private ArrayList<Product> shelfContent = new ArrayList<Product>();
	//Workload in decigram >> Max 10Tones == 100.000.000 decigram
	private int workload = 0; 

	
	public Shelf() {}
	
	public void addProduct(Product newProduct) throws Exception{	
		int newLoad = Integer.parseInt(newProduct.getAmount())*Integer.parseInt(newProduct.getWeight());
		//can't overload the shelf
		try {
			addLoad(newLoad);
			shelfContent.add(newProduct); //Throws Exception if Load to Heavy;	
		} catch (Exception e) {throw e;}		
	}

	public void removeProduct(Product toRemove) {
		shelfContent.remove(toRemove);
		this.workload -= Integer.parseInt(toRemove.getAmount())*Integer.parseInt(toRemove.getWeight());	
	}
	
	private void addLoad(int newLoad) throws Exception{
		if (this.workload + newLoad > 100000000) {
			throw new Exception("Regal wäre überladen, Aktion nicht Ausgeführt");
		} else {
		this.workload += newLoad;
		}
	}

	public ArrayList<String> getStringOfShelf() {
		ArrayList<String> shelfContentAsString = new ArrayList<String>();
		for (int ii = 0; shelfContent.size() > ii ; ii++) {
			shelfContentAsString.addAll(shelfContent.get(ii).productToString());
			}
		return shelfContentAsString;
	}

}
