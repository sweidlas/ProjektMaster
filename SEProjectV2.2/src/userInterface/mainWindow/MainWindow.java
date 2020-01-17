package userInterface.mainWindow;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainWindow extends JFrame implements ActionListener{
	
	
	
	private static final long serialVersionUID = 1L;
	static Layout mainLayout;
	userInterface.editProductInterface.AddProduct addProduct;
	userInterface.changeCategory.ChangeCategory changeCategory;
	
	public MainWindow() {
		super("penfactory Lagerverwaltung");
		setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//=always full screen
		
		Container c = getContentPane();
		
		
		mainLayout = new Layout();
		c.add(mainLayout, BorderLayout.NORTH);
		
		mainLayout.search.addActionListener(this);
		mainLayout.addProduct.addActionListener(this);
		mainLayout.editCategory.addActionListener(this);
		
		//SEARCH AND FILTER
		 mainLayout.termTF.getDocument().addDocumentListener(new DocumentListener() {
			// Refilter Table after each change on searchfield
			@Override
			// when new symbol is typed
			public void insertUpdate(DocumentEvent e) {
				search(mainLayout.termTF.getText());
			}

			@Override
			// when symbol is deleted
			public void removeUpdate(DocumentEvent e) {
				search(mainLayout.termTF.getText());
			}

			@Override
			// other changes(pasted text, etc.)
			public void changedUpdate(DocumentEvent e) {
				search(mainLayout.termTF.getText());
			}

			public void search(String str) {
				// show all rows
				if (str.length() == 0) {
					start.Main.table.sorter.setRowFilter(null);
				} 
				// set filter to the string, case insensitive
				else {
					start.Main.table.sorter.setRowFilter(RowFilter.regexFilter(("(?i)" + str), start.Main.table.getSelectedColumns()));
				}

			}
		});
		this.setVisible(true);
	}	

	
	@Override
	public void actionPerformed(ActionEvent event) {

		//mainFrame Events
		if(event.getSource() == mainLayout.addProduct){ //Opens Add Product Interface
			addProduct = new userInterface.editProductInterface.AddProduct();
		} else if(event.getSource() == mainLayout.editCategory) { //Opens changeCategory Interface
			changeCategory = new userInterface.changeCategory.ChangeCategory();
		}	
		System.out.println(event.getActionCommand()+" pressed in MainFrame");
	}
}
	
		
