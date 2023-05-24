package entities;

public class ImportedProduct extends Product {
	private Double customsFee;
	
	//overload
	public ImportedProduct() {
		super();
	}
	//constructor

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	//getters and setters
	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	//methods
	public Double totalPrice() {
		return getPrice() + customsFee;
	}
	
	@Override
	public final String priceTag() {
		StringBuilder sb = new StringBuilder();

		sb.append(getName());
		sb.append(" $ ");
		sb.append(String.format("%.2f", totalPrice()));
		sb.append(" (Taxa personalizada: $ ");
		sb.append(String.format("%.2f", customsFee));
		sb.append(")");

		return sb.toString();
	}
}
