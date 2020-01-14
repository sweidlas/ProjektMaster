package userInterface.changeCategory;

import java.util.ArrayList;

public class Categories {
	//TODO use Categories in Database and Interface

	public static ArrayList<String> CategoryList = new ArrayList<String>();
	String CategoryName;
	
	public Categories(String Name) {
		this.CategoryName = Name;
		CategoryList.add(Name);
	}
	
	public void deleteCategory(Categories Category) {
		if (CategoryList.contains(this.CategoryName)) {
			CategoryList.remove(this.CategoryName);
			Category=null;
			System.gc();
		} else {
			System.out.println("Category doesn't exist!");
		}
	}
	
	public ArrayList<String> getCategoryList() {
		return CategoryList;
	}
}
