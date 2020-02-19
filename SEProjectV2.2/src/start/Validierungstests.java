package start;

import static org.junit.Assert.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import org.junit.Test;
import org.junit.*;
import org.junit.Assert.*;


//Am Anfang wird die Datenbank geleert um für die Tests die Grundlage zu schaffen
//Es werden die Produkte hinzugefügt, auf Grundlage derer die Tests durchgeführt werden.
//Die Produktattribute werden in die Eingabemaske des Interface gesetzt, danach wird der gesamte Prozess durchlaufen, 
//zur Überprüfungung, dass nur korrekte Produkte hinzugefügt werden. Die Tests verifizieren darauf hin, dass dieser Prozess
//korrekt abgelaufen ist. Um ein Produkt hinzufügen zu können, muss dessen Kategorie in der Datenbank sein, deshalb werden
//im ersten Schritt die Kategorien hinzugefügt.


public class Validierungstests {
	//4.1.1
	/* um korrekte Speicherung zu testen, wird ein Produkt in die Datenbank geschrieben,
	 * die Datenbank wird dann abgespeichert. Danach wird das gespeicherte in eine neue
	 * Datenbank geladen. Das Produkt wird in beiden Datenbanken gesucht und in einem 
	 * String verwandelt. Dann wird getestet ob beide Strings gleich sind.
	 */	
	@Test
	public void KorrekteSpeicherung() {
		//System.out.println("list "+Main.categoryList.toString());
		produktHinzufügen("Paper3000", "999999", "0,1", "0,60", "360", "Papier"); 
		DataHandler.save((DefaultTableModel) start.Main.table.model); 
		DefaultTableModel newmodel = start.DataHandler.load();
		String modelString = "§";
		String newmodelString = "$";
		for (int i = 0; i<start.Main.table.model.getRowCount(); i++) {
			if(start.Main.table.model.getValueAt(i, 0).toString().equals("Paper3000")) {
				modelString = getRowAt(start.Main.table.model,i);	}						//Produktattribute als String
		}
		for (int i = 0; i<newmodel.getRowCount(); i++) {
			if(newmodel.getValueAt(i, 0).toString().equals("Paper3000")) {
				newmodelString = getRowAt(newmodel,i); }
		}
		//System.out.println("String: "+modelString);
		assertEquals("gleich", modelString, newmodelString);								//sind beide Strings gleich, wird das Produkt richtig gespeichert
	}
	


	//4.1.2
	@Test
	public void NameEindeutig() {
		//Im Folgenden wird ein Produkt mit einem bereits in der Datenbank vorhandenen Name hinzugefügt.
		//Danach wird überprüft ob das Produkt auch aufgenommen wurde
		produktHinzufügen("Stift", "000001", "0,1", "0,60", "360", "Schreibgeräte"); 
		int AnzahlProdukteDavor = start.Main.table.model.getRowCount();
		produktHinzufügen("Stift", "000000", "0,1", "0,60", "360", "Schreibgeräte"); 			//gleicher Name
		int AnzahlProdukteDanach = start.Main.table.model.getRowCount();
		//System.out.println("Name: "+start.Main.table.model.getRowCount());
		assertEquals("Produkt wurde hinzugefügt", AnzahlProdukteDavor, AnzahlProdukteDanach);
	}
	
	@Test
	public void LagernummerEindeutig() {
		produktHinzufügen("Block", "000012", "0,1", "0,60", "360", "Schreibgeräte"); 
		int AnzahlProdukteDavor2 = start.Main.table.model.getRowCount();
		produktHinzufügen("Block2", "000012", "0,1", "0,60", "360", "Schreibgeräte"); 		//gleiche Lagernummer
		int AnzahlProdukteDanach2 = start.Main.table.model.getRowCount();
		assertEquals("Produkt wurde hinzugefügt", AnzahlProdukteDavor2, AnzahlProdukteDanach2);
	}
	
