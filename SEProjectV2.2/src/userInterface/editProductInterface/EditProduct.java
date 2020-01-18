package userInterface.editProductInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Exception;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class EditProduct extends AddProduct{
	int row;
	public EditProduct(int row) {
		super();
		this.row=row;
		this.addProduct.setText("Speichern");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//editProduct Events	
		if(e.getSource() == this.addProduct) { //Add Product to Database&Table
			this.addProduct();
			this.editProduct(row);
		}	
	}  
	public void editProduct(int index) {
		 
		descriptionTF.setText((String) start.Main.table.model.getValueAt(index, 1));
		weightTF.setText((String) start.Main.table.model.getValueAt(index, 6));
		quantityTF.setText((String) start.Main.table.model.getValueAt(index, 2));
		stocknumberTF.setText((String) start.Main.table.model.getValueAt(index, 5));
		priceTF.setText((String) start.Main.table.model.getValueAt(index, 4));
		newCategoryTF.setText((String) start.Main.table.model.getValueAt(index, 3));
		//addProductToShelf();
		//if (Fehlermeldungen.isEmpty()) {start.Main.table.remove(index);}
	}
	
	public void deleteProduct() {
		
	}
}
