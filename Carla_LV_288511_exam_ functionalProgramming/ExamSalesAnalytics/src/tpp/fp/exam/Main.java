package tpp.fp.exam;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import tpp.fp.exam.model.Customer;
import tpp.fp.exam.model.DatasetGenerator;
import tpp.fp.exam.model.Order;
import tpp.fp.exam.model.OrderItem;
import tpp.fp.exam.model.Product;
import tpp.fp.exam.model.Tier;

public class Main {

	private static final Function<OrderItem, Double> itemRevenue =
            item -> item.getProduct().getPrice() * item.getQuantity();

    private static final Function<Order, Double> orderRevenue =
            order -> order.getItems()
                    .stream()
                    .map(itemRevenue)
                    .reduce(0.0, Double::sum);
	
	public static void main(String[] args) {
		List<Customer> customers = DatasetGenerator.generateCustomers(50);
		List<Product> products = DatasetGenerator.generateProducts(100);
		List<Order> orders = DatasetGenerator.generateOrders(1000, customers, products);

		System.out.format("Exercise 1\nTotal revenue VIP Customers: %.2f\n\n", totalRevenueVIPCustomers(orders));
		System.out.format("Exercise 2\nIs there any order with products from Electronics: %b\n\n", anyOrderWhereCategoryIs(orders, "Electronics"));
		System.out.format("Exercise 3\nCategories where PREMIUM custormers buy:\n %s\n\n", uniqueCategoriesByPremiumCustomers(orders));
		System.out.format("Exercise 4\nTop most expensive products:\n %s\n\n", topExpensiveProducts(orders));
		System.out.format("Exercise 5\nTotal amount of books sold: %d\n\n", totalProductsSoldInCategory(orders, "Books"));
		System.out.format("Exercise 6\nProducts bought by customer from Spain:\n %s\n\n", productsBoughtByCustomersFrom(orders, "Spain"));
		System.out.format("Exercise 7\nTotal revenue considering a 10%% discount: %.2f\n\n", revenueWithDiscount(orders, (v) -> v * 0.9));
		System.out.format("Exercise 8\nOrders with a revenue greater then 5000 euros, from VIP customers from Spain:\n %s\n\n", orders.stream().filter(getPredicate(Tier.VIP, "Spain", 5000)).map(Order::getId).toList());
	}

	/**
	 * 
	 * @return total revenue of the order from VIP customers
	 */
	private static double totalRevenueVIPCustomers(List<Order> orders) {
		// TODO
		
		return orders.stream().filter(x-> x.getCustomer().getTier().equals(Tier.VIP)).map(orderRevenue).reduce((double) 0,(a,b)-> a+b);
		
		/* return orders.stream()
                .filter(order -> order.getCustomer().getTier().equals(Tier.VIP))
                .map(orderRevenue)
                .reduce(0.0, Double::sum);*/
				
		 
	}
	
	

	/**
	 * 
	 * @return true if there is any order where there is a product from the Category {@code category}
	 */
	private static boolean anyOrderWhereCategoryIs(List<Order> orders, String category){
		// TODO
		
		return orders.stream().anyMatch(x -> x.getItems().getFirst().getProduct().getCategory().equals(category));
		/*return orders.stream()
                .flatMap(order -> order.getItems().stream())
                .map(OrderItem::getProduct)
                .anyMatch(product -> product.getCategory().equals(category)); */
		
	}
	
	/**
	 * 
	 * @return the list of unique categories that the PREMIUM customer buy
	 */
	private static List<String> uniqueCategoriesByPremiumCustomers(List<Order> orders) {
		// TODO
		
		return orders.stream()
				.filter(x-> x.getCustomer().getTier().equals(Tier.PREMIUM))
				.map(x-> x.getItems().getFirst().getProduct().getCategory())
				.distinct().toList();
		
		/*return orders.stream()
                .filter(order -> order.getCustomer().getTier().equals(Tier.PREMIUM))
                .flatMap(order -> order.getItems().stream())
                .map(OrderItem::getProduct)
                .map(Product::getCategory)
                .distinct()
                .toList();*/
	}
	
	/**
	 * 
	 * @return the list containing the name of the 5 top most expensive products without repetitions
	 */
	private static List<String> topExpensiveProducts(List<Order> orders) {
		// TODO
		
		return orders.stream().sorted((b,a) -> Double.compare(a.getItems().getFirst().getProduct().getPrice(), b.getItems().getFirst().getProduct().getPrice()))
				.map(x -> x.getItems().getFirst().getProduct().getName())
				.distinct()
				.limit(5)
				.toList();
		
		/*  return orders.stream()
                .flatMap(order -> order.getItems().stream())
                .map(OrderItem::getProduct)
                .distinct()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(5)
                .map(Product::getName)
                .toList();*/
	}
	
	/**
	 * 
	 * @return the total amount of products of the category {@code category} sold
	 */
	private static int totalProductsSoldInCategory(List<Order> orders, String category) {
		// TODO
		
		/*int p = (int) orders.stream()
			.map(x -> x.getItems().stream()
						.filter(i-> i.getProduct().getCategory().equals(category)
					     .filter(i-> i.getQuantity())
					     .count())
			.count();*/
		return 0;
		
		/* return orders.stream()
                .flatMap(order -> order.getItems().stream())
                .filter(item -> item.getProduct().getCategory().equals(category))
                .map(OrderItem::getQuantity)
                .reduce(0, Integer::sum);*/
				
	}
	
	/**
	 * 
	 * @return the list containing the name of the unique products bought by customers from the country {@code country}
	 */
	private static List<String> productsBoughtByCustomersFrom(List<Order> orders, String country) {
		// TODO
		
		return orders.stream().filter(x -> x.getCustomer().getCountry().equals(country))
				.map(x -> x.getItems().getFirst().getProduct().getName())
				.distinct()
				.toList();
		
		/*return orders.stream()
                .filter(order -> order.getCustomer().getCountry().equals(country))
                .flatMap(order -> order.getItems().stream())
                .map(OrderItem::getProduct)
                .map(Product::getName)
                .distinct()
                .toList();*/
	}
	
	/**
	 * 
	 * @param orders
	 * @param discountFunction
	 * @return the total revenue of the orders applying the discount defined by {@code discountFunction}
	 */
	private static double revenueWithDiscount(List<Order> orders, Function<Double, Double> discountFunction) {
		// TODO
		
		Function <Double , Double > discount = x -> x - x*0.1;
		Function <Order, Double> compose = orderRevenue.andThen(discount);
		
		
		
		
		
		
		return orders.stream().map(x->compose.apply(x)).reduce((double) 0, (a,b) -> a+b);
		
		/*return orders.stream()
                .map(orderRevenue.andThen(discountFunction))
                .reduce(0.0, Double::sum);*/
	}
	
	/**
	 * 
	 * @return a Predicate for filtering that the customer from the order is from Tier {@code tier} AND
	 * from the Country {@code country} AND
	 * the revenue of the order is greater than {@code revenueThreshold} 
	 */
	private static Predicate<Order> getPredicate(Tier tier, String country, double revenueThreshold) {
		// TODO
		Predicate <Order> isTier = x-> x.getCustomer().getTier().equals(tier);
		Predicate <Order> isCountry = x -> x.getCustomer().getCountry().equals(country);
		Predicate <Order> isGreaterRev = x -> orderRevenue.apply(x) > revenueThreshold;
		
		Predicate <Order> all = isTier.and(isCountry).and(isGreaterRev);
		
		
		return all;
	}

	
}