	@Test
	public void KategorieEindeutig() {
		userInterface.changeCategory.ChangeCategory c = new userInterface.changeCategory.ChangeCategory();
		start.Main.categoryList.add("Block");									//Kategorienamen hinzufügen
		//System.out.println("Kategorien: "+start.Main.categoryList.toString());
	    Exception e = assertThrows(
	            Exception.class, () -> c.addCategory("Block"));					//erneutes Hinzufügen gibt Exception, die Kategorie wird nicht hinzugefügt
	    assertEquals("Kategorie schon belegt", e.getMessage());
	}
	
	
	
	//4.1.3 Suchfunktion
	@Test
	public void suche() throws Exception {
		String[] a = {};
		Main.main(a);
		deleteDatabase();
		
		//Am Anfang wird die Datenbank geleert um für die Tests die Grundlage zu schaffen
		//Es werden die Produkte hinzugefügt, auf Grundlage derer die Tests durchgeführt werden.
		//Die Produktattribute werden in die Eingabemaske des Interface gesetzt, danach wird der gesamte Prozess zur Überprüfungung,
		//dass nur korrekte Produkte hinzugefügt werden, durchlaufen. Die Tests verifizieren darauf hin, dass dieser Prozess
		//korrekt abgelaufen ist. Um ein Produkt hinzufügen zu können, muss dessen Kategorie in der Datenbank sein, deshalb werden
		//im ersten Schritt die Kategorien hinzugefügt.

		//Kategorien hinzufügen
		
		KategorieHinzufügen("Schreibgeräte");
		KategorieHinzufügen("Korrekturflüssigkeit");
		KategorieHinzufügen("Büromaterial");
		KategorieHinzufügen("Notizzettel");
		KategorieHinzufügen("Hefter");
		KategorieHinzufügen("Papier");
		KategorieHinzufügen("Register");
		//System.out.println(Main.categoryList);
		
		//Produkte hinzufügen						
		produktHinzufügen("Stift_blau_0.05mm", "000012", "0,1", "0,60", "360", "Schreibgeräte");  //die Punkte wurden durch Kommas ersetzt, da unser Produkt für den deutschen Markt das Komma benutzt
		produktHinzufügen("Stift_schwarz_0.03mm", "000013", "0,1", "0,60", "130", "Schreibgeräte");
		produktHinzufügen("Tippex 3x", "951167", "0,16", "4,95", "97", "Korrekturflüssigkeit");
		produktHinzufügen("Tippex 10x", "461168", "0,55", "15,50", "48", "Korrekturflüssigkeit");
		produktHinzufügen("Locher 25 Blatt rot", "332471", "0,24", "6,25", "37", "Büromaterial");
		produktHinzufügen("Post-it Block weiß", "123483", "0,30", "2,15", "460", "Notizzettel");
		produktHinzufügen("Hefter 100x bunt", "513513", "4,50", "25,00", "179", "Hefter");
		produktHinzufügen("Textmarker 3x neongrün", "986722", "20,00", "3,50", "255", "Schreibgeräte");
		produktHinzufügen("Kopierpapier 10x 500", "002001", "2,5", "35,95", "513", "Papier");
		produktHinzufügen("Trennstreifen 5x 100 bunt", "501993", "0,024", "25,00", "83", "Register");
		//System.out.println("Rowcount" +start.Main.table.model.getRowCount());
		
		//for (int i=0; i < start.Main.table.model.getRowCount(); i++) {
		//	getRowAt(start.Main.table.model,i);
		
		//Tippex
		assertFalse("Stift_blau_0.05mm gefunden", isIn("Stift_blau_0.05mm", "Tippex"));
		assertFalse("Stift_schwarz_0.03mm gefunden", isIn("Stift_schwarz_0.03mm", "Tippex"));
		assertTrue("Tippex 3x gefunden", isIn("Tippex 3x", "Tippex"));
		assertTrue("Tippex 10x gefunden", isIn("Tippex 10x", "Tippex"));
		assertFalse("Locher 25 Blatt rot gefunden", isIn("Locher 25 Blatt rot", "Tippex"));
		assertFalse("Post-it Block weiß gefunden", isIn("Post-it Block weiß", "Tippex"));
		assertFalse("Hefter 100x bunt gefunden", isIn("Hefter 100x bunt", "Tippex"));
		assertFalse("Textmarker 3x neongrün gefunden", isIn("Textmarker 3x neongrün", "Tippex"));
		assertFalse("Kopierpapier 10x 500 rot gefunden", isIn("Kopierpapier 10x 500", "Tippex"));
		assertFalse("Trennstreifen 5x 100 bunt gefunden", isIn("Trennstreifen 5x 100 bunt", "Tippex"));
		
		//Locher 25 Blatt rot
		assertFalse("Stift_blau_0.05mm gefunden", isIn("Stift_blau_0.05mm", "Locher 25 Blatt rot"));
		assertFalse("Stift_schwarz_0.03mm gefunden", isIn("Stift_schwarz_0.03mm", "Locher 25 Blatt rot"));
		assertFalse("Tippex 3x gefunden", isIn("Tippex 3x", "Locher 25 Blatt rot"));
		assertFalse("Tippex 10x gefunden", isIn("Tippex 10x", "Locher 25 Blatt rot"));
		assertTrue("Locher 25 Blatt rot gefunden", isIn("Locher 25 Blatt rot", "Locher 25 Blatt rot"));
		assertFalse("Post-it Block weiß gefunden", isIn("Post-it Block weiß", "Locher 25 Blatt rot"));
		assertFalse("Hefter 100x bunt gefunden", isIn("Hefter 100x bunt", "Locher 25 Blatt rot"));
		assertFalse("Textmarker 3x neongrün gefunden", isIn("Textmarker 3x neongrün", "Locher 25 Blatt rot"));
		assertFalse("Kopierpapier 10x 500 rot gefunden", isIn("Kopierpapier 10x 500", "Locher 25 Blatt rot"));
		assertFalse("Trennstreifen 5x 100 bunt gefunden", isIn("Trennstreifen 5x 100 bunt", "Locher 25 Blatt rot"));
		
		//Kopierpapier 10x 500
		assertFalse("Stift_blau_0.05mm gefunden", isIn("Stift_blau_0.05mm", "Kopierpapier 10x 500"));
		assertFalse("Stift_schwarz_0.03mm gefunden", isIn("Stift_schwarz_0.03mm", "Kopierpapier 10x 500"));
		assertFalse("Tippex 3x gefunden", isIn("Tippex 3x", "Kopierpapier 10x 500"));
		assertFalse("Tippex 10x gefunden", isIn("Tippex 10x", "Kopierpapier 10x 500"));
		assertFalse("Locher 25 Blatt rot gefunden", isIn("Locher 25 Blatt rot", "Kopierpapier 10x 500"));
		assertFalse("Post-it Block weiß gefunden", isIn("Post-it Block weiß", "Kopierpapier 10x 500"));
		assertFalse("Hefter 100x bunt gefunden", isIn("Hefter 100x bunt", "Kopierpapier 10x 500"));
		assertFalse("Textmarker 3x neongrün gefunden", isIn("Textmarker 3x neongrün", "Kopierpapier 10x 500"));
		assertTrue("Kopierpapier 10x 500 rot gefunden", isIn("Kopierpapier 10x 500", "Kopierpapier 10x 500"));
		assertFalse("Trennstreifen 5x 100 bunt gefunden", isIn("Trennstreifen 5x 100 bunt", "Kopierpapier 10x 500"));
		
		//Tuppex 10x
		assertFalse("Stift_blau_0.05mm gefunden", isIn("Stift_blau_0.05mm", "Tuppex 10x"));
		assertFalse("Stift_schwarz_0.03mm gefunden", isIn("Stift_schwarz_0.03mm", "Tuppex 10x"));
		assertFalse("Tippex 3x gefunden", isIn("Tippex 3x", "Tuppex 10x"));
		assertFalse("Tippex 10x gefunden", isIn("Tippex 10x", "Tuppex 10x"));
		assertFalse("Locher 25 Blatt rot gefunden", isIn("Locher 25 Blatt rot", "Tuppex 10x"));
		assertFalse("Post-it Block weiß gefunden", isIn("Post-it Block weiß", "Tuppex 10x"));
		assertFalse("Hefter 100x bunt gefunden", isIn("Hefter 100x bunt", "Tuppex 10x"));
		assertFalse("Textmarker 3x neongrün gefunden", isIn("Textmarker 3x neongrün", "Tuppex 10x"));
		assertFalse("Kopierpapier 10x 500 rot gefunden", isIn("Kopierpapier 10x 500", "Tuppex 10x"));
		assertFalse("Trennstreifen 5x 100 bunt gefunden", isIn("Trennstreifen 5x 100 bunt", "Tuppex 10x"));
		
		//3
		assertTrue("Stift_blau_0.05mm gefunden", isIn("Stift_blau_0.05mm", "3"));
		assertTrue("Stift_schwarz_0.03mm gefunden", isIn("Stift_schwarz_0.03mm", "3"));
		assertTrue("Tippex 3x gefunden", isIn("Tippex 3x", "3"));
		assertFalse("Tippex 10x gefunden", isIn("Tippex 10x", "3"));
		assertTrue("Locher 25 Blatt rot gefunden", isIn("Locher 25 Blatt rot", "3"));
		assertTrue("Post-it Block weiß gefunden", isIn("Post-it Block weiß", "3"));
		assertTrue("Hefter 100x bunt gefunden", isIn("Hefter 100x bunt", "3"));
		assertTrue("Textmarker 3x neongrün gefunden", isIn("Textmarker 3x neongrün", "3"));
		assertTrue("Kopierpapier 10x 500 rot gefunden", isIn("Kopierpapier 10x 500", "3"));
		assertTrue("Trennstreifen 5x 100 bunt gefunden", isIn("Trennstreifen 5x 100 bunt", "3"));
	}
	
	
	
