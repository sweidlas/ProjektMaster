package userInterface.mainWindow;

import javax.swing.table.TableRowSorter;
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
	
	public static ArrayList<String> categoryList = new ArrayList<String>();
	
	private static final long serialVersionUID = 1L;
	static Layout mainLayout;
	userInterface.editProductInterface.EditProduct editProduct;
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
			editProduct = new userInterface.editProductInterface.EditProduct();
		     for (String h: categoryList) {
			       editProduct.categories.add(h);
			       editProduct.addProduct.addActionListener(this);
		     }
		} else if(event.getSource() == mainLayout.editCategory) { //Opens changeCategory Interface
			changeCategory = new userInterface.changeCategory.ChangeCategory();
			changeCategory.deleteCategory.addActionListener(this);
			changeCategory.addCat.addActionListener(this);
			
		} else if(event.getSource() == mainLayout.search) { //Search in Table (Probably not used)
			//TODO start		
		}
		
		//editProduct Events
		if (editProduct != null) {
			if(event.getSource() == editProduct.addProduct) { //Add Product to Database&Table
				editProduct.addProductToShelf();

				mainLayout.refreshTable();
			}	
		} 

		//changeCategory Events
		if (changeCategory != null) {
			if(event.getSource() == changeCategory.deleteCategory) { //Delete Category to Database
			//TODO deleteCategory
			} else if(event.getSource() == changeCategory.addCat) { //Add Category
				try {
					
					this.addCategory(changeCategory.addCategoryTF.getText());
					//changeCategory.list.add(changeCategory.addCategoryTF.getText());
				} catch (Exception e) {
					new exceptions.Exception(e.getMessage());
				}
				changeCategory.refreshList();
			}	
		}
		System.out.println(event.getActionCommand());
	}
	
	public void testCategory(String testMe) throws Exception{
		if (!categoryList.contains(testMe)) {
			throw new Exception("Kategorie exestiert nicht");
		}
	}
		
	public void addCategory(String name) throws Exception{
		if (categoryList.contains(name)) {
			throw new Exception("Category already used");
		} else {categoryList.add(name);}
	}
	
	public void deleteCategory(String category){
		if (categoryList.contains(category)) {
			categoryList.remove(category);
		} else {
			System.out.println("Category doesn't exist!");//this should not be possible
		}
	}
	
}
