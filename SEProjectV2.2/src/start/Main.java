package start;

import javax.swing.SwingUtilities;

public class Main {

	//public static database.allProducts.AllProducts Datenbank = new database.allProducts.AllProducts();
	public static database.allProducts.AllProductsInList List = new database.allProducts.AllProductsInList();
	
	public static void main(String[] args) {	
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//new userInterface.mainWindow.MainWindow (); 
				new userInterface.mainWindow.MainWindow (); 
				//userInterface.mainWindow.MainWindow myMainWindow = 
				//start.userInterface.productView.ProductView myProductView = new start.userInterface.productView.ProductView (); 
				//exeptions.Exception myException1 = new exeptions.Exception ("there is a Problem");
			}
			});
	}
}
