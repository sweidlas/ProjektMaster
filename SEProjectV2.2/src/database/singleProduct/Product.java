package database.singleProduct;

import java.util.ArrayList;

public class Product extends ProductData{ //Class of Single Products

	 public ArrayList<Integer> Fehlermeldungen = new ArrayList<Integer>();

	public Product(String name, String weight, String quantity, String price,
			String number, String category)  {
		
		 //check if Input is valid
 	    boolean descriptionOK = false;
 	    boolean newCategoryOK = false;
 	    boolean stocknumberOK = false;
 	    boolean priceOK = false;
 	    boolean weightOK = false;
 	    boolean quantityOK = false;
 	   

 	    //descriptionOK
 	    int desc = checkProductname(name);
 	    if (desc == 0) {descriptionOK = true;}
 	    if (desc == 1) {Fehlermeldungen.add(1);}
 	    if (desc == 2) {Fehlermeldungen.add(11);}

 	    //newCategoryOK   
 	    int cat = checkCategoryname(category);
 	    if (cat == 0) {newCategoryOK = true;}
 	    if (cat == 1) {Fehlermeldungen.add(2);}
 	    if (cat == 2) {Fehlermeldungen.add(22);}

 	    //stocknumberOK
 	    int sto = checkStocknumber(number);
 	    if (sto == 0) {stocknumberOK = true;}
 	    if (sto == 1) {Fehlermeldungen.add(3);}
 	    if (sto == 2) {Fehlermeldungen.add(4);}

 	    //priceOK
 	    int pri = checkPrice(price);
 	    if (pri == 0) {priceOK = true;}
 	    if (pri == 1) {Fehlermeldungen.add(5);}

 	    //weightOK
 	    int wei = checkWeight(weight);
 	    if (wei == 0) {weightOK = true;}
 	    if (wei == 1) {Fehlermeldungen.add(6);}

 	    //quantityOK
 	    int qua = checkQuantity(quantity);
 	    if (qua == 0) {quantityOK = true;}
 	    if (qua == 1) {Fehlermeldungen.add(7);}



 	    System.out.println(Fehlermeldungen);

 	    System.out.println(descriptionOK);
 	    System.out.println(newCategoryOK);
 	    System.out.println(stocknumberOK);
 	    System.out.println(priceOK);
 	    System.out.println(weightOK);
 	    System.out.println(quantityOK); 

 	    if (descriptionOK&newCategoryOK&stocknumberOK&priceOK&weightOK &quantityOK == true) {
 	    	setProductData(name, weight, quantity, price, number, category);
 	    }
	}
	
	
	public ArrayList<String> productToString() {
		ArrayList<String> productAsString = new ArrayList<String>();
		productAsString.add(getName());
		productAsString.add(getWeight());
		productAsString.add(getAmount());
		productAsString.add(getPrice());
		productAsString.add(getNumber());
		productAsString.add(getCategory());
		return productAsString;
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
	  
	  
	private int checkStocknumber(String Stocknumber) {
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
	 	        else return 1;
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
	  
	private static int checkWeight(String weight)  {  //Input in kg
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
}	
