package userInterface.mainWindow;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	Layout mainLayout;
	userInterface.editProductInterface.EditProduct editProduct;
	userInterface.changeCategory.ChangeCategory chCategory;
	
	public MainWindow() {
		super("penfactory Lagerverwaltung");
		setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(10000,10000);//=always full screen
		
		Container c = getContentPane();
		
		
		mainLayout = new Layout();
		c.add(mainLayout, BorderLayout.NORTH);
		
		mainLayout.search.addActionListener(this);
		mainLayout.addProduct.addActionListener(this);
		mainLayout.editCategory.addActionListener(this);

		
		this.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent event) {

		if(event.getSource() == mainLayout.addProduct){
			editProduct = new userInterface.editProductInterface.EditProduct();
			editProduct.addProduct.addActionListener(this);
			
		} else if(event.getSource() == mainLayout.editCategory) {
			chCategory = new userInterface.changeCategory.ChangeCategory();
			chCategory.deleteCategory.addActionListener(this);
			chCategory.addCat.addActionListener(this);
			
		} else if(event.getSource() == mainLayout.search) {
			//TODO start	
			
		} else if(event.getSource() == editProduct.addProduct) {
			editProduct.addProductToShelf();
			mainLayout.refreshTable();
			

		} else if(event.getSource() == chCategory.deleteCategory) {
			try {
				start.Main.List.addCategory(chCategory.addCategoryTF.getText());
			} catch (Exception e) {
				new exceptions.Exception(e.getMessage());
			}
			//TODO deleteCategory
			
		} else if(event.getSource() == chCategory.addCat) {
			chCategory.refreshList();
			//TODO whatever this Button does
			
		}
		
	}
	
}
