package database.singleProduct;

import java.util.ArrayList;

public class Product extends ProductData{ //Class of Single Products


	public Product(String name, String weight, String quantity, String price,
			String number, String category)  {
	
 	    	setProductData(name, weight, quantity, price, number, category);
	}
	
	
	public ArrayList<String> productToString() {
		ArrayList<String> productAsString = new ArrayList<String>();
		productAsString.add(getName());
		productAsString.add(getWeight());
		productAsString.add(getAmount());
		productAsString.add(getPrice());
		productAsString.add(getNumber());
		productAsString.add(getCategory());
		return productAsString;
	}  
}	
