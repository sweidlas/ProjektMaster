package userInterface.mainWindow;

import java.util.ArrayList;
import javax.swing.table.*;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//TableModel that returns the actual class and not String
//May or may not be needed


public class DataTable extends JTable{
	

	private static final long serialVersionUID = 1L;

	static String[] columNames = {"Produktbezeichnung",
			"Anzahl",
			"Kategorie",
			"Stückpreis(in Cent)",
			"Lagernummer",
			"Gewicht"};
	
	public static DefaultTableModel model= new DefaultTableModel( columNames, 0 );
	ArrayList<JCheckBox> searchCheckboxes = new ArrayList<>();
	TableRowSorter sorter;
    
	public DataTable() {
		
		super(model);
		sorter=new TableRowSorter<>(model);
		this.setRowSorter(sorter);
		//setNewDatabase();
		//TODO Change double click on List opens EditProduct Frame
    }
	
	
//	public void setNewDatabase(){
//		model.setRowCount(0);
//		ArrayList<String> databaseAsString = start.Main.List.databaseAsString;
//		String[] showMe = new String[6];
//		for (int ii = 0; databaseAsString.size()/6>ii;ii++) {
//			for (int kk=0; kk<6;kk++) {
//				showMe[kk] = databaseAsString.get(ii*6+kk);
//			}
//			model.addRow(showMe);
//		}
//	}
	@Override	
	public boolean isCellEditable(int row, int column) {
	       return false;
	    
	}
	
	@Override
	// returns selected checkboxes
	public int[] getSelectedColumns() {
		ArrayList<Integer> indexesOfSelected = new ArrayList<Integer>();
		for (int i = 0; i < this.searchCheckboxes.size(); ++i) {
			JCheckBox box = this.searchCheckboxes.get(i);
			if (box.isSelected()) {
				indexesOfSelected.add(i);
			}
		}
		
		int[] rv = new int[indexesOfSelected.size()];
		// java is stupid
		for (int i = 0; i < rv.length; i++) {
			rv[i] = indexesOfSelected.get(i);
		}
		return rv;

	}

	ArrayList<JCheckBox> getCheckboxes() {
		return this.searchCheckboxes;
	}
	
}
