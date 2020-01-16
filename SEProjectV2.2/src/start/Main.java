package start;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import userInterface.mainWindow.DataTable;

public class Main {

	//public static database.allProducts.AllProducts List = new database.allProducts.AllProducts();
	public static ArrayList<String> categoryList = new ArrayList<String>();
	public static DataTable table = new DataTable();
	
	public static void main(String[] args) {	
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new userInterface.mainWindow.MainWindow (); 
			}
			});
	}
}
