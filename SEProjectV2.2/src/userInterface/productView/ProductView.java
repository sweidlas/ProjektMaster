package userInterface.productView;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ProductView extends Frame implements ActionListener {

	Button deleteProduct;
	Button okay;
	
	public ProductView() {
		super ("Produktansicht"); // set title
		GridBagLayout myGBL = new GridBagLayout ();
		setLayout(myGBL);
		
		GridBagConstraints myGBC = new GridBagConstraints();
		setVisible (true);
		
		// generally
		myGBC.fill = GridBagConstraints.HORIZONTAL;
		myGBC.insets = new Insets(5,5,5,5) ; // distance to line: 5 above, 5 left, 5 below, 5 right 
		
		// Button deleteProduct
		myGBC.gridx = 0;
		myGBC.gridy = 10;
		myGBC.gridwidth = 2; // width of the element
		myGBC.gridheight = 1; // height of the element
		deleteProduct = new Button ("Produkt löschen");
		deleteProduct.setBackground(Color.red);
		deleteProduct.addActionListener(this);
		myGBL.setConstraints(deleteProduct, myGBC);
		add(deleteProduct);
		
		// Button okay
		myGBC.gridx = 3;
		myGBC.gridy = 9;
		myGBC.gridwidth = 1; // width of the element
		myGBC.gridheight = 1; // height of the element
		okay = new Button ("Okay");
		okay.setBackground(Color.green);
		okay.addActionListener (this);
		myGBL.setConstraints(okay, myGBC);
		add(okay);
		
		// description
		myGBC.gridx = 0;
		myGBC.gridy = 0;
		myGBC.gridwidth = 2; 
		myGBC.gridheight = 1; 
		Label description = new Label ("Produktbezeichnung: ");
		myGBL.setConstraints(description, myGBC);
		add(description);
		
		myGBC.gridx = 2;
		myGBC.gridy = 0;
		myGBC.gridwidth = 2; 
		myGBC.gridheight = 1; 
		TextField descriptionTF = new TextField (50);
		myGBL.setConstraints(descriptionTF, myGBC);
		add(descriptionTF);
		
		// weight
		myGBC.gridx = 0;
		myGBC.gridy = 1;
		myGBC.gridwidth = 2; 
		myGBC.gridheight = 1; 
		Label weight = new Label ("Gewicht (in g): ");
		myGBL.setConstraints(weight, myGBC);
		add(weight);
		
		myGBC.gridx = 2;
		myGBC.gridy = 1;
		myGBC.gridwidth = 2; 
		myGBC.gridheight = 1;
		TextField weightTF = new TextField (50);
		myGBL.setConstraints(weightTF, myGBC);
		add(weightTF);  
		
		// price
		myGBC.gridx = 0;
		myGBC.gridy = 2;
		myGBC.gridwidth = 2; 
		myGBC.gridheight = 1; 
		Label price = new Label ("Stückpreis(in Cent): ");
		myGBL.setConstraints(price, myGBC);
		add(price);
		
		myGBC.gridx = 2;
		myGBC.gridy = 2;
		myGBC.gridwidth = 2; 
		myGBC.gridheight = 1;
		TextField priceTF = new TextField (50);
		myGBL.setConstraints(priceTF, myGBC);
		add(priceTF);
		
		// category
		myGBC.gridx = 0;
		myGBC.gridy = 3;
		myGBC.gridwidth = 2; 
		myGBC.gridheight = 1; 
		Label category = new Label ("Kategorie: ");
		myGBL.setConstraints(category, myGBC);
		add(category);
		
		// stocknumber
		myGBC.gridx = 0;
		myGBC.gridy = 4;
		myGBC.gridwidth = 2; 
		myGBC.gridheight = 1; 
		Label stocknumber = new Label ("Lagernummer: ");
		myGBL.setConstraints(stocknumber, myGBC);
		add(stocknumber);
		
		myGBC.gridx = 2;
		myGBC.gridy = 4;
		myGBC.gridwidth = 2; 
		myGBC.gridheight = 1;
		TextField stocknumberTF = new TextField (50);
		myGBL.setConstraints(stocknumberTF, myGBC);
		add(stocknumberTF);
		
		// quantity
		myGBC.gridx = 0;
		myGBC.gridy = 5;
		myGBC.gridwidth = 2; 
		myGBC.gridheight = 1; 
		Label quantity = new Label ("Anzahl: "); // get.Quantity
		myGBL.setConstraints(quantity, myGBC);
		add(quantity);
		
		// add product
		myGBC.gridx = 0;
		myGBC.gridy = 6;
		myGBC.gridwidth = 2; 
		myGBC.gridheight = 1; 
		Label addProduct = new Label ("   Artikel hinzufügen: ");
		myGBL.setConstraints(addProduct, myGBC);
		add(addProduct);
		
		myGBC.gridx = 2;
		myGBC.gridy = 6;
		myGBC.gridwidth = 1; 
		myGBC.gridheight = 1;
		TextField addProductTF = new TextField (3);
		myGBL.setConstraints(addProductTF, myGBC);
		add(addProductTF);
		
		// delete product
		myGBC.gridx = 0;
		myGBC.gridy = 7;
		myGBC.gridwidth = 2; 
		myGBC.gridheight = 1; 
		Label deleteProduct = new Label ("   Artikel entnehmen: ");
		myGBL.setConstraints(deleteProduct, myGBC);
		add(deleteProduct);
		
		myGBC.gridx = 2;
		myGBC.gridy = 7  ;
		myGBC.gridwidth = 1; 
		myGBC.gridheight = 1;
		TextField deleteProductTF = new TextField (3);
		myGBL.setConstraints(deleteProductTF, myGBC);
		add(deleteProductTF);
		
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == deleteProduct || e.getSource() == okay )
		{
			this.dispose();
		}
		
	}

}
