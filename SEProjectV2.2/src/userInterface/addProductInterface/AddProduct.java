package userInterface.addProductInterface;

import java.awt.event.ActionEvent;
import java.lang.Exception;

import database.singleProduct.Product;

import java.awt.Button;

@SuppressWarnings("serial")
public class AddProduct extends Interface {
	
	// view of the window
	public AddProduct (){
		super();	
	} // addProduct	
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == addProduct ) {
			//TODO Use Textfields to Create Product
			String name ="";
			int weight=0;
			int amount=0;
			int number=0;
			int price=0;
			String category="";
			Product p = new	Product(name, weight, amount, price, number, category);
			int ShelfNr = number/1000;
			
			try {start.Main.Datenbank.addProduct(ShelfNr,p); this.dispose();
			} catch (Exception exception) {
				exeptions.Exception newException = new exeptions.Exception(exception.getMessage());
			}
			
		}
	}
	
} // public class addProduct
