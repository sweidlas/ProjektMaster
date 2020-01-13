package userInterface.addProductInterface;

import java.lang.Exception;

@SuppressWarnings("serial")
public class AddProduct extends Interface {
	
	// view of the window
	public AddProduct (){
		super();	
	} // addProduct	
	
	public int addProductToShelf() {
     	
		String name = quantityTF.getText();
		String weight= weightTF.getText();
		String quantity= quantityTF.getText();
		String number= stocknumberTF.getText();
		String price= priceTF.getText();
		String category= newCategoryTF.getText();


 		try {
 			//Syntax Tests while creating p in Product Class
 			database.singleProduct.Product p = new	database.singleProduct.Product(name, weight, quantity, price, number, category);
 			if (p.Fehlermeldungen.isEmpty()) {
 				int ShelfNr = Integer.parseInt(number)/1000;	
 				start.Main.List.addProduct(ShelfNr,p); 
 				this.dispose();
 			}
 		} catch (Exception exception) {
 			new exeptions.Exception(exception.getMessage());
 		} 


 		return 0;
 	}
 	
	
} // public class addProduct
