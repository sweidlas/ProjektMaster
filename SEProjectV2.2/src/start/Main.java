package start;

import javax.swing.SwingUtilities;

public class Main {

	public static database.allProducts.AllProductsInList List = new database.allProducts.AllProductsInList();
	
	public static void main(String[] args) {	
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new userInterface.mainWindow.MainWindow (); 
			}
			});
	}
}
