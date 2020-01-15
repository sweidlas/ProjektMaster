package userInterface.changeCategory;

import java.util.ArrayList;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ChangeCategory extends Interface{
	
	// view of the window
	public ChangeCategory (){
		super();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300, 250);
		this.setLocationRelativeTo(null);//Middle of screen
	} 
	
	public void refreshList() {
		ArrayList<String> cats = start.Main.List.getCategoryList();
		list.removeAll();
		for(int ii = 0; cats.size()>ii ; ii++) {
			list.add(cats.get(ii));
		}

	}

	public void changeCategory(String newCategory, String oldCategory) {
		
		try {
			start.Main.List.addCategory(newCategory);
			start.Main.List.deleteCategory(oldCategory);
			
		} catch (Exception e) {
			new exceptions.Exception(e.getMessage());
		}
		
	}
}
