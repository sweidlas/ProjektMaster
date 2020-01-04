package start.database.allProducts;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import start.database.shelf.Shelf;
import start.database.singleProduct.Product;

public class AllProducts {
	
	private ArrayList<Shelf> Shelfs = new ArrayList<Shelf>();
	
	public AllProducts(){
		initilize();
	}
	
	private void initilize() {
		//Load Savefile
		for (int ii=0; ii<999; ii++) {
			Shelf newShelf = new Shelf();
			Shelfs.add(newShelf);
		}
	}
	
	
	
	
	
	/*public void save() {				
		// for testing
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			FileWriter writer = new FileWriter(formatter.format(new Date()));
			// save to specific file
			//FileWriter writer = new FileWriter("specificfile");
			for (Product p : data) {
				writer.write(p.getDescription() + "\n");
				writer.write(p.getCategory() + "\n");
				writer.write(p.getQuantity() + "\n");
				writer.write(p.getWeight() + "\n");
				writer.write(p.getPrice() + "\n");
				writer.write(p.getStockNumber() + "\n");
			}
			writer.close();
		}
		catch (IOException e) {
			System.out.println("got it:\n" + e.getMessage());
		}	
	} //save*/
}
