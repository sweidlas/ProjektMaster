package userInterface.addProductInterface;

import java.awt.Label;
import java.lang.Exception;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class AddProduct extends Interface {
	
	 public ArrayList<Integer> Fehlermeldungen = new ArrayList<Integer>();
	// view of the window
	public AddProduct (){
		super();	
	} // addProduct	
	
	public void addProductToShelf() {
     	
		String name = quantityTF.getText();
		String weight= weightTF.getText();
		String quantity= quantityTF.getText();
		String number= stocknumberTF.getText();
		String price= priceTF.getText();
		String category= newCategoryTF.getText();
		
		leereEingabeFM.setText("");
		descriptionFM.setText("");
		weightFM.setText(""); 
		priceFM.setText(""); 
		newCategoryFM.setText(""); 
		stocknumberFM.setText(""); 
		quantityFM.setText("");
		 	   

 	    //descriptionOK
 	    int desc = checkProductname(name);
 	    if (desc == 1) {Fehlermeldungen.add(11);}//Input to Long/Small
 	    if (desc == 2) {Fehlermeldungen.add(12);}//wrong character

 	    //newCategoryOK   
 	    int cat = checkCategoryname(category);
 	    if (cat == 1) {Fehlermeldungen.add(21);}//Input to Long/Small
 	    if (cat == 2) {Fehlermeldungen.add(22);}//wrong character 

 	    //stocknumberOK
 	    int sto = checkStocknumber(number);
 	    if (sto == 1) {Fehlermeldungen.add(31);}//Input to Long/Small =!6
 	    if (sto == 2) {Fehlermeldungen.add(32);}//Letters inside

 	    //priceOK
 	    int pri = checkPrice(price);
 	    if (pri == 1) {Fehlermeldungen.add(41);}//Number to Big/Small

 	    //weightOK
 	    int wei = checkWeight(weight);
 	    if (wei == 1) {Fehlermeldungen.add(51);}//Wrong Input

 	    //quantityOK
 	    int qua = checkQuantity(quantity);
 	    if (qua == 1) {Fehlermeldungen.add(61);}//Wrong Input



 	    System.out.println("Fehlermeldungen :" + Fehlermeldungen);




 		try {
			if (name.length()==0|category.length()==0|number.length()==0|price.length()==0|weight.length()==0|quantity.length()==0) {
				leereEingabeFM.setText("Bitte alle Felder ausfüllen!");
			} else {
				if (Fehlermeldungen.isEmpty()) {
					database.singleProduct.Product p = new database.singleProduct.Product(name, weight, quantity, price, number, category);
	 				int ShelfNr = Integer.parseInt(number)/1000;	
	 				start.Main.List.addProduct(ShelfNr,p);
	 				this.dispose();
	 			}else {

	 		         if (Fehlermeldungen.contains(11)) {descriptionFM.setText("zu viele Zeichen");} //Productdescription contains more than 256 characters
	 		         else if (Fehlermeldungen.contains(12)) {descriptionFM.setText("falsches Zeichen");}
	 		           else descriptionFM.setText(""); 

	 		         if (Fehlermeldungen.contains(21)) {newCategoryFM.setText("zu viele Zeichen");} //new Category contains more than 256 characters
	 		         else if (Fehlermeldungen.contains(22)) {newCategoryFM.setText("falsches Zeichen");}
	 		           else newCategoryFM.setText("");

	 		         if (Fehlermeldungen.contains(31)) {stocknumberFM.setText("6- stellige Zahl");}
	 		         else if (Fehlermeldungen.contains(31)) {stocknumberFM.setText("keine Buchstaben");} 
	 		           else stocknumberFM.setText("");

	 		         if (Fehlermeldungen.contains(41)) {priceFM.setText("keine Buchstaben");} else priceFM.setText("");;

	 		         if (Fehlermeldungen.contains(51)) {weightFM.setText("keine Buchstaben");} else weightFM.setText("");;

	 		         if (Fehlermeldungen.contains(61)) {quantityFM.setText("keine Buchstaben");} else quantityFM.setText("");;


	 			}//End: all Labels for Wrong input
			} //End Case: All Textfields are used 
 	 					

 		} catch (Exception exception) {
 			new exeptions.Exception(exception.getMessage());
 		} 
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


private int checkCategoryname(String name) {
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

 	    //char[] chara = name.toCharArray();
 	    for (char ch: name.toCharArray()) {
 	      if (Zeichen.contains(ch) == false) return 2; //wrong character  
 	    }
 	    if (name.length() > 256 | name.length() <= 1) {return 1;}
 	    else return 0;
 	  } 
  
  
private int checkStocknumber(String Stocknumber) {//TODO Never uses Catch
 	    try {
 	      if (Stocknumber.length() == 6) return 0;
 	      else return  1;// else: Zahl zu groß  
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
 	        if ((i.length() <= 5) & (a.length() <= 2)) { return 0;}
 	        else return 1; //Number to Big/Small
 	      }
 	      catch(NumberFormatException ee) {
 	        return 1;
 	      }
 	    }
 	    else if (teil.length == 1) {
 	      String u = teil[0];   
 	      try {
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
 	    String[] teil = weight.split(",");
 	    if (teil.length == 2) {
 	      String i = teil[0];
 	      String a = teil[1];

 	      try {
 	        if ((i.length() <= 5) & (a.length() <= 4)) { return 0;}
 	        else return 1; 
 	      }
 	      catch(NumberFormatException ee) {
 	        return 1;
 	      }
 	    }
 	    else if (teil.length == 1) {
 	      String u = teil[0];   
 	      try {
 	        if (u.length() <= 4 | u == "10000") { return 0;}
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
 	      if (zahl2 <= 100000000) return 0;
 	      else return 1;// else: Zahl zu groß 
 	      }
 	    catch(NumberFormatException ee) {
 	      return 1; //print: keine Buchstaben   
 	    }
 	  }

 	  //a

 	public static int parseToInt (String a) {
 		String[] teil = a.split(",");
 		String ganz = "";
 		for(int i = 0;i<(teil.length);i++) {
 			ganz = ganz + teil[i];
 		}
 		int zahl = Integer.parseInt(ganz);
 		return zahl;
 	}  
 	
	
} // public class addProduct
