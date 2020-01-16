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
		this.list.removeAll();
		for (int ii = 0; start.Main.categoryList.size()<ii;ii++) {
			this.list.add(start.Main.categoryList.get(ii));
			System.out.println(ii);
		}
		//this.list.add(addCategoryTF.getText());
		
		
	}
}
