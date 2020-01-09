package start;

public class Main {

	public static database.allProducts.AllProducts Datenbank = new database.allProducts.AllProducts();
	public static database.allProducts.AllProductsInList List = new database.allProducts.AllProductsInList();
	
	public static void main(String[] args) {
		userInterface.mainWindow.MainWindow myMainWindow = new userInterface.mainWindow.MainWindow (); 
		//start.userInterface.productView.ProductView myProductView = new start.userInterface.productView.ProductView (); 
		//exeptions.Exception myException1 = new exeptions.Exception ("there is a Problem");
	}

}
