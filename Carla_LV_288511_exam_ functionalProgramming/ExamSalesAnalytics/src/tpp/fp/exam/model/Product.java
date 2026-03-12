package tpp.fp.exam.model;

public class Product {

	private String id;
	private String name;
    private String category;
    private double price;
    
	public Product(String id, String name, String category, double price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return String.format("Product [id=%s, name=%s, category=%s, price=%s]", id, name, category, price);
	}
}
