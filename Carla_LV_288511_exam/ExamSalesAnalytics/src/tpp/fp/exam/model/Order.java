package tpp.fp.exam.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

	private String id;
	private Customer customer;
	private List<OrderItem> items;
	private LocalDateTime orderDate;

	public Order(String id, Customer customer, List<OrderItem> items, LocalDateTime orderDate) {
		this.id = id;
		this.customer = customer;
		this.items = items;
		this.orderDate = orderDate;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the items
	 */
	public List<OrderItem> getItems() {
		return items;
	}

	/**
	 * @return the orderDate
	 */
	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	@Override
	public String toString() {
		return String.format("Order [id=%s, customer=%s, items=%s, orderDate=%s]", id, customer, items, orderDate);
	}
}
