package database.singleProduct;

public class ProductData { //Products Data with Getters/Setters

	private String name;
	//Weight in DECIGRAM
	private String weight;
	private String amount;
	private String price;
	// Six Digits long identify Number 000.000 first 3 for Place
	private String number; 
	private String category;
	
	//constructor in Product
	void setProductData(String name, String weight, String amount, String price, String number, String category) {
		this.name = name;
		this.weight = weight;
		this.amount = amount;	
		this.price = price;
		this.number = number;
		this.category = category;
		
	}
	
	// GETTER & SETTER
    
    //getters
	public String getName() {
		return this.name;
	}
	
	public String getWeight() {
		return this.weight;
	}
	
	public String getAmount() {
		return this.amount;
	}
	
	public String getPrice() {
		return this.price;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setCategory(String category) {
		this.category = category;

	}

}