package userInterface.mainWindow;

import javax.swing.table.DefaultTableModel;

public class MyModel extends DefaultTableModel{
	
	
	private static final long serialVersionUID = 1L;
	//TODO Insert actual class order
	Class[] columnClass= new Class[] {String.class, Integer.class, String.class, Integer.class, Float.class};
	
	MyModel(String[] columNames, int x){
		super(columNames, x);

		
	}
	@Override
	public Class getColumnClass(int column){
		return columnClass[column];
	}
}
