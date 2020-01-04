package start.userInterface.changeCategory;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
class Interface extends Frame implements ActionListener {
	

	Button deleteCategory;
	Button okay;
	
	public Interface() {
		super ("Kategorien"); // set title
		GridBagLayout myGBL = new GridBagLayout ();
		setLayout(myGBL);
		
		GridBagConstraints myGBC = new GridBagConstraints();
		setVisible (true);
		
		// generally
		myGBC.fill = GridBagConstraints.HORIZONTAL;
		myGBC.insets = new Insets(5,5,5,5) ; // distance to line: 5 above, 5 left, 5 below, 5 right 
		
		// Button deleteProduct
		myGBC.gridx = 3;
		myGBC.gridy = 1;
		myGBC.gridwidth = 2; // width of the element
		myGBC.gridheight = 1; // height of the element
		deleteCategory = new Button ("löschen");
		deleteCategory.setBackground(Color.red);
		deleteCategory.addActionListener(this);
		myGBL.setConstraints(deleteCategory, myGBC);
		add(deleteCategory);
		
		// Button okay
		myGBC.gridx = 3;
		myGBC.gridy = 6;
		myGBC.gridwidth = 1; 
		myGBC.gridheight = 1; 
		okay = new Button ("Okay");
		okay.setBackground(Color.green);
		okay.addActionListener (this);
		myGBL.setConstraints(okay, myGBC);
		add(okay);
	
		myGBC.gridx = 0;
		myGBC.gridy = 0;
		myGBC.gridwidth = 2; // width of the element
		myGBC.gridheight = 2; // height of the element
		List list = new List (6);
		list.add("Kategorie1"); // example for the space for the categories
		list.add("Kategorie2");
		list.add("Kategorie3");
		list.add("Kategorie4");
		list.add("Kategorie5");
		list.add("Kategorie6");
		myGBL.setConstraints(list, myGBC);
		add(list);
		
		// add category
		myGBC.gridx = 0;
		myGBC.gridy = 5;
		myGBC.gridwidth = 2; 
		myGBC.gridheight = 1; 
		Label addCategory = new Label ("Kategorie hinzufügen:");
		myGBL.setConstraints(addCategory, myGBC);
		add(addCategory);
		
		myGBC.gridx = 0;
		myGBC.gridy = 6;
		myGBC.gridwidth = 2; 
		myGBC.gridheight = 1;
		TextField addCategoryTF = new TextField (3);
		myGBL.setConstraints(addCategoryTF, myGBC);
		add(addCategoryTF);
		
		pack();
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == deleteCategory || e.getSource() == okay )
		{
			this.dispose();
		}
		
	}
}
