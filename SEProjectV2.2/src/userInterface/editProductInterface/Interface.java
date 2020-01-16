package userInterface.editProductInterface;
/*
import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
*/
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Interface extends JFrame {
	   public Button addProduct;
	   protected TextField descriptionTF, weightTF, priceTF, newCategoryTF, stocknumberTF, quantityTF;
	   protected Label leereEingabeFM, descriptionFM, weightFM, priceFM, newCategoryFM, stocknumberFM, quantityFM;
	   GridBagConstraints myGBC;
	   GridBagLayout myGBL;
	   public Choice categories;


	   public Interface() {
	     super ("Produkt hinzufuegen"); // set title
	     myGBL = new GridBagLayout ();
	     setLayout(myGBL);

	     myGBC = new GridBagConstraints();
	     setVisible(true); 

	     // generally
	     myGBC.insets = new Insets(10,10,20,20) ; // distance to line: 5 above, 5 left, 5 below, 5 right 

	     // Button addProduct
	     myGBC.gridx = 4;
	     myGBC.gridy = 10;
	     myGBC.gridwidth = 1; // width of the element
	     myGBC.gridheight = 1; // height of the element
	     addProduct = new Button ("Produkt hinzufügen");
	     addProduct.setBackground(Color.green);
	     myGBL.setConstraints(addProduct, myGBC);
	     add(addProduct);

	     myGBC.gridx = 1;
	     myGBC.gridy = 10;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1; 
	     leereEingabeFM = new Label ("                                               ");
	     myGBL.setConstraints(leereEingabeFM, myGBC);
	     add(leereEingabeFM);

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
	     descriptionTF = new TextField (50);
	     myGBL.setConstraints(descriptionTF, myGBC);
	     add(descriptionTF);

	     myGBC.gridx = 4;
	     myGBC.gridy = 0;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1; 
	     descriptionFM = new Label ("                                               ");
	     myGBL.setConstraints(descriptionFM, myGBC);
	     add(descriptionFM);

	     // weight
	     myGBC.gridx = 0;
	     myGBC.gridy = 1;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1; 
	     Label weight = new Label ("Gewicht (in kg): ");
	     myGBL.setConstraints(weight, myGBC);
	     add(weight);

	     myGBC.gridx = 2;
	     myGBC.gridy = 1;
	     myGBC.gridwidth = 1; 
	     myGBC.gridheight = 1;
	     weightTF = new TextField (6);
	     myGBL.setConstraints(weightTF, myGBC);
	     add(weightTF); 

	     myGBC.gridx = 3;
	     myGBC.gridy = 1;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1; 
	     weightFM = new Label ("                                               ");
	     myGBL.setConstraints(weightFM, myGBC);
	     add(weightFM);

	     // price
	     myGBC.gridx = 0;
	     myGBC.gridy = 2;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1; 
	     Label price = new Label ("Stueckpreis(€): ");
	     myGBL.setConstraints(price, myGBC);
	     add(price);

	     myGBC.gridx = 2;
	     myGBC.gridy = 2;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1;
	     priceTF = new TextField (50);
	     myGBL.setConstraints(priceTF, myGBC);
	     add(priceTF);

	     myGBC.gridx = 4;
	     myGBC.gridy = 2;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1; 
	     priceFM = new Label ("                                               ");
	     myGBL.setConstraints(priceFM, myGBC);
	     add(priceFM);

	     // category
	     myGBC.gridx = 0;
	     myGBC.gridy = 3;
	     myGBC.gridwidth = 1; 
	     myGBC.gridheight = 1; 
	     Label category = new Label ("Kategorie: ");
	     myGBL.setConstraints(category, myGBC);
	     add(category);
	     
	     myGBC.gridx = 1;
	     myGBC.gridy = 3;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1;
	     categories = new Choice();

	     /*
	   categories.add("Java");
	   categories.add("C");
	   categories.add("VB");
	   categories.add("Perl");*/
	  myGBL.setConstraints(categories, myGBC);
	   for (String h: start.Main.categoryList) {
		   categories.add(h);
	   }
	   add(categories);
	// new category
	   
	     myGBC.gridx = 0;
	     myGBC.gridy = 4;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1; 
	     Label newCategory = new Label ("   neue Kategorie: ");
	     myGBL.setConstraints(newCategory, myGBC);
	     add(newCategory);
	     /*
	     myGBC.gridx = 2;
	     myGBC.gridy = 4;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1;
	     newCategoryTF = new TextField (50);
	     myGBL.setConstraints(newCategoryTF, myGBC);
	     add(newCategoryTF);

	     myGBC.gridx = 4;
	     myGBC.gridy = 4;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1; 
	     newCategoryFM = new Label ("                                               ");
	     myGBL.setConstraints(newCategoryFM, myGBC);
	     add(newCategoryFM);*/

	     // stocknumber
	     myGBC.gridx = 0;
	     myGBC.gridy = 5;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1; 
	     Label stocknumber = new Label ("Lagernummer: ");
	     myGBL.setConstraints(stocknumber, myGBC);
	     add(stocknumber);

	     myGBC.gridx = 2;
	     myGBC.gridy = 5;
	     myGBC.gridwidth = 1;  // enough space?
	     myGBC.gridheight = 1;
	     stocknumberTF = new TextField (6);
	     myGBL.setConstraints(stocknumberTF, myGBC);
	     add(stocknumberTF);

	     myGBC.gridx = 3;
	     myGBC.gridy = 5;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1; 
	     stocknumberFM = new Label ("                                               ");
	     myGBL.setConstraints(stocknumberFM, myGBC);
	     add(stocknumberFM);

	     // quantity
	     myGBC.gridx = 0;
	     myGBC.gridy = 6;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1; 
	     Label quantity = new Label ("Anzahl: "); // get.Quantity
	     myGBL.setConstraints(quantity, myGBC);
	     add(quantity);

	     myGBC.gridx = 2;
	     myGBC.gridy = 6;
	     myGBC.gridwidth = 1; 
	     myGBC.gridheight = 1;
	     quantityTF = new TextField (3);
	     myGBL.setConstraints(quantityTF, myGBC);
	     add(quantityTF);

	     myGBC.gridx = 3;
	     myGBC.gridy = 6;
	     myGBC.gridwidth = 2; 
	     myGBC.gridheight = 1; 
	     quantityFM = new Label ("                                               "); // get.Quantity
	     myGBL.setConstraints(quantityFM, myGBC);
	     add(quantityFM);

	     pack();
	   }
}