	//Hilfsfunktionen
	public boolean isIn(String Produktname  ,String Suchbegriff) {			//überprüft, ob die Zeile mit dem eindeutigen Produktnamen Teil der durch die Suche gefundenen Zeilen ist
		ArrayList<Integer> SelectedItems = produktSuchen(Suchbegriff);
		//System.out.println("selected: "+SelectedItems.toString());
		int row;
		for (int i = 0; i < start.Main.table.model.getRowCount(); i++) {
			if (Produktname.equals(start.Main.table.model.getValueAt(i, 0))) {
				if (SelectedItems.contains(i)) return true;
			}
		}
		return false;
	}
	public ArrayList<Integer> produktSuchen(String a) {						//gibt alle alle zeilen die den übergebenen String enthalten zurück
		//sorter im nachhinein public gemacht
		start.Main.table.sorter.setRowFilter(RowFilter.regexFilter(("(?i)" + a), start.Main.table.getSelectedColumns()));	
		ArrayList<Integer> rowIndexes = new ArrayList<Integer>();
		for (int i = 0; i < (start.Main.table.getRowCount()); i++) {
			int rowIndex = start.Main.table.convertRowIndexToModel(i); 
			rowIndexes.add(rowIndex);	
		}
		return rowIndexes;
	}
	
	
	public void KategorieHinzufügen(String a) throws Exception {
		userInterface.changeCategory.ChangeCategory c = new userInterface.changeCategory.ChangeCategory();
		c.addCategory(a);
	}
	
	public void produktHinzufügen(String des, String sto, String wei, String pri, String qua, String cat) {
		userInterface.editProductInterface.AddProduct p = new userInterface.editProductInterface.AddProduct();
	    p.descriptionTF.setText(des);
	    p.weightTF.setText(wei); 
	    p.priceTF.setText(pri); 
	    p.stocknumberTF.setText(sto); 
	    p.quantityTF.setText(qua);
	    p.categories.select(cat);
	    p.addProduct();
	}
	

	
	public String getRowAt(DefaultTableModel x,int row) {			//gibt eine Zeile des Tables als String zurück
	     String s = "";
	     for (int i = 0; i < 6; i++) {
	         String result = x.getValueAt(row, i).toString();
	         s = s.concat(result);
	     }
	    return s;
	}
	
	//delete Database
	public void deleteDatabase() {
	while (start.Main.table.model.getRowCount() > 0) {
		start.Main.table.model.removeRow(0);
	}
	//System.out.println("new2Rowcount" +start.Main.table.model.getRowCount());
	start.Main.categoryList.clear();
	start.Main.productsInCategory.clear();
	DataHandler.save((DefaultTableModel) start.Main.table.model); 
	}
	

	
}
