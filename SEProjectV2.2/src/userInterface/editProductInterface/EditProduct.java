/*

package userInterface.editProductInterface;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Exception;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import  javax.swing.*;


@SuppressWarnings("serial")
public class EditProduct extends AddProduct implements ActionListener{
	int row;
	JButton deleteProduct;
	JLabel currentQuantity;
	
	
	
	public EditProduct(int row) {
		super();
		this.setName("Produkt verändern");
		this.row=row;
		this.addProduct.setText("Speichern");
		this.editProduct(row);
		quantityTF.setVisible(false);
			
	     myGBC.gridx = 1;
	     myGBC.gridy = 10;
	     myGBC.gridwidth = 1; // width of the element
	     myGBC.gridheight = 1; // height of the element
	     deleteProduct = new JButton ("Produkt löschen");
	     deleteProduct.setBackground(Color.red);
	     myGBL.setConstraints(deleteProduct, myGBC);
	     add(deleteProduct);
	     deleteProduct.addActionListener(this);
	     
	     myGBC.gridx = 0;
	     myGBC.gridy = 3;
	     myGBC.gridwidth = 1; 
	     myGBC.gridheight = 1; 
	     Label currentQuantity = new Label ("Kategorie: ");
	     myGBL.setConstraints(currentQuantity, myGBC);
	     add(currentQuantity);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//editProduct Events
		System.out.println(e.getSource());
		if(e.getSource() == this.addProduct) { //speicher button
			//start.Main.table.model.removeRow(row);
			this.addProduct();	
		} else if (e.getSource() == this.deleteProduct) {
			//new YesNoPopup();
			deleteProduct(row);
		}
		System.out.println(e.getActionCommand()+" pressed in MainFrame");
		
	}
	


	

	
	public void editProduct(int index) {
		  
		  System.out.println(row);
		  descriptionTF.setText(start.Main.table.model.getValueAt(index, 0).toString());
		  weightTF.setText(start.Main.table.model.getValueAt(index, 3).toString());
		  quantityTF.setText(start.Main.table.model.getValueAt(index, 5).toString());
		  stocknumberTF.setText(start.Main.table.model.getValueAt(index, 2).toString());
		  priceTF.setText(start.Main.table.model.getValueAt(index, 4).toString());
		  //newCategoryTF.setText(start.Main.table.model.getValueAt(index, 2).toString());
	}
	
	public void deleteProduct(int row) {
		int reply = JOptionPane.showConfirmDialog(this, "Dieses Produkt löschen?", "Dieses Produkt löschen?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);;
	    if (reply == JOptionPane.YES_OPTION) {
	    	start.Main.table.model.removeRow(row);
	    	this.dispose();
	    }
		
	}

}

*/








package userInterface.editProductInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Exception;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class EditProduct extends AddProduct implements ActionListener{
  int row;
  JButton deleteProduct;
  Label currentQuantity, quantityAdd, quantitySub;
  TextField quantityAddTF, quantitySubTF;
  
  
public EditProduct(int row) {
	super();
	this.setName("Produkt verändern");
	this.row=row;
	this.addProduct.setText("Speichern");
	quantityTF.setVisible(false);
	
     
	myGBC.gridx = 1;
	myGBC.gridy = 10;
	myGBC.gridwidth = 1; // width of the element
	myGBC.gridheight = 1; // height of the element
	deleteProduct = new JButton ("Produkt löschen");
	deleteProduct.setBackground(Color.red);
	myGBL.setConstraints(deleteProduct, myGBC);
	add(deleteProduct);
	deleteProduct.addActionListener(this);
	   
	 myGBC.gridx = 1;
	 myGBC.gridy = 6;
	 myGBC.gridwidth = 1; 
	 myGBC.gridheight = 1; 
	 currentQuantity = new Label ("");
	 myGBL.setConstraints(currentQuantity, myGBC);
	 add(currentQuantity);
	 
	 myGBC.gridx = 2;
	 myGBC.gridy = 6;
	 myGBC.gridwidth = 1; 
	 myGBC.gridheight = 1; 
	 quantityAdd = new Label ("Hinzufügen:");
	 myGBL.setConstraints(quantityAdd, myGBC);
	 add(quantityAdd);
	 
     myGBC.gridx = 3;
     myGBC.gridy = 6;
     myGBC.gridwidth = 1; 
     myGBC.gridheight = 1;
     quantityAddTF = new TextField (10);
     myGBL.setConstraints(quantityAddTF, myGBC);
     add(quantityAddTF);
	 
	 myGBC.gridx = 4;
	 myGBC.gridy = 6;
	 myGBC.gridwidth = 1; 
	 myGBC.gridheight = 1; 
	 quantitySub = new Label ("Entnehmen:");
	 myGBL.setConstraints(quantitySub, myGBC);
	 add(quantitySub);
	 
     myGBC.gridx = 5;
     myGBC.gridy = 6;
     myGBC.gridwidth = 1; 
     myGBC.gridheight = 1;
     quantitySubTF = new TextField (10);
     myGBL.setConstraints(quantitySubTF, myGBC);
     add(quantitySubTF);
	 
	 
	 
	 this.editProduct(row);
  }
  


  @Override
  public void actionPerformed(ActionEvent e) {
    //editProduct Events
    System.out.println(e.getSource());
    if(e.getSource() == this.addProduct) { //speicher button
      //start.Main.table.model.removeRow(row);
      this.addProduct();  
    } else if (e.getSource() == this.deleteProduct) {
      //new YesNoPopup();
      deleteProduct(row);
    }
    System.out.println(e.getActionCommand()+" pressed in MainFrame");
    
  }
  

  public void editProduct(int index) {
      
      System.out.println(row);
      descriptionTF.setText(start.Main.table.model.getValueAt(index, 0).toString());
      weightTF.setText(start.Main.table.model.getValueAt(index, 3).toString());
      currentQuantity.setText(start.Main.table.model.getValueAt(index, 5).toString());
      stocknumberTF.setText(start.Main.table.model.getValueAt(index, 2).toString());
      priceTF.setText(start.Main.table.model.getValueAt(index, 4).toString());
      //newCategoryTF.setText(start.Main.table.model.getValueAt(index, 2).toString());
  }
  
  public void deleteProduct(int row) {
    row=start.Main.table.convertRowIndexToModel(row);
    int reply = JOptionPane.showConfirmDialog(this, "Dieses Produkt löschen?", "Dieses Produkt löschen?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);;
      if (reply == JOptionPane.YES_OPTION) {
      String category= (String) start.Main.table.getValueAt(row,1);
      int index= start.Main.categoryList.indexOf(category);
      int temp=start.Main.productsInCategory.get(index);
      start.Main.productsInCategory.set(index, temp-1);
      
        start.Main.table.model.removeRow(row);
        this.dispose();
      }
    
  }

}
