package userInterface.editProductInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddProduct extends Interface implements ActionListener{

	private static final long serialVersionUID = 1L;



	
	 public ArrayList<Integer> Fehlermeldungen = new ArrayList<Integer>();
	// view of the window
	public AddProduct(){
		super();
		this.setDefaultCloseOperation(Interface.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);//Middle of screen
		this.setResizable(false);
		this.addProduct.addActionListener(this);

	} // addProduct

	public void actionPerformed(ActionEvent e) {
		//editProduct Events	
		if(e.getSource() == this.addProduct) { //Add Product to Database&Table
			this.addProduct();
		}	
	}  
	

	
	public void addProduct() {
		Fehlermeldungen.clear();
     	
		String name = descriptionTF.getText();
		String weight= weightTF.getText();
		String quantity= quantityTF.getText();
		String number= stocknumberTF.getText();
		String price= priceTF.getText();
		String category= categories.getSelectedItem();
		
		leereEingabeFM.setText("");
		descriptionFM.setText("");
		weightFM.setText(""); 
		priceFM.setText(""); 
		stocknumberFM.setText(""); 
		quantityFM.setText("");
		 	   
		//TODO Bug Check + include more Error warnings
 	    //descriptionOK
 	    int desc = checkProductname(name);
 	    if (desc == 1) {Fehlermeldungen.add(11);}//Input to Long/Small
 	    if (desc == 2) {Fehlermeldungen.add(12);}//wrong character

 	    //stocknumberOK
 	    int sto = checkStocknumber(number);
 	    if (sto == 1) {Fehlermeldungen.add(31);}//Input to Long/Small =!6
 	    if (sto == 2) {Fehlermeldungen.add(32);}//Letters inside
 	   
 	    //priceOK
 	    int pri = checkPrice(price);
 	    if (pri == 1) {Fehlermeldungen.add(41);}//Number to Big/Small
 	    if (pri == 2) {Fehlermeldungen.add(42);}
 	    if (pri == 2) {Fehlermeldungen.add(43);}
 	    //weightOK
 	    int wei = checkWeight(weight);
 	    if (wei == 1) {Fehlermeldungen.add(51);}//Wrong Input
 	    if (wei == 2) {Fehlermeldungen.add(52);}
 	    if (wei == 3) {Fehlermeldungen.add(53);}
 	    //quantityOK
 	    int qua = checkQuantity(quantity);
 	    if (qua == 1) {Fehlermeldungen.add(61);}//Wrong Input

 	    System.out.println(Fehlermeldungen);

	 	if (name.length()==0|category.length()==0|number.length()==0|price.length()==0|weight.length()==0|quantity.length()==0) {
	 		leereEingabeFM.setText("Bitte alle Felder ausfüllen!");}
	 	else {
			if (Fehlermeldungen.isEmpty()) {
				 if (checkNameInList(name) == false) {descriptionFM.setText("Produktbezeichnung schon vergeben");}
				 else if (checkStocknumberInList(number) == false) {stocknumberFM.setText("Lagerplatz schon vergeben");}
				 else if (checkWeightInShelf(number, weight, quantity) == 1) {leereEingabeFM.setText("Regal überlastet");}
				 else {
					String[] newRow = {name, category, number, weight, price, quantity};
			 		start.Main.table.model.addRow(newRow);
			 		this.dispose();
					}
			}
			else {
	
		         if (Fehlermeldungen.contains(11)) {descriptionFM.setText("zu viele Zeichen");} //Productdescription contains more than 256 characters
		         if (Fehlermeldungen.contains(12)) {descriptionFM.setText("falsches Zeichen");}
		        
		         if (Fehlermeldungen.contains(31)) {stocknumberFM.setText("6- stellige Zahl");}
		         if (Fehlermeldungen.contains(32)) {stocknumberFM.setText("keine Buchstaben");}
		         
		         if (Fehlermeldungen.contains(41)) {priceFM.setText("keine Buchstaben");}
		         if (Fehlermeldungen.contains(42)) {priceFM.setText("Zahl zu groß");}
		         if (Fehlermeldungen.contains(43)) {priceFM.setText("zu viele Nachkommastellen");}
	
		         if (Fehlermeldungen.contains(51)) {weightFM.setText("keine Buchstaben");} 
		         if (Fehlermeldungen.contains(52)) {weightFM.setText("Zahl zu groß");} 
		         if (Fehlermeldungen.contains(53)) {weightFM.setText("zu viele Nachkommastellen");} 
		         
		         if (Fehlermeldungen.contains(61)) {quantityFM.setText("keine Buchstaben");} 

			}
		} 
	
	 	
	}


 	    
	private boolean checkNameInList(String name) {
		for (int ii = 0; ii < start.Main.table.model.getRowCount(); ii++) { 
			String n = (String) start.Main.table.model.getValueAt(ii, 0);
			if (n.equals(name)) {return false;}
		}
		return true;
	}
	
	private boolean checkStocknumberInList(String stocknumber) {
		for (int ii = 0; ii < start.Main.table.model.getRowCount(); ii++) { 
			String n = (String) start.Main.table.model.getValueAt(ii, 2);
			if (n.equals(stocknumber)) {return false;}
		}
		return true;
	}
	
	
	
	
	private int checkWeightInShelf(String stocknumber, String newWeight, String newQuantity) {
		int workload = 0;
		String shelf = stocknumber.substring(0, 3);
		int she = Integer.parseInt(shelf);
		int newQuantityInt = Integer.parseInt(newQuantity);
		int newWeightInt = parseToInt(newWeight);
	
		for (int ii = 0; ii < start.Main.table.model.getRowCount(); ii++) { 
			String n = ((String) start.Main.table.model.getValueAt(ii, 2)).substring(0, 3); //stocknumber
			int num = Integer.parseInt(n);
			if (she == num) {
				System.out.println("hier");
				int quantity = Integer.parseInt((String) start.Main.table.model.getValueAt(ii, 5));
				int weight = parseToInt((String) start.Main.table.model.getValueAt(ii, 3));
				workload += quantity*weight;
				System.out.println(weight);
				System.out.println(workload);}
		}
		workload += newQuantityInt*newWeightInt;
		if (workload > 100000000) {return 1;}
		return 0;
	}

	
	private int checkProductname(String name) {
 	    //List<Character> Zeichen = new List<Character>();
 	    ArrayList<Character> Zeichen = new ArrayList<Character>();
 	    Zeichen.add('a'); Zeichen.add('b'); Zeichen.add('c'); Zeichen.add('d'); Zeichen.add('e'); Zeichen.add('f');
 	    Zeichen.add('g'); Zeichen.add('h'); Zeichen.add('i'); Zeichen.add('j'); Zeichen.add('k'); Zeichen.add('l'); 
 	    Zeichen.add('m'); Zeichen.add('n'); Zeichen.add('o'); Zeichen.add('p'); Zeichen.add('q'); Zeichen.add('r');
 	    Zeichen.add('s'); Zeichen.add('t'); Zeichen.add('u'); Zeichen.add('v'); Zeichen.add('w'); Zeichen.add('x');
 	    Zeichen.add('y'); Zeichen.add('z');
 	    Zeichen.add('A'); Zeichen.add('B'); Zeichen.add('C'); Zeichen.add('D'); Zeichen.add('E'); Zeichen.add('F');
 	    Zeichen.add('G'); Zeichen.add('H'); Zeichen.add('I'); Zeichen.add('J'); Zeichen.add('K'); Zeichen.add('L');
 	    Zeichen.add('M'); Zeichen.add('N'); Zeichen.add('O'); Zeichen.add('P'); Zeichen.add('Q'); Zeichen.add('R');
 	    Zeichen.add('S'); Zeichen.add('T'); Zeichen.add('U'); Zeichen.add('V'); Zeichen.add('W'); Zeichen.add('X');
 	    Zeichen.add('Y'); Zeichen.add('Z');
 	    Zeichen.add('0'); Zeichen.add('1'); Zeichen.add('2'); Zeichen.add('3'); Zeichen.add('4'); Zeichen.add('5');
 	    Zeichen.add('6'); Zeichen.add('7'); Zeichen.add('8'); Zeichen.add('9');
 	    Zeichen.add('-'); Zeichen.add('!'); Zeichen.add('?'); Zeichen.add('.'); Zeichen.add('('); Zeichen.add(')');

 	    //char[] chara = name.toCharArray();
 	    for (char ch: name.toCharArray()) {
 	      if (Zeichen.contains(ch) == false) return 2; //wrong character  
 	    }
 	    if (name.length() > 256 | name.length() <= 1) {return 1;}
 	    else return 0;
 	  } 



  
private int checkStocknumber(String Stocknumber) {//TODO Never uses Catch
 	    try {
 	    	Integer.parseInt(Stocknumber);
 	      if (Stocknumber.length() == 6) return 0;
 	      else return  1;// else: Zahl zu groÃŸ  
 	      }
 	    catch(NumberFormatException ee) {
 	      return 2; //print: keine Buchstaben   
 	    }
 	  }
  
private int checkPrice(String price)  {
 	    String[] teil = price.split(",");
 	    if (teil.length == 2) {
 	      String i = teil[0];
 	      String a = teil[1];

 	      try {
 	    	Integer.parseInt(i);
 	    	Integer.parseInt(a);
 	        if ((i.length() <= 5) & (a.length() <= 2)) { return 0;}
 	        if (i.length() > 5) {return 2;}
 	        if (a.length() > 2) {return 3;}
 	        else return 1; //Number to Big/Small
 	      }
 	      catch(NumberFormatException ee) {
 	        return 1;
 	      }
 	    }
 	    else if (teil.length == 1) {
 	      String u = teil[0];   
 	     
 	      try {
 	    	 Integer.parseInt(u);
 	        if (u.length() <= 5) { return 0;}
 	        else return 1;
 	      }
 	      catch(NumberFormatException ee) {
 	        return 1;
 	      }

 	    }
 	    else return 1;
 	  }
  
private static int checkWeight(String weight)  {  //Input in Kg
 	    String[] part = weight.split(",");
 	    if (part.length == 2) {
 	      String i = part[0];
 	      String a = part[1];

 	      try {
 	    	  Integer.parseInt(i);
 	    	  Integer.parseInt(a);
 	        if ((i.length() <= 5) & (a.length() <= 4)) { return 0;}
 	        if (i.length() > 5) {return 2;}
 	        if (a.length() > 4) {return 3;}
 	        else return 1; 
 	      }
 	      catch(Exception ee) {
 	        return 1;
 	      }
 	    }
 	    else if (part.length == 1) {
 	    	
 	      String u = part[0];   
 	      try {
 	    	 Integer.parseInt(u);
 	        if (u.length() <= 4 | u == "10000") { return 0;}
 	        if (u.length() >= 5) {return 2;}
 	        else return 1;
 	      }
 	      catch(NumberFormatException ee) {
 	        return 1;
 	      }

 	    }
 	    else return 1;
 	  }

private int checkQuantity(String quantity) {
 	    try {
 	    	
 	      int zahl2 = Integer.parseInt(quantity);
 	      if (zahl2 <= 100000000) return 0;// else: Zahl zu groÃŸ 
 	      }
 	    catch(Exception ee) {
 	       //print: keine Buchstaben   
 	    }
 	   return 1;
 	  }

 	  //a

public static int parseToInt (String a) {
 		String[] teil = a.split(",");
 		if (teil.length == 1) {
 			int i = Integer.parseInt(teil[0]);
 			i = i*10000;
 			return i;
 		}
 		else {
 			String neu = teil[0]+teil[1];
 			int o = Integer.parseInt(neu);
 			int nachkomma = 4-teil[1].length();
 			for (int ii=0; ii < nachkomma; ii++) {
 				o = o*10;
 			}
 			return o;
 		}
 					
 	}  

	
} // public class addProduct
