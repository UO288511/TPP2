package tpp.fp.exam.model;

public class OrderItem {

	private Product product;
	private int quantity;

	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return String.format("OrderItem [product=%s, quantity=%s]", product, quantity);
	}
}
