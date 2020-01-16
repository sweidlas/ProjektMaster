package userInterface.mainWindow;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Layout extends JPanel{	

	private static final long serialVersionUID = 1L;
	public Button addProduct, search, editCategory; 
	JScrollPane pane;
	JLabel term;
	JTextField termTF;
	
	Layout(){
		
		setLayout(new GridBagLayout ());
		GridBagConstraints myGBC = new GridBagConstraints();
		
		// generally
		myGBC.insets = new Insets(5,5,5,5) ; // distance to line: 5 above, 5 left, 5 below, 5 right 
		myGBC.weightx = 1;
		myGBC.weighty = 1;
		
		// button search
		myGBC.gridx = 5;
		myGBC.gridy = 0;
		myGBC.gridwidth = 1; 
		myGBC.gridheight = 1; 
		myGBC.fill = GridBagConstraints.BOTH;
		search = new Button ("Produkt Suchen");
		search.setBackground(Color.cyan);
		add(search,myGBC);
		
		// button addProduct
		myGBC.gridx = 5;
		myGBC.gridy = 1;
		myGBC.gridwidth = 1; // width of the element
		myGBC.gridheight = 1; // height of the element
		myGBC.fill = GridBagConstraints.BOTH;
		addProduct = new Button ("Produkt hinzufügen");
		addProduct.setBackground(Color.green);
		add(addProduct,myGBC);
		
		// button edit category
		myGBC.gridx = 5;
		myGBC.gridy = 2;
		myGBC.gridwidth = 1;
		myGBC.gridheight = 1; 
		myGBC.fill = GridBagConstraints.BOTH;
		editCategory = new Button ("Kategorien bearbeiten");
		editCategory.setBackground(Color.green);
		add(editCategory,myGBC);
		
		// term
		myGBC.gridx = 0;
		myGBC.gridy = 0;
		myGBC.gridwidth = 1; 
		myGBC.gridheight = 1; 
		term = new JLabel ("Suchbegriff:");
		add(term,myGBC);
		
		// Search Input
		myGBC.gridx = 1;
		myGBC.gridy = 0;
		myGBC.gridwidth = 4; 
		myGBC.gridheight = 1;
		myGBC.fill = GridBagConstraints.BOTH;
		termTF = new JTextField ();
		add(termTF,myGBC);

		// Table
		myGBC.gridx = 0;
		myGBC.gridy = 3;
		myGBC.gridwidth = 6;
		myGBC.gridheight = 6; 
		myGBC.fill = GridBagConstraints.BOTH;
		pane = new JScrollPane(start.Main.table);
		add(pane,myGBC);
		
		//GridBag solution
		myGBC.gridx = 0;
		myGBC.gridy = 3;
		String shString = "test";
		Label sh = new Label (shString);
		add(sh,myGBC);
		myGBC.gridx = 1; 
		sh = new Label (shString);
		add(sh,myGBC);
		myGBC.gridx = 2; 
		sh = new Label (shString);
		add(sh,myGBC);
		myGBC.gridx = 3; 
		sh = new Label (shString);
		add(sh,myGBC);
		myGBC.gridx = 4; 
		sh = new Label (shString);
		add(sh,myGBC);		
		myGBC.gridx = 5; 
		sh = new Label (shString);
		add(sh,myGBC);
	}
	
	public void refreshTable() {
		
		//table.setNewDatabase();
	}
}
