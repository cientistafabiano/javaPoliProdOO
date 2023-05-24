package entities;

public class Product {
	private String name;
	private Double price;
	
	//overload
	public Product() {
	}
	//constructor
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	//methods
	public String priceTag() {
		StringBuilder sb = new StringBuilder();

		sb.append(name);
		sb.append(" $ ");
		sb.append(String.format("%.2f", price));

		return sb.toString();
	}
}
